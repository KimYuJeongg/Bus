package com.example.bus.data.bus;

import com.example.bus.data.Header;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusResult {

    @SerializedName("header")
    @Expose
    private Header header;
    @SerializedName("body")
    @Expose
    private BusBody body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public BusBody getBody() {
        return body;
    }

    public void setBody(BusBody body) {
        this.body = body;
    }

}
