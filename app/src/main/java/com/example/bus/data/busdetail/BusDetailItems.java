package com.example.bus.data.busdetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusDetailItems {

    @SerializedName("item")
    @Expose
    private BusDetailItem item;

    public BusDetailItem getBusDetailItem() {
        return item;
    }

    public void setItem(BusDetailItem item) {
        this.item = item;
    }

}