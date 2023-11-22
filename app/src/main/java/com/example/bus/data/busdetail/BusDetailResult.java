package com.example.bus.data.busdetail;

import com.example.bus.data.Header;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusDetailResult {

    @SerializedName("header")
    @Expose
    private Header header;
    @SerializedName("body")
    @Expose
    private BusDetailBody body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public BusDetailBody getBody() {
        return body;
    }

    public void setBody(BusDetailBody body) {
        this.body = body;
    }

}