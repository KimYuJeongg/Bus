package com.example.bus.data.bus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusExample {

    @SerializedName("response")
    @Expose
    private BusResult result;

    public BusResult getResult() {
        return result;
    }

    public void setResult(BusResult result) {
        this.result = result;
    }

}
