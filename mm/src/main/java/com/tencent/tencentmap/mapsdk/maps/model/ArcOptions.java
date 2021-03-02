package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.smtt.sdk.WebView;

public final class ArcOptions {
    float mAngle = 0.0f;
    int mColor = WebView.NIGHT_MODE_COLOR;
    LatLng mEndLatLng;
    LatLng mPassLatLng;
    boolean mShowArrow;
    LatLng mStartLatLng;
    int mStrokeColor;
    float mStrokeWidth = 0.0f;
    float mWidth = 5.0f;

    public final ArcOptions points(LatLng latLng, LatLng latLng2) {
        this.mStartLatLng = latLng;
        this.mEndLatLng = latLng2;
        return this;
    }

    public final ArcOptions pass(LatLng latLng) {
        this.mPassLatLng = latLng;
        return this;
    }

    public final ArcOptions angle(float f2) {
        this.mAngle = f2;
        return this;
    }

    public final ArcOptions width(float f2) {
        this.mWidth = f2;
        return this;
    }

    public final ArcOptions strokeWidth(float f2) {
        this.mStrokeWidth = f2;
        return this;
    }

    public final ArcOptions strokeColor(int i2) {
        this.mStrokeColor = i2;
        return this;
    }

    public final ArcOptions color(int i2) {
        this.mColor = i2;
        return this;
    }

    public final boolean isShowArrow() {
        return this.mShowArrow;
    }

    public final ArcOptions showArrow(boolean z) {
        this.mShowArrow = z;
        return this;
    }

    public final LatLng getStartLatLng() {
        return this.mStartLatLng;
    }

    public final LatLng getPassLatLng() {
        return this.mPassLatLng;
    }

    public final LatLng getEndLatLng() {
        return this.mEndLatLng;
    }

    public final float getAngle() {
        return this.mAngle;
    }

    public final float getWidth() {
        return this.mWidth;
    }

    public final float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public final int getStrokeColor() {
        return this.mStrokeColor;
    }

    public final int getColor() {
        return this.mColor;
    }
}
