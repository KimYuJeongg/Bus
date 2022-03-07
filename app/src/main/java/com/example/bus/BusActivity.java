package com.example.bus;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.adapter.BusRouteRecyclerViewAdapter;
import com.example.bus.data.RetrofitClient;
import com.example.bus.data.busroute.BusRouteExample;
import com.example.bus.data.busroute.BusRouteInterface;
import com.example.bus.data.busroute.BusRouteItems;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusActivity extends AppCompatActivity {

    TextView busStartStop, busEndStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        final String API_KEY = BuildConfig.API_KEY;

        TextView busName = findViewById(R.id.busName_activity);
        TextView busArea = findViewById(R.id.busArea_activity);
        TextView busType = findViewById(R.id.busType_activity);
        busStartStop = findViewById(R.id.busStartStop);
        busEndStop = findViewById(R.id.busEndStop);
        RecyclerView busRouteRecyclerView = findViewById(R.id.busRouteRecyclerView);

        Intent intent = getIntent();
        String[] busRouteData = intent.getStringArrayExtra("busRouteData");
        busName.setText(busRouteData[1]);
        busType.setText(busRouteData[2]);
        busStartStop.setText(busRouteData[3] + " 방향");
        busEndStop.setText(busRouteData[4] + " 방향");
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        BusRouteInterface busRouteInterface = retrofitClient.getBusRouteRetrofitInterface();

        busRouteInterface.getBusStop(API_KEY, 2, "json", 25, busRouteData[0]).enqueue(new Callback<BusRouteExample>() {
            @Override
            public void onResponse(Call<BusRouteExample> call, Response<BusRouteExample> response) {
                if(response.isSuccessful()) {
                    BusRouteExample example = response.body();
                    int totalCount = example.getResult().getBody().getTotalCount();
                    if(totalCount > 1) {
                        busRouteInterface.getBusStop(API_KEY, totalCount, "json", 25, busRouteData[0]).enqueue(new Callback<BusRouteExample>() {
                            @Override
                            public void onResponse(Call<BusRouteExample> call, Response<BusRouteExample> response) {
                                BusRouteExample example = response.body();
                                BusRouteItems items = example.getResult().getBody().getItems();
                                BusRouteRecyclerViewAdapter adapter = new BusRouteRecyclerViewAdapter(items.getBusRouteItem());
                                busRouteRecyclerView.setAdapter(adapter);
                                busRouteRecyclerView.addItemDecoration(new DividerItemDecoration(busRouteRecyclerView.getContext(), 1));
                            }

                            @Override
                            public void onFailure(Call<BusRouteExample> call, Throwable t) {
                                Log.e("fail", t.getMessage());
                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<BusRouteExample> call, Throwable t) {

            }
        });

    }

    public void upBus(View view) {
        busStartStop.setTextColor(Color.parseColor("#01C8C1"));
        busEndStop.setTextColor(Color.parseColor("#808080"));

        BusRouteRecyclerViewAdapter adapter = new BusRouteRecyclerViewAdapter();
        adapter.changeUpDown(true);
    }

    public void downBus(View view) {
        busStartStop.setTextColor(Color.parseColor("#808080"));
        busEndStop.setTextColor(Color.parseColor("#01C8C1"));

        BusRouteRecyclerViewAdapter adapter = new BusRouteRecyclerViewAdapter();
        adapter.changeUpDown(false);
    }

}