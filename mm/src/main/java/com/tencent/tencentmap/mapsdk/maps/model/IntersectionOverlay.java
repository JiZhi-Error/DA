package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Rect;

public interface IntersectionOverlay {
    void remove();

    void setBounds(Rect rect);

    void setDarkMode(boolean z);

    void setData(byte[] bArr);

    void setDistance(int i2);

    void setVisibility(boolean z);
}
