package com.example.bus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.R;

import java.util.ArrayList;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mData = null;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textBusNumber, textStation, textPredictTime, textSettingTime;

        ViewHolder(View itemView) {
            super(itemView);

            textBusNumber = itemView.findViewById(R.id.textBusNumber);
            textStation = itemView.findViewById(R.id.textStation);
            textPredictTime = itemView.findViewById(R.id.textPredictTime);
            textSettingTime = itemView.findViewById(R.id.textSettingTime);
        }
    }

    public MainRecyclerViewAdapter(ArrayList<String> list) {
        mData = list;
    }

    @Override
    public MainRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.bus_item, parent, false);
        MainRecyclerViewAdapter.ViewHolder vh = new MainRecyclerViewAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(MainRecyclerViewAdapter.ViewHolder holder, int position) {
        String text = mData.get(position);
        holder.textBusNumber.setText("603");
        holder.textStation.setText("서대전역 입구");
        holder.textPredictTime.setText("14분");
        holder.textSettingTime.setText("6분");
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
