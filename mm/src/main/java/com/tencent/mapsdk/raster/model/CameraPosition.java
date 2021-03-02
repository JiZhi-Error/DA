package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CameraPosition implements Parcelable {
    public static final Parcelable.Creator<CameraPosition> CREATOR = new Parcelable.Creator<CameraPosition>() {
        /* class com.tencent.mapsdk.raster.model.CameraPosition.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final CameraPosition createFromParcel(Parcel parcel) {
            AppMethodBeat.i(87546);
            float readFloat = parcel.readFloat();
            float readFloat2 = parcel.readFloat();
            CameraPosition cameraPosition = new CameraPosition(new LatLng((double) readFloat, (double) readFloat2), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
            AppMethodBeat.o(87546);
            return cameraPosition;
        }

        @Override // android.os.Parcelable.Creator
        public final CameraPosition[] newArray(int i2) {
            return new CameraPosition[i2];
        }
    };
    private static final int EMPTY_ZOOMLEVEL = -1;
    private float bearing;
    private float skew;
    private final LatLng target;
    private float zoom;

    static {
        AppMethodBeat.i(87571);
        AppMethodBeat.o(87571);
    }

    public CameraPosition(LatLng latLng, float f2) {
        this(latLng, f2, 0.0f, 0.0f);
    }

    public CameraPosition(LatLng latLng, float f2, float f3, float f4) {
        this.zoom = -1.0f;
        this.skew = 0.0f;
        this.bearing = 0.0f;
        this.target = latLng;
        this.zoom = f2;
        this.skew = f3;
        this.bearing = f4;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(87564);
        parcel.writeFloat((float) this.target.getLatitude());
        parcel.writeFloat((float) this.target.getLongitude());
        parcel.writeFloat(this.zoom);
        parcel.writeFloat(this.skew);
        parcel.writeFloat(this.bearing);
        AppMethodBeat.o(87564);
    }

    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        AppMethodBeat.i(87565);
        int hashCode = super.hashCode();
        AppMethodBeat.o(87565);
        return hashCode;
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f2) {
        AppMethodBeat.i(87566);
        CameraPosition cameraPosition = new CameraPosition(latLng, f2);
        AppMethodBeat.o(87566);
        return cameraPosition;
    }

    public static Builder builder() {
        AppMethodBeat.i(87567);
        Builder builder = new Builder();
        AppMethodBeat.o(87567);
        return builder;
    }

    public static Builder builder(CameraPosition cameraPosition) {
        AppMethodBeat.i(87568);
        Builder builder = new Builder(cameraPosition);
        AppMethodBeat.o(87568);
        return builder;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(87569);
        if (this == obj) {
            AppMethodBeat.o(87569);
            return true;
        } else if (!(obj instanceof CameraPosition)) {
            AppMethodBeat.o(87569);
            return false;
        } else {
            CameraPosition cameraPosition = (CameraPosition) obj;
            if (!getTarget().equals(cameraPosition.getTarget()) || Float.floatToIntBits(getZoom()) != Float.floatToIntBits(cameraPosition.getZoom())) {
                AppMethodBeat.o(87569);
                return false;
            }
            AppMethodBeat.o(87569);
            return true;
        }
    }

    public final String toString() {
        AppMethodBeat.i(87570);
        String str = "target" + this.target + "zoom" + this.zoom;
        AppMethodBeat.o(87570);
        return str;
    }

    public final LatLng getTarget() {
        return this.target;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final float getSkew() {
        return this.skew;
    }

    public final float getBearing() {
        return this.bearing;
    }

    public static final class Builder {
        private float bearing = 0.0f;
        private float skew = 0.0f;
        private LatLng target;
        private float zoom = -1.0f;

        public Builder() {
        }

        public Builder(CameraPosition cameraPosition) {
            AppMethodBeat.i(87549);
            target(cameraPosition.getTarget()).zoom(cameraPosition.getZoom());
            AppMethodBeat.o(87549);
        }

        public final Builder target(LatLng latLng) {
            this.target = latLng;
            return this;
        }

        public final Builder zoom(float f2) {
            this.zoom = f2;
            return this;
        }

        public final Builder skew(float f2) {
            this.skew = f2;
            return this;
        }

        public final Builder bearing(float f2) {
            this.bearing = f2;
            return this;
        }

        public final CameraPosition build() {
            AppMethodBeat.i(87550);
            CameraPosition cameraPosition = new CameraPosition(this.target, this.zoom, this.skew, this.bearing);
            AppMethodBeat.o(87550);
            return cameraPosition;
        }
    }
}
