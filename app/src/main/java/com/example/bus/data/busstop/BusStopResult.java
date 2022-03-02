package com.example.bus.data.busstop;

import com.example.bus.data.Header;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusStopResult {

    @SerializedName("header")
    @Expose
    private Header header;
    @SerializedName("body")
    @Expose
    private BusStopBody body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public BusStopBody getBody() {
        return body;
    }

    public void setBody(BusStopBody body) {
        this.body = body;
    }

}
