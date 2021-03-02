package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GroundOverlayOptions {
    public static Bitmap TRANSPARENT_PIXEL = Bitmap.createBitmap(new int[]{0}, 1, 1, Bitmap.Config.ARGB_8888);
    private float mAlpha = 1.0f;
    private float mAnchorU = 0.5f;
    private float mAnchorV = 0.5f;
    private BitmapDescriptor mBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(TRANSPARENT_PIXEL);
    private LatLngBounds mLatLngBounds;
    private int mLevel = OverlayLevel.OverlayLevelAboveBuildings;
    private LatLng mPosition;
    private boolean mVisibility = true;
    private int mZIndex;
    private float mZoom = 18.0f;

    public GroundOverlayOptions() {
        AppMethodBeat.i(193607);
        AppMethodBeat.o(193607);
    }

    static {
        AppMethodBeat.i(193608);
        AppMethodBeat.o(193608);
    }

    public final BitmapDescriptor getBitmap() {
        return this.mBitmapDescriptor;
    }

    public final GroundOverlayOptions bitmap(BitmapDescriptor bitmapDescriptor) {
        this.mBitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public final LatLngBounds getLatLngBounds() {
        return this.mLatLngBounds;
    }

    public final GroundOverlayOptions latLngBounds(LatLngBounds latLngBounds) {
        this.mLatLngBounds = latLngBounds;
        return this;
    }

    public final LatLng getPosition() {
        return this.mPosition;
    }

    public final GroundOverlayOptions position(LatLng latLng) {
        this.mPosition = latLng;
        return this;
    }

    public final float getZoom() {
        return this.mZoom;
    }

    public final GroundOverlayOptions zoom(float f2) {
        this.mZoom = f2;
        return this;
    }

    public final float getAnchorU() {
        return this.mAnchorU;
    }

    public final float getAnchorV() {
        return this.mAnchorV;
    }

    public final GroundOverlayOptions anchor(float f2, float f3) {
        this.mAnchorU = f2;
        this.mAnchorV = f3;
        return this;
    }

    public final float getAlpha() {
        return this.mAlpha;
    }

    public final GroundOverlayOptions alpha(float f2) {
        this.mAlpha = f2;
        return this;
    }

    public final boolean isVisible() {
        return this.mVisibility;
    }

    public final GroundOverlayOptions visible(boolean z) {
        this.mVisibility = z;
        return this;
    }

    public final int getZIndex() {
        return this.mZIndex;
    }

    public final GroundOverlayOptions zIndex(int i2) {
        this.mZIndex = i2;
        return this;
    }

    public final int getLevel() {
        return this.mLevel;
    }

    public final GroundOverlayOptions level(int i2) {
        if (i2 >= OverlayLevel.OverlayLevelAboveRoads && i2 <= OverlayLevel.OverlayLevelAboveLabels) {
            this.mLevel = i2;
        }
        return this;
    }
}
