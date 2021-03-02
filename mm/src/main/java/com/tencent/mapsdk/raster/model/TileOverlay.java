package com.tencent.mapsdk.raster.model;

public interface TileOverlay {
    void clearTileCache();

    boolean equals(Object obj);

    String getId();

    int hashCode();

    void reload();

    void remove();

    void setDiskCacheDir(String str);

    void setZindex(int i2);
}
