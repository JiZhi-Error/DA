package com.tencent.tencentmap.mapsdk.maps.model;

public final class IndoorLevel {
    private String floorName;

    public IndoorLevel(String str) {
        this.floorName = str;
    }

    public final String getName() {
        return this.floorName;
    }
}
