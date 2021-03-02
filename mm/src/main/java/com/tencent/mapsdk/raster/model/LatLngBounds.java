package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class LatLngBounds {
    private int mVersionCode;
    private LatLng northeast;
    private LatLng southwest;

    static /* synthetic */ double access$400(double d2, double d3) {
        AppMethodBeat.i(87595);
        double longitudeDistanceHeadingWest = longitudeDistanceHeadingWest(d2, d3);
        AppMethodBeat.o(87595);
        return longitudeDistanceHeadingWest;
    }

    static /* synthetic */ double access$500(double d2, double d3) {
        AppMethodBeat.i(87596);
        double longitudeDistanceHeadingEast = longitudeDistanceHeadingEast(d2, d3);
        AppMethodBeat.o(87596);
        return longitudeDistanceHeadingEast;
    }

    LatLngBounds(int i2, LatLng latLng, LatLng latLng2) {
        AppMethodBeat.i(87583);
        Builder include = new Builder().include(latLng).include(latLng2);
        this.southwest = new LatLng(include.mSouth, include.mWest);
        this.northeast = new LatLng(include.mNorth, include.mEast);
        this.mVersionCode = i2;
        AppMethodBeat.o(87583);
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public static Builder builder() {
        AppMethodBeat.i(87584);
        Builder builder = new Builder();
        AppMethodBeat.o(87584);
        return builder;
    }

    public LatLng getSouthwest() {
        return this.southwest;
    }

    public LatLng getNortheast() {
        return this.northeast;
    }

    public boolean contains(LatLng latLng) {
        AppMethodBeat.i(87585);
        if (!containsLatitude(latLng.getLatitude()) || !containsLongitude(latLng.getLongitude())) {
            AppMethodBeat.o(87585);
            return false;
        }
        AppMethodBeat.o(87585);
        return true;
    }

    public boolean contains(LatLngBounds latLngBounds) {
        boolean z = false;
        AppMethodBeat.i(87586);
        if (latLngBounds == null) {
            AppMethodBeat.o(87586);
        } else {
            if (contains(latLngBounds.southwest) && contains(latLngBounds.northeast)) {
                z = true;
            }
            AppMethodBeat.o(87586);
        }
        return z;
    }

    public boolean intersects(LatLngBounds latLngBounds) {
        AppMethodBeat.i(87587);
        if (latLngBounds == null) {
            AppMethodBeat.o(87587);
            return false;
        } else if (intersect(latLngBounds) || latLngBounds.intersect(this)) {
            AppMethodBeat.o(87587);
            return true;
        } else {
            AppMethodBeat.o(87587);
            return false;
        }
    }

    private boolean intersect(LatLngBounds latLngBounds) {
        AppMethodBeat.i(87588);
        if (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null || this.northeast == null || this.southwest == null) {
            AppMethodBeat.o(87588);
            return false;
        }
        double longitude = ((latLngBounds.northeast.getLongitude() + latLngBounds.southwest.getLongitude()) - this.northeast.getLongitude()) - this.southwest.getLongitude();
        double longitude2 = ((this.northeast.getLongitude() - this.southwest.getLongitude()) + latLngBounds.northeast.getLongitude()) - latLngBounds.southwest.getLongitude();
        double latitude = ((latLngBounds.northeast.getLatitude() + latLngBounds.southwest.getLatitude()) - this.northeast.getLatitude()) - this.southwest.getLatitude();
        double latitude2 = ((this.northeast.getLatitude() - this.southwest.getLatitude()) + latLngBounds.northeast.getLatitude()) - latLngBounds.southwest.getLatitude();
        if (Math.abs(longitude) >= longitude2 || Math.abs(latitude) >= latitude2) {
            AppMethodBeat.o(87588);
            return false;
        }
        AppMethodBeat.o(87588);
        return true;
    }

    public LatLngBounds including(LatLng latLng) {
        AppMethodBeat.i(87589);
        double min = Math.min(this.southwest.getLatitude(), latLng.getLatitude());
        double max = Math.max(this.northeast.getLatitude(), latLng.getLatitude());
        double longitude = this.northeast.getLongitude();
        double longitude2 = this.southwest.getLongitude();
        double longitude3 = latLng.getLongitude();
        if (!containsLongitude(longitude3)) {
            if (longitudeDistanceHeadingWest(longitude2, longitude3) < longitudeDistanceHeadingEast(longitude, longitude3)) {
                longitude2 = longitude3;
            } else {
                longitude = longitude3;
            }
        }
        LatLngBounds latLngBounds = new LatLngBounds(new LatLng(min, longitude2), new LatLng(max, longitude));
        AppMethodBeat.o(87589);
        return latLngBounds;
    }

    private static double longitudeDistanceHeadingWest(double d2, double d3) {
        return ((d2 - d3) + 360.0d) % 360.0d;
    }

    private static double longitudeDistanceHeadingEast(double d2, double d3) {
        return ((d3 - d2) + 360.0d) % 360.0d;
    }

    private boolean containsLatitude(double d2) {
        AppMethodBeat.i(87590);
        if (this.southwest.getLatitude() > d2 || d2 > this.northeast.getLatitude()) {
            AppMethodBeat.o(87590);
            return false;
        }
        AppMethodBeat.o(87590);
        return true;
    }

    private boolean containsLongitude(double d2) {
        AppMethodBeat.i(87591);
        if (this.southwest.getLongitude() <= this.northeast.getLongitude()) {
            if (this.southwest.getLongitude() > d2 || d2 > this.northeast.getLongitude()) {
                AppMethodBeat.o(87591);
                return false;
            }
            AppMethodBeat.o(87591);
            return true;
        } else if (this.southwest.getLongitude() <= d2 || d2 <= this.northeast.getLongitude()) {
            AppMethodBeat.o(87591);
            return true;
        } else {
            AppMethodBeat.o(87591);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(87592);
        int hashCode = Arrays.hashCode(new Object[]{this.southwest, this.northeast});
        AppMethodBeat.o(87592);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(87593);
        if (this == obj) {
            AppMethodBeat.o(87593);
            return true;
        } else if (!(obj instanceof LatLngBounds)) {
            AppMethodBeat.o(87593);
            return false;
        } else {
            LatLngBounds latLngBounds = (LatLngBounds) obj;
            if (!this.southwest.equals(latLngBounds.southwest) || !this.northeast.equals(latLngBounds.northeast)) {
                AppMethodBeat.o(87593);
                return false;
            }
            AppMethodBeat.o(87593);
            return true;
        }
    }

    public String toString() {
        AppMethodBeat.i(87594);
        String str = "southwest" + this.southwest + "northeast" + this.northeast;
        AppMethodBeat.o(87594);
        return str;
    }

    public static final class Builder {
        private double mEast = Double.NaN;
        private double mNorth = Double.NEGATIVE_INFINITY;
        private double mSouth = Double.POSITIVE_INFINITY;
        private double mWest = Double.NaN;

        public final Builder include(LatLng latLng) {
            AppMethodBeat.i(87542);
            this.mSouth = Math.min(this.mSouth, latLng.getLatitude());
            this.mNorth = Math.max(this.mNorth, latLng.getLatitude());
            double longitude = latLng.getLongitude();
            if (Double.isNaN(this.mWest)) {
                this.mWest = longitude;
            } else {
                if (!containsLongitude(longitude)) {
                    if (LatLngBounds.access$400(this.mWest, longitude) < LatLngBounds.access$500(this.mEast, longitude)) {
                        this.mWest = longitude;
                    }
                }
                AppMethodBeat.o(87542);
                return this;
            }
            this.mEast = longitude;
            AppMethodBeat.o(87542);
            return this;
        }

        public final Builder include(Iterable<LatLng> iterable) {
            AppMethodBeat.i(87543);
            if (iterable != null) {
                for (LatLng latLng : iterable) {
                    include(latLng);
                }
            }
            AppMethodBeat.o(87543);
            return this;
        }

        private boolean containsLongitude(double d2) {
            return this.mWest <= this.mEast ? this.mWest <= d2 && d2 <= this.mEast : this.mWest <= d2 || d2 <= this.mEast;
        }

        public final LatLngBounds build() {
            AppMethodBeat.i(87544);
            LatLngBounds latLngBounds = new LatLngBounds(new LatLng(this.mSouth, this.mWest), new LatLng(this.mNorth, this.mEast));
            AppMethodBeat.o(87544);
            return latLngBounds;
        }
    }
}
