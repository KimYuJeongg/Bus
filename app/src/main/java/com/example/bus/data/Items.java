package com.example.bus.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {

    @SerializedName("item")
    @Expose
    private BusStopItem busStopItem;

    public BusStopItem getBusStopItem() {
        return busStopItem;
    }

    public void setBusStopItem(BusStopItem busStopItem) {
        this.busStopItem = busStopItem;
    }
}
