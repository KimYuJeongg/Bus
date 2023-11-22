package com.example.bus.data.busdetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusDetailBody {

    @SerializedName("items")
    @Expose
    private BusDetailItems items;

    public BusDetailItems getItems() {
        return items;
    }

    public void setItems(BusDetailItems items) {
        this.items = items;
    }
}