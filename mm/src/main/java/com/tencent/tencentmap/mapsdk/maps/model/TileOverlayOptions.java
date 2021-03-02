package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;

public final class TileOverlayOptions {
    private boolean mBetterQuality = true;
    private volatile String mDiskCacheDir;
    private int mMaxMemoryCacheSize;
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

    public final TileOverlayOptions maxMemoryCacheSize(int i2) {
        this.mMaxMemoryCacheSize = i2;
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

    public final int getMaxMemoryCacheSize(TencentMapContext tencentMapContext) {
        AppMethodBeat.i(181090);
        if (this.mMaxMemoryCacheSize == 0) {
            int screenPixels = tencentMapContext.getScreenPixels() * 4;
            AppMethodBeat.o(181090);
            return screenPixels;
        }
        int i2 = this.mMaxMemoryCacheSize;
        AppMethodBeat.o(181090);
        return i2;
    }

    public final String toString() {
        AppMethodBeat.i(193616);
        String str = "{mDiskCacheDir='" + this.mDiskCacheDir + '\'' + ", mVersionInfo='" + this.mVersionInfo + '\'' + ", mZIndex=" + this.mZIndex + ", mBetterQuality=" + this.mBetterQuality + ", mMaxMemoryCacheSize=" + this.mMaxMemoryCacheSize + '}';
        AppMethodBeat.o(193616);
        return str;
    }
}
