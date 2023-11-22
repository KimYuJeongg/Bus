package com.example.bus.data.busdetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusDetailExample {

    @SerializedName("response")
    @Expose
    private BusDetailResult result;

    public BusDetailResult getResult() {
        return result;
    }

    public void setResponse(BusDetailResult result) {
        this.result = result;
    }

}