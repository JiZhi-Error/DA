package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.OverlayLevel;

@Keep
public class PolygonInfo {
    public int borderColor;
    public int borderLineId;
    public float borderWidth;
    public int color;
    public int level = OverlayLevel.OverlayLevelAboveLabels;
    public int maxScaleLevel = 30;
    public int minScaleLevel;
    public int[] pattern;
    public LatLng[] points;
    public int polygonId;
    public String textureName;
    public int textureSpacing;
    public float zIndex = 0.0f;

    public String toString() {
        AppMethodBeat.i(193500);
        StringBuffer stringBuffer = new StringBuffer("Polygon2D{");
        stringBuffer.append(", color=").append(this.color);
        stringBuffer.append(", borderColor=").append(this.borderColor);
        stringBuffer.append(", borderWidth=").append(this.borderWidth);
        stringBuffer.append(", points=").append(this.points == null ? BuildConfig.COMMAND : Integer.valueOf(this.points.length));
        stringBuffer.append(", polygonId=").append(this.polygonId);
        stringBuffer.append(", borderLineId=").append(this.borderLineId);
        stringBuffer.append(", zIndex=").append(this.zIndex);
        stringBuffer.append(", level=").append(this.level);
        stringBuffer.append('}');
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(193500);
        return stringBuffer2;
    }
}
