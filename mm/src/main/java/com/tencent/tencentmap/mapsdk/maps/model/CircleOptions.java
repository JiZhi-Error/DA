package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public class CircleOptions {
    private boolean boVisible;
    private double dRadius;
    private float fStrokeWidth;
    private int iFillColor;
    private int iLevel;
    private int iStrokeColor;
    private int iZindex;
    private LatLng latlngCenter;
    private boolean mClickable;

    public CircleOptions() {
        AppMethodBeat.i(173128);
        this.iLevel = OverlayLevel.OverlayLevelAboveLabels;
        this.latlngCenter = new LatLng(39.984253d, 116.307439d);
        this.dRadius = 1.0d;
        this.fStrokeWidth = 1.0f;
        this.iStrokeColor = WebView.NIGHT_MODE_COLOR;
        this.iFillColor = 0;
        this.iZindex = 0;
        this.boVisible = true;
        AppMethodBeat.o(173128);
    }

    CircleOptions(int i2, LatLng latLng, double d2, float f2, int i3, int i4, int i5, boolean z) {
        AppMethodBeat.i(181059);
        this.iLevel = OverlayLevel.OverlayLevelAboveLabels;
        this.latlngCenter = new LatLng(39.984253d, 116.307439d);
        this.dRadius = 1.0d;
        this.fStrokeWidth = 1.0f;
        this.iStrokeColor = WebView.NIGHT_MODE_COLOR;
        this.iFillColor = 0;
        this.boVisible = true;
        this.latlngCenter = latLng;
        this.dRadius = d2;
        this.fStrokeWidth = f2;
        this.iStrokeColor = i3;
        this.iFillColor = i4;
        this.iZindex = i5;
        this.boVisible = z;
        AppMethodBeat.o(181059);
    }

    public CircleOptions center(LatLng latLng) {
        this.latlngCenter = latLng;
        return this;
    }

    public CircleOptions radius(double d2) {
        this.dRadius = d2;
        return this;
    }

    public CircleOptions strokeWidth(float f2) {
        if (f2 < 0.0f) {
            this.fStrokeWidth = 1.0f;
        } else {
            this.fStrokeWidth = f2;
        }
        return this;
    }

    public CircleOptions strokeColor(int i2) {
        this.iStrokeColor = i2;
        return this;
    }

    public CircleOptions fillColor(int i2) {
        this.iFillColor = i2;
        return this;
    }

    public CircleOptions zIndex(int i2) {
        this.iZindex = i2;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.boVisible = z;
        return this;
    }

    public LatLng getCenter() {
        return this.latlngCenter;
    }

    public double getRadius() {
        return this.dRadius;
    }

    public float getStrokeWidth() {
        return this.fStrokeWidth;
    }

    public int getStrokeColor() {
        return this.iStrokeColor;
    }

    public int getFillColor() {
        return this.iFillColor;
    }

    public int getZIndex() {
        return this.iZindex;
    }

    public boolean isVisible() {
        return this.boVisible;
    }

    public CircleOptions clickable(boolean z) {
        this.mClickable = z;
        return this;
    }

    public boolean isClickable() {
        return this.mClickable;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(173129);
        if (parcel == null) {
            AppMethodBeat.o(173129);
            return;
        }
        parcel.writeDouble(this.dRadius);
        AppMethodBeat.o(173129);
    }

    public CircleOptions level(int i2) {
        if (i2 >= OverlayLevel.OverlayLevelAboveRoads && i2 <= OverlayLevel.OverlayLevelAboveLabels) {
            this.iLevel = i2;
        }
        return this;
    }

    public int getLevel() {
        return this.iLevel;
    }
}
