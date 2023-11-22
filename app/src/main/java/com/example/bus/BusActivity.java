package com.example.bus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.adapter.BusRouteRecyclerViewAdapter;
import com.example.bus.data.RetrofitClient;
import com.example.bus.data.busdetail.BusDetailExample;
import com.example.bus.data.busdetail.BusDetailInterface;
import com.example.bus.data.busdetail.BusDetailItem;
import com.example.bus.data.busdetail.BusDetailItems;
import com.example.bus.data.busroute.BusRouteExample;
import com.example.bus.data.busroute.BusRouteInterface;
import com.example.bus.data.busroute.BusRouteItems;
import com.example.bus.tools.BusTypeColor;
import com.google.android.material.tabs.TabLayout;

import java.time.LocalDate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        final String API_KEY = BuildConfig.API_KEY;
        Intent intent = getIntent();
        final String busRouteId = intent.getStringExtra("busRouteId");
        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        BusDetailInterface busDetailInterface = retrofitClient.getBusDetailInterface();
        busDetailInterface.getBusDetail(API_KEY, "json", 25, busRouteId).enqueue(new Callback<BusDetailExample>() {
            @Override
            public void onResponse(Call<BusDetailExample> call, Response<BusDetailExample> response) {
                if (response.isSuccessful()) {
                    BusDetailExample example = response.body();
                    BusDetailItems items = example.getResult().getBody().getItems();
                    setText(items.getBusDetailItem());
                    Log.d("detail data log", items.getBusDetailItem().toString());
                } else {
                    Log.d("retrofit", "Bus Detail Data fetch fail");
                }
            }

            @Override
            public void onFailure(Call<BusDetailExample> call, Throwable t) {

            }
        });

        BusRouteInterface busRouteInterface = retrofitClient.getBusRouteRetrofitInterface();
        busRouteInterface.getBusStopsByRoute(API_KEY, 2, "json", 25, busRouteId).enqueue(new Callback<BusRouteExample>() {
            @Override
            public void onResponse(Call<BusRouteExample> call, Response<BusRouteExample> response) {
                if (response.isSuccessful()) {
                    BusRouteExample example = response.body();
                    int totalCount = example.getResult().getBody().getTotalCount();
                    if (totalCount > 1) {
                        busRouteInterface.getBusStopsByRoute(API_KEY, totalCount, "json", 25, busRouteId).enqueue(new Callback<BusRouteExample>() {
                            @Override
                            public void onResponse(Call<BusRouteExample> call, Response<BusRouteExample> response) {
                                BusRouteExample example = response.body();
                                BusRouteItems items = example.getResult().getBody().getItems();
                                BusRouteRecyclerViewAdapter adapter = new BusRouteRecyclerViewAdapter(items.getBusRouteItem());
                                RecyclerView busRouteRecyclerView = findViewById(R.id.busRouteRecyclerView);
                                busRouteRecyclerView.setAdapter(adapter);
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

    void setText(BusDetailItem busDetailItems) {
        TextView busName = findViewById(R.id.busName_activity);
        TextView busCity = findViewById(R.id.busCity_activity);
        TextView busType = findViewById(R.id.busType_activity);
        TextView busSection = findViewById(R.id.busSection_activity);
        TextView busOperationTime = findViewById(R.id.operationTime_activity);
        TextView busDispatchInterval = findViewById(R.id.dispatchInterval_activity);
        TabLayout startEndTab = findViewById(R.id.startEndTabLayout);

        busName.setText(busDetailItems.getRouteno().toString());
        busCity.setText("대전");
        busType.setText(busDetailItems.getRoutetp());
        BusTypeColor busTypeColor = new BusTypeColor();
        busType.setBackgroundTintList(busTypeColor.getBusTypeColor(busDetailItems.getRoutetp()));
        busSection.setText(String.format("%s ⇆ %s", busDetailItems.getStartnodenm(), busDetailItems.getEndnodenm()));
        StringBuffer startTimeBuffer = new StringBuffer(busDetailItems.getStartvehicletime());
        StringBuffer endTimeBuffer = new StringBuffer(String.valueOf(busDetailItems.getEndvehicletime()));
        busOperationTime.setText(String.format("%s ~ %s", startTimeBuffer.insert(2, ":"), endTimeBuffer.insert(2, ":")));
        final int dayOfWeek = LocalDate.now().getDayOfWeek().getValue();
        busDispatchInterval.setText(String.format("배차시간 %d분", dayOfWeek == 6 ? busDetailItems.getIntervalsattime() : dayOfWeek == 7 ? busDetailItems.getIntervalsuntime() : busDetailItems.getIntervaltime()));
        startEndTab.getTabAt(0).setText(busDetailItems.getStartnodenm());
        startEndTab.getTabAt(1).setText(busDetailItems.getEndnodenm());
    }

//    public void upBus(View view) {
//        busStartStop.setTextColor(Color.parseColor("#01C8C1"));
//        busEndStop.setTextColor(Color.parseColor("#808080"));
//
//        BusRouteRecyclerViewAdapter adapter = new BusRouteRecyclerViewAdapter();
//        adapter.changeUpDown(true);
//    }
//
//    public void downBus(View view) {
//        busStartStop.setTextColor(Color.parseColor("#808080"));
//        busEndStop.setTextColor(Color.parseColor("#01C8C1"));
//
//        BusRouteRecyclerViewAdapter adapter = new BusRouteRecyclerViewAdapter();
//        adapter.changeUpDown(false);
//    }

}