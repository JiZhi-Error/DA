package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.exception.InvalidLatLngBoundsException;
import java.util.ArrayList;
import java.util.List;

public class LatLngBounds implements Parcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new Parcelable.Creator<LatLngBounds>() {
        /* class com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LatLngBounds[] newArray(int i2) {
            return new LatLngBounds[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLngBounds createFromParcel(Parcel parcel) {
            AppMethodBeat.i(173158);
            LatLngBounds readFromParcel = LatLngBounds.readFromParcel(parcel);
            AppMethodBeat.o(173158);
            return readFromParcel;
        }
    };
    private final double latitudeNorth;
    private final double latitudeSouth;
    private final double longitudeEast;
    private final double longitudeWest;
    public final LatLng northeast;
    public final LatLng southwest;

    LatLngBounds(double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(173163);
        this.latitudeNorth = d2;
        this.longitudeEast = d3;
        this.latitudeSouth = d4;
        this.longitudeWest = d5;
        this.northeast = new LatLng(d2, d3);
        this.southwest = new LatLng(d4, d5);
        AppMethodBeat.o(173163);
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this.northeast = latLng;
        this.southwest = latLng2;
        this.latitudeNorth = latLng.latitude;
        this.longitudeEast = latLng.longitude;
        this.latitudeSouth = latLng2.latitude;
        this.longitudeWest = latLng2.longitude;
    }

    public static LatLngBounds world() {
        AppMethodBeat.i(173164);
        LatLngBounds from = from(90.0d, 180.0d, -90.0d, -180.0d);
        AppMethodBeat.o(173164);
        return from;
    }

    public static Builder builder() {
        AppMethodBeat.i(173165);
        Builder builder = new Builder();
        AppMethodBeat.o(173165);
        return builder;
    }

    public LatLngBounds including(LatLng latLng) {
        AppMethodBeat.i(173166);
        LatLngBounds include = include(latLng);
        AppMethodBeat.o(173166);
        return include;
    }

    public LatLng getCenter() {
        AppMethodBeat.i(173167);
        LatLng latLng = new LatLng((this.latitudeNorth + this.latitudeSouth) / 2.0d, (this.longitudeEast + this.longitudeWest) / 2.0d);
        AppMethodBeat.o(173167);
        return latLng;
    }

    public double getLatNorth() {
        return this.latitudeNorth;
    }

    public double getLatSouth() {
        return this.latitudeSouth;
    }

    public double getLonEast() {
        return this.longitudeEast;
    }

    public double getLonWest() {
        return this.longitudeWest;
    }

    public LatLng getSouthWest() {
        AppMethodBeat.i(173168);
        LatLng latLng = new LatLng(this.latitudeSouth, this.longitudeWest);
        AppMethodBeat.o(173168);
        return latLng;
    }

    public LatLng getNorthEast() {
        AppMethodBeat.i(173169);
        LatLng latLng = new LatLng(this.latitudeNorth, this.longitudeEast);
        AppMethodBeat.o(173169);
        return latLng;
    }

    public LatLng getSouthEast() {
        AppMethodBeat.i(173170);
        LatLng latLng = new LatLng(this.latitudeSouth, this.longitudeEast);
        AppMethodBeat.o(173170);
        return latLng;
    }

    public LatLng getNorthWest() {
        AppMethodBeat.i(173171);
        LatLng latLng = new LatLng(this.latitudeNorth, this.longitudeWest);
        AppMethodBeat.o(173171);
        return latLng;
    }

    public LatLngSpan getSpan() {
        AppMethodBeat.i(181062);
        LatLngSpan latLngSpan = new LatLngSpan(getLatitudeSpan(), getLongitudeSpan());
        AppMethodBeat.o(181062);
        return latLngSpan;
    }

    public double getLatitudeSpan() {
        AppMethodBeat.i(173173);
        double abs = Math.abs(this.latitudeNorth - this.latitudeSouth);
        AppMethodBeat.o(173173);
        return abs;
    }

    public double getLongitudeSpan() {
        AppMethodBeat.i(173174);
        double abs = Math.abs(this.longitudeEast - this.longitudeWest);
        AppMethodBeat.o(173174);
        return abs;
    }

    public boolean isEmptySpan() {
        AppMethodBeat.i(173175);
        if (getLongitudeSpan() == 0.0d || getLatitudeSpan() == 0.0d) {
            AppMethodBeat.o(173175);
            return true;
        }
        AppMethodBeat.o(173175);
        return false;
    }

    public String toString() {
        AppMethodBeat.i(173176);
        String str = "N:" + this.latitudeNorth + "; E:" + this.longitudeEast + "; S:" + this.latitudeSouth + "; W:" + this.longitudeWest;
        AppMethodBeat.o(173176);
        return str;
    }

    static LatLngBounds fromLatLngs(List<? extends LatLng> list) {
        AppMethodBeat.i(181063);
        double d2 = 90.0d;
        double d3 = Double.MAX_VALUE;
        double d4 = -90.0d;
        double d5 = -1.7976931348623157E308d;
        for (LatLng latLng : list) {
            if (latLng != null) {
                double latitude = latLng.getLatitude();
                double longitude = latLng.getLongitude();
                d2 = Math.min(d2, latitude);
                d3 = Math.min(d3, longitude);
                d4 = Math.max(d4, latitude);
                d5 = Math.max(d5, longitude);
            }
        }
        LatLngBounds latLngBounds = new LatLngBounds(d4, d5, d2, d3);
        AppMethodBeat.o(181063);
        return latLngBounds;
    }

    public LatLng[] toLatLngs() {
        AppMethodBeat.i(173178);
        LatLng[] latLngArr = {getNorthEast(), getSouthWest()};
        AppMethodBeat.o(173178);
        return latLngArr;
    }

    public static LatLngBounds from(double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(173179);
        checkParams(d2, d3, d4, d5);
        LatLngBounds latLngBounds = new LatLngBounds(d2, d3, d4, d5);
        AppMethodBeat.o(173179);
        return latLngBounds;
    }

    private static void checkParams(double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(181064);
        if (Double.isNaN(d2) || Double.isNaN(d4)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("latitude must not be NaN");
            AppMethodBeat.o(181064);
            throw illegalArgumentException;
        } else if (Double.isNaN(d3) || Double.isNaN(d5)) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("longitude must not be NaN");
            AppMethodBeat.o(181064);
            throw illegalArgumentException2;
        } else if (Double.isInfinite(d3) || Double.isInfinite(d5)) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("longitude must not be infinite");
            AppMethodBeat.o(181064);
            throw illegalArgumentException3;
        } else if (d2 > 90.0d || d2 < -90.0d || d4 > 90.0d || d4 < -90.0d) {
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("latitude must be between -90 and 90");
            AppMethodBeat.o(181064);
            throw illegalArgumentException4;
        } else if (d2 < d4) {
            IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("latNorth cannot be less than latSouth");
            AppMethodBeat.o(181064);
            throw illegalArgumentException5;
        } else if (d3 < d5) {
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("lonEast cannot be less than lonWest");
            AppMethodBeat.o(181064);
            throw illegalArgumentException6;
        } else {
            AppMethodBeat.o(181064);
        }
    }

    private static double lat_(int i2, int i3) {
        AppMethodBeat.i(181065);
        double pow = 3.141592653589793d - ((6.283185307179586d * ((double) i3)) / Math.pow(2.0d, (double) i2));
        double degrees = Math.toDegrees(Math.atan((Math.exp(pow) - Math.exp(-pow)) * 0.5d));
        AppMethodBeat.o(181065);
        return degrees;
    }

    private static double lon_(int i2, int i3) {
        AppMethodBeat.i(181066);
        double pow = ((((double) i3) / Math.pow(2.0d, (double) i2)) * 360.0d) - 180.0d;
        AppMethodBeat.o(181066);
        return pow;
    }

    public static LatLngBounds from(int i2, int i3, int i4) {
        AppMethodBeat.i(173183);
        LatLngBounds latLngBounds = new LatLngBounds(lat_(i2, i4), lon_(i2, i3 + 1), lat_(i2, i4 + 1), lon_(i2, i3));
        AppMethodBeat.o(173183);
        return latLngBounds;
    }

    public LatLngBounds include(LatLng latLng) {
        AppMethodBeat.i(173184);
        LatLngBounds build = new Builder().include(getNorthEast()).include(getSouthWest()).include(latLng).build();
        AppMethodBeat.o(173184);
        return build;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(173185);
        if (this == obj) {
            AppMethodBeat.o(173185);
            return true;
        } else if (obj instanceof LatLngBounds) {
            LatLngBounds latLngBounds = (LatLngBounds) obj;
            if (this.latitudeNorth == latLngBounds.getLatNorth() && this.latitudeSouth == latLngBounds.getLatSouth() && this.longitudeEast == latLngBounds.getLonEast() && this.longitudeWest == latLngBounds.getLonWest()) {
                AppMethodBeat.o(173185);
                return true;
            }
            AppMethodBeat.o(173185);
            return false;
        } else {
            AppMethodBeat.o(173185);
            return false;
        }
    }

    private boolean containsLatitude(double d2) {
        return d2 <= this.latitudeNorth && d2 >= this.latitudeSouth;
    }

    private boolean containsLongitude(double d2) {
        return d2 <= this.longitudeEast && d2 >= this.longitudeWest;
    }

    public boolean contains(LatLng latLng) {
        AppMethodBeat.i(173186);
        if (!containsLatitude(latLng.getLatitude()) || !containsLongitude(latLng.getLongitude())) {
            AppMethodBeat.o(173186);
            return false;
        }
        AppMethodBeat.o(173186);
        return true;
    }

    public boolean contains(LatLngBounds latLngBounds) {
        AppMethodBeat.i(173187);
        if (!contains(latLngBounds.getNorthEast()) || !contains(latLngBounds.getSouthWest())) {
            AppMethodBeat.o(173187);
            return false;
        }
        AppMethodBeat.o(173187);
        return true;
    }

    public LatLngBounds union(LatLngBounds latLngBounds) {
        AppMethodBeat.i(173188);
        LatLngBounds unionNoParamCheck = unionNoParamCheck(latLngBounds.getLatNorth(), latLngBounds.getLonEast(), latLngBounds.getLatSouth(), latLngBounds.getLonWest());
        AppMethodBeat.o(173188);
        return unionNoParamCheck;
    }

    public LatLngBounds union(double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(173189);
        checkParams(d2, d3, d4, d5);
        LatLngBounds unionNoParamCheck = unionNoParamCheck(d2, d3, d4, d5);
        AppMethodBeat.o(173189);
        return unionNoParamCheck;
    }

    private LatLngBounds unionNoParamCheck(double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(181067);
        LatLngBounds latLngBounds = new LatLngBounds(this.latitudeNorth < d2 ? d2 : this.latitudeNorth, this.longitudeEast < d3 ? d3 : this.longitudeEast, this.latitudeSouth > d4 ? d4 : this.latitudeSouth, this.longitudeWest > d5 ? d5 : this.longitudeWest);
        AppMethodBeat.o(181067);
        return latLngBounds;
    }

    public LatLngBounds intersect(LatLngBounds latLngBounds) {
        AppMethodBeat.i(173191);
        LatLngBounds intersectNoParamCheck = intersectNoParamCheck(latLngBounds.getLatNorth(), latLngBounds.getLonEast(), latLngBounds.getLatSouth(), latLngBounds.getLonWest());
        AppMethodBeat.o(173191);
        return intersectNoParamCheck;
    }

    public LatLngBounds intersect(double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(173192);
        checkParams(d2, d3, d4, d5);
        LatLngBounds intersectNoParamCheck = intersectNoParamCheck(d2, d3, d4, d5);
        AppMethodBeat.o(173192);
        return intersectNoParamCheck;
    }

    private LatLngBounds intersectNoParamCheck(double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(181068);
        double max = Math.max(this.longitudeWest, d5);
        double min = Math.min(this.longitudeEast, d3);
        if (min >= max) {
            double max2 = Math.max(this.latitudeSouth, d4);
            double min2 = Math.min(this.latitudeNorth, d2);
            if (min2 >= max2) {
                LatLngBounds latLngBounds = new LatLngBounds(min2, min, max2, max);
                AppMethodBeat.o(181068);
                return latLngBounds;
            }
        }
        AppMethodBeat.o(181068);
        return null;
    }

    static {
        AppMethodBeat.i(173196);
        AppMethodBeat.o(173196);
    }

    public int hashCode() {
        return (int) (this.latitudeNorth + 90.0d + ((this.latitudeSouth + 90.0d) * 1000.0d) + ((this.longitudeEast + 180.0d) * 1000000.0d) + ((this.longitudeWest + 180.0d) * 1.0E9d));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(173194);
        parcel.writeDouble(this.latitudeNorth);
        parcel.writeDouble(this.longitudeEast);
        parcel.writeDouble(this.latitudeSouth);
        parcel.writeDouble(this.longitudeWest);
        AppMethodBeat.o(173194);
    }

    protected static LatLngBounds readFromParcel(Parcel parcel) {
        AppMethodBeat.i(173195);
        LatLngBounds latLngBounds = new LatLngBounds(parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble());
        AppMethodBeat.o(173195);
        return latLngBounds;
    }

    public static final class Builder {
        private final List<LatLng> latLngList = new ArrayList();

        public Builder() {
            AppMethodBeat.i(173159);
            AppMethodBeat.o(173159);
        }

        public final LatLngBounds build() {
            AppMethodBeat.i(173160);
            if (this.latLngList.size() < 2) {
                InvalidLatLngBoundsException invalidLatLngBoundsException = new InvalidLatLngBoundsException(this.latLngList.size());
                AppMethodBeat.o(173160);
                throw invalidLatLngBoundsException;
            }
            LatLngBounds fromLatLngs = LatLngBounds.fromLatLngs(this.latLngList);
            AppMethodBeat.o(173160);
            return fromLatLngs;
        }

        public final Builder include(List<LatLng> list) {
            AppMethodBeat.i(173161);
            this.latLngList.addAll(list);
            AppMethodBeat.o(173161);
            return this;
        }

        public final Builder include(LatLng latLng) {
            AppMethodBeat.i(173162);
            this.latLngList.add(latLng);
            AppMethodBeat.o(173162);
            return this;
        }
    }
}
