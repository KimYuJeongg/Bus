package com.example.bus.data.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bus_stop")
public class BusStop {

    public BusStop(String nodeId) {
        this.nodeId = nodeId;
    }

    public BusStop(String nodeId, String nodeNm, String busStopName) {
        this.nodeId = nodeId;
        this.nodeNm = nodeNm;
        this.busStopName = busStopName;
    }

    @PrimaryKey
    public String nodeId;

    @ColumnInfo(name = "node_number")
    public String nodeNm;

    @ColumnInfo(name = "bus_stop_name")
    public String busStopName;
}
