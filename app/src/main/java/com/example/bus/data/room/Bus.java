package com.example.bus.data.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bus")
public class Bus {

    public Bus(@NonNull String routeId) {
        this.routeId = routeId;
    }

    public Bus(@NonNull String routeId, String nodeId, String nodeNm, int cityCode, String nodeNo, String routeTp){
        this.routeId = routeId;
        this.nodeId = nodeId;
        this.nodeNm = nodeNm;
        this.nodeNo = nodeNo;
        this.routeTp = routeTp;
        this.cityCode = cityCode;
    }

    @NonNull
    @PrimaryKey
    public String routeId;

    @ColumnInfo(name = "node_id")
    public String nodeId;

    @ColumnInfo(name = "node_name")
    public String nodeNm;

    @ColumnInfo(name = "city_code")
    public int cityCode;

    @ColumnInfo(name = "node_number")
    public String nodeNo;

    @ColumnInfo(name = "route_type")
    public String routeTp;
}
