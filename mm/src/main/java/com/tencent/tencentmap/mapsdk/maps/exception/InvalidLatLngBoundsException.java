package com.tencent.tencentmap.mapsdk.maps.exception;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class InvalidLatLngBoundsException extends RuntimeException {
    public InvalidLatLngBoundsException(int i2) {
        super("Cannot create a LatLngBounds from " + i2 + " items");
        AppMethodBeat.i(181048);
        AppMethodBeat.o(181048);
    }
}
