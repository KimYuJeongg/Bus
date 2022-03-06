package com.example.bus.data.busroute;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BusRouteInterface {

    @GET("http://apis.data.go.kr/1613000/BusRouteInfoInqireService/getRouteAcctoThrghSttnList")
    Call<BusRouteExample> getBusStop(
            @Query("serviceKey") String serviceKey,
            @Query("numOfRows") int numOfRows,
            @Query("_type") String type,
            @Query("cityCode") int cityCode,
            @Query("routeId") String routeId
    );

}
