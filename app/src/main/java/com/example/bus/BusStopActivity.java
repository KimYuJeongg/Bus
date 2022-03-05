package com.example.bus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.bus.adapter.BusArrivalRecyclerViewAdapter;
import com.example.bus.data.RetrofitClient;
import com.example.bus.data.busarrival.BusArrivalExample;
import com.example.bus.data.busarrival.BusArrivalInterface;
import com.example.bus.data.busarrival.BusArrivalItems;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusStopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_stop);

        final String API_KEY = BuildConfig.API_KEY;
        TextView busStopName = findViewById(R.id.busStopName);
        TextView busStopId = findViewById(R.id.busStopId);
        TextView busStopLocation = findViewById(R.id.busStopLocation);
        RecyclerView busArrivalRecyclerView = findViewById(R.id.busArrivalRecyclerView);
        busArrivalRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        busStopName.setText(intent.getStringArrayExtra("busStopData")[0]);
        busStopId.setText(intent.getStringArrayExtra("busStopData")[1]);
        busStopLocation.setText(intent.getStringArrayExtra("busStopData")[2]);

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        BusArrivalInterface busArrivalInterface = retrofitClient.getBusArrivalRetrofitInterface();

        busArrivalInterface.getArrivalBus(API_KEY, 10, "json", 25, intent.getStringArrayExtra("busStopData")[3]).enqueue(new Callback<BusArrivalExample>() {
            @Override
            public void onResponse(Call<BusArrivalExample> call, Response<BusArrivalExample> response) {
                BusArrivalExample example = response.body();
                BusArrivalItems items = example.getResult().getBody().getItems();
                BusArrivalRecyclerViewAdapter adapter = new BusArrivalRecyclerViewAdapter(items.getBusArrivalItem());
                busArrivalRecyclerView.setAdapter(adapter);
                busArrivalRecyclerView.addItemDecoration(new DividerItemDecoration(busArrivalRecyclerView.getContext(), 1));
            }

            @Override
            public void onFailure(Call<BusArrivalExample> call, Throwable t) {
                Log.e("bus arrival", t.getMessage());
            }
        });

    }
}