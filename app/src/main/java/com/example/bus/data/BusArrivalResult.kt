package com.example.bus.data

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

class BusArrivalResult {

    @Xml(name = "response")
    data class Tour(
            @Element
            val header: Header,
            @Element
            val body: Body,
    ) {

    }

    @Xml(name = "header")
    data class Header(
            @PropertyElement
            val resultCode: Int,
            @PropertyElement
            val resultMsg: String,
    )

    @Xml(name = "body")
    data class Body(
            @Element
            val items: Items,
            @PropertyElement
            val numOfRows: Int,
            @PropertyElement
            val pageNo: Int,
            @PropertyElement
            val totalCount: Int,
    )

    @Xml
    data class Items(
            @Element(name = "item")
            val item: List<Item>
    )

    @Xml
    data class Item(
            @PropertyElement(name = "arrprevstationcnt") var arrPrevStationCnt: Int?,
            @PropertyElement(name = "arrtime") var arrTime: Int?,
            @PropertyElement(name = "nodeid") var nodeId: String?,
            @PropertyElement(name = "nodenm") var nodeNm: String?,
            @PropertyElement(name = "routeid") var routeId: String?,
            @PropertyElement(name = "routeno") var routeNo: Int?,
            @PropertyElement(name = "routetp") var routeTp: String?,
            @PropertyElement(name = "vehicletp") var vehicleTp: String?,
    ) {
        constructor() : this(null, null, null, null, null, null, null, null)
    }

}