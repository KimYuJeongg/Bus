package com.example.bus.data.busnumber;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusNumberBody {

    @SerializedName("items")
    @Expose
    private BusNumberItems items;

    @SerializedName("numOfRows")
    @Expose
    private Integer numOfRows;
    @SerializedName("pageNo")
    @Expose
    private Integer pageNo;
    @SerializedName("totalCount")
    @Expose
    private Integer totalCount;

    public BusNumberItems getItems() {
        return items;
    }

    public void setItems(BusNumberItems items) {
        this.items = items;
    }

    public Integer getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(Integer numOfRows) {
        this.numOfRows = numOfRows;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

}
