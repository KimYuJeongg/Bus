package com.example.bus.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusStopItems {

    @SerializedName("item")
    @Expose
    private List<BusStopItem> item = null;

    public List<BusStopItem> getItem() {
        return item;
    }

    public void setItem(List<BusStopItem> item) {
        this.item = item;
    }

}
