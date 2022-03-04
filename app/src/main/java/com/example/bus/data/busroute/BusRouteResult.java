package com.example.bus.data.busroute;

import com.example.bus.data.Header;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusRouteResult {

    @SerializedName("header")
    @Expose
    private Header header;
    @SerializedName("body")
    @Expose
    private BusRouteBody body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public BusRouteBody getBody() {
        return body;
    }

    public void setBody(BusRouteBody body) {
        this.body = body;
    }

}
