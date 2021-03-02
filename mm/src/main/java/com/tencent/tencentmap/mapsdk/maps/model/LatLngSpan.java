package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LatLngSpan implements Parcelable {
    public static final Parcelable.Creator<LatLngSpan> CREATOR = new Parcelable.Creator<LatLngSpan>() {
        /* class com.tencent.tencentmap.mapsdk.maps.model.LatLngSpan.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LatLngSpan[] newArray(int i2) {
            return new LatLngSpan[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLngSpan createFromParcel(Parcel parcel) {
            AppMethodBeat.i(181069);
            LatLngSpan latLngSpan = new LatLngSpan(parcel);
            AppMethodBeat.o(181069);
            return latLngSpan;
        }
    };
    private double mLatitudeSpan;
    private double mLongitudeSpan;

    private LatLngSpan(Parcel parcel) {
        AppMethodBeat.i(181070);
        this.mLatitudeSpan = parcel.readDouble();
        this.mLongitudeSpan = parcel.readDouble();
        AppMethodBeat.o(181070);
    }

    public LatLngSpan(double d2, double d3) {
        this.mLatitudeSpan = d2;
        this.mLongitudeSpan = d3;
    }

    public double getLatitudeSpan() {
        return this.mLatitudeSpan;
    }

    public void setLatitudeSpan(double d2) {
        this.mLatitudeSpan = d2;
    }

    public double getLongitudeSpan() {
        return this.mLongitudeSpan;
    }

    public void setLongitudeSpan(double d2) {
        this.mLongitudeSpan = d2;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(181071);
        if (this == obj) {
            AppMethodBeat.o(181071);
            return true;
        } else if (obj instanceof LatLngSpan) {
            LatLngSpan latLngSpan = (LatLngSpan) obj;
            if (this.mLongitudeSpan == latLngSpan.getLongitudeSpan() && this.mLatitudeSpan == latLngSpan.getLatitudeSpan()) {
                AppMethodBeat.o(181071);
                return true;
            }
            AppMethodBeat.o(181071);
            return false;
        } else {
            AppMethodBeat.o(181071);
            return false;
        }
    }

    static {
        AppMethodBeat.i(181074);
        AppMethodBeat.o(181074);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(181072);
        parcel.writeDouble(this.mLatitudeSpan);
        parcel.writeDouble(this.mLongitudeSpan);
        AppMethodBeat.o(181072);
    }

    public int hashCode() {
        AppMethodBeat.i(181073);
        long doubleToLongBits = Double.doubleToLongBits(this.mLatitudeSpan);
        long doubleToLongBits2 = Double.doubleToLongBits(this.mLongitudeSpan);
        int i2 = (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        AppMethodBeat.o(181073);
        return i2;
    }
}
