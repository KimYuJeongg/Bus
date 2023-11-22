package com.example.bus.data.busarrival;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusArrivalExample {

    @SerializedName("response")
    @Expose
    private BusArrivalResult result;

    public BusArrivalResult getResult() {
        return result;
    }

    public void setResult(BusArrivalResult result) {
        this.result = result;
    }

}
