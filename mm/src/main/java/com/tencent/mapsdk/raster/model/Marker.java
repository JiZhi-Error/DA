package com.tencent.mapsdk.raster.model;

import android.view.View;
import android.view.animation.Animation;

public interface Marker extends IOverlay {
    boolean equals(Object obj);

    float getAlpha();

    String getContentDescription();

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    String getId();

    int getLevel();

    View getMarkerView();

    LatLng getPosition();

    float getRotation();

    String getSnippet();

    Object getTag();

    String getTitle();

    float getZIndex();

    int hashCode();

    void hideInfoWindow();

    boolean isDraggable();

    boolean isInfoWindowShown();

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    boolean isVisible();

    void refreshInfoWindow();

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    void remove();

    void set2Top();

    void setAlpha(float f2);

    void setAnchor(float f2, float f3);

    void setContentDescription(String str);

    void setDraggable(boolean z);

    void setIcon(BitmapDescriptor bitmapDescriptor);

    void setInfoWindowHideAnimation(Animation animation);

    void setInfoWindowOffset(int i2, int i3);

    void setInfoWindowShowAnimation(Animation animation);

    void setLevel(int i2);

    void setMarkerView(View view);

    void setPosition(LatLng latLng);

    void setRotation(float f2);

    void setSnippet(String str);

    void setTag(Object obj);

    void setTitle(String str);

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    void setVisible(boolean z);

    void setZIndex(float f2);

    void showInfoWindow();
}
