package com.d.a.a.a.a;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;

public final class h implements Projection {
    private com.tencent.tencentmap.mapsdk.maps.Projection SJP;
    private TencentMap mMap;

    public h(TencentMap tencentMap) {
        AppMethodBeat.i(217383);
        this.SJP = tencentMap.getProjection();
        this.mMap = tencentMap;
        AppMethodBeat.o(217383);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.Projection
    public final LatLng fromScreenLocation(Point point) {
        AppMethodBeat.i(217384);
        LatLng a2 = l.a(this.SJP.fromScreenLocation(point));
        AppMethodBeat.o(217384);
        return a2;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.Projection
    public final Point toScreenLocation(LatLng latLng) {
        AppMethodBeat.i(217385);
        Point screenLocation = this.SJP.toScreenLocation(l.c(latLng));
        AppMethodBeat.o(217385);
        return screenLocation;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.Projection
    public final VisibleRegion getVisibleRegion() {
        LatLngBounds latLngBounds = null;
        AppMethodBeat.i(217386);
        com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion visibleRegion = this.SJP.getVisibleRegion();
        if (visibleRegion == null) {
            AppMethodBeat.o(217386);
            return null;
        }
        LatLng a2 = l.a(visibleRegion.nearLeft);
        LatLng a3 = l.a(visibleRegion.nearRight);
        LatLng a4 = l.a(visibleRegion.farLeft);
        LatLng a5 = l.a(visibleRegion.farRight);
        com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds latLngBounds2 = visibleRegion.latLngBounds;
        if (!(latLngBounds2 == null || latLngBounds2.northeast == null || latLngBounds2.southwest == null)) {
            latLngBounds = new LatLngBounds(new LatLng(latLngBounds2.southwest.latitude, latLngBounds2.southwest.longitude), new LatLng(latLngBounds2.northeast.latitude, latLngBounds2.northeast.longitude));
        }
        VisibleRegion visibleRegion2 = new VisibleRegion(a2, a3, a4, a5, latLngBounds);
        AppMethodBeat.o(217386);
        return visibleRegion2;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.Projection
    public final float metersToEquatorPixels(float f2) {
        AppMethodBeat.i(217388);
        float metersToPixels = metersToPixels(0.0d, (double) f2);
        AppMethodBeat.o(217388);
        return metersToPixels;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.Projection
    public final float metersToPixels(double d2, double d3) {
        AppMethodBeat.i(217389);
        float metersPerPixel = (float) (d3 / this.SJP.metersPerPixel(d2));
        AppMethodBeat.o(217389);
        return metersPerPixel;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.Projection
    public final double getLatitudeSpan() {
        AppMethodBeat.i(217390);
        com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion visibleRegion = this.SJP.getVisibleRegion();
        if (visibleRegion == null) {
            AppMethodBeat.o(217390);
            return -1.0d;
        }
        double d2 = visibleRegion.latLngBounds.southwest.latitude - visibleRegion.latLngBounds.northeast.latitude;
        AppMethodBeat.o(217390);
        return d2;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.Projection
    public final double getLongitudeSpan() {
        AppMethodBeat.i(217391);
        com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion visibleRegion = this.SJP.getVisibleRegion();
        if (visibleRegion == null) {
            AppMethodBeat.o(217391);
            return -1.0d;
        }
        double d2 = visibleRegion.latLngBounds.southwest.longitude - visibleRegion.latLngBounds.northeast.longitude;
        AppMethodBeat.o(217391);
        return d2;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.Projection
    public final float getScalePerPixel() {
        AppMethodBeat.i(217392);
        float metersPerPixel = (float) this.SJP.metersPerPixel(this.mMap.getCameraPosition().target.latitude);
        AppMethodBeat.o(217392);
        return metersPerPixel;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.Projection
    @Deprecated
    public final Point toPixels(GeoPoint geoPoint, Point point) {
        AppMethodBeat.i(217393);
        LatLng g2l = GeoPoint.g2l(geoPoint);
        if (g2l == null) {
            AppMethodBeat.o(217393);
            return null;
        }
        Point screenLocation = toScreenLocation(g2l);
        AppMethodBeat.o(217393);
        return screenLocation;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.Projection
    public final double distanceBetween(LatLng latLng, LatLng latLng2) {
        AppMethodBeat.i(217387);
        double longitude = latLng.getLongitude();
        double latitude = latLng.getLatitude();
        double d2 = longitude * 0.01745329251994329d;
        double d3 = latitude * 0.01745329251994329d;
        double longitude2 = latLng2.getLongitude() * 0.01745329251994329d;
        double latitude2 = latLng2.getLatitude() * 0.01745329251994329d;
        double sin = Math.sin(d2);
        double sin2 = Math.sin(d3);
        double cos = Math.cos(d2);
        double cos2 = Math.cos(d3);
        double sin3 = Math.sin(longitude2);
        double sin4 = Math.sin(latitude2);
        double cos3 = Math.cos(longitude2);
        double cos4 = Math.cos(latitude2);
        double[] dArr = {cos * cos2, cos2 * sin, sin2};
        double[] dArr2 = {cos4 * cos3, cos4 * sin3, sin4};
        double asin = Math.asin(Math.sqrt((((dArr[0] - dArr2[0]) * (dArr[0] - dArr2[0])) + ((dArr[1] - dArr2[1]) * (dArr[1] - dArr2[1]))) + ((dArr[2] - dArr2[2]) * (dArr[2] - dArr2[2]))) / 2.0d) * 1.27420015798544E7d;
        AppMethodBeat.o(217387);
        return asin;
    }
}
