package com.example.bus.data;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BusStopInterface {

    @GET("http://apis.data.go.kr/1613000/BusSttnInfoInqireService/getSttnNoList")
    Call<Example> getBusStop(
            @Query("serviceKey") String serviceKey,
            @Query("pageNo") int pageNo,
            @Query("numOfRows") int numOfRows,
            @Query("_type") String type,
            @Query("cityCode") int cityCode,
            @Query("nodeNm") String nodeNm
//            @Query("nodeNo") int nodeNo
    );

}
