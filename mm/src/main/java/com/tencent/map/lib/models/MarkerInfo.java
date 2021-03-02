package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.OverlayLevel;

@Keep
public class MarkerInfo {
    public static final int TYPE_2D_GEO_ANGLE = 0;
    public static final int TYPE_2D_SCREEN_ANGLE = 1;
    public static final int TYPE_2D_UI = 2;
    public static final int TYPE_3D = 3;
    private float alpha = 1.0f;
    private float anchorX = 0.5f;
    private float anchorY = 0.5f;
    private float angle = 0.0f;
    private boolean avoidAnnotation = false;
    private boolean avoidOtherMarker = false;
    private int displayLevel = OverlayLevel.OverlayLevelAboveRoads;
    private boolean forceLoad = true;
    private int iconHeight;
    private String iconName;
    private int iconWidth;
    private boolean interactive = true;
    private double latitude;
    private double longitude;
    private SubMarkerInfo mSubMarkerInfo;
    private int maxScaleLevel = 30;
    private int minScaleLevel = 0;
    private int priority;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private int type = 1;
    private boolean visibility = true;

    private MarkerInfo() {
    }

    public MarkerInfo(double d2, double d3, String str) {
        this.latitude = d2;
        this.longitude = d3;
        this.iconName = str;
    }

    public MarkerInfo position(double d2, double d3) {
        this.latitude = d2;
        this.longitude = d3;
        return this;
    }

    public MarkerInfo iconName(String str) {
        this.iconName = str;
        return this;
    }

    public MarkerInfo type(int i2) {
        this.type = i2;
        return this;
    }

    public MarkerInfo anchor(float f2, float f3) {
        this.anchorX = f2;
        this.anchorY = f3;
        return this;
    }

    public MarkerInfo rotation(float f2) {
        this.angle = f2;
        return this;
    }

    public MarkerInfo alpha(float f2) {
        this.alpha = f2;
        return this;
    }

    public MarkerInfo scale(float f2, float f3) {
        this.scaleX = f2;
        this.scaleY = f3;
        return this;
    }

    public MarkerInfo avoidAnnotation(boolean z) {
        this.avoidAnnotation = z;
        return this;
    }

    public MarkerInfo interactive(boolean z) {
        this.interactive = z;
        return this;
    }

    public MarkerInfo displayLevel(int i2) {
        this.displayLevel = i2;
        return this;
    }

    public MarkerInfo priority(int i2) {
        this.priority = i2;
        return this;
    }

    public MarkerInfo forceLoad(boolean z) {
        this.forceLoad = z;
        return this;
    }

    public MarkerInfo minScaleLevel(int i2) {
        this.minScaleLevel = i2;
        return this;
    }

    public MarkerInfo maxScaleLevel(int i2) {
        this.maxScaleLevel = i2;
        return this;
    }

    public MarkerInfo visible(boolean z) {
        this.visibility = z;
        return this;
    }

    public MarkerInfo avoidOtherMarker(boolean z) {
        this.avoidOtherMarker = z;
        return this;
    }

    public MarkerInfo subMarkerInfo(SubMarkerInfo subMarkerInfo) {
        this.mSubMarkerInfo = subMarkerInfo;
        return this;
    }

    public MarkerInfo iconWidth(int i2) {
        this.iconWidth = i2;
        return this;
    }

    public MarkerInfo iconHeight(int i2) {
        this.iconHeight = i2;
        return this;
    }

    public String toString() {
        AppMethodBeat.i(193499);
        String str = "MarkerInfo{type=" + this.type + ", iconName='" + this.iconName + '\'' + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", anchorX=" + this.anchorX + ", anchorY=" + this.anchorY + ", angle=" + this.angle + ", alpha=" + this.alpha + ", scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", avoidAnnotation=" + this.avoidAnnotation + ", interactive=" + this.interactive + ", displayLevel=" + this.displayLevel + ", priority=" + this.priority + ", forceLoad=" + this.forceLoad + ", minScaleLevel=" + this.minScaleLevel + ", maxScaleLevel=" + this.maxScaleLevel + ", visibility=" + this.visibility + ", avoidOtherMarker=" + this.avoidOtherMarker + ", iconWidth=" + this.iconWidth + ", iconHeight=" + this.iconHeight + ", mSubMarkerInfo=" + this.mSubMarkerInfo + '}';
        AppMethodBeat.o(193499);
        return str;
    }
}
