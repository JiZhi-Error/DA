package com.tencent.map.lib.models;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.OverlayLevel;

@Keep
public class GroundOverlayInfo {
    protected float mAlpha = 1.0f;
    protected Bitmap mBitmap;
    protected int mBitmapHeight;
    protected int mBitmapWidth;
    protected LatLngBounds mLatLngBounds;
    protected int mLevel = OverlayLevel.OverlayLevelAboveBuildings;
    protected boolean mVisibility = true;
    protected int mZIndex;

    public void setBitmap(Bitmap bitmap) {
        AppMethodBeat.i(193498);
        this.mBitmap = bitmap;
        if (this.mBitmap != null) {
            this.mBitmapWidth = this.mBitmap.getWidth();
            this.mBitmapHeight = this.mBitmap.getHeight();
        }
        AppMethodBeat.o(193498);
    }

    public void setLatLngBounds(LatLngBounds latLngBounds) {
        this.mLatLngBounds = latLngBounds;
    }

    public void setAlpha(float f2) {
        this.mAlpha = f2;
    }

    public void setVisibility(boolean z) {
        this.mVisibility = z;
    }

    public void setZIndex(int i2) {
        this.mZIndex = i2;
    }

    public void setLevel(int i2) {
        this.mLevel = i2;
    }
}
