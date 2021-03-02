package com.d.a.a.a.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mapsdk.raster.model.Language;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.CameraParameter;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorInfo;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;

public final class l {
    public static LatLng c(com.tencent.mapsdk.raster.model.LatLng latLng) {
        AppMethodBeat.i(217540);
        if (latLng == null) {
            AppMethodBeat.o(217540);
            return null;
        }
        LatLng latLng2 = new LatLng(latLng.getLatitude(), latLng.getLongitude());
        AppMethodBeat.o(217540);
        return latLng2;
    }

    public static com.tencent.mapsdk.raster.model.LatLng a(LatLng latLng) {
        AppMethodBeat.i(217541);
        if (latLng == null) {
            AppMethodBeat.o(217541);
            return null;
        }
        com.tencent.mapsdk.raster.model.LatLng latLng2 = new com.tencent.mapsdk.raster.model.LatLng(latLng.latitude, latLng.longitude);
        AppMethodBeat.o(217541);
        return latLng2;
    }

    public static List<com.tencent.mapsdk.raster.model.LatLng> kk(List<LatLng> list) {
        AppMethodBeat.i(217542);
        if (list == null) {
            AppMethodBeat.o(217542);
            return null;
        }
        LatLng[] latLngArr = (LatLng[]) list.toArray(new LatLng[list.size()]);
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : latLngArr) {
            arrayList.add(a(latLng));
        }
        AppMethodBeat.o(217542);
        return arrayList;
    }

    public static List<LatLng> kl(List<com.tencent.mapsdk.raster.model.LatLng> list) {
        AppMethodBeat.i(217543);
        if (list == null) {
            AppMethodBeat.o(217543);
            return null;
        }
        com.tencent.mapsdk.raster.model.LatLng[] latLngArr = (com.tencent.mapsdk.raster.model.LatLng[]) list.toArray(new com.tencent.mapsdk.raster.model.LatLng[list.size()]);
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mapsdk.raster.model.LatLng latLng : latLngArr) {
            arrayList.add(c(latLng));
        }
        AppMethodBeat.o(217543);
        return arrayList;
    }

    private static CameraPosition a(com.tencent.mapsdk.raster.model.CameraPosition cameraPosition) {
        AppMethodBeat.i(217544);
        if (cameraPosition == null) {
            AppMethodBeat.o(217544);
            return null;
        }
        CameraPosition cameraPosition2 = new CameraPosition(c(cameraPosition.getTarget()), cameraPosition.getZoom(), cameraPosition.getSkew(), cameraPosition.getBearing());
        AppMethodBeat.o(217544);
        return cameraPosition2;
    }

    public static com.tencent.mapsdk.raster.model.CameraPosition a(CameraPosition cameraPosition) {
        AppMethodBeat.i(217545);
        if (cameraPosition == null) {
            AppMethodBeat.o(217545);
            return null;
        }
        com.tencent.mapsdk.raster.model.CameraPosition cameraPosition2 = new com.tencent.mapsdk.raster.model.CameraPosition(a(cameraPosition.target), cameraPosition.zoom, cameraPosition.tilt, cameraPosition.bearing);
        AppMethodBeat.o(217545);
        return cameraPosition2;
    }

    private static LatLngBounds a(com.tencent.mapsdk.raster.model.LatLngBounds latLngBounds) {
        AppMethodBeat.i(217546);
        if (latLngBounds == null || latLngBounds.getNortheast() == null || latLngBounds.getSouthwest() == null) {
            AppMethodBeat.o(217546);
            return null;
        }
        LatLngBounds latLngBounds2 = new LatLngBounds(new LatLng(latLngBounds.getSouthwest().getLatitude(), latLngBounds.getSouthwest().getLongitude()), new LatLng(latLngBounds.getNortheast().getLatitude(), latLngBounds.getNortheast().getLongitude()));
        AppMethodBeat.o(217546);
        return latLngBounds2;
    }

    public static PolylineOptions a(com.tencent.mapsdk.raster.model.PolylineOptions polylineOptions) {
        AppMethodBeat.i(217547);
        if (polylineOptions == null) {
            AppMethodBeat.o(217547);
            return null;
        }
        PolylineOptions polylineOptions2 = new PolylineOptions();
        List<LatLng> kl = kl(polylineOptions.getPoints());
        if (kl == null || kl.size() == 0) {
            AppMethodBeat.o(217547);
            return null;
        }
        polylineOptions2.addAll(kl);
        polylineOptions2.zIndex((int) polylineOptions.getZIndex()).level(polylineOptions.getLevel()).width(polylineOptions.getWidth()).visible(polylineOptions.isVisible()).color(polylineOptions.getColor()).borderColor(polylineOptions.getEdgeColor()).borderWidth(polylineOptions.getEdgeWidth()).lineType(polylineOptions.getLineType()).eraseColor(polylineOptions.getEraseColor()).indoorInfo(a(polylineOptions.getIndoorInfo())).lineCap(polylineOptions.lineCap());
        if (polylineOptions.getColorTexture() != null) {
            polylineOptions2.colorTexture(BitmapDescriptorFactory.fromBitmap(polylineOptions.getColorTexture().getBitmap()));
        }
        if (polylineOptions.getArrowTexture() != null) {
            polylineOptions2.arrow(true);
            polylineOptions2.arrowSpacing((int) polylineOptions.getArrowGap());
            Matrix matrix = new Matrix();
            matrix.postRotate(-90.0f);
            try {
                Bitmap bitmap = polylineOptions.getArrowTexture().getBitmap();
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);
                polylineOptions2.arrowTexture(BitmapDescriptorFactory.fromBitmap(Bitmap.createBitmap(createScaledBitmap, 0, 0, createScaledBitmap.getWidth(), createScaledBitmap.getHeight(), matrix, true)));
            } catch (Exception e2) {
            }
        }
        if (polylineOptions.isDottedLine()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf((int) (3.0f * polylineOptions.getWidth())));
            arrayList.add(Integer.valueOf((int) polylineOptions.getWidth()));
            polylineOptions2.pattern(arrayList);
        }
        if (polylineOptions.getColors() != null) {
            polylineOptions2.colors(polylineOptions.getColors()[0], polylineOptions.getColors()[1]);
        }
        AppMethodBeat.o(217547);
        return polylineOptions2;
    }

    static CameraUpdate a(com.tencent.tencentmap.mapsdk.map.CameraUpdate cameraUpdate, TencentMap tencentMap) {
        float maxZoomLevel;
        int i2;
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(217548);
        if (cameraUpdate == null || cameraUpdate.getParams() == null) {
            AppMethodBeat.o(217548);
            return null;
        }
        CameraParameter params = cameraUpdate.getParams();
        switch (cameraUpdate.getParams().cameraUpdate_type) {
            case 0:
                CameraUpdate zoomIn = CameraUpdateFactory.zoomIn();
                AppMethodBeat.o(217548);
                return zoomIn;
            case 1:
                CameraUpdate zoomOut = CameraUpdateFactory.zoomOut();
                AppMethodBeat.o(217548);
                return zoomOut;
            case 2:
                CameraUpdate scrollBy = CameraUpdateFactory.scrollBy(params.scrollBy_xPixel, params.scrollBy_yPixel);
                AppMethodBeat.o(217548);
                return scrollBy;
            case 3:
                if (params.zoomTo_zoom < tencentMap.getMinZoomLevel()) {
                    maxZoomLevel = tencentMap.getMinZoomLevel();
                } else {
                    maxZoomLevel = params.zoomTo_zoom > tencentMap.getMaxZoomLevel() ? tencentMap.getMaxZoomLevel() : params.zoomTo_zoom;
                }
                CameraUpdate zoomTo = CameraUpdateFactory.zoomTo(maxZoomLevel);
                AppMethodBeat.o(217548);
                return zoomTo;
            case 4:
                CameraUpdate zoomBy = CameraUpdateFactory.zoomBy(params.zoomBy_amount);
                AppMethodBeat.o(217548);
                return zoomBy;
            case 5:
                CameraUpdate zoomBy2 = CameraUpdateFactory.zoomBy(params.zoomBy_Point_amount, params.zoomBy_Point_focus);
                AppMethodBeat.o(217548);
                return zoomBy2;
            case 6:
                CameraUpdate newCameraPosition = CameraUpdateFactory.newCameraPosition(a(params.newCameraPosition));
                AppMethodBeat.o(217548);
                return newCameraPosition;
            case 7:
                CameraUpdate newLatLng = CameraUpdateFactory.newLatLng(c(params.newLatLng));
                AppMethodBeat.o(217548);
                return newLatLng;
            case 8:
                CameraUpdate newLatLngZoom = CameraUpdateFactory.newLatLngZoom(c(params.newLatLngZoom_latlng), params.newLatLngZoom_zoom);
                AppMethodBeat.o(217548);
                return newLatLngZoom;
            case 9:
                CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(a(params.newLatLngBounds_bounds), params.newLatLngBounds_padding);
                AppMethodBeat.o(217548);
                return newLatLngBounds;
            case 10:
                if (tencentMap == null || tencentMap.getMapWidth() == 0 || tencentMap.getMapWidth() == 0) {
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                } else {
                    if (params.newLatLngBounds_dimension_width < tencentMap.getMapWidth()) {
                        int mapWidth = (tencentMap.getMapWidth() / 2) - ((params.newLatLngBounds_dimension_width / 2) - params.newLatLngBounds_dimension_padding);
                        i3 = mapWidth;
                        i5 = mapWidth;
                    } else {
                        i3 = 0;
                        i5 = 0;
                    }
                    if (params.newLatLngBounds_dimension_height < tencentMap.getMapHeight()) {
                        int mapHeight = (tencentMap.getMapHeight() / 2) - ((params.newLatLngBounds_dimension_height / 2) - params.newLatLngBounds_dimension_padding);
                        i2 = mapHeight;
                        i4 = mapHeight;
                    } else {
                        i2 = 0;
                        i4 = 0;
                    }
                }
                CameraUpdate newLatLngBoundsRect = CameraUpdateFactory.newLatLngBoundsRect(a(params.newLatLngBounds_dimension_bounds), i3, i5, i4, i2);
                AppMethodBeat.o(217548);
                return newLatLngBoundsRect;
            case 11:
                CameraUpdate newLatLngBoundsWithMapCenter = CameraUpdateFactory.newLatLngBoundsWithMapCenter(a(params.newLatLngBounds_bounds), c(params.newLatLng), params.newLatLngBounds_padding);
                AppMethodBeat.o(217548);
                return newLatLngBoundsWithMapCenter;
            case 12:
                CameraUpdate newLatLngBoundsRect2 = CameraUpdateFactory.newLatLngBoundsRect(a(params.newLatLngBounds_dimension_bounds), params.newLatLngBoundsRects_padLeft, params.newLatLngBoundsRects_padRight, params.newLatLngBoundsRects_padTop, params.newLatLngBoundsRects_padBom);
                AppMethodBeat.o(217548);
                return newLatLngBoundsRect2;
            default:
                AppMethodBeat.o(217548);
                return null;
        }
    }

    static IndoorInfo a(com.tencent.mapsdk.raster.model.IndoorInfo indoorInfo) {
        AppMethodBeat.i(217549);
        if (indoorInfo == null) {
            AppMethodBeat.o(217549);
            return null;
        }
        IndoorInfo indoorInfo2 = new IndoorInfo(indoorInfo.getBuildingId(), indoorInfo.getFloorName());
        AppMethodBeat.o(217549);
        return indoorInfo2;
    }

    /* renamed from: com.d.a.a.a.a.l$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] SKu = new int[Language.values().length];

        static {
            AppMethodBeat.i(217539);
            try {
                SKu[Language.zh.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                SKu[Language.en.ordinal()] = 2;
                AppMethodBeat.o(217539);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.o(217539);
            }
        }
    }
}
