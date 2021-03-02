package com.tencent.mapsdk.raster.model;

public interface TileProvider {
    public static final Tile NO_TILE = new Tile(-1, -1, null);

    Tile getTile(int i2, int i3, int i4);
}
