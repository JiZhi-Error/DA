package com.d.a.a.a.a;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements Circle {
    private com.tencent.tencentmap.mapsdk.maps.model.Circle SJJ;

    public b(com.tencent.tencentmap.mapsdk.maps.model.Circle circle) {
        this.SJJ = circle;
    }

    @Override // com.tencent.mapsdk.raster.model.Circle, com.tencent.mapsdk.raster.model.IOverlay
    public final void remove() {
        AppMethodBeat.i(217276);
        if (this.SJJ != null) {
            this.SJJ.remove();
        }
        AppMethodBeat.o(217276);
    }

    @Override // com.tencent.mapsdk.raster.model.Circle, com.tencent.mapsdk.raster.model.IOverlay
    public final String getId() {
        AppMethodBeat.i(217277);
        if (this.SJJ != null) {
            String id = this.SJJ.getId();
            AppMethodBeat.o(217277);
            return id;
        }
        AppMethodBeat.o(217277);
        return null;
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final void setCenter(LatLng latLng) {
        AppMethodBeat.i(217278);
        if (this.SJJ != null) {
            this.SJJ.setCenter(l.c(latLng));
        }
        AppMethodBeat.o(217278);
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final LatLng getCenter() {
        AppMethodBeat.i(217279);
        if (this.SJJ != null) {
            LatLng a2 = l.a(this.SJJ.getCenter());
            AppMethodBeat.o(217279);
            return a2;
        }
        AppMethodBeat.o(217279);
        return null;
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final void setRadius(double d2) {
        AppMethodBeat.i(217280);
        if (this.SJJ != null) {
            this.SJJ.setRadius(d2);
        }
        AppMethodBeat.o(217280);
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final double getRadius() {
        AppMethodBeat.i(217281);
        if (this.SJJ != null) {
            double radius = this.SJJ.getRadius();
            AppMethodBeat.o(217281);
            return radius;
        }
        AppMethodBeat.o(217281);
        return 0.0d;
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final void setStrokeWidth(float f2) {
        AppMethodBeat.i(217282);
        if (this.SJJ != null) {
            com.tencent.tencentmap.mapsdk.maps.model.Circle circle = this.SJJ;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            circle.setStrokeWidth(f2);
        }
        AppMethodBeat.o(217282);
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final float getStrokeWidth() {
        AppMethodBeat.i(217283);
        if (this.SJJ != null) {
            float strokeWidth = this.SJJ.getStrokeWidth();
            AppMethodBeat.o(217283);
            return strokeWidth;
        }
        AppMethodBeat.o(217283);
        return 0.0f;
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final void setStrokeColor(int i2) {
        AppMethodBeat.i(217284);
        if (this.SJJ != null) {
            this.SJJ.setStrokeColor(i2);
        }
        AppMethodBeat.o(217284);
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final int getStrokeColor() {
        AppMethodBeat.i(217285);
        if (this.SJJ != null) {
            int strokeColor = this.SJJ.getStrokeColor();
            AppMethodBeat.o(217285);
            return strokeColor;
        }
        AppMethodBeat.o(217285);
        return 0;
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final void setFillColor(int i2) {
        AppMethodBeat.i(217286);
        if (this.SJJ != null) {
            this.SJJ.setFillColor(i2);
        }
        AppMethodBeat.o(217286);
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final int getFillColor() {
        AppMethodBeat.i(217287);
        if (this.SJJ != null) {
            int fillColor = this.SJJ.getFillColor();
            AppMethodBeat.o(217287);
            return fillColor;
        }
        AppMethodBeat.o(217287);
        return 0;
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final void setZIndex(float f2) {
        AppMethodBeat.i(217288);
        if (this.SJJ != null) {
            this.SJJ.setZIndex((int) f2);
        }
        AppMethodBeat.o(217288);
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final float getZIndex() {
        AppMethodBeat.i(217289);
        if (this.SJJ != null) {
            float zIndex = (float) this.SJJ.getZIndex();
            AppMethodBeat.o(217289);
            return zIndex;
        }
        AppMethodBeat.o(217289);
        return 0.0f;
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final void setLevel(int i2) {
        AppMethodBeat.i(217290);
        if (this.SJJ != null) {
            this.SJJ.setLevel(i2);
        }
        AppMethodBeat.o(217290);
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final int getLevel() {
        AppMethodBeat.i(217291);
        if (this.SJJ != null) {
            int level = this.SJJ.getLevel();
            AppMethodBeat.o(217291);
            return level;
        }
        AppMethodBeat.o(217291);
        return 0;
    }

    @Override // com.tencent.mapsdk.raster.model.Circle, com.tencent.mapsdk.raster.model.IOverlay
    public final void setVisible(boolean z) {
        AppMethodBeat.i(217292);
        if (this.SJJ != null) {
            this.SJJ.setVisible(z);
        }
        AppMethodBeat.o(217292);
    }

    @Override // com.tencent.mapsdk.raster.model.Circle, com.tencent.mapsdk.raster.model.IOverlay
    public final boolean isVisible() {
        AppMethodBeat.i(217293);
        if (this.SJJ != null) {
            boolean isVisible = this.SJJ.isVisible();
            AppMethodBeat.o(217293);
            return isVisible;
        }
        AppMethodBeat.o(217293);
        return false;
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final boolean contains(LatLng latLng) {
        AppMethodBeat.i(217294);
        if (this.SJJ != null) {
            boolean contains = this.SJJ.contains(l.c(latLng));
            AppMethodBeat.o(217294);
            return contains;
        }
        AppMethodBeat.o(217294);
        return false;
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final void setStrokeDash(boolean z) {
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final void strokeDashPathEffect(DashPathEffect dashPathEffect) {
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final boolean getStrokeDash() {
        return false;
    }

    @Override // com.tencent.mapsdk.raster.model.Circle
    public final DashPathEffect getStrokeDashPathEffect() {
        return null;
    }
}
