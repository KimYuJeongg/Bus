package com.example.bus.data.bus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusItems {

    @SerializedName("item")
    @Expose
    private List<BusItem> busItem = null;

    public List<BusItem> getBusItem() {
        return busItem;
    }

    public void setBusItem(List<BusItem> busItem) {
        this.busItem = this.busItem;
    }

}
