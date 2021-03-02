package com.tencent.tencentmap.mapsdk.maps.interfaces;

public interface Removable {
    boolean isRemoved();

    void releaseData();

    void remove();
}
