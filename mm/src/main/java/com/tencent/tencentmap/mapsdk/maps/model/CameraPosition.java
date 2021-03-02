package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CameraPosition {
    public final float bearing;
    public LatLng target;
    public final float tilt;
    public final float zoom;

    public static final class Builder {
        private LatLng p;
        private float q;
        private float r = Float.MIN_VALUE;
        private float s = Float.MIN_VALUE;

        public final Builder target(LatLng latLng) {
            this.p = latLng;
            return this;
        }

        public final Builder zoom(float f2) {
            this.q = f2;
            return this;
        }

        public final Builder tilt(float f2) {
            this.r = f2;
            return this;
        }

        public final Builder bearing(float f2) {
            this.s = f2;
            return this;
        }

        public final CameraPosition build() {
            AppMethodBeat.i(173099);
            CameraPosition cameraPosition = new CameraPosition(this.p, this.q, this.r, this.s);
            AppMethodBeat.o(173099);
            return cameraPosition;
        }

        public Builder() {
        }

        public Builder(CameraPosition cameraPosition) {
            this.p = cameraPosition.target;
            this.q = cameraPosition.zoom;
            this.r = cameraPosition.tilt;
            this.s = cameraPosition.bearing;
        }
    }

    CameraPosition(int i2, LatLng latLng, float f2, float f3, float f4) {
        this.target = latLng;
        this.zoom = f2;
        this.tilt = f3;
        this.bearing = f4;
    }

    public CameraPosition(LatLng latLng, float f2, float f3, float f4) {
        this(1, latLng, f2, f3, f4);
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f2) {
        AppMethodBeat.i(173100);
        CameraPosition cameraPosition = new CameraPosition(latLng, f2, 0.0f, 0.0f);
        AppMethodBeat.o(173100);
        return cameraPosition;
    }

    public static Builder builder() {
        AppMethodBeat.i(173101);
        Builder builder = new Builder();
        AppMethodBeat.o(173101);
        return builder;
    }

    public static Builder builder(CameraPosition cameraPosition) {
        AppMethodBeat.i(173102);
        Builder builder = new Builder(cameraPosition);
        AppMethodBeat.o(173102);
        return builder;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(173103);
        if (this == obj) {
            AppMethodBeat.o(173103);
            return true;
        } else if (!(obj instanceof CameraPosition)) {
            AppMethodBeat.o(173103);
            return false;
        } else {
            CameraPosition cameraPosition = (CameraPosition) obj;
            if (this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing)) {
                AppMethodBeat.o(173103);
                return true;
            }
            AppMethodBeat.o(173103);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(173104);
        String str = "latlng:" + this.target.latitude + "," + this.target.longitude + ",zoom:" + this.zoom + ",tilt=" + this.tilt + ",bearing:" + this.bearing;
        AppMethodBeat.o(173104);
        return str;
    }
}
