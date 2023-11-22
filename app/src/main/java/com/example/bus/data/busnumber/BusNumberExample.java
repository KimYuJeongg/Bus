package com.example.bus.data.busnumber;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusNumberExample {

    @SerializedName("response")
    @Expose
    private BusNumberResult result;

    public BusNumberResult getResult() {
        return result;
    }

    public void setResult(BusNumberResult result) {
        this.result = result;
    }

}
