package com.example.bus.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BusArrivalAPI {

    @GET("openapi/service/")
    Call<Bus> getBusArrivalList(
            @Query("key") String key,
            @Query("cityCode") int cityCode
    );
}
