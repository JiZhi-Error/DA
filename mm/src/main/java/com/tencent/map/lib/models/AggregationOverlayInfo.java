package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import com.tencent.map.sdk.utilities.heatmap.WeightedLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class AggregationOverlayInfo {
    protected int[] mColors = {1174031124, -1711650028, -637908204};
    protected float mGap = 0.0f;
    protected int mMaxZoom = 22;
    protected int mMinZoom = 3;
    protected WeightedLatLng[] mNodes;
    protected float mOpacity = 1.0f;
    protected float mSize = 2000.0f;
    protected double[] mStartPoints = {0.0d, 0.6d, 0.8d};
    protected int mType = 0;
    protected boolean mVisibility = true;

    public AggregationOverlayInfo() {
        AppMethodBeat.i(193493);
        AppMethodBeat.o(193493);
    }

    public void setType(int i2) {
        this.mType = i2;
    }

    public void setNodes(WeightedLatLng[] weightedLatLngArr) {
        this.mNodes = weightedLatLngArr;
    }

    public void setSize(float f2) {
        this.mSize = f2;
    }

    public void setGap(float f2) {
        this.mGap = f2;
    }

    public void setOpacity(float f2) {
        this.mOpacity = f2;
    }

    public void setVisibility(boolean z) {
        this.mVisibility = z;
    }

    public void setMinZoom(int i2) {
        this.mMinZoom = i2;
    }

    public void setMaxZoom(int i2) {
        this.mMaxZoom = i2;
    }

    public void setColors(int[] iArr) {
        this.mColors = iArr;
    }

    public void setStartPoints(double[] dArr) {
        this.mStartPoints = dArr;
    }
}
