package com.tencent.map.sdk.utilities.heatmap;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class WeightedLatLng implements Parcelable {
    public static final Parcelable.Creator<WeightedLatLng> CREATOR = new Parcelable.Creator<WeightedLatLng>() {
        /* class com.tencent.map.sdk.utilities.heatmap.WeightedLatLng.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WeightedLatLng[] newArray(int i2) {
            return new WeightedLatLng[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WeightedLatLng createFromParcel(Parcel parcel) {
            AppMethodBeat.i(193508);
            WeightedLatLng weightedLatLng = new WeightedLatLng(parcel);
            AppMethodBeat.o(193508);
            return weightedLatLng;
        }
    };
    private static final double DEFAULT_INTENSITY = 1.0d;
    private double mIntensity;
    private LatLng mPoint;

    static {
        AppMethodBeat.i(84402);
        AppMethodBeat.o(84402);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(193509);
        parcel.writeParcelable(this.mPoint, i2);
        parcel.writeDouble(this.mIntensity);
        AppMethodBeat.o(193509);
    }

    protected WeightedLatLng(Parcel parcel) {
        AppMethodBeat.i(193510);
        this.mPoint = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.mIntensity = parcel.readDouble();
        AppMethodBeat.o(193510);
    }

    public WeightedLatLng(LatLng latLng, double d2) {
        AppMethodBeat.i(172903);
        setPoint(latLng);
        setIntensity(d2);
        AppMethodBeat.o(172903);
    }

    public WeightedLatLng(LatLng latLng) {
        this(latLng, DEFAULT_INTENSITY);
    }

    public void setPoint(LatLng latLng) {
        this.mPoint = latLng;
    }

    public LatLng getPoint() {
        return this.mPoint;
    }

    public void setIntensity(double d2) {
        if (d2 >= 0.0d) {
            this.mIntensity = d2;
        } else {
            this.mIntensity = DEFAULT_INTENSITY;
        }
    }

    public double getIntensity() {
        return this.mIntensity;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(193511);
        if (!(obj instanceof WeightedLatLng)) {
            AppMethodBeat.o(193511);
            return false;
        } else if (obj == this) {
            AppMethodBeat.o(193511);
            return true;
        } else if (this.mPoint != null) {
            if (!this.mPoint.equals(((WeightedLatLng) obj).mPoint) || this.mIntensity != ((WeightedLatLng) obj).mIntensity) {
                AppMethodBeat.o(193511);
                return false;
            }
            AppMethodBeat.o(193511);
            return true;
        } else if (((WeightedLatLng) obj).mPoint != null) {
            AppMethodBeat.o(193511);
            return false;
        } else if (this.mIntensity == ((WeightedLatLng) obj).mIntensity) {
            AppMethodBeat.o(193511);
            return true;
        } else {
            AppMethodBeat.o(193511);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(193512);
        if (this.mPoint != null) {
            int hashCode = this.mPoint.hashCode() + ((int) (this.mIntensity * 1000000.0d));
            AppMethodBeat.o(193512);
            return hashCode;
        }
        int i2 = (int) (this.mIntensity * 1000000.0d);
        AppMethodBeat.o(193512);
        return i2;
    }
}
