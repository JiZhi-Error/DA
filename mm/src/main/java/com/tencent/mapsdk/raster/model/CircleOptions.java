package com.tencent.mapsdk.raster.model;

import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public final class CircleOptions {
    private DashPathEffect dashPathEffect = null;
    private int fillColor = 0;
    private int iLevel = OverlayLevel.OverlayLevelAboveLabels;
    private String id;
    private boolean isVisible = true;
    private LatLng point = new LatLng(39.908288d, 116.397572d);
    private double radius = 0.0d;
    private int strokeColor = WebView.NIGHT_MODE_COLOR;
    private boolean strokeDash = false;
    private float strokeWidth = 10.0f;
    private float zIndex = 0.0f;

    public CircleOptions() {
        AppMethodBeat.i(87551);
        AppMethodBeat.o(87551);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(87552);
        Bundle bundle = new Bundle();
        if (this.point != null) {
            bundle.putDouble("lat", this.point.getLatitude());
            bundle.putDouble("lng", this.point.getLongitude());
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeInt(this.fillColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte((byte) (this.isVisible ? 1 : 0));
        parcel.writeString(this.id);
        AppMethodBeat.o(87552);
    }

    public final int describeContents() {
        return 0;
    }

    public final CircleOptions center(LatLng latLng) {
        this.point = latLng;
        return this;
    }

    public final CircleOptions radius(double d2) {
        this.radius = d2;
        return this;
    }

    public final CircleOptions strokeWidth(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.strokeWidth = f2;
        return this;
    }

    public final CircleOptions strokeColor(int i2) {
        this.strokeColor = i2;
        return this;
    }

    public final CircleOptions fillColor(int i2) {
        this.fillColor = i2;
        return this;
    }

    public final CircleOptions zIndex(float f2) {
        this.zIndex = f2;
        return this;
    }

    public final CircleOptions level(int i2) {
        if (i2 >= OverlayLevel.OverlayLevelAboveRoads && i2 <= OverlayLevel.OverlayLevelAboveLabels) {
            this.iLevel = i2;
        }
        return this;
    }

    public final CircleOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public final CircleOptions strokeDash(boolean z) {
        this.strokeDash = z;
        return this;
    }

    public final CircleOptions strokeDashPathEffect(DashPathEffect dashPathEffect2) {
        this.dashPathEffect = dashPathEffect2;
        return this;
    }

    public final LatLng getCenter() {
        return this.point;
    }

    public final double getRadius() {
        return this.radius;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final int getLevel() {
        return this.iLevel;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final boolean getStrokeDash() {
        return this.strokeDash;
    }

    public final DashPathEffect getStrokeDashPathEffect() {
        return this.dashPathEffect;
    }
}
