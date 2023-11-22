package com.example.bus.data.busdetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusDetailItem {

    @SerializedName("endnodenm")
    @Expose
    private String endnodenm;
    @SerializedName("endvehicletime")
    @Expose
    private Integer endvehicletime;
    @SerializedName("intervalsattime")
    @Expose
    private Integer intervalsattime;
    @SerializedName("intervalsuntime")
    @Expose
    private Integer intervalsuntime;
    @SerializedName("intervaltime")
    @Expose
    private Integer intervaltime;
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

    public Integer getIntervalsattime() {
        return intervalsattime;
    }

    public void setIntervalsattime(Integer intervalsattime) {
        this.intervalsattime = intervalsattime;
    }

    public Integer getIntervalsuntime() {
        return intervalsuntime;
    }

    public void setIntervalsuntime(Integer intervalsuntime) {
        this.intervalsuntime = intervalsuntime;
    }

    public Integer getIntervaltime() {
        return intervaltime;
    }

    public void setIntervaltime(Integer intervaltime) {
        this.intervaltime = intervaltime;
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
