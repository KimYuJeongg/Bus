package com.example.bus.data.room;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface BusDao {
    @Query("SELECT * FROM bus")
    List<Bus> getAllBuses();

    @Query("SELECT routeId FROM bus")
    List<Bus> getAllRouteIds();

    @Insert
    void insert(Bus bus);

    @Delete
    void delete(Bus bus);
}
