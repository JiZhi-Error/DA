package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class LatLng implements Cloneable {
    private static DecimalFormat df = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));
    private final double latitude;
    private final double longitude;

    static {
        AppMethodBeat.i(87563);
        AppMethodBeat.o(87563);
    }

    public LatLng(double d2, double d3) {
        AppMethodBeat.i(87556);
        if (-180.0d > d3 || d3 >= 180.0d) {
            this.longitude = parseDouble(((((d3 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d);
        } else {
            this.longitude = parseDouble(d3);
        }
        this.latitude = parseDouble(Math.max(-85.0d, Math.min(85.0d, d2)));
        AppMethodBeat.o(87556);
    }

    private static double parseDouble(double d2) {
        AppMethodBeat.i(87557);
        double parseDouble = Double.parseDouble(df.format(d2));
        AppMethodBeat.o(87557);
        return parseDouble;
    }

    @Override // java.lang.Object
    public final LatLng clone() {
        AppMethodBeat.i(87558);
        LatLng latLng = new LatLng(this.latitude, this.longitude);
        AppMethodBeat.o(87558);
        return latLng;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final int hashCode() {
        AppMethodBeat.i(87559);
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        int i2 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        AppMethodBeat.o(87559);
        return i2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(87560);
        if (this == obj) {
            AppMethodBeat.o(87560);
            return true;
        } else if (!(obj instanceof LatLng)) {
            AppMethodBeat.o(87560);
            return false;
        } else {
            LatLng latLng = (LatLng) obj;
            if (Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude)) {
                AppMethodBeat.o(87560);
                return true;
            }
            AppMethodBeat.o(87560);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(87561);
        String str = "lat/lng: (" + this.latitude + "," + this.longitude + ")";
        AppMethodBeat.o(87561);
        return str;
    }
}
