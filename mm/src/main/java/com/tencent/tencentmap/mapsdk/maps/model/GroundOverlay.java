package com.tencent.tencentmap.mapsdk.maps.model;

public interface GroundOverlay {
    void remove();

    void setAlpha(float f2);

    void setAnchor(float f2, float f3);

    void setBitmap(BitmapDescriptor bitmapDescriptor);

    void setLatLongBounds(LatLngBounds latLngBounds);

    void setLevel(int i2);

    void setPosition(LatLng latLng);

    void setVisibility(boolean z);

    void setZindex(int i2);

    void setZoom(float f2);
}
