package com.example.bus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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

        TextView busStopName = findViewById(R.id.busStopName);
        TextView busStopId = findViewById(R.id.busStopId);
        TextView busStopLocation = findViewById(R.id.busStopLocation);

        Intent intent = getIntent();
        busStopName.setText(intent.getStringArrayExtra("busStopData")[0]);
        busStopId.setText(intent.getStringArrayExtra("busStopData")[1]);
        busStopLocation.setText(intent.getStringArrayExtra("busStopData")[2]);

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        BusArrivalInterface busArrivalInterface = retrofitClient.getBusArrivalRetrofitInterface();
        String key = "9BWhbO2OOt0gFxjT43TFFgz5hK2EAxt+PEO0DTHE1i7lO7pOlN3GhQJgM2F5Yd4cH4fwkoC4UYmwOFoLOzVxng==";
        busArrivalInterface.getArrivalBus(key, 10, "json", 25, intent.getStringArrayExtra("busStopData")[3]).enqueue(new Callback<BusArrivalExample>() {
            @Override
            public void onResponse(Call<BusArrivalExample> call, Response<BusArrivalExample> response) {
                BusArrivalExample example = response.body();
                BusArrivalItems items = example.getResult().getBody().getItems();

            }

            @Override
            public void onFailure(Call<BusArrivalExample> call, Throwable t) {

            }
        });

    }
}