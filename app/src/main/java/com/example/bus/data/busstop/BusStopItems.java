package com.example.bus.data.busstop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusStopItems {

    @SerializedName("item")
    @Expose
    private List<BusStopItem> busStopItem = null;

    public List<BusStopItem> getBusStopItem() {
        return busStopItem;
    }

    public void setBusStopItem(List<BusStopItem> busStopItem) {
        this.busStopItem = busStopItem;
    }

}
