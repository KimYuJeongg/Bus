package com.example.bus.data.busnumber;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusNumberItems {

    @SerializedName("item")
    @Expose
    private List<BusNumberItem> busItem = null;

    public List<BusNumberItem> getBusItem() {
        return busItem;
    }

    public void setBusItem(List<BusNumberItem> busItem) {
        this.busItem = this.busItem;
    }

}
