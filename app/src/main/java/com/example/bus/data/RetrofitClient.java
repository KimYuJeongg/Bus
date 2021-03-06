package com.example.bus.data;

import android.util.Log;

import com.example.bus.data.bus.BusInterface;
import com.example.bus.data.busarrival.BusArrivalInterface;
import com.example.bus.data.busroute.BusRouteInterface;
import com.example.bus.data.busstop.BusStopInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private BusStopInterface busStopInterface;
    private BusInterface busInterface;
    private BusArrivalInterface busArrivalInterface;
    private BusRouteInterface busRouteInterface;
    private String baseUrl = "http://apis.data.go.kr/1613000/";

    private RetrofitClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor()).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        busStopInterface = retrofit.create(BusStopInterface.class);
        busInterface = retrofit.create(BusInterface.class);
        busArrivalInterface = retrofit.create(BusArrivalInterface.class);
        busRouteInterface = retrofit.create(BusRouteInterface.class);
    }

    private HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("HttpLoggingInterceptor :", message + "");
            }
        });

        return interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public BusStopInterface getBusStopRetrofitInterface() {
        return busStopInterface;
    }

    public BusInterface getBusRetrofitInterface() {
        return busInterface;
    }

    public BusArrivalInterface getBusArrivalRetrofitInterface() {
        return busArrivalInterface;
    }

    public BusRouteInterface getBusRouteRetrofitInterface() {
        return busRouteInterface;
    }

}