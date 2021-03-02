package com.tencent.mapsdk.raster.model;

import java.util.List;

public interface Polyline extends IOverlay {
    boolean equals(Object obj);

    void eraseTo(int i2, LatLng latLng);

    int getColor();

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    String getId();

    int getLevel();

    List<LatLng> getPoints();

    float getWidth();

    float getZIndex();

    int hashCode();

    boolean isDottedLine();

    boolean isGeodesic();

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    boolean isVisible();

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    void remove();

    void setColor(int i2);

    void setColorTexture(BitmapDescriptor bitmapDescriptor);

    void setDottedLine(boolean z);

    void setEraseable(boolean z);

    void setGeodesic(boolean z);

    void setLevel(int i2);

    void setPoints(List<LatLng> list);

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    void setVisible(boolean z);

    void setWidth(float f2);

    void setZIndex(float f2);
}
