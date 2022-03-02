package com.example.bus.data.busarrival;

import com.example.bus.data.Header;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusArrivalResult {

    @SerializedName("header")
    @Expose
    private Header header;
    @SerializedName("body")
    @Expose
    private BusArrivalBody body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public BusArrivalBody getBody() {
        return body;
    }

    public void setBody(BusArrivalBody body) {
        this.body = body;
    }

}
