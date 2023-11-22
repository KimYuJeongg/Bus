package com.example.bus.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.BusActivity;
import com.example.bus.R;
import com.example.bus.data.busarrival.BusArrivalItem;
import com.example.bus.data.room.AppDatabase;
import com.example.bus.data.room.Bus;
import com.example.bus.data.room.BusDao;
import com.example.bus.tools.BusTypeColor;

import java.util.List;

public class BusArrivalRecyclerViewAdapter extends RecyclerView.Adapter<BusArrivalRecyclerViewAdapter.ViewHolder>{

    List<BusArrivalItem> items;
    private String nodeNo;
    private boolean isStar = false;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView busName, busType, leftStops, arrivalTime;
        ImageButton imgbtnBusBookMark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            busName = itemView.findViewById(R.id.busName);
            busType = itemView.findViewById(R.id.busType);
            leftStops = itemView.findViewById(R.id.leftStops);
            arrivalTime = itemView.findViewById(R.id.arrivalTime);
            imgbtnBusBookMark = itemView.findViewById(R.id.imgbtn_bus_bookmark);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), BusActivity.class);
                    final BusArrivalItem item = items.get(getBindingAdapterPosition());
                    intent.putExtra("busRouteId", item.getRouteid());
                    v.getContext().startActivity(intent);
                }
            });
        }

        public void setItem(BusArrivalItem item) {
            busName.setText(item.getRouteno().toString());
            busType.setText(item.getRoutetp().substring(0, item.getRoutetp().length() - 2));
            BusTypeColor busTypeColor = new BusTypeColor();
            busType.setBackgroundTintList(busTypeColor.getBusTypeColor(item.getRoutetp()));
            leftStops.setText(item.getArrprevstationcnt() + "번째 전");
            final int arrTime = Math.round(item.getArrtime() / 60);
            arrivalTime.setText(arrTime <= 0 ? "곧 도착" : arrTime + "분");

            AppDatabase db = AppDatabase.getInstance(itemView.getContext());
            BusDao busDao = db.busDao();
            isStar = busDao.getAllRouteIds().contains(item.getRouteid());
            if(isStar) {
                imgbtnBusBookMark.setImageResource(R.drawable.ic_star);
            }

            imgbtnBusBookMark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(isStar) {
                        imgbtnBusBookMark.setImageResource(R.drawable.ic_empty_star);
                        Bus bus = new Bus(item.getRouteid());
                        busDao.delete(bus);
                    } else {
                        imgbtnBusBookMark.setImageResource(R.drawable.ic_star);
                        Bus bus = new Bus(item.getRouteid(), item.getNodeid(), item.getNodenm(), 25, nodeNo, item.getRoutetp());
                        busDao.insert(bus);
                    }
                    isStar = !isStar;
                    Toast.makeText(view.getContext(), "즐겨찾기가 " + (isStar ? "추가" : "해제") + "되었습니다.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public BusArrivalRecyclerViewAdapter(List<BusArrivalItem> items, String nodeNo) {
        this.items = items;
        this.nodeNo = nodeNo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.arrival_bus_item, parent, false);

        return new ViewHolder(view);
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
