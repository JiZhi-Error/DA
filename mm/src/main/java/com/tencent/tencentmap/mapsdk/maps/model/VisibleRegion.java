package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class VisibleRegion {
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds2) {
        this.nearLeft = latLng;
        this.nearRight = latLng2;
        this.farLeft = latLng3;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(173397);
        if (this == obj) {
            AppMethodBeat.o(173397);
            return true;
        } else if (!(obj instanceof VisibleRegion)) {
            AppMethodBeat.o(173397);
            return false;
        } else {
            VisibleRegion visibleRegion = (VisibleRegion) obj;
            if (!this.nearLeft.equals(visibleRegion.nearLeft) || !this.nearRight.equals(visibleRegion.nearRight) || !this.farLeft.equals(visibleRegion.farLeft) || !this.farRight.equals(visibleRegion.farRight) || !this.latLngBounds.equals(visibleRegion.latLngBounds)) {
                AppMethodBeat.o(173397);
                return false;
            }
            AppMethodBeat.o(173397);
            return true;
        }
    }

    public final String toString() {
        AppMethodBeat.i(173398);
        String str = "nearLeft" + this.nearLeft + "nearRight" + this.nearRight + "farLeft" + this.farLeft + "farRight" + this.farRight + "latLngBounds" + this.latLngBounds;
        AppMethodBeat.o(173398);
        return str;
    }
}
