package com.example.bus.data;

import com.tickaroo.tikxml.TikXml;
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import retrofit2.Retrofit;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private static BusArrivalAPI busArrival;
    private static String baseUrl = "http://openapi.tago.go.kr/openapi/service/";

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(TikXmlConverterFactory.create(new TikXml.Builder().exceptionOnUnreadXml(false).build()))
                .build();
        busArrival = retrofit.create(BusArrivalAPI.class);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public static BusArrivalAPI getBusArrivalAPI() {
        return busArrival;
    }
}
