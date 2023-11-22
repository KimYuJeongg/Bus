package com.example.bus.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.BusActivity;
import com.example.bus.BusStopActivity;
import com.example.bus.R;
import com.example.bus.data.busnumber.BusNumberItem;
import com.example.bus.data.busstop.BusStopItem;

import java.util.HashMap;
import java.util.List;

public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchRecyclerViewAdapter.ViewHolder> {

    public static final int VIEWTYPE_BUS_STOP = 0;
    public static final int VIEWTYPE_BUS = 1;
    public int mItemViewType;

    List<BusStopItem> busStopItems;
    List<BusNumberItem> busItems;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView busStopName, busStopId, busStopLocation, busName, busArea, busRoute;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            busStopName = itemView.findViewById(R.id.busStopNameItem);
            busStopId = itemView.findViewById(R.id.busStopIdItem);
            busStopLocation = itemView.findViewById(R.id.busStopLocationItem);
            busName = itemView.findViewById(R.id.busNameItem);
            busArea = itemView.findViewById(R.id.busAreaItem);
            busRoute = itemView.findViewById(R.id.busRouteItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemViewType == 0) {
                        Intent intent = new Intent(v.getContext(), BusStopActivity.class);

                        final BusStopItem item = busStopItems.get(getBindingAdapterPosition());
                        final HashMap<String, String> busStopData = new HashMap(){{
                            put("nodeNm", item.getNodenm());
                            put("nodeNo", item.getNodeno().toString());
                            put("gpsLati", item.getGpslati().toString());
                            put("gpsLong", item.getGpslong().toString());
                            put("nodeId", item.getNodeid());
                        }};

                        intent.putExtra("busStopData", busStopData);
                        v.getContext().startActivity(intent);
                    } else if (mItemViewType == 1) {
                        final BusNumberItem item = busItems.get(getBindingAdapterPosition());
                        Intent intent = new Intent(v.getContext(), BusActivity.class);
                        intent.putExtra("busRouteId", item.getRouteid());
                        v.getContext().startActivity(intent);
                    }
                }
            });
        }

        public void setBusStopItem(BusStopItem item) {
            busStopName.setText(item.getNodenm());
            busStopId.setText(item.getNodeno().toString());
        }

        public void setBusItem(BusNumberItem item) {
            busName.setText(item.getRouteno());
            busArea.setText("대전");
            busRoute.setText(String.format("%s ⇆ %s", item.getEndnodenm(), item.getStartnodenm()));
        }

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
            view = inflater.inflate(R.layout.search_bus_stop_item, parent, false);
        } else if (viewType == VIEWTYPE_BUS) {
            view = inflater.inflate(R.layout.search_bus_item, parent, false);
        }

        return new ViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return mItemViewType;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mItemViewType == VIEWTYPE_BUS_STOP) {
            holder.setBusStopItem(busStopItems.get(position));
        } else if (mItemViewType == VIEWTYPE_BUS) {
            holder.setBusItem(busItems.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (mItemViewType == VIEWTYPE_BUS_STOP) {
            if (busStopItems == null) {
                return 0;
            } else {
                return busStopItems.size();
            }
        } else {
            if (busItems == null) {
                return 0;
            } else {
                return busItems.size();
            }
        }
    }

    public void resetBusStopItems(List<BusStopItem> newItems) {
        this.busStopItems = newItems;
        notifyDataSetChanged();
    }

    public void resetBusItems(List<BusNumberItem> newItems) {
        this.busItems = newItems;
        notifyDataSetChanged();
    }

}
