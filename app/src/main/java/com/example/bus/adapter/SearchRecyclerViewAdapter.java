package com.example.bus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.R;

import java.util.ArrayList;

public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchRecyclerViewAdapter.ViewHolder> {

    public static final int VIEWTYPE_BUS_STOP = 0;
    public static final int VIEWTYPE_BUS = 1;
    int mItemViewType;

    ArrayList<String> list;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView busStopName, busStopId, busStopLocation;
//        busName, busArea, busRoute;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            busStopName = itemView.findViewById(R.id.busStopName);
            busStopId = itemView.findViewById(R.id.busStopId);
            busStopLocation = itemView.findViewById(R.id.busStopLocation);
//            busName = itemView.findViewById(R.id.busName);
//            busArea = itemView.findViewById(R.id.busRoute);
        }

//        public BusStopViewHolder(@NonNull View itemView) {
//            super(itemView);
//        }
    }

//    public class BusViewHolder extends RecyclerView.ViewHolder {
//
//        public BusViewHolder(@NonNull View itemView) {
//            super(itemView);
//        }
//    }

    public SearchRecyclerViewAdapter(ArrayList<String> list) {
        this.list = list;
    }

    public void setItemViewType(int viewType) {
        mItemViewType = viewType;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;

        if (viewType == VIEWTYPE_BUS_STOP) {
            view = inflater.inflate(R.layout.fragment_search_bus_stop_item, parent, false);
//            View busStopView = inflater.inflate(R.layout.fragment_search_bus_stop_item, parent, false);
        } else if (viewType == VIEWTYPE_BUS) {
            view = inflater.inflate(R.layout.fragment_search_bus_item, parent, false);
//            View busView = inflater.inflate(R.layout.fragment_search_bus_item, parent, false);
        }

        SearchRecyclerViewAdapter.ViewHolder vh = new SearchRecyclerViewAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public int getItemViewType(int position) {
        return mItemViewType;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.busStopId.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}