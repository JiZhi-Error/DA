package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class IndoorInfo {
    private String buildingId;
    private String floorName;

    public IndoorInfo(String str, String str2) {
        this.buildingId = str;
        this.floorName = str2;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public String getFloorName() {
        return this.floorName;
    }

    public String toString() {
        AppMethodBeat.i(173141);
        String str = this.buildingId + "_" + this.floorName;
        AppMethodBeat.o(173141);
        return str;
    }
}
