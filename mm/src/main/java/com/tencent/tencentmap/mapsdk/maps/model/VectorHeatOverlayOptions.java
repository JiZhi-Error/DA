package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.utilities.heatmap.WeightedLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class VectorHeatOverlayOptions {
    private int[] mColors;
    private float mGap;
    private int mMaxZoom = 22;
    private int mMinZoom = 3;
    private WeightedLatLng[] mNodes;
    private float mOpacity = 1.0f;
    private float mSize = 2000.0f;
    private double[] mStartPoints;
    private int mType = 0;
    private boolean mVisibility = true;

    public enum VectorHeatOverlayType {
        HoneyComb,
        Square;

        public static VectorHeatOverlayType valueOf(String str) {
            AppMethodBeat.i(193620);
            VectorHeatOverlayType vectorHeatOverlayType = (VectorHeatOverlayType) Enum.valueOf(VectorHeatOverlayType.class, str);
            AppMethodBeat.o(193620);
            return vectorHeatOverlayType;
        }

        static {
            AppMethodBeat.i(193621);
            AppMethodBeat.o(193621);
        }
    }

    public final VectorHeatOverlayType getType() {
        AppMethodBeat.i(193622);
        VectorHeatOverlayType vectorHeatOverlayType = VectorHeatOverlayType.values()[this.mType];
        AppMethodBeat.o(193622);
        return vectorHeatOverlayType;
    }

    public final VectorHeatOverlayOptions type(VectorHeatOverlayType vectorHeatOverlayType) {
        AppMethodBeat.i(193623);
        this.mType = vectorHeatOverlayType.ordinal();
        AppMethodBeat.o(193623);
        return this;
    }

    public final WeightedLatLng[] getNodes() {
        return this.mNodes;
    }

    public final VectorHeatOverlayOptions nodes(WeightedLatLng[] weightedLatLngArr) {
        this.mNodes = weightedLatLngArr;
        return this;
    }

    public final float getSize() {
        return this.mSize;
    }

    public final VectorHeatOverlayOptions size(float f2) {
        this.mSize = f2;
        return this;
    }

    public final float getGap() {
        return this.mGap;
    }

    public final VectorHeatOverlayOptions gap(float f2) {
        this.mGap = f2;
        return this;
    }

    public final float getOpacity() {
        return this.mOpacity;
    }

    public final VectorHeatOverlayOptions opacity(float f2) {
        this.mOpacity = f2;
        return this;
    }

    public final boolean isVisibility() {
        return this.mVisibility;
    }

    public final VectorHeatOverlayOptions visibility(boolean z) {
        this.mVisibility = z;
        return this;
    }

    public final int getMinZoom() {
        return this.mMinZoom;
    }

    public final VectorHeatOverlayOptions minZoom(int i2) {
        this.mMinZoom = i2;
        return this;
    }

    public final int getMaxZoom() {
        return this.mMaxZoom;
    }

    public final VectorHeatOverlayOptions maxZoom(int i2) {
        this.mMaxZoom = i2;
        return this;
    }

    public final int[] getColors() {
        return this.mColors;
    }

    public final VectorHeatOverlayOptions colors(int[] iArr) {
        this.mColors = iArr;
        return this;
    }

    public final double[] getStartPoints() {
        return this.mStartPoints;
    }

    public final VectorHeatOverlayOptions startPoints(double[] dArr) {
        this.mStartPoints = dArr;
        return this;
    }
}
