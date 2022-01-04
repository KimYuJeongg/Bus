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

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textBusNumber, textStation, textPredictTime, textSettingTime;

        ViewHolder(View itemView) {
            super(itemView);

            // 뷰 객체에 대한 참조. (hold strong reference)
            textBusNumber = itemView.findViewById(R.id.textBusNumber);
            textStation = itemView.findViewById(R.id.textStation);
            textPredictTime = itemView.findViewById(R.id.textPredictTime);
            textSettingTime = itemView.findViewById(R.id.textSettingTime);
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public MainRecyclerViewAdapter(ArrayList<String> list) {
        mData = list;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public MainRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.bus_item, parent, false);
        MainRecyclerViewAdapter.ViewHolder vh = new MainRecyclerViewAdapter.ViewHolder(view);

        return vh;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(MainRecyclerViewAdapter.ViewHolder holder, int position) {
        String text = mData.get(position);
        holder.textBusNumber.setText("603");
        holder.textStation.setText("서대전역 입구");
        holder.textPredictTime.setText("14분");
        holder.textSettingTime.setText("6분");
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size();
    }
}
