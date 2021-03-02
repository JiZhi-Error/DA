package com.d.a.a.a.a;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;

public class e implements Marker {
    private i SJM;
    private com.tencent.tencentmap.mapsdk.maps.model.Marker mMarker;

    public e(i iVar, com.tencent.tencentmap.mapsdk.maps.model.Marker marker) {
        AppMethodBeat.i(217314);
        this.SJM = iVar;
        this.mMarker = marker;
        if (this.SJM == null || this.SJM.SJR == null) {
            AppMethodBeat.o(217314);
            return;
        }
        synchronized (e.class) {
            try {
                this.SJM.SJR.add(this.mMarker);
            } finally {
                AppMethodBeat.o(217314);
            }
        }
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public float getAlpha() {
        AppMethodBeat.i(217315);
        if (this.mMarker != null) {
            float alpha = this.mMarker.getAlpha();
            AppMethodBeat.o(217315);
            return alpha;
        }
        AppMethodBeat.o(217315);
        return 0.0f;
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay, com.tencent.mapsdk.raster.model.Marker
    public String getId() {
        AppMethodBeat.i(217316);
        if (this.mMarker != null) {
            String id = this.mMarker.getId();
            AppMethodBeat.o(217316);
            return id;
        }
        AppMethodBeat.o(217316);
        return "";
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public LatLng getPosition() {
        AppMethodBeat.i(217317);
        if (this.mMarker != null) {
            LatLng a2 = l.a(this.mMarker.getPosition());
            AppMethodBeat.o(217317);
            return a2;
        }
        AppMethodBeat.o(217317);
        return null;
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public float getRotation() {
        AppMethodBeat.i(217318);
        if (this.mMarker != null) {
            float rotation = this.mMarker.getRotation();
            AppMethodBeat.o(217318);
            return rotation;
        }
        AppMethodBeat.o(217318);
        return 0.0f;
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public String getSnippet() {
        AppMethodBeat.i(217319);
        if (this.mMarker != null) {
            String snippet = this.mMarker.getSnippet();
            AppMethodBeat.o(217319);
            return snippet;
        }
        AppMethodBeat.o(217319);
        return null;
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public String getTitle() {
        AppMethodBeat.i(217320);
        if (this.mMarker != null) {
            String title = this.mMarker.getTitle();
            AppMethodBeat.o(217320);
            return title;
        }
        AppMethodBeat.o(217320);
        return null;
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void hideInfoWindow() {
        AppMethodBeat.i(217321);
        if (this.mMarker != null) {
            this.mMarker.hideInfoWindow();
        }
        AppMethodBeat.o(217321);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public boolean isDraggable() {
        AppMethodBeat.i(217322);
        if (this.mMarker != null) {
            boolean isDraggable = this.mMarker.isDraggable();
            AppMethodBeat.o(217322);
            return isDraggable;
        }
        AppMethodBeat.o(217322);
        return false;
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public boolean isInfoWindowShown() {
        AppMethodBeat.i(217323);
        if (this.mMarker != null) {
            boolean isInfoWindowShown = this.mMarker.isInfoWindowShown();
            AppMethodBeat.o(217323);
            return isInfoWindowShown;
        }
        AppMethodBeat.o(217323);
        return false;
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay, com.tencent.mapsdk.raster.model.Marker
    public boolean isVisible() {
        AppMethodBeat.i(217324);
        if (this.mMarker != null) {
            boolean isVisible = this.mMarker.isVisible();
            AppMethodBeat.o(217324);
            return isVisible;
        }
        AppMethodBeat.o(217324);
        return false;
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay, com.tencent.mapsdk.raster.model.Marker
    public void remove() {
        AppMethodBeat.i(217325);
        if (this.mMarker != null) {
            synchronized (e.class) {
                try {
                    if (!(this.SJM == null || this.SJM.SJR == null)) {
                        this.SJM.SJR.remove(this.mMarker);
                    }
                } finally {
                    AppMethodBeat.o(217325);
                }
            }
            this.mMarker.remove();
        }
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setAlpha(float f2) {
        AppMethodBeat.i(217326);
        if (this.mMarker != null) {
            this.mMarker.setAlpha(f2);
        }
        AppMethodBeat.o(217326);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setAnchor(float f2, float f3) {
        AppMethodBeat.i(217327);
        if (this.mMarker != null) {
            this.mMarker.setAnchor(f2, f3);
        }
        AppMethodBeat.o(217327);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setDraggable(boolean z) {
        AppMethodBeat.i(217328);
        if (this.mMarker != null) {
            this.mMarker.setDraggable(z);
        }
        AppMethodBeat.o(217328);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        AppMethodBeat.i(217329);
        if (!(this.mMarker == null || bitmapDescriptor == null)) {
            this.mMarker.setIcon(BitmapDescriptorFactory.fromBitmap(bitmapDescriptor.getBitmap()));
        }
        AppMethodBeat.o(217329);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setPosition(LatLng latLng) {
        AppMethodBeat.i(217330);
        if (this.mMarker != null) {
            this.mMarker.setPosition(l.c(latLng));
        }
        AppMethodBeat.o(217330);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setRotation(float f2) {
        AppMethodBeat.i(217331);
        if (this.mMarker != null) {
            this.mMarker.setRotation(f2);
        }
        AppMethodBeat.o(217331);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setSnippet(String str) {
        AppMethodBeat.i(217332);
        if (this.mMarker != null) {
            this.mMarker.setSnippet(str);
        }
        AppMethodBeat.o(217332);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setTitle(String str) {
        AppMethodBeat.i(217333);
        if (this.mMarker != null) {
            this.mMarker.setTitle(str);
        }
        AppMethodBeat.o(217333);
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay, com.tencent.mapsdk.raster.model.Marker
    public void setVisible(boolean z) {
        AppMethodBeat.i(217334);
        if (this.mMarker != null) {
            this.mMarker.setVisible(z);
        }
        AppMethodBeat.o(217334);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void showInfoWindow() {
        AppMethodBeat.i(217335);
        if (this.mMarker != null) {
            this.mMarker.showInfoWindow();
        }
        AppMethodBeat.o(217335);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void set2Top() {
        int i2;
        AppMethodBeat.i(217336);
        if (this.SJM == null || this.SJM.SJR == null) {
            AppMethodBeat.o(217336);
            return;
        }
        synchronized (e.class) {
            try {
                int size = this.SJM.SJR.size();
                for (com.tencent.tencentmap.mapsdk.maps.model.Marker marker : this.SJM.SJR) {
                    if (marker.getZIndex() == Integer.MAX_VALUE) {
                        i2 = size;
                    } else if (marker.getZIndex() > size) {
                        i2 = marker.getZIndex();
                    } else {
                        i2 = size;
                    }
                    size = i2;
                }
                this.mMarker.setZIndex(size < Integer.MAX_VALUE ? size + 1 : Integer.MAX_VALUE);
            } finally {
                AppMethodBeat.o(217336);
            }
        }
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public View getMarkerView() {
        return null;
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setMarkerView(View view) {
        AppMethodBeat.i(217337);
        if (this.mMarker != null) {
            this.mMarker.setIcon(BitmapDescriptorFactory.fromView(view));
        }
        AppMethodBeat.o(217337);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setInfoWindowHideAnimation(Animation animation) {
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setInfoWindowShowAnimation(Animation animation) {
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public Object getTag() {
        AppMethodBeat.i(217338);
        if (this.mMarker != null) {
            Object tag = this.mMarker.getTag();
            AppMethodBeat.o(217338);
            return tag;
        }
        AppMethodBeat.o(217338);
        return null;
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setTag(Object obj) {
        AppMethodBeat.i(217339);
        if (this.mMarker != null) {
            this.mMarker.setTag(obj);
        }
        AppMethodBeat.o(217339);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setZIndex(float f2) {
        AppMethodBeat.i(217340);
        if (this.mMarker != null) {
            this.mMarker.setZIndex(f2);
        }
        AppMethodBeat.o(217340);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public float getZIndex() {
        AppMethodBeat.i(217341);
        if (this.mMarker != null) {
            float zIndex = (float) this.mMarker.getZIndex();
            AppMethodBeat.o(217341);
            return zIndex;
        }
        AppMethodBeat.o(217341);
        return 0.0f;
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setLevel(int i2) {
        AppMethodBeat.i(217342);
        if (this.mMarker != null) {
            this.mMarker.setLevel(i2);
        }
        AppMethodBeat.o(217342);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public int getLevel() {
        AppMethodBeat.i(217343);
        if (this.mMarker != null) {
            int level = this.mMarker.getLevel();
            AppMethodBeat.o(217343);
            return level;
        }
        AppMethodBeat.o(217343);
        return 0;
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setContentDescription(String str) {
        AppMethodBeat.i(217344);
        if (this.mMarker != null) {
            this.mMarker.setContentDescription(str);
        }
        AppMethodBeat.o(217344);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public String getContentDescription() {
        AppMethodBeat.i(217345);
        if (this.mMarker != null) {
            String contentDescription = this.mMarker.getContentDescription();
            AppMethodBeat.o(217345);
            return contentDescription;
        }
        AppMethodBeat.o(217345);
        return null;
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void refreshInfoWindow() {
        AppMethodBeat.i(217346);
        if (this.mMarker != null) {
            this.mMarker.refreshInfoWindow();
        }
        AppMethodBeat.o(217346);
    }

    @Override // com.tencent.mapsdk.raster.model.Marker
    public void setInfoWindowOffset(int i2, int i3) {
        AppMethodBeat.i(217347);
        if (this.mMarker != null) {
            this.mMarker.setInfoWindowOffset(i2, i3);
        }
        AppMethodBeat.o(217347);
    }
}
