package com.tencent.tencentmap.mapsdk.maps.model;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate;

public class LatLng implements Parcelable, Coordinate {
    public static final Parcelable.Creator<LatLng> CREATOR = new Parcelable.Creator<LatLng>() {
        /* class com.tencent.tencentmap.mapsdk.maps.model.LatLng.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LatLng[] newArray(int i2) {
            return new LatLng[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLng createFromParcel(Parcel parcel) {
            AppMethodBeat.i(173145);
            LatLng latLng = new LatLng(parcel);
            AppMethodBeat.o(173145);
            return latLng;
        }
    };
    public double altitude;
    public double latitude;
    public double longitude;

    static {
        AppMethodBeat.i(173157);
        AppMethodBeat.o(173157);
    }

    public LatLng() {
        this.altitude = 0.0d;
        this.latitude = 0.0d;
        this.longitude = 0.0d;
    }

    public LatLng(double d2, double d3) {
        AppMethodBeat.i(173146);
        this.altitude = 0.0d;
        setLatitude(d2);
        setLongitude(d3);
        AppMethodBeat.o(173146);
    }

    public LatLng(double d2, double d3, double d4) {
        AppMethodBeat.i(173147);
        this.altitude = 0.0d;
        setLatitude(d2);
        setLongitude(d3);
        setAltitude(d4);
        AppMethodBeat.o(173147);
    }

    public LatLng(Location location) {
        this(location.getLatitude(), location.getLongitude(), location.getAltitude());
        AppMethodBeat.i(173148);
        AppMethodBeat.o(173148);
    }

    public LatLng(LatLng latLng) {
        this.altitude = 0.0d;
        this.latitude = latLng.latitude;
        this.longitude = latLng.longitude;
        this.altitude = latLng.altitude;
    }

    public LatLng(Parcel parcel) {
        AppMethodBeat.i(173149);
        this.altitude = 0.0d;
        setLatitude(parcel.readDouble());
        setLongitude(parcel.readDouble());
        setAltitude(parcel.readDouble());
        AppMethodBeat.o(173149);
    }

    public void setLatitude(double d2) {
        AppMethodBeat.i(173150);
        if (Double.isNaN(d2)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("latitude must not be NaN");
            AppMethodBeat.o(173150);
            throw illegalArgumentException;
        } else if (Math.abs(d2) > 90.0d) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("latitude must be between -90 and 90");
            AppMethodBeat.o(173150);
            throw illegalArgumentException2;
        } else {
            this.latitude = d2;
            AppMethodBeat.o(173150);
        }
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLongitude(double d2) {
        AppMethodBeat.i(173151);
        if (Double.isNaN(d2)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("longitude must not be NaN");
            AppMethodBeat.o(173151);
            throw illegalArgumentException;
        } else if (Double.isInfinite(d2)) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("longitude must not be infinite");
            AppMethodBeat.o(173151);
            throw illegalArgumentException2;
        } else {
            this.longitude = d2;
            AppMethodBeat.o(173151);
        }
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setAltitude(double d2) {
        this.altitude = d2;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public LatLng wrap() {
        AppMethodBeat.i(173152);
        LatLng latLng = new LatLng(this.latitude, wrap(this.longitude, -180.0d, 180.0d));
        AppMethodBeat.o(173152);
        return latLng;
    }

    static double wrap(double d2, double d3, double d4) {
        double d5 = d4 - d3;
        double d6 = (((d2 - d3) % d5) + d5) % d5;
        return (d2 < d4 || d6 != 0.0d) ? d6 + d3 : d4;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(173153);
        if (this == obj) {
            AppMethodBeat.o(173153);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(173153);
            return false;
        } else {
            LatLng latLng = (LatLng) obj;
            if (Double.compare(latLng.altitude, this.altitude) == 0 && Double.compare(latLng.latitude, this.latitude) == 0 && Double.compare(latLng.longitude, this.longitude) == 0) {
                AppMethodBeat.o(173153);
                return true;
            }
            AppMethodBeat.o(173153);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(173154);
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        long doubleToLongBits3 = Double.doubleToLongBits(this.altitude);
        int i2 = (((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        AppMethodBeat.o(173154);
        return i2;
    }

    public String toString() {
        AppMethodBeat.i(173155);
        String str = "LatLng [latitude=" + this.latitude + ", longitude=" + this.longitude + ", altitude=" + this.altitude + "]";
        AppMethodBeat.o(173155);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(173156);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.altitude);
        AppMethodBeat.o(173156);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public double x() {
        return this.latitude;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public double y() {
        return this.longitude;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public double z() {
        return this.altitude;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public void setX(double d2) {
        this.latitude = d2;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public void setY(double d2) {
        this.longitude = d2;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public void setZ(double d2) {
        this.altitude = d2;
    }
}
