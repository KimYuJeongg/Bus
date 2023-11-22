package com.example.bus.data.room;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface BusStopDao {
    @Query("SELECT * FROM bus_stop")
    List<BusStop> getAllBusStops();

    @Query("SELECT nodeId FROM bus_stop")
    List<String> getAllNodeIds();

    @Insert
    void insert(BusStop busStop);

    @Delete
    void delete(BusStop busStop);
}
