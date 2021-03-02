package com.tencent.tencentmap.mapsdk.maps.model;

public class IndoorMapPoi extends MapPoi {
    public String buildingId;
    public String buildingName;
    public String floorName;

    public String getBuildingId() {
        return this.buildingId;
    }

    public String getBuildingName() {
        return this.buildingName;
    }

    public String getFloorName() {
        return this.floorName;
    }
}
