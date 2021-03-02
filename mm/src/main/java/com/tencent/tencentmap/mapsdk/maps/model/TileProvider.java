package com.tencent.tencentmap.mapsdk.maps.model;

public interface TileProvider {
    public static final Tile NO_TILE = Tile.EMPTY_TILE;

    Tile getTile(int i2, int i3, int i4);
}
