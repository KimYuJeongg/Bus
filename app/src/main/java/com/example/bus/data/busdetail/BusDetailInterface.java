package com.example.bus.data.busdetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BusDetailInterface {

    @GET("http://apis.data.go.kr/1613000/BusRouteInfoInqireService/getRouteInfoIem")
    Call<BusDetailExample> getBusDetail(
            @Query("serviceKey") String serviceKey,
            @Query("_type") String type,
            @Query("cityCode") int cityCode,
            @Query("routeId") String nodeId
    );
}
