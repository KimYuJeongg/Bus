package com.example.bus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bus.data.RetrofitClient;
import com.example.bus.data.busarrival.BusArrivalInterface;
import com.example.bus.data.busroute.BusRouteInterface;

public class BusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        TextView busName = findViewById(R.id.busName_activity);
        TextView busArea = findViewById(R.id.busArea_activity);
        TextView busType = findViewById(R.id.busType_activity);
        TextView busStartStop = findViewById(R.id.busStartStop);
        TextView busEndStop = findViewById(R.id.busEndStop);

        Intent intent = getIntent();
        busName.setText(intent.getStringArrayExtra("busRouteData")[1]);
        busType.setText(intent.getStringArrayExtra("busRouteData")[2]);
        busStartStop.setText(intent.getStringArrayExtra("busRouteData")[3]);
        busEndStop.setText(intent.getStringArrayExtra("busRouteData")[4]);
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        BusRouteInterface busRouteInterface = retrofitClient.getBusRouteRetrofitInterface();
    }
}