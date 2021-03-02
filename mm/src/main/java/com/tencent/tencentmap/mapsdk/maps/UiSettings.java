package com.tencent.tencentmap.mapsdk.maps;

public interface UiSettings {
    boolean isCompassEnabled();

    boolean isIndoorLevelPickerEnabled();

    boolean isMyLocationButtonEnabled();

    boolean isRotateGesturesEnabled();

    boolean isScaleViewEnabled();

    boolean isScrollGesturesEnabled();

    boolean isTiltGesturesEnabled();

    boolean isZoomControlsEnabled();

    boolean isZoomGesturesEnabled();

    void setAllGesturesEnabled(boolean z);

    void setCompassEnabled(boolean z);

    void setCompassExtraPadding(int i2);

    void setCompassExtraPadding(int i2, int i3);

    void setFlingGestureEnabled(boolean z);

    void setGestureScaleByMapCenter(boolean z);

    void setIndoorLevelPickerEnabled(boolean z);

    void setLogoPosition(int i2);

    void setLogoPosition(int i2, int[] iArr);

    void setLogoPositionWithMargin(int i2, int i3, int i4, int i5, int i6);

    void setLogoScale(float f2);

    void setLogoSize(int i2);

    void setMyLocationButtonEnabled(boolean z);

    void setRotateGesturesEnabled(boolean z);

    void setScaleViewEnabled(boolean z);

    void setScaleViewFadeEnable(boolean z);

    void setScaleViewPosition(int i2);

    void setScaleViewPositionWithMargin(int i2, int i3, int i4, int i5, int i6);

    void setScrollGesturesEnabled(boolean z);

    void setTiltGesturesEnabled(boolean z);

    void setZoomControlsEnabled(boolean z);

    void setZoomGesturesEnabled(boolean z);

    void setZoomPosition(int i2);
}
