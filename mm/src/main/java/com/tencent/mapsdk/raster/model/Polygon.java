package com.tencent.mapsdk.raster.model;

import java.util.List;

public interface Polygon extends IOverlay {
    boolean contains(LatLng latLng);

    boolean equals(Object obj);

    int getFillColor();

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    String getId();

    int getLevel();

    List<LatLng> getPoints();

    int getStrokeColor();

    float getStrokeWidth();

    float getZIndex();

    int hashCode();

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    boolean isVisible();

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    void remove();

    void setFillColor(int i2);

    void setLevel(int i2);

    void setPoints(List<LatLng> list);

    void setStrokeColor(int i2);

    void setStrokeWidth(float f2);

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    void setVisible(boolean z);

    void setZIndex(float f2);
}
