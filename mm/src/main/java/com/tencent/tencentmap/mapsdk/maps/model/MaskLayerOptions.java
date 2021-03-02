package com.tencent.tencentmap.mapsdk.maps.model;

public class MaskLayerOptions {
    private long mAnimationDuration = 0;
    private int mColor = 0;
    private int mZIndex = 0;

    public MaskLayerOptions color(int i2) {
        this.mColor = i2;
        return this;
    }

    public int getColor() {
        return this.mColor;
    }

    public MaskLayerOptions animationDuration(long j2) {
        this.mAnimationDuration = j2;
        return this;
    }

    public long getAnimationDuration() {
        return this.mAnimationDuration;
    }

    public MaskLayerOptions zIndex(int i2) {
        this.mZIndex = i2;
        return this;
    }

    public int getZIndex() {
        return this.mZIndex;
    }
}
