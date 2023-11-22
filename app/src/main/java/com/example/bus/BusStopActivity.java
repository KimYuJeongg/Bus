package com.example.bus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bus.adapter.BusArrivalRecyclerViewAdapter;
import com.example.bus.data.RetrofitClient;
import com.example.bus.data.busarrival.BusArrivalExample;
import com.example.bus.data.busarrival.BusArrivalInterface;
import com.example.bus.data.busarrival.BusArrivalItems;
import com.example.bus.data.room.AppDatabase;
import com.example.bus.data.room.BusStop;
import com.example.bus.data.room.BusStopDao;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusStopActivity extends AppCompatActivity {

    private boolean isStar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_stop);

        final String API_KEY = BuildConfig.API_KEY;

        RecyclerView busArrivalRecyclerView = findViewById(R.id.busArrivalRecyclerView);
        busArrivalRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        HashMap<String, String> busStopData = (HashMap<String, String>) intent.getSerializableExtra("busStopData");

        TextView busStopName = findViewById(R.id.busStopName);
        TextView busStopId = findViewById(R.id.busStopId);
        TextView busStopLocation = findViewById(R.id.busStopLocation);
        ImageButton imgbtnBusStopBookMark = findViewById(R.id.imgbtn_bus_stop_bookmark_busstop);
        busStopName.setText(busStopData.get("nodeNm"));
        busStopId.setText(busStopData.get("nodeNo"));
        busStopLocation.setText(String.format("%s / %s", busStopData.get("gpsLati"), busStopData.get("gpsLong")));

//        TODO isStar = db에 동일한 nodeId 있는지 여부

        AppDatabase db = AppDatabase.getInstance(this);
        BusStopDao busStopDao = db.busStopDao();

        isStar = busStopDao.getAllNodeIds().contains(busStopData.get("nodeId"));
        imgbtnBusStopBookMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isStar) {
                    imgbtnBusStopBookMark.setImageResource(R.drawable.ic_empty_star);
                    BusStop busStop = new BusStop(busStopData.get("nodeId"));
                    busStopDao.delete(busStop);
                } else {
                    imgbtnBusStopBookMark.setImageResource(R.drawable.ic_star);
                    BusStop busStop = new BusStop(busStopData.get("nodeId"), busStopData.get("nodeNo"), busStopData.get("nodeNm"));
                    busStopDao.insert(busStop);
                }
                isStar = !isStar;
                Toast.makeText(getApplicationContext(), "즐겨찾기가 " + (isStar ? "추가" : "해제") + "되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        BusArrivalInterface busArrivalInterface = retrofitClient.getBusArrivalRetrofitInterface();

        busArrivalInterface.getArrivalBus(API_KEY, 10, "json", 25, busStopData.get("nodeId")).enqueue(new Callback<BusArrivalExample>() {
            @Override
            public void onResponse(Call<BusArrivalExample> call, Response<BusArrivalExample> response) {
                BusArrivalExample example = response.body();
                BusArrivalItems items = example.getResult().getBody().getItems();
                BusArrivalRecyclerViewAdapter adapter = new BusArrivalRecyclerViewAdapter(items.getBusArrivalItem(), busStopData.get("nodeNo"));
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