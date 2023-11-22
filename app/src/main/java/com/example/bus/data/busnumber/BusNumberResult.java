package com.example.bus.data.busnumber;

import com.example.bus.data.Header;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusNumberResult {

    @SerializedName("header")
    @Expose
    private Header header;
    @SerializedName("body")
    @Expose
    private BusNumberBody body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public BusNumberBody getBody() {
        return body;
    }

    public void setBody(BusNumberBody body) {
        this.body = body;
    }

}
