package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BubbleOptions {
    private Drawable[] mBackground = null;
    private String mContent;
    private View mContentView;
    private int mDisplayLevel = 0;
    private Marker mMarker;
    private float mMarkerAnchorU = 0.5f;
    private float mMarkerAnchorV = 0.5f;
    private int mMarkerHeight = 0;
    private int mMarkerWidth = 0;
    private boolean mOnTapHidden = false;
    private LatLng mPosition;

    public BubbleOptions marker(Marker marker) {
        AppMethodBeat.i(173097);
        this.mMarker = marker;
        position(marker.getPosition());
        markerAnchor(marker.getAnchorU(), marker.getAnchorV());
        AppMethodBeat.o(173097);
        return this;
    }

    public Marker getMarker() {
        return this.mMarker;
    }

    public BubbleOptions markerSize(int i2, int i3) {
        this.mMarkerWidth = i2;
        this.mMarkerHeight = i3;
        return this;
    }

    public int getMarkerWidth() {
        return this.mMarkerWidth;
    }

    public int getMarkerHeight() {
        return this.mMarkerHeight;
    }

    public BubbleOptions markerAnchor(float f2, float f3) {
        this.mMarkerAnchorU = f2;
        this.mMarkerAnchorV = f3;
        return this;
    }

    public float getMarkerAnchorU() {
        return this.mMarkerAnchorU;
    }

    public float getMarkerAnchorV() {
        return this.mMarkerAnchorV;
    }

    public BubbleOptions content(String str) {
        this.mContent = str;
        return this;
    }

    public String getContent() {
        return this.mContent;
    }

    public BubbleOptions position(LatLng latLng) {
        this.mPosition = latLng;
        return this;
    }

    public LatLng getPosition() {
        return this.mPosition;
    }

    public BubbleOptions displayLevel(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.mDisplayLevel = i2;
        return this;
    }

    public int getDisplayLevel() {
        return this.mDisplayLevel;
    }

    public BubbleOptions contentView(View view) {
        this.mContentView = view;
        return this;
    }

    public View getContentView() {
        return this.mContentView;
    }

    public BubbleOptions background(Drawable[] drawableArr) {
        this.mBackground = drawableArr;
        return this;
    }

    public BubbleOptions background(Bitmap[] bitmapArr) {
        AppMethodBeat.i(173098);
        if (bitmapArr != null) {
            this.mBackground = new Drawable[4];
            int length = bitmapArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.mBackground[i2] = new BitmapDrawable(bitmapArr[i2]);
            }
        }
        AppMethodBeat.o(173098);
        return this;
    }

    public Drawable[] getBackground() {
        return this.mBackground;
    }

    public BubbleOptions setOnTapHidden(boolean z) {
        this.mOnTapHidden = z;
        return this;
    }

    public boolean getOnTapHidden() {
        return this.mOnTapHidden;
    }
}
