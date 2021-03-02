package com.tencent.mm.plugin.appbrand.widget.e;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public static double oyL = 6378137.0d;
    final double oyM = (6.283185307179586d * oyL);

    public f() {
        AppMethodBeat.i(146599);
        AppMethodBeat.o(146599);
    }

    public final e b(LatLng latLng) {
        AppMethodBeat.i(146600);
        double sin = Math.sin(Math.toRadians(latLng.getLatitude()));
        e eVar = new e(((latLng.getLongitude() / 360.0d) + 0.5d) * this.oyM, (((Math.log((1.0d + sin) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * this.oyM);
        AppMethodBeat.o(146600);
        return eVar;
    }
}
