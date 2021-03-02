package com.tencent.mapsdk.raster.model;

public interface CustomLayer {
    void clearDiskCache();

    String getId();

    void reload();

    void remove();
}
