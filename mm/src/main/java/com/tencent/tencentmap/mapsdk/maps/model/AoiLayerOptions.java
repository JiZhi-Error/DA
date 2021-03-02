package com.tencent.tencentmap.mapsdk.maps.model;

public class AoiLayerOptions {
    private int mMaxLevel = -1;
    private int mMinLevel = -1;

    public AoiLayerOptions setDisplayLevel(int i2, int i3) {
        if (i2 >= 0 && i3 >= 0 && i2 <= i3) {
            if (i2 < 3) {
                i2 = 3;
            }
            if (i3 > 20) {
                i3 = 20;
            }
            this.mMinLevel = i2;
            this.mMaxLevel = i3;
        }
        return this;
    }

    public int getMinLevel() {
        return this.mMinLevel;
    }

    public int getMaxLevel() {
        return this.mMaxLevel;
    }
}
