package com.d.a.a.a.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class g implements Polygon {
    private com.tencent.tencentmap.mapsdk.maps.model.Polygon SJO;

    public g(com.tencent.tencentmap.mapsdk.maps.model.Polygon polygon) {
        this.SJO = polygon;
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon, com.tencent.mapsdk.raster.model.IOverlay
    public final void remove() {
        AppMethodBeat.i(217366);
        if (this.SJO != null) {
            this.SJO.remove();
        }
        AppMethodBeat.o(217366);
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon, com.tencent.mapsdk.raster.model.IOverlay
    public final String getId() {
        AppMethodBeat.i(217367);
        if (this.SJO != null) {
            String id = this.SJO.getId();
            AppMethodBeat.o(217367);
            return id;
        }
        AppMethodBeat.o(217367);
        return null;
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon
    public final void setPoints(List<LatLng> list) {
        AppMethodBeat.i(217368);
        if (this.SJO != null) {
            this.SJO.setPoints(l.kl(list));
        }
        AppMethodBeat.o(217368);
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon
    public final List<LatLng> getPoints() {
        AppMethodBeat.i(217369);
        if (this.SJO != null) {
            List<LatLng> kk = l.kk(this.SJO.getPoints());
            AppMethodBeat.o(217369);
            return kk;
        }
        AppMethodBeat.o(217369);
        return null;
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon
    public final void setStrokeWidth(float f2) {
        AppMethodBeat.i(217370);
        if (this.SJO != null) {
            com.tencent.tencentmap.mapsdk.maps.model.Polygon polygon = this.SJO;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            polygon.setStrokeWidth(f2);
        }
        AppMethodBeat.o(217370);
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon
    public final float getStrokeWidth() {
        AppMethodBeat.i(217371);
        if (this.SJO != null) {
            float strokeWidth = this.SJO.getStrokeWidth();
            AppMethodBeat.o(217371);
            return strokeWidth;
        }
        AppMethodBeat.o(217371);
        return 0.0f;
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon
    public final void setStrokeColor(int i2) {
        AppMethodBeat.i(217372);
        if (this.SJO != null) {
            this.SJO.setStrokeColor(i2);
        }
        AppMethodBeat.o(217372);
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon
    public final int getStrokeColor() {
        AppMethodBeat.i(217373);
        if (this.SJO != null) {
            int strokeColor = this.SJO.getStrokeColor();
            AppMethodBeat.o(217373);
            return strokeColor;
        }
        AppMethodBeat.o(217373);
        return 0;
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon
    public final void setFillColor(int i2) {
        AppMethodBeat.i(217374);
        if (this.SJO != null) {
            this.SJO.setFillColor(i2);
        }
        AppMethodBeat.o(217374);
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon
    public final int getFillColor() {
        AppMethodBeat.i(217375);
        if (this.SJO != null) {
            int fillColor = this.SJO.getFillColor();
            AppMethodBeat.o(217375);
            return fillColor;
        }
        AppMethodBeat.o(217375);
        return 0;
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon
    public final void setZIndex(float f2) {
        AppMethodBeat.i(217376);
        if (this.SJO != null) {
            this.SJO.setZIndex((int) f2);
        }
        AppMethodBeat.o(217376);
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon
    public final float getZIndex() {
        AppMethodBeat.i(217377);
        if (this.SJO != null) {
            float zIndex = (float) this.SJO.getZIndex();
            AppMethodBeat.o(217377);
            return zIndex;
        }
        AppMethodBeat.o(217377);
        return 0.0f;
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon
    public final void setLevel(int i2) {
        AppMethodBeat.i(217378);
        if (this.SJO != null) {
            this.SJO.setLevel(i2);
        }
        AppMethodBeat.o(217378);
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon
    public final int getLevel() {
        AppMethodBeat.i(217379);
        if (this.SJO != null) {
            int level = this.SJO.getLevel();
            AppMethodBeat.o(217379);
            return level;
        }
        AppMethodBeat.o(217379);
        return 0;
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon, com.tencent.mapsdk.raster.model.IOverlay
    public final void setVisible(boolean z) {
        AppMethodBeat.i(217380);
        if (this.SJO != null) {
            this.SJO.setVisible(z);
        }
        AppMethodBeat.o(217380);
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon, com.tencent.mapsdk.raster.model.IOverlay
    public final boolean isVisible() {
        AppMethodBeat.i(217381);
        if (this.SJO != null) {
            boolean isVisible = this.SJO.isVisible();
            AppMethodBeat.o(217381);
            return isVisible;
        }
        AppMethodBeat.o(217381);
        return false;
    }

    @Override // com.tencent.mapsdk.raster.model.Polygon
    public final boolean contains(LatLng latLng) {
        AppMethodBeat.i(217382);
        if (this.SJO != null) {
            boolean contains = this.SJO.contains(l.c(latLng));
            AppMethodBeat.o(217382);
            return contains;
        }
        AppMethodBeat.o(217382);
        return false;
    }
}
