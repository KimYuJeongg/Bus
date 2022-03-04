package com.example.bus.data.busroute;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusRouteExample {

    @SerializedName("response")
    @Expose
    private BusRouteResult result;

    public BusRouteResult getResult() {
        return result;
    }

    public void setResult(BusRouteResult result) {
        this.result = result;
    }

}
