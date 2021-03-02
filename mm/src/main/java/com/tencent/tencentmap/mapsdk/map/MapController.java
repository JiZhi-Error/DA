package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.raster.model.LatLng;

@Deprecated
public interface MapController {
    @Deprecated
    void animateTo(LatLng latLng);

    @Deprecated
    void animateTo(LatLng latLng, long j2, CancelableCallback cancelableCallback);

    @Deprecated
    void animateTo(LatLng latLng, Runnable runnable);

    @Deprecated
    void setCenter(LatLng latLng);

    @Deprecated
    void setZoom(int i2);

    void zoomToSpan(double d2, double d3);

    void zoomToSpan(LatLng latLng, LatLng latLng2);
}
