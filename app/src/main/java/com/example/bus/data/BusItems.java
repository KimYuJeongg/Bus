package com.example.bus.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusItems {

    @SerializedName("item")
    @Expose
    private List<BusItem> item = null;

    public List<BusItem> getItem() {
        return item;
    }

    public void setItem(List<BusItem> item) {
        this.item = item;
    }

}
