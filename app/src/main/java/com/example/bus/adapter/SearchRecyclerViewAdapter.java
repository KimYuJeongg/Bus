package com.example.bus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.R;
import com.example.bus.data.bus.BusItem;
import com.example.bus.data.busstop.BusStopItem;

import java.util.List;

public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchRecyclerViewAdapter.ViewHolder> {

    public static final int VIEWTYPE_BUS_STOP = 0;
    public static final int VIEWTYPE_BUS = 1;
    public int mItemViewType;

    List<BusStopItem> busStopItems;
    List<BusItem> busItems;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView busStopName, busStopId, busStopLocation, busName, busArea, busRoute;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            busStopName = itemView.findViewById(R.id.busStopName);
            busStopId = itemView.findViewById(R.id.busStopId);
            busStopLocation = itemView.findViewById(R.id.busStopLocation);
            busName = itemView.findViewById(R.id.busName);
            busArea = itemView.findViewById(R.id.busArea);
            busRoute = itemView.findViewById(R.id.busRoute);
        }

        public void setBusStopItem(BusStopItem item) {
            busStopName.setText(item.getNodenm());
            if (item.getNodeno() != null) {
                busStopId.setText(item.getNodeno().toString());
            }
        }

        public void setBusItem(BusItem item) {
            busName.setText(item.getRouteno().toString());
            busArea.setText("대전");
            busRoute.setText(item.getEndnodenm() + " ⇆ " + item.getStartnodenm());
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

        SearchRecyclerViewAdapter.ViewHolder vh = new SearchRecyclerViewAdapter.ViewHolder(view);

        return vh;
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
            if(busStopItems == null) {
                return 0;
            } else {
                return busStopItems.size();
            }
        } else {
            if(busItems == null) {
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

    public void resetBusItems(List<BusItem> newItems) {
        this.busItems = newItems;
        notifyDataSetChanged();
    }

}
