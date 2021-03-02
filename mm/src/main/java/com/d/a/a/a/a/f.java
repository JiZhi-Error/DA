package com.d.a.a.a.a;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import java.util.List;

public final class f implements Polyline {
    private com.tencent.tencentmap.mapsdk.maps.model.Polyline SJN;

    public f(com.tencent.tencentmap.mapsdk.maps.model.Polyline polyline) {
        this.SJN = polyline;
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline, com.tencent.mapsdk.raster.model.IOverlay
    public final void remove() {
        AppMethodBeat.i(217348);
        if (this.SJN != null) {
            this.SJN.remove();
        }
        AppMethodBeat.o(217348);
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline, com.tencent.mapsdk.raster.model.IOverlay
    public final String getId() {
        AppMethodBeat.i(217349);
        if (this.SJN != null) {
            String id = this.SJN.getId();
            AppMethodBeat.o(217349);
            return id;
        }
        AppMethodBeat.o(217349);
        return null;
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final void setPoints(List<LatLng> list) {
        AppMethodBeat.i(217350);
        if (this.SJN != null) {
            this.SJN.setPoints(l.kl(list));
        }
        AppMethodBeat.o(217350);
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final List<LatLng> getPoints() {
        AppMethodBeat.i(217351);
        if (this.SJN != null) {
            List<LatLng> kk = l.kk(this.SJN.getPoints());
            AppMethodBeat.o(217351);
            return kk;
        }
        AppMethodBeat.o(217351);
        return null;
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final void setWidth(float f2) {
        AppMethodBeat.i(217352);
        if (this.SJN != null) {
            com.tencent.tencentmap.mapsdk.maps.model.Polyline polyline = this.SJN;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            polyline.setWidth(f2);
        }
        AppMethodBeat.o(217352);
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final float getWidth() {
        AppMethodBeat.i(217353);
        if (this.SJN != null) {
            float width = this.SJN.getWidth();
            AppMethodBeat.o(217353);
            return width;
        }
        AppMethodBeat.o(217353);
        return 0.0f;
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final void setColor(int i2) {
        AppMethodBeat.i(217354);
        if (this.SJN != null) {
            this.SJN.setColor(i2);
        }
        AppMethodBeat.o(217354);
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final int getColor() {
        AppMethodBeat.i(217355);
        if (this.SJN != null) {
            int color = this.SJN.getColor();
            AppMethodBeat.o(217355);
            return color;
        }
        AppMethodBeat.o(217355);
        return 0;
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final void setZIndex(float f2) {
        AppMethodBeat.i(217356);
        if (this.SJN != null) {
            this.SJN.setZIndex((int) f2);
        }
        AppMethodBeat.o(217356);
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final void setLevel(int i2) {
        AppMethodBeat.i(217357);
        if (this.SJN != null) {
            this.SJN.setLevel(i2);
        }
        AppMethodBeat.o(217357);
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final float getZIndex() {
        AppMethodBeat.i(217358);
        if (this.SJN != null) {
            float zIndex = (float) this.SJN.getZIndex();
            AppMethodBeat.o(217358);
            return zIndex;
        }
        AppMethodBeat.o(217358);
        return 0.0f;
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final int getLevel() {
        AppMethodBeat.i(217359);
        if (this.SJN != null) {
            int level = this.SJN.getLevel();
            AppMethodBeat.o(217359);
            return level;
        }
        AppMethodBeat.o(217359);
        return 0;
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline, com.tencent.mapsdk.raster.model.IOverlay
    public final void setVisible(boolean z) {
        AppMethodBeat.i(217360);
        if (this.SJN != null) {
            this.SJN.setVisible(z);
        }
        AppMethodBeat.o(217360);
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline, com.tencent.mapsdk.raster.model.IOverlay
    public final boolean isVisible() {
        AppMethodBeat.i(217361);
        if (this.SJN != null) {
            boolean isVisible = this.SJN.isVisible();
            AppMethodBeat.o(217361);
            return isVisible;
        }
        AppMethodBeat.o(217361);
        return false;
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final void setGeodesic(boolean z) {
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final boolean isGeodesic() {
        return false;
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final void setDottedLine(boolean z) {
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final boolean isDottedLine() {
        AppMethodBeat.i(217362);
        if (this.SJN == null || this.SJN.getPattern() == null) {
            AppMethodBeat.o(217362);
            return false;
        }
        AppMethodBeat.o(217362);
        return true;
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final void setColorTexture(BitmapDescriptor bitmapDescriptor) {
        AppMethodBeat.i(217363);
        if (this.SJN == null) {
            AppMethodBeat.o(217363);
            return;
        }
        this.SJN.setColorTexture(BitmapDescriptorFactory.fromBitmap(bitmapDescriptor.getBitmap()));
        AppMethodBeat.o(217363);
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final void eraseTo(int i2, LatLng latLng) {
        AppMethodBeat.i(217364);
        if (this.SJN == null) {
            AppMethodBeat.o(217364);
            return;
        }
        this.SJN.eraseTo(i2, l.c(latLng));
        AppMethodBeat.o(217364);
    }

    @Override // com.tencent.mapsdk.raster.model.Polyline
    public final void setEraseable(boolean z) {
        AppMethodBeat.i(217365);
        if (this.SJN == null) {
            AppMethodBeat.o(217365);
            return;
        }
        this.SJN.setEraseable(z);
        AppMethodBeat.o(217365);
    }
}
