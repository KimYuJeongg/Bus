package com.example.bus.data.busarrival;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BusArrivalInterface {

    @GET("http://apis.data.go.kr/1613000/ArvlInfoInqireService/getSttnAcctoArvlPrearngeInfoList")
    Call<BusArrivalExample> getArrivalBus(
            @Query("serviceKey") String serviceKey,
            @Query("numOfRows") int numOfRows,
            @Query("_type") String type,
            @Query("cityCode") int cityCode,
            @Query("nodeId") String nodeId
    );

}
