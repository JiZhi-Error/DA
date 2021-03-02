package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolygonOptions {
    private static final int COLOR_DEFAULT_POLYGON = Color.argb(200, 0, (int) TbsListener.ErrorCode.STARTDOWNLOAD_4, 255);
    private boolean boIsVisble = true;
    private float fStrokeWidth = 1.0f;
    private int iFillColor = COLOR_DEFAULT_POLYGON;
    private int iLevel = OverlayLevel.OverlayLevelAboveLabels;
    private int iStrokeColor = WebView.NIGHT_MODE_COLOR;
    private int iZindex = 0;
    private final List<LatLng> listPts = new ArrayList();
    private boolean mClickable;
    private List<Integer> pattern;
    private BitmapDescriptor texture;
    private int textureSpacing;

    static {
        AppMethodBeat.i(181085);
        AppMethodBeat.o(181085);
    }

    public PolygonOptions() {
        AppMethodBeat.i(173295);
        AppMethodBeat.o(173295);
    }

    public void setPoints(Iterable<LatLng> iterable) {
        AppMethodBeat.i(173296);
        this.listPts.clear();
        if (iterable == null) {
            AppMethodBeat.o(173296);
            return;
        }
        addAll(iterable);
        AppMethodBeat.o(173296);
    }

    public PolygonOptions add(LatLng latLng) {
        AppMethodBeat.i(173297);
        if (latLng != null) {
            this.listPts.add(latLng);
        }
        AppMethodBeat.o(173297);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        AppMethodBeat.i(173298);
        if (latLngArr != null) {
            this.listPts.addAll(Arrays.asList(latLngArr));
        }
        AppMethodBeat.o(173298);
        return this;
    }

    public PolygonOptions add(List<LatLng> list) {
        AppMethodBeat.i(173299);
        if (list != null) {
            this.listPts.addAll(list);
        }
        AppMethodBeat.o(173299);
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        AppMethodBeat.i(173300);
        if (iterable != null) {
            for (LatLng latLng : iterable) {
                this.listPts.add(latLng);
            }
        }
        AppMethodBeat.o(173300);
        return this;
    }

    public PolygonOptions strokeWidth(float f2) {
        if (f2 < 0.0f) {
            this.fStrokeWidth = 1.0f;
        } else {
            this.fStrokeWidth = f2;
        }
        return this;
    }

    public PolygonOptions strokeColor(int i2) {
        this.iStrokeColor = i2;
        this.texture = null;
        return this;
    }

    public PolygonOptions fillColor(int i2) {
        this.iFillColor = i2;
        return this;
    }

    public PolygonOptions zIndex(int i2) {
        this.iZindex = i2;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.boIsVisble = z;
        return this;
    }

    public PolygonOptions clickable(boolean z) {
        this.mClickable = z;
        return this;
    }

    public List<LatLng> getPoints() {
        return this.listPts;
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

    public float getZIndex() {
        return (float) this.iZindex;
    }

    public boolean isVisible() {
        return this.boIsVisble;
    }

    public boolean isClickable() {
        return this.mClickable;
    }

    public PolygonOptions level(int i2) {
        if (i2 >= OverlayLevel.OverlayLevelAboveRoads && i2 <= OverlayLevel.OverlayLevelAboveLabels) {
            this.iLevel = i2;
        }
        return this;
    }

    public int getLevel() {
        return this.iLevel;
    }

    public boolean isValid() {
        AppMethodBeat.i(193615);
        if (this.listPts == null || this.listPts.size() <= 2) {
            AppMethodBeat.o(193615);
            return false;
        }
        AppMethodBeat.o(193615);
        return true;
    }

    public List<Integer> getPattern() {
        return this.pattern;
    }

    public PolygonOptions pattern(List<Integer> list) {
        this.pattern = list;
        this.texture = null;
        return this;
    }

    public BitmapDescriptor getTexture() {
        return this.texture;
    }

    public PolygonOptions texture(BitmapDescriptor bitmapDescriptor) {
        this.texture = bitmapDescriptor;
        return this;
    }

    public int getTextureSpacing() {
        return this.textureSpacing;
    }

    public PolygonOptions textureSpacing(int i2) {
        this.textureSpacing = i2;
        return this;
    }
}
