package com.example.bus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.R;
import com.example.bus.data.busarrival.BusArrivalItem;

import java.util.List;

public class BusArrivalRecyclerViewAdapter extends RecyclerView.Adapter<BusArrivalRecyclerViewAdapter.ViewHolder>{

    List<BusArrivalItem> items;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView busName, busType, leftStops, arrivalTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            busName = itemView.findViewById(R.id.busName);
            busType = itemView.findViewById(R.id.busType);
            leftStops = itemView.findViewById(R.id.leftStops);
            arrivalTime = itemView.findViewById(R.id.arrivalTime);
        }

        public void setItem(BusArrivalItem item) {
            busName.setText(item.getRouteno().toString());
            busType.setText(item.getRoutetp());
            leftStops.setText(item.getArrprevstationcnt() + "번째 전");
            arrivalTime.setText("약 " + Math.round(item.getArrtime() / 60) + "분");
        }
    }

    public BusArrivalRecyclerViewAdapter(List<BusArrivalItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.arrival_bus_item, parent, false);
        BusArrivalRecyclerViewAdapter.ViewHolder viewHolder = new BusArrivalRecyclerViewAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
