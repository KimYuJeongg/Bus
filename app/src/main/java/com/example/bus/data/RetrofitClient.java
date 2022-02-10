package com.example.bus.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private static BusStopInterface busStopInterface;
    private static String baseUrl = "http://apis.data.go.kr/1613000";

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        busStopInterface = retrofit.create(BusStopInterface.class);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public static BusStopInterface getRetrofitInterface() {
        return busStopInterface;
    }

}
