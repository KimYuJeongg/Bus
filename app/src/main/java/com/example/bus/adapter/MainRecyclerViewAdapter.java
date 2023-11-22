package com.example.bus.adapter;

import  android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.R;
import com.example.bus.data.busarrival.BusArrivalItem;
import com.example.bus.data.busstop.BusStopItem;
import com.example.bus.data.room.Bus;
import com.example.bus.data.room.BusStop;
import com.example.bus.tools.BusTypeColor;

import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {

    private List<Object> items = null;

    final int VIEWTYPE_BUS_STOP = 0;
    final int VIEWTYPE_BUS = 1;
    int mItemViewType;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView busIcon;
        TextView tvBusNumber, tvBusType, tvPredictTime, tvLeftStops, tvStopName, tvStopId;
        TextView tvBusStopName, tvBusStopId;


        ViewHolder(View itemView) {
            super(itemView);

            busIcon = itemView.findViewById(R.id.imgv_bus_mainbusitem);
            tvBusNumber = itemView.findViewById(R.id.tv_bus_number_mainbusitem);
            tvBusType = itemView.findViewById(R.id.tv_bus_type_mainbusitem);
            tvPredictTime = itemView.findViewById(R.id.tv_predict_time_mainbusitem);
            tvLeftStops = itemView.findViewById(R.id.tv_left_stops_mainbusitem);
            tvStopName = itemView.findViewById(R.id.tv_stop_name_mainbusitem);
            tvStopId = itemView.findViewById(R.id.tv_stop_id_mainbusitem);

            tvBusStopName = itemView.findViewById(R.id.tv_stop_name_mainbusstopitem);
            tvBusStopId = itemView.findViewById(R.id.tv_stop_id_mainbusstopitem);
        }

        void setBusItem(BusArrivalItem item) {
            BusTypeColor busTypeColor = new BusTypeColor();
            busIcon.setImageTintList(busTypeColor.getBusTypeColor(item.getRoutetp()));
            tvBusNumber.setText(item.getRouteno());
            tvBusType.setText(item.getRoutetp().substring(0, item.getRoutetp().length() - 2));
            tvPredictTime.setText(item.getArrtime());
            tvLeftStops.setText(item.getArrprevstationcnt());
            tvStopName.setText(item.getNodenm());
            tvStopId.setText(item.getNodeid());
        }

        void setBusStopItem(BusStopItem item) {
            tvBusStopName.setText(item.getNodenm());
            tvBusStopId.setText(item.getNodeno());
        }

    }

    public MainRecyclerViewAdapter(List<Object> list) {
        items = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof Bus) {
            return VIEWTYPE_BUS;
        } else if (items.get(position) instanceof BusStop) {
            return VIEWTYPE_BUS_STOP;
        }
        return super.getItemViewType(position);
    }

    @Override
    public MainRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;

        if (viewType == VIEWTYPE_BUS) {
            view = inflater.inflate(R.layout.main_bus_loading_item, parent, false);
        } else if(viewType == VIEWTYPE_BUS_STOP) {
            view = inflater.inflate(R.layout.main_bus_stop_item, parent, false);
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainRecyclerViewAdapter.ViewHolder holder, int position) {
        if(mItemViewType == VIEWTYPE_BUS) {
            holder.setBusItem((BusArrivalItem) items.get(position));
        } else  if(mItemViewType == VIEWTYPE_BUS_STOP) {
            holder.setBusStopItem((BusStopItem) items.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
