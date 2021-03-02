package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CameraUpdateFactory {
    public static CameraUpdate zoomIn() {
        AppMethodBeat.i(87498);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 0;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(87498);
        return cameraUpdate;
    }

    public static CameraUpdate zoomOut() {
        AppMethodBeat.i(87499);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 1;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(87499);
        return cameraUpdate;
    }

    public static CameraUpdate scrollBy(float f2, float f3) {
        AppMethodBeat.i(87500);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 2;
        cameraParameter.scrollBy_xPixel = f2;
        cameraParameter.scrollBy_yPixel = f3;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(87500);
        return cameraUpdate;
    }

    public static CameraUpdate zoomTo(float f2) {
        AppMethodBeat.i(87501);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 3;
        cameraParameter.zoomTo_zoom = f2;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(87501);
        return cameraUpdate;
    }

    public static CameraUpdate zoomBy(float f2) {
        AppMethodBeat.i(87502);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 4;
        cameraParameter.zoomBy_amount = f2;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(87502);
        return cameraUpdate;
    }

    public static CameraUpdate zoomBy(float f2, Point point) {
        AppMethodBeat.i(87503);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 5;
        cameraParameter.zoomBy_Point_amount = f2;
        cameraParameter.zoomBy_Point_focus = point;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(87503);
        return cameraUpdate;
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        AppMethodBeat.i(87504);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 6;
        cameraParameter.newCameraPosition = cameraPosition;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(87504);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        AppMethodBeat.i(87505);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 7;
        cameraParameter.newLatLng = latLng;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(87505);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f2) {
        AppMethodBeat.i(87506);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 8;
        cameraParameter.newLatLngZoom_latlng = latLng;
        cameraParameter.newLatLngZoom_zoom = f2;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(87506);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i2) {
        AppMethodBeat.i(87507);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 9;
        cameraParameter.newLatLngBounds_bounds = latLngBounds;
        cameraParameter.newLatLngBounds_padding = i2;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(87507);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i2, int i3, int i4) {
        AppMethodBeat.i(87508);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 10;
        cameraParameter.newLatLngBounds_dimension_bounds = latLngBounds;
        cameraParameter.newLatLngBounds_dimension_width = i2;
        cameraParameter.newLatLngBounds_dimension_height = i3;
        cameraParameter.newLatLngBounds_dimension_padding = i4;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(87508);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLngBoundsWithMapCenter(LatLngBounds latLngBounds, LatLng latLng, int i2) {
        AppMethodBeat.i(87509);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 11;
        cameraParameter.newLatLngBounds_bounds = latLngBounds;
        cameraParameter.newLatLng = latLng;
        cameraParameter.newLatLngBounds_padding = i2;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(87509);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(173712);
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 12;
        cameraParameter.newLatLngBounds_dimension_bounds = latLngBounds;
        cameraParameter.newLatLngBoundsRects_padLeft = i2;
        cameraParameter.newLatLngBoundsRects_padRight = i3;
        cameraParameter.newLatLngBoundsRects_padTop = i4;
        cameraParameter.newLatLngBoundsRects_padBom = i5;
        CameraUpdate cameraUpdate = new CameraUpdate(cameraParameter);
        AppMethodBeat.o(173712);
        return cameraUpdate;
    }
}
