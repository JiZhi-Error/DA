package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class VisibleRegion {
    private final LatLng farLeft;
    private final LatLng farRight;
    private final LatLngBounds latLngBounds;
    private final int mVersionCode;
    private final LatLng nearLeft;
    private final LatLng nearRight;

    protected VisibleRegion(int i2, LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds2) {
        this.mVersionCode = i2;
        this.nearLeft = latLng;
        this.nearRight = latLng2;
        this.farLeft = latLng3;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds2;
    }

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds2) {
        this(1, latLng, latLng2, latLng3, latLng4, latLngBounds2);
    }

    public final int hashCode() {
        AppMethodBeat.i(87580);
        int hashCode = Arrays.hashCode(new Object[]{getNearLeft(), getNearRight(), getFarLeft(), getFarRight(), getLatLngBounds()});
        AppMethodBeat.o(87580);
        return hashCode;
    }

    /* access modifiers changed from: protected */
    public final int getVersionCode() {
        return this.mVersionCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(87581);
        if (this == obj) {
            AppMethodBeat.o(87581);
            return true;
        } else if (!(obj instanceof VisibleRegion)) {
            AppMethodBeat.o(87581);
            return false;
        } else {
            VisibleRegion visibleRegion = (VisibleRegion) obj;
            if (!getNearLeft().equals(visibleRegion.getNearLeft()) || !getNearRight().equals(visibleRegion.getNearRight()) || !getFarLeft().equals(visibleRegion.getFarLeft()) || !getFarRight().equals(visibleRegion.getFarRight()) || !getLatLngBounds().equals(visibleRegion.getLatLngBounds())) {
                AppMethodBeat.o(87581);
                return false;
            }
            AppMethodBeat.o(87581);
            return true;
        }
    }

    public final String toString() {
        AppMethodBeat.i(87582);
        String str = "nearLeft" + this.nearLeft + "nearRight" + this.nearRight + "farLeft" + this.farLeft + "farRight" + this.farRight + "latLngBounds" + this.latLngBounds;
        AppMethodBeat.o(87582);
        return str;
    }

    public final LatLng getNearLeft() {
        return this.nearLeft;
    }

    public final LatLng getNearRight() {
        return this.nearRight;
    }

    public final LatLng getFarLeft() {
        return this.farLeft;
    }

    public final LatLng getFarRight() {
        return this.farRight;
    }

    public final LatLngBounds getLatLngBounds() {
        return this.latLngBounds;
    }
}
