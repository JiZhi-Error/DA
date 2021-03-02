package com.tencent.map.sdk.comps.indoor;

import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public interface IIndoor {
    @Deprecated
    String getActivedIndoorBuilding(LatLng latLng);

    String[] getActivedIndoorFloorNames();

    int getIndoorFloorId();

    void setIndoorEnabled(boolean z);

    void setIndoorFloor(int i2);

    void setIndoorFloor(String str, String str2);

    void setIndoorMaskColor(int i2);

    void setOnIndoorStateChangeListener(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener);
}
