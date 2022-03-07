package com.example.bus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.R;
import com.example.bus.data.busroute.BusRouteItem;

import java.util.ArrayList;
import java.util.List;

public class BusRouteRecyclerViewAdapter extends RecyclerView.Adapter<BusRouteRecyclerViewAdapter.ViewHolder> {

    List<BusRouteItem> upItems = new ArrayList<>();
    List<BusRouteItem> downItems = new ArrayList<>();
    List<BusRouteItem> items;
    boolean isUpDown;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView busStopName, busStopId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            busStopName = itemView.findViewById(R.id.busStopNameRoute);
            busStopId = itemView.findViewById(R.id.busStopIdRoute);
        }

        public void setItem(BusRouteItem item) {
            busStopName.setText(item.getNodenm());
            if (item.getNodeno() != null) {
                busStopId.setText(item.getNodeno().toString());
            }
        }
    }

    public BusRouteRecyclerViewAdapter() {
    }

    public BusRouteRecyclerViewAdapter(List<BusRouteItem> items) {
        this.items = items;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getUpdowncd() == 0) {
                upItems.add(items.get(i));
            } else {
                downItems.add(items.get(i));
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.bus_route_item, parent, false);
        BusRouteRecyclerViewAdapter.ViewHolder viewHolder = new BusRouteRecyclerViewAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (isUpDown) {
            holder.setItem(upItems.get(position));
        } else {
            holder.setItem(downItems.get(position));
        }

    }

    @Override
    public int getItemCount() {
        if (isUpDown) {
            return upItems.size();
        } else {
            return downItems.size();
        }
    }

    public void changeUpDown(boolean isUpDown) {
        this.isUpDown = isUpDown;
        if (isUpDown) {
            items = upItems;
        } else {
            items = downItems;
        }
        notifyDataSetChanged();
    }

}
