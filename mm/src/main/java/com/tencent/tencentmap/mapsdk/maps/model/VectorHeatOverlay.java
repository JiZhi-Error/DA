package com.tencent.tencentmap.mapsdk.maps.model;

public interface VectorHeatOverlay {
    VectorHeatAggregationUnit getUnit(LatLng latLng);

    void remove();

    void setOpacity(float f2);

    void setVisibility(boolean z);
}
