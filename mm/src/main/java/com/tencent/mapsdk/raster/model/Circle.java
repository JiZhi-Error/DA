package com.tencent.mapsdk.raster.model;

import android.graphics.DashPathEffect;

public interface Circle extends IOverlay {
    boolean contains(LatLng latLng);

    boolean equals(Object obj);

    LatLng getCenter();

    int getFillColor();

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    String getId();

    int getLevel();

    double getRadius();

    int getStrokeColor();

    boolean getStrokeDash();

    DashPathEffect getStrokeDashPathEffect();

    float getStrokeWidth();

    float getZIndex();

    int hashCode();

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    boolean isVisible();

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    void remove();

    void setCenter(LatLng latLng);

    void setFillColor(int i2);

    void setLevel(int i2);

    void setRadius(double d2);

    void setStrokeColor(int i2);

    void setStrokeDash(boolean z);

    void setStrokeWidth(float f2);

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    void setVisible(boolean z);

    void setZIndex(float f2);

    void strokeDashPathEffect(DashPathEffect dashPathEffect);
}
