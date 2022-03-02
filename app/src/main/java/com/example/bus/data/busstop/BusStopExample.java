package com.example.bus.data.busstop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusStopExample {

    @SerializedName("response")
    @Expose
    private BusStopResult result;

    public BusStopResult getResult() {
        return result;
    }

    public void setResult(BusStopResult result) {
        this.result = result;
    }

}
