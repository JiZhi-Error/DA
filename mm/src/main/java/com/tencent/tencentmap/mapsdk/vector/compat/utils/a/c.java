package com.tencent.tencentmap.mapsdk.vector.compat.utils.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static double f2834a = 6378137.0d;

    /* renamed from: b  reason: collision with root package name */
    final double f2835b;

    public c() {
        AppMethodBeat.i(199656);
        this.f2835b = 6.283185307179586d * f2834a;
        AppMethodBeat.o(199656);
    }

    public c(double d2) {
        this.f2835b = d2;
    }

    public b a(LatLng latLng) {
        AppMethodBeat.i(199657);
        double sin = Math.sin(Math.toRadians(latLng.getLatitude()));
        b bVar = new b(((latLng.getLongitude() / 360.0d) + 0.5d) * this.f2835b, (((Math.log((1.0d + sin) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * this.f2835b);
        AppMethodBeat.o(199657);
        return bVar;
    }

    public LatLng a(b bVar) {
        AppMethodBeat.i(199658);
        LatLng latLng = new LatLng(90.0d - Math.toDegrees(Math.atan(Math.exp(((-(0.5d - (bVar.f2833b / this.f2835b))) * 2.0d) * 3.141592653589793d)) * 2.0d), ((bVar.f2832a / this.f2835b) - 0.5d) * 360.0d);
        AppMethodBeat.o(199658);
        return latLng;
    }

    public double a(LatLng latLng, LatLng latLng2) {
        AppMethodBeat.i(199659);
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
        double asin = Math.asin(Math.sqrt((((dArr[0] - dArr2[0]) * (dArr[0] - dArr2[0])) + ((dArr[1] - dArr2[1]) * (dArr[1] - dArr2[1]))) + ((dArr[2] - dArr2[2]) * (dArr[2] - dArr2[2]))) / 2.0d) * this.f2835b * 3.141592653589793d;
        AppMethodBeat.o(199659);
        return asin;
    }
}
