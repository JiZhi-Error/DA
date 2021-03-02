package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions {
    private int fillColor = WebView.NIGHT_MODE_COLOR;
    private int iLevel = OverlayLevel.OverlayLevelAboveLabels;
    private boolean isVisible = true;
    private final List<LatLng> points = new ArrayList();
    private int strokeColor = WebView.NIGHT_MODE_COLOR;
    private float strokeWidth = 10.0f;
    private float zIndex = 0.0f;

    public PolygonOptions() {
        AppMethodBeat.i(87576);
        AppMethodBeat.o(87576);
    }

    public final PolygonOptions add(LatLng latLng) {
        AppMethodBeat.i(87577);
        if (latLng == null) {
            AppMethodBeat.o(87577);
        } else {
            this.points.add(latLng);
            AppMethodBeat.o(87577);
        }
        return this;
    }

    public final PolygonOptions add(LatLng... latLngArr) {
        AppMethodBeat.i(87578);
        if (latLngArr == null) {
            AppMethodBeat.o(87578);
        } else {
            this.points.addAll(Arrays.asList(latLngArr));
            AppMethodBeat.o(87578);
        }
        return this;
    }

    public final PolygonOptions addAll(Iterable<LatLng> iterable) {
        AppMethodBeat.i(87579);
        if (iterable == null) {
            AppMethodBeat.o(87579);
        } else {
            for (LatLng latLng : iterable) {
                this.points.add(latLng);
            }
            AppMethodBeat.o(87579);
        }
        return this;
    }

    public final PolygonOptions strokeWidth(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.strokeWidth = f2;
        return this;
    }

    public final PolygonOptions strokeColor(int i2) {
        this.strokeColor = i2;
        return this;
    }

    public final PolygonOptions fillColor(int i2) {
        this.fillColor = i2;
        return this;
    }

    public final PolygonOptions zIndex(float f2) {
        this.zIndex = f2;
        return this;
    }

    public final PolygonOptions level(int i2) {
        if (i2 >= OverlayLevel.OverlayLevelAboveRoads && i2 <= OverlayLevel.OverlayLevelAboveLabels) {
            this.iLevel = i2;
        }
        return this;
    }

    public final PolygonOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public final List<LatLng> getPoints() {
        return this.points;
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
}
