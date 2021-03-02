package com.tencent.mapsdk.raster.model;

import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {
    private static final boolean PRINT_URL = false;
    public final int mHeight;
    public final int mWidth;

    public abstract URL getTileUrl(int i2, int i3, int i4);

    public UrlTileProvider(int i2, int i3) {
        this.mWidth = i2;
        this.mHeight = i3;
    }

    @Override // com.tencent.mapsdk.raster.model.TileProvider
    public Tile getTile(int i2, int i3, int i4) {
        return null;
    }
}
