package com.tencent.tencentmap.mapsdk.maps.model;

public interface TrafficEvent {
    String getDescription();

    int getEndTime();

    String getMessage();

    String getRoadName();

    String getSource();

    int getStartTime();

    String getType();

    int getUpdateTime();
}
