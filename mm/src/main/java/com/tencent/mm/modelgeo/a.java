package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static boolean m(double d2) {
        AppMethodBeat.i(150461);
        double abs = Math.abs(d2);
        if (abs < 0.0d || abs > 180.0d) {
            AppMethodBeat.o(150461);
            return false;
        }
        AppMethodBeat.o(150461);
        return true;
    }

    public static boolean n(double d2) {
        AppMethodBeat.i(150462);
        double abs = Math.abs(d2);
        if (abs < 0.0d || abs > 90.0d) {
            AppMethodBeat.o(150462);
            return false;
        }
        AppMethodBeat.o(150462);
        return true;
    }

    /* renamed from: com.tencent.mm.modelgeo.a$a  reason: collision with other inner class name */
    public static class C0451a {

        /* renamed from: a  reason: collision with root package name */
        private static double f1456a = 6378245.0d;
        private static double iVa = 3.141592653589793d;
        private static double iVb = 0.006693421622965943d;

        public static double[] c(double d2, double d3) {
            boolean z;
            AppMethodBeat.i(150460);
            if (d2 < 72.004d || d2 > 137.8347d) {
                z = true;
            } else if (d3 < 0.8293d || d3 > 55.8271d) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                double[] dArr = {d2, d3};
                AppMethodBeat.o(150460);
                return dArr;
            }
            double d4 = d2 - 105.0d;
            double d5 = d3 - 35.0d;
            double sin = ((((Math.sin((d4 * 2.0d) * iVa) * 20.0d) + (20.0d * Math.sin((6.0d * d4) * iVa))) * 2.0d) / 3.0d) + -100.0d + (2.0d * d4) + (3.0d * d5) + (0.2d * d5 * d5) + (0.1d * d4 * d5) + (0.2d * Math.sqrt(Math.abs(d4))) + ((((20.0d * Math.sin(iVa * d5)) + (40.0d * Math.sin((d5 / 3.0d) * iVa))) * 2.0d) / 3.0d) + ((((Math.sin((d5 * iVa) / 30.0d) * 320.0d) + (160.0d * Math.sin((d5 / 12.0d) * iVa))) * 2.0d) / 3.0d);
            double d6 = d2 - 105.0d;
            double d7 = d3 - 35.0d;
            double sin2 = ((((Math.sin((d6 / 30.0d) * iVa) * 300.0d) + (150.0d * Math.sin((d6 / 12.0d) * iVa))) * 2.0d) / 3.0d) + (d7 * 0.1d * d6) + 300.0d + d6 + (2.0d * d7) + (0.1d * d6 * d6) + (0.1d * Math.sqrt(Math.abs(d6))) + ((((20.0d * Math.sin((6.0d * d6) * iVa)) + (20.0d * Math.sin((2.0d * d6) * iVa))) * 2.0d) / 3.0d) + ((((20.0d * Math.sin(iVa * d6)) + (40.0d * Math.sin((d6 / 3.0d) * iVa))) * 2.0d) / 3.0d);
            double d8 = (d3 / 180.0d) * iVa;
            double sin3 = Math.sin(d8);
            double d9 = 1.0d - (sin3 * (iVb * sin3));
            double sqrt = Math.sqrt(d9);
            double d10 = (sin * 180.0d) / (((f1456a * (1.0d - iVb)) / (d9 * sqrt)) * iVa);
            double d11 = 2.0d * d2;
            double[] dArr2 = {d11 - (((sin2 * 180.0d) / ((Math.cos(d8) * (f1456a / sqrt)) * iVa)) + d2), (2.0d * d3) - (d3 + d10)};
            AppMethodBeat.o(150460);
            return dArr2;
        }
    }
}
