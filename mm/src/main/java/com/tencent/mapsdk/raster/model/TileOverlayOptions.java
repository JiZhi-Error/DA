package com.tencent.mapsdk.raster.model;

public final class TileOverlayOptions {
    private boolean mBetterQuality = true;
    private volatile String mDiskCacheDir;
    private TileProvider mTileProvider;
    private volatile String mVersionInfo;
    private int mZIndex = 1;

    public final TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.mTileProvider = tileProvider;
        return this;
    }

    public final TileOverlayOptions diskCacheDir(String str) {
        this.mDiskCacheDir = str;
        return this;
    }

    public final TileOverlayOptions versionInfo(String str) {
        this.mVersionInfo = str;
        return this;
    }

    public final TileOverlayOptions zIndex(int i2) {
        this.mZIndex = i2;
        return this;
    }

    public final TileOverlayOptions betterQuality(boolean z) {
        this.mBetterQuality = z;
        return this;
    }

    public final TileProvider getTileProvider() {
        return this.mTileProvider;
    }

    public final int getZIndex() {
        return this.mZIndex;
    }

    public final boolean isBetterQuality() {
        return this.mBetterQuality;
    }

    public final String getDiskCacheDir() {
        return this.mDiskCacheDir;
    }

    public final String getVersionInfo() {
        return this.mVersionInfo;
    }
}
