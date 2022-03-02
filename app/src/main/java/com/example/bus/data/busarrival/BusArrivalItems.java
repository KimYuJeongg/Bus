package com.example.bus.data.busarrival;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusArrivalItems {

    @SerializedName("item")
    @Expose
    private List<BusArrivalItem> busArrivalItem = null;

    public List<BusArrivalItem> getBusStopItem() {
        return busArrivalItem;
    }

    public void setBusStopItem(List<BusArrivalItem> busStopItem) {
        this.busArrivalItem = busStopItem;
    }

}
