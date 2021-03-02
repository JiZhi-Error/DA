package com.tencent.tencentmap.mapsdk.maps;

import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import java.util.List;

public interface TencentMapNavi extends TencentMap {
    IntersectionOverlay addIntersectionEnlargeOverlay(IntersectionOverlayOptions intersectionOverlayOptions);

    void addSegmentsWithRouteName(List<MapRouteSection> list, List<LatLng> list2);

    void animateToNaviPosition(LatLng latLng, float f2, float f3);

    void animateToNaviPosition(LatLng latLng, float f2, float f3, float f4);

    void animateToNaviPosition(LatLng latLng, float f2, float f3, float f4, boolean z);

    void animateToNaviPosition2(LatLng latLng, float f2, float f3, float f4, boolean z);

    float calNaviLevel(LatLngBounds latLngBounds, float f2, int i2, boolean z);

    float calNaviLevel2(LatLng latLng, LatLng latLng2, float f2, float f3, int i2, boolean z);

    float calNaviLevel3(LatLng latLng, LatLng latLng2, float f2, int i2, int i3, int i4, int i5, boolean z);

    CameraPosition calculateZoomToSpanLevelAsync(List<IOverlay> list, List<LatLng> list2, int i2, int i3, int i4, int i5, TencentMap.AsyncOperateCallback<CameraPosition> asyncOperateCallback);

    void clearRouteNameSegments();

    boolean isNaviStateEnabled();

    void moveToNavPosition(CameraUpdate cameraUpdate, LatLng latLng);

    void setNavCenter(int i2, int i3);

    void setNaviFixingProportion(float f2, float f3);

    void setNaviFixingProportion2D(float f2, float f3);

    void setNaviStateEnabled(boolean z);

    void setOptionalResourcePath(String str);
}
