package com.example.bus.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BusStopInterface {

    @GET("http://apis.data.go.kr/1613000/BusSttnInfoInqireService/getSttnNoList")
    Call<Example> getBusStop(
            @Query("serviceKey") String serviceKey,
            @Query("numOfRows") int numOfRows,
            @Query("_type") String type,
            @Query("cityCode") int cityCode,
            @Query("nodeNm") String nodeNm
    );

}
