package com.example.bus.tools;

import android.content.res.ColorStateList;
import android.graphics.Color;

import java.util.HashMap;

public class BusTypeColor {

    final HashMap<String, String> busStopData = new HashMap() {{
        put("급행버스", "#e35959");
        put("광역버스", "#e35959");
        put("좌석버스", "#e35959");
        put("시외버스", "#e35959");
        put("농어촌(좌석)버스", "#e35959");
        put("직행좌석버스", "#e35959");
        put("간선버스", "#598ee3");
        put("일반버스", "#598ee3");
        put("심야버스", "#598ee3");
        put("농어촌(일반)버스", "#598ee3");
        put("광역급행버스", "#598ee3");
        put("공항버스", "#598ee3");
        put("지선버스", "#39bd65");
        put("외곽버스", "#39bd65");
        put("마을버스", "#39bd65");
        put("첨단버스", "#39bd65");
        put("마중버스", "#39bd65");
        put("순환버스", "#FFBE3B");
    }};

    public ColorStateList getBusTypeColor(String type) {
        return ColorStateList.valueOf(Color.parseColor(busStopData.getOrDefault(type, "#598ee3")));
    }

}
