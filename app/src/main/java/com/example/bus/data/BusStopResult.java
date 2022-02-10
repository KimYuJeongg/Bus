package com.example.bus.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusStopResult {

    @SerializedName("gpslati")
    @Expose
    private Double gpslati;
    @SerializedName("gpslong")
    @Expose
    private Double gpslong;
    @SerializedName("nodeid")
    @Expose
    private String nodeid;
    @SerializedName("nodenm")
    @Expose
    private String nodenm;
    @SerializedName("nodeno")
    @Expose
    private Integer nodeno;

    public Double getGpslati() {
        return gpslati;
    }

    public void setGpslati(Double gpslati) {
        this.gpslati = gpslati;
    }

    public Double getGpslong() {
        return gpslong;
    }

    public void setGpslong(Double gpslong) {
        this.gpslong = gpslong;
    }

    public String getNodeid() {
        return nodeid;
    }

    public void setNodeid(String nodeid) {
        this.nodeid = nodeid;
    }

    public String getNodenm() {
        return nodenm;
    }

    public void setNodenm(String nodenm) {
        this.nodenm = nodenm;
    }

    public Integer getNodeno() {
        return nodeno;
    }

    public void setNodeno(Integer nodeno) {
        this.nodeno = nodeno;
    }

}
