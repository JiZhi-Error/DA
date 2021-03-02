package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;

public class MyLocationStyle {
    public static final int LOCATION_TYPE_FOLLOW_NO_CENTER = 2;
    public static final int LOCATION_TYPE_LOCATION_ROTATE = 0;
    public static final int LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER = 1;
    public static final int LOCATION_TYPE_MAP_ROTATE_NO_CENTER = 3;
    private float anchorU = 0.5f;
    private float anchorV = 0.5f;
    private int fillColor = Color.argb(102, 0, (int) TbsListener.ErrorCode.STARTDOWNLOAD_4, 255);
    private BitmapDescriptor mIcon;
    private int myLocationType = 0;
    private int strokeColor = Color.argb((int) TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, 0, (int) TbsListener.ErrorCode.STARTDOWNLOAD_4, 255);
    private float strokeWidth = 1.0f;

    public MyLocationStyle() {
        AppMethodBeat.i(173272);
        AppMethodBeat.o(173272);
    }

    public MyLocationStyle anchor(float f2, float f3) {
        this.anchorU = f2;
        this.anchorV = f3;
        return this;
    }

    public MyLocationStyle icon(BitmapDescriptor bitmapDescriptor) {
        this.mIcon = bitmapDescriptor;
        return this;
    }

    public MyLocationStyle fillColor(int i2) {
        this.fillColor = i2;
        return this;
    }

    public MyLocationStyle strokeWidth(int i2) {
        this.strokeWidth = (float) i2;
        return this;
    }

    public MyLocationStyle strokeColor(int i2) {
        this.strokeColor = i2;
        return this;
    }

    public float getAnchorU() {
        return this.anchorU;
    }

    public float getAnchorV() {
        return this.anchorV;
    }

    public BitmapDescriptor getMyLocationIcon() {
        return this.mIcon;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public int getFillColor() {
        return this.fillColor;
    }

    public MyLocationStyle myLocationType(int i2) {
        this.myLocationType = i2;
        return this;
    }

    public int getMyLocationType() {
        return this.myLocationType;
    }

    public String toString() {
        AppMethodBeat.i(193611);
        String str = "{anchorU=" + this.anchorU + ", anchorV=" + this.anchorV + ", fillColor=" + this.fillColor + ", strokeColor=" + this.strokeColor + ", strokeWidth=" + this.strokeWidth + ", myLocationType=" + this.myLocationType + ", mIcon=" + this.mIcon + '}';
        AppMethodBeat.o(193611);
        return str;
    }
}
