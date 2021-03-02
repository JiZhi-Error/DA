package com.tencent.map.lib.models;

import android.graphics.Rect;
import android.support.annotation.Keep;

@Keep
public class IntersectionOverlayInfo {
    protected Rect mBounds;
    protected byte[] mData;
    protected int mDistance;
    protected boolean mIsDarkMode;
    protected boolean mVisibility = true;

    public void setBounds(Rect rect) {
        this.mBounds = rect;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public void setVisibility(boolean z) {
        this.mVisibility = z;
    }

    public void setDistance(int i2) {
        this.mDistance = i2;
    }

    public void enableDarkMode(boolean z) {
        this.mIsDarkMode = z;
    }
}
