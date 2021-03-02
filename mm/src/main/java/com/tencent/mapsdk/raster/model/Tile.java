package com.tencent.mapsdk.raster.model;

public final class Tile {
    public final byte[] mData;
    public final int mHeight;
    public final int mWidth;

    public Tile(int i2, int i3, byte[] bArr) {
        this.mWidth = i2;
        this.mHeight = i3;
        this.mData = bArr;
    }
}
