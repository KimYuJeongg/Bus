package com.example.bus.data;

import android.util.Log;

import com.example.bus.data.busdetail.BusDetailInterface;
import com.example.bus.data.busdetail.BusDetailResult;
import com.example.bus.data.busnumber.BusNumberInterface;
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
    private final BusStopInterface busStopInterface;
    private final BusNumberInterface busNumberInterface;
    private final BusArrivalInterface busArrivalInterface;
    private final BusRouteInterface busRouteInterface;
    private final BusDetailInterface busDetailInterface;

    private RetrofitClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor()).build();

        final String baseUrl = "http://apis.data.go.kr/1613000/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        busStopInterface = retrofit.create(BusStopInterface.class);
        busNumberInterface = retrofit.create(BusNumberInterface.class);
        busArrivalInterface = retrofit.create(BusArrivalInterface.class);
        busRouteInterface = retrofit.create(BusRouteInterface.class);
        busDetailInterface = retrofit.create(BusDetailInterface.class);
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

    public BusNumberInterface getBusRetrofitInterface() {
        return busNumberInterface;
    }

    public BusArrivalInterface getBusArrivalRetrofitInterface() {
        return busArrivalInterface;
    }

    public BusRouteInterface getBusRouteRetrofitInterface() {
        return busRouteInterface;
    }

    public BusDetailInterface getBusDetailInterface() {
        return  busDetailInterface;
    }
}