package com.example.bus.data.bus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusItem {

    @SerializedName("endnodenm")
    @Expose
    private String endnodenm;
    @SerializedName("endvehicletime")
    @Expose
    private Integer endvehicletime;
    @SerializedName("routeid")
    @Expose
    private String routeid;
    @SerializedName("routeno")
    @Expose
    private Integer routeno;
    @SerializedName("routetp")
    @Expose
    private String routetp;
    @SerializedName("startnodenm")
    @Expose
    private String startnodenm;
    @SerializedName("startvehicletime")
    @Expose
    private String startvehicletime;

    public String getEndnodenm() {
        return endnodenm;
    }

    public void setEndnodenm(String endnodenm) {
        this.endnodenm = endnodenm;
    }

    public Integer getEndvehicletime() {
        return endvehicletime;
    }

    public void setEndvehicletime(Integer endvehicletime) {
        this.endvehicletime = endvehicletime;
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

    public String getStartnodenm() {
        return startnodenm;
    }

    public void setStartnodenm(String startnodenm) {
        this.startnodenm = startnodenm;
    }

    public String getStartvehicletime() {
        return startvehicletime;
    }

    public void setStartvehicletime(String startvehicletime) {
        this.startvehicletime = startvehicletime;
    }

}
