package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import com.tencent.tencentmap.mapsdk.maps.model.OverlayLevel;

@Keep
public class CircleInfo {
    public int borderColor;
    public float borderWidth;
    public int centerX;
    public int centerY;
    public boolean drawBorder = true;
    public boolean drawFill = true;
    public int fillColor;
    public boolean isVisible = true;
    public int level = OverlayLevel.OverlayLevelAboveLabels;
    public float radius;
    public int zIndex = 0;
}
