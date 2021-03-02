package com.tencent.tencentmap.mapsdk.maps.model;

public interface TencentMapGestureListener {
    boolean onDoubleTap(float f2, float f3);

    boolean onDown(float f2, float f3);

    boolean onFling(float f2, float f3);

    boolean onLongPress(float f2, float f3);

    void onMapStable();

    boolean onScroll(float f2, float f3);

    boolean onSingleTap(float f2, float f3);

    boolean onUp(float f2, float f3);
}
