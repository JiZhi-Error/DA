package com.tencent.map.sdk.comps.mylocation;

import android.location.Location;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;

public interface IMyLocation {
    Location getMyLocation();

    boolean isMyLocationEnabled();

    void setLocationSource(LocationSource locationSource);

    void setMyLocationClickListener(TencentMap.OnMyLocationClickListener onMyLocationClickListener);

    void setMyLocationEnabled(boolean z);

    void setMyLocationStyle(MyLocationStyle myLocationStyle);

    void setOnMyLocationChangeListener(TencentMap.OnMyLocationChangeListener onMyLocationChangeListener);
}
