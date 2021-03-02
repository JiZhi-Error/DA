package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s {
    public static double c(double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(151617);
        double d6 = (3.141592653589793d * d2) / 180.0d;
        double d7 = (3.141592653589793d * d4) / 180.0d;
        double round = (double) (Math.round(((Math.asin(Math.sqrt(((Math.cos(d6) * Math.cos(d7)) * Math.pow(Math.sin((((d3 - d5) * 3.141592653589793d) / 180.0d) / 2.0d), 2.0d)) + Math.pow(Math.sin((d6 - d7) / 2.0d), 2.0d))) * 2.0d) * 6378137.0d) * 10000.0d) / 10000);
        AppMethodBeat.o(151617);
        return round;
    }
}
