package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.CamerParameter;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;

public final class CameraUpdateFactory {
    private CameraUpdateFactory() {
    }

    public static CameraUpdate zoomIn() {
        AppMethodBeat.i(180971);
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.ZOOMIN;
        CameraUpdate cameraUpdate = new CameraUpdate(camerParameter);
        AppMethodBeat.o(180971);
        return cameraUpdate;
    }

    public static CameraUpdate zoomOut() {
        AppMethodBeat.i(180972);
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.ZOOMOUT;
        CameraUpdate cameraUpdate = new CameraUpdate(camerParameter);
        AppMethodBeat.o(180972);
        return cameraUpdate;
    }

    public static CameraUpdate scrollBy(float f2, float f3) {
        AppMethodBeat.i(180973);
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.SCROLLBY;
        camerParameter.scrollBy_xPixel = f2;
        camerParameter.scrollBy_yPixel = f3;
        CameraUpdate cameraUpdate = new CameraUpdate(camerParameter);
        AppMethodBeat.o(180973);
        return cameraUpdate;
    }

    public static CameraUpdate zoomTo(float f2) {
        AppMethodBeat.i(180974);
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.ZOOMTO;
        camerParameter.zoomTo_zoom = f2;
        CameraUpdate cameraUpdate = new CameraUpdate(camerParameter);
        AppMethodBeat.o(180974);
        return cameraUpdate;
    }

    public static CameraUpdate zoomBy(float f2) {
        AppMethodBeat.i(180975);
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.ZOOMBY;
        camerParameter.zoomBy_amount = f2;
        CameraUpdate cameraUpdate = new CameraUpdate(camerParameter);
        AppMethodBeat.o(180975);
        return cameraUpdate;
    }

    public static CameraUpdate zoomBy(float f2, Point point) {
        AppMethodBeat.i(180976);
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.ZOOMBY_POINT;
        camerParameter.zoomBy_Point_amount = f2;
        camerParameter.zoomBy_Point_focus = point;
        CameraUpdate cameraUpdate = new CameraUpdate(camerParameter);
        AppMethodBeat.o(180976);
        return cameraUpdate;
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        AppMethodBeat.i(180977);
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.NEWCAMER_POSITION;
        camerParameter.newCameraPosition_cameraPosition = cameraPosition;
        CameraUpdate cameraUpdate = new CameraUpdate(camerParameter);
        AppMethodBeat.o(180977);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        AppMethodBeat.i(180978);
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.NEWLATLNG;
        camerParameter.newLatLng_latLng = latLng;
        CameraUpdate cameraUpdate = new CameraUpdate(camerParameter);
        AppMethodBeat.o(180978);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f2) {
        AppMethodBeat.i(180979);
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.NEWLATLNG_ZOOM;
        camerParameter.newLatLngZoom_latLng = latLng;
        camerParameter.newLatLngZoom_zoom = f2;
        CameraUpdate cameraUpdate = new CameraUpdate(camerParameter);
        AppMethodBeat.o(180979);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i2) {
        AppMethodBeat.i(180980);
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.NEWLATLNG_BOUNDS;
        camerParameter.newLatLngBounds_bounds = latLngBounds;
        camerParameter.newLatLngBounds_padding = i2;
        CameraUpdate cameraUpdate = new CameraUpdate(camerParameter);
        AppMethodBeat.o(180980);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(180981);
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.NEWLATLNG_BOUNDS_RECT;
        camerParameter.newLatLngBounds_dimension_bounds = latLngBounds;
        camerParameter.newLatLngBoundsRects_padLeft = i2;
        camerParameter.newLatLngBoundsRects_padRight = i3;
        camerParameter.newLatLngBoundsRects_padTop = i4;
        camerParameter.newLatLngBoundsRects_padBom = i5;
        CameraUpdate cameraUpdate = new CameraUpdate(camerParameter);
        AppMethodBeat.o(180981);
        return cameraUpdate;
    }

    static CameraUpdate newElementBoundsRect(List<IOverlay> list, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(180982);
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.NEW_ELEMENTS_BOUNDS_RECT;
        camerParameter.elements = list;
        camerParameter.newLatLngBoundsRects_padLeft = i2;
        camerParameter.newLatLngBoundsRects_padRight = i3;
        camerParameter.newLatLngBoundsRects_padTop = i4;
        camerParameter.newLatLngBoundsRects_padBom = i5;
        CameraUpdate cameraUpdate = new CameraUpdate(camerParameter);
        AppMethodBeat.o(180982);
        return cameraUpdate;
    }

    public static CameraUpdate rotateTo(float f2, float f3) {
        AppMethodBeat.i(180983);
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = CamerParameter.ROTATETO;
        camerParameter.rotateto_rotate = f2;
        camerParameter.rotateto_skew = f3;
        CameraUpdate cameraUpdate = new CameraUpdate(camerParameter);
        AppMethodBeat.o(180983);
        return cameraUpdate;
    }

    public static CameraUpdate newLatLngBoundsWithMapCenter(LatLngBounds latLngBounds, LatLng latLng, int i2) {
        AppMethodBeat.i(180984);
        if (latLngBounds == null) {
            AppMethodBeat.o(180984);
            return null;
        }
        LatLng latLng2 = latLngBounds.northeast;
        LatLng symmetricPoint = getSymmetricPoint(latLng, latLng2);
        LatLng latLng3 = latLngBounds.southwest;
        LatLng symmetricPoint2 = getSymmetricPoint(latLng, latLng3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(latLng2);
        arrayList.add(symmetricPoint);
        arrayList.add(latLng3);
        arrayList.add(symmetricPoint2);
        CameraUpdate newLatLngBounds = newLatLngBounds(new LatLngBounds.Builder().include(arrayList).build(), i2);
        AppMethodBeat.o(180984);
        return newLatLngBounds;
    }

    private static LatLng getSymmetricPoint(LatLng latLng, LatLng latLng2) {
        AppMethodBeat.i(180985);
        LatLng latLng3 = new LatLng((latLng.latitude * 2.0d) - latLng2.latitude, (latLng.longitude * 2.0d) - latLng2.longitude);
        AppMethodBeat.o(180985);
        return latLng3;
    }
}
