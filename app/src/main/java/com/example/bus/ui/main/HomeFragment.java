package com.example.bus.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.R;
import com.example.bus.adapter.MainRecyclerViewAdapter;
import com.example.bus.data.room.AppDatabase;
import com.example.bus.data.room.BusDao;
import com.example.bus.data.room.BusStopDao;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView) ;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(initialMainRecyclerViewItems()) ;
        recyclerView.setAdapter(adapter) ;

        return view;
    }

    List<Object> initialMainRecyclerViewItems() {
        AppDatabase db = AppDatabase.getInstance(getActivity());
        BusDao busDao = db.busDao();
        BusStopDao busStopDao = db.busStopDao();

//        RetrofitClient retrofitClient = RetrofitClient.getInstance();
//        BusArrivalInterface busArrivalInterface = retrofitClient.getBusArrivalRetrofitInterface();
//        busArrivalInterface.getArrivalBus(BuildConfig.API_KEY, 10, "json", 25, busStopData.get("nodeId"))

        final List<Object> items = new ArrayList<>();
        items.addAll(busDao.getAllBuses());
        items.addAll(busStopDao.getAllBusStops());

        return items;
    }
}