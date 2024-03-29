package com.example.bus.tools;

import java.util.HashMap;

public class BusCityCode {

    final HashMap<String, Integer> busCityCode = new HashMap() {{
        put("세종특별시", 12);
        put("부산광역시", 21);
        put("대구광역시", 22);
        put("인천광역시", 23);
        put("광주광역시", 24);
        put("대전광역시/계룡시", 25);
        put("울산광역시", 26);
        put("제주도", 39);
        put("수원시", 31010);
        put("성남시", 31020);
        put("의정부시", 31030);
        put("안양시", 31040);
        put("부천시", 31050);
        put("광명시", 31060);
        put("평택시", 31070);
        put("동두천시", 31080);
        put("안산시", 31090);
        put("고양시", 31100);
        put("과천시", 31110);
        put("구리시", 31120);
        put("남양주시", 31130);
        put("오산시", 31140);
        put("시흥시", 31150);
        put("군포시", 31160);
        put("의왕시", 31170);
        put("하남시", 31180);
        put("용인시", 31190);
        put("파주시", 31200);
        put("이천시", 31210);
        put("안성시", 31220);
        put("김포시", 31230);
        put("화성시", 31240);
        put("광주시", 31250);
        put("양주시", 31260);
        put("포천시", 31270);
        put("여주군", 31320);
        put("연천군", 31350);
        put("가평군", 31370);
        put("양평군", 31380);
        put("춘천시", 32010);
        put("원주시/횡성군", 32020);
        put("태백시", 32050);
        put("속초시", 32060);
        put("홍천군", 32310);
        put("영월군", 32330);
        put("철원군", 32360);
        put("화천군", 32370);
        put("양구군", 32380);
        put("인제군", 32390);
        put("고성군", 32400);
        put("양양군", 32410);
        put("청주시", 33010);
        put("충주시", 33020);
        put("제천시", 33030);
        put("보은군", 33320);
        put("옥천군", 33330);
        put("영동군", 33340);
        put("진천군", 33350);
        put("괴산군", 33360);
        put("음성군", 33370);
        put("단양군", 33380);
        put("천안시", 34010);
        put("공주시", 34020);
        put("아산시", 34040);
        put("서산시", 34050);
        put("논산시", 34060);
        put("계룡시", 34070);
        put("부여군", 34330);
        put("당진시", 34390);
        put("전주시", 35010);
        put("군산시", 35020);
        put("익산시", 35030);
        put("정읍시", 35040);
        put("남원시", 35050);
        put("김제시", 35060);
        put("진안군", 35320);
        put("무주군", 35330);
        put("장수군", 35340);
        put("임실군", 35350);
        put("순창군", 35360);
        put("고창군", 35370);
        put("부안군", 35380);
        put("목포시", 36010);
        put("여수시", 36020);
        put("순천시", 36030);
        put("나주시", 36040);
        put("광양시", 36060);
        put("곡성군", 36320);
        put("구례군", 36330);
        put("고흥군", 36350);
        put("장흥군", 36380);
        put("해남군", 36400);
        put("영암군", 36410);
        put("무안군", 36420);
        put("함평군", 36430);
        put("영광군", 36440);
        put("장성군", 36450);
        put("완도군", 36460);
        put("진도군", 36470);
        put("신안군", 36480);
        put("포항시", 37010);
        put("경주시", 37020);
        put("김천시", 37030);
        put("안동시", 37040);
        put("구미시", 37050);
        put("영주시", 37060);
        put("영천시", 37070);
        put("상주시", 37080);
        put("문경시", 37090);
        put("경산시", 37100);
        put("군위군", 37310);
        put("의성군", 37320);
        put("청송군", 37330);
        put("영양군", 37340);
        put("영덕군", 37350);
        put("청도군", 37360);
        put("고령군", 37370);
        put("칠곡군", 37390);
        put("예천군", 37400);
        put("봉화군", 37410);
        put("울진군", 37420);
        put("울릉군", 37430);
        put("창원시", 38010);
        put("진주시", 38030);
        put("통영시", 38050);
        put("사천시", 38060);
        put("김해시", 38070);
        put("밀양시", 38080);
        put("거제시", 38090);
        put("양산시", 38100);
        put("의령군", 38310);
        put("함안군", 38320);
        put("창녕군", 38330);
//        put("고성군", 38340);
        put("남해군", 38350);
        put("하동군", 38360);
        put("산청군", 38370);
        put("함양군", 38380);
        put("거창군", 38390);
        put("합천군", 38400);
    }};

    public int getBusCityCode(String city) {
        return busCityCode.get(city);
    }
}
