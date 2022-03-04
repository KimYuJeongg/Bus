package com.example.bus.data.busroute;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusRouteItems {

    @SerializedName("item")
    @Expose
    private List<BusRouteItem> busRouteItem = null;

    public List<BusRouteItem> getBusRouteItem() {
        return busRouteItem;
    }

    public void setBusRouteItem(List<BusRouteItem> busItem) {
        this.busRouteItem = this.busRouteItem;
    }

}
