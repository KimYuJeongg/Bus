package com.example.bus.data.busarrival;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusArrivalItem {

    @SerializedName("arrprevstationcnt")
    @Expose
    private Integer arrprevstationcnt;
    @SerializedName("arrtime")
    @Expose
    private Integer arrtime;
    @SerializedName("nodeid")
    @Expose
    private String nodeid;
    @SerializedName("nodenm")
    @Expose
    private String nodenm;
    @SerializedName("routeid")
    @Expose
    private String routeid;
    @SerializedName("routeno")
    @Expose
    private Integer routeno;
    @SerializedName("routetp")
    @Expose
    private String routetp;
    @SerializedName("vehicletp")
    @Expose
    private String vehicletp;

    public Integer getArrprevstationcnt() {
        return arrprevstationcnt;
    }

    public void setArrprevstationcnt(Integer arrprevstationcnt) {
        this.arrprevstationcnt = arrprevstationcnt;
    }

    public Integer getArrtime() {
        return arrtime;
    }

    public void setArrtime(Integer arrtime) {
        this.arrtime = arrtime;
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

    public String getRouteid() {
        return routeid;
    }

    public void setRouteid(String routeid) {
        this.routeid = routeid;
    }

    public Integer getRouteno() {
        return routeno;
    }

    public void setRouteno(Integer routeno) {
        this.routeno = routeno;
    }

    public String getRoutetp() {
        return routetp;
    }

    public void setRoutetp(String routetp) {
        this.routetp = routetp;
    }

    public String getVehicletp() {
        return vehicletp;
    }

    public void setVehicletp(String vehicletp) {
        this.vehicletp = vehicletp;
    }

}
