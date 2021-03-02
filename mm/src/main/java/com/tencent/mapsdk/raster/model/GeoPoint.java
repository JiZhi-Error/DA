package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GeoPoint implements Parcelable {
    public static final Parcelable.Creator<GeoPoint> CREATOR = new Parcelable.Creator<GeoPoint>() {
        /* class com.tencent.mapsdk.raster.model.GeoPoint.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final GeoPoint createFromParcel(Parcel parcel) {
            AppMethodBeat.i(87597);
            GeoPoint geoPoint = new GeoPoint(parcel);
            AppMethodBeat.o(87597);
            return geoPoint;
        }

        @Override // android.os.Parcelable.Creator
        public final GeoPoint[] newArray(int i2) {
            return new GeoPoint[i2];
        }
    };
    private int e6Lat;
    private int e6Lon;

    public GeoPoint(int i2, int i3) {
        this.e6Lat = 0;
        this.e6Lon = 0;
        this.e6Lat = i2;
        this.e6Lon = i3;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(87534);
        if (obj == null) {
            AppMethodBeat.o(87534);
            return false;
        } else if (obj.getClass() != getClass()) {
            AppMethodBeat.o(87534);
            return false;
        } else {
            GeoPoint geoPoint = (GeoPoint) obj;
            if (this.e6Lat == geoPoint.e6Lat && this.e6Lon == geoPoint.e6Lon) {
                AppMethodBeat.o(87534);
                return true;
            }
            AppMethodBeat.o(87534);
            return false;
        }
    }

    public int hashCode() {
        return (this.e6Lon * 7) + (this.e6Lat * 11);
    }

    public String toString() {
        AppMethodBeat.i(87535);
        String str = this.e6Lat + "," + this.e6Lon;
        AppMethodBeat.o(87535);
        return str;
    }

    public int getLongitudeE6() {
        return this.e6Lon;
    }

    public void setLongitudeE6(int i2) {
        this.e6Lon = i2;
    }

    public int getLatitudeE6() {
        return this.e6Lat;
    }

    public void setLatitudeE6(int i2) {
        this.e6Lat = i2;
    }

    public GeoPoint Copy() {
        AppMethodBeat.i(87536);
        GeoPoint geoPoint = new GeoPoint(this.e6Lat, this.e6Lon);
        AppMethodBeat.o(87536);
        return geoPoint;
    }

    private GeoPoint(Parcel parcel) {
        AppMethodBeat.i(87537);
        this.e6Lat = 0;
        this.e6Lon = 0;
        this.e6Lat = parcel.readInt();
        this.e6Lon = parcel.readInt();
        AppMethodBeat.o(87537);
    }

    static {
        AppMethodBeat.i(87540);
        AppMethodBeat.o(87540);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(87538);
        parcel.writeInt(this.e6Lat);
        parcel.writeInt(this.e6Lon);
        AppMethodBeat.o(87538);
    }

    public static LatLng g2l(GeoPoint geoPoint) {
        AppMethodBeat.i(87539);
        LatLng latLng = new LatLng((((double) geoPoint.getLatitudeE6()) * 1.0d) / 1000000.0d, (((double) geoPoint.getLongitudeE6()) * 1.0d) / 1000000.0d);
        AppMethodBeat.o(87539);
        return latLng;
    }
}
