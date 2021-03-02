package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    private static double mbq = -85.0d;
    private static double mbr = -1000.0d;
    private static double mbs = -85.0d;
    private static double mbt = -1000.0d;

    public static double h(double d2, double d3) {
        double d4;
        AppMethodBeat.i(55688);
        mbs = d2;
        mbt = d3;
        if (mbq == -85.0d || mbr == -1000.0d) {
            d4 = 0.0d;
        } else {
            d4 = (Math.atan2(mbt - mbr, mbs - mbq) * 180.0d) / 3.141592d;
        }
        mbq = mbs;
        mbr = mbt;
        AppMethodBeat.o(55688);
        return d4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        if (r19 > 0.0d) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(double r10, double r12, double r14, double r16, int r18, double r19) {
        /*
            r2 = 55689(0xd989, float:7.8037E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            r2 = 0
            if (r18 != 0) goto L_0x001f
            r4 = 0
            int r3 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0017
            r2 = 0
        L_0x0010:
            r3 = 55689(0xd989, float:7.8037E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return r2
        L_0x0017:
            r4 = 0
            int r3 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0010
        L_0x001d:
            r2 = 1
            goto L_0x0010
        L_0x001f:
            r3 = 1
            r0 = r18
            if (r0 != r3) goto L_0x0010
            r2 = -4587690276662804480(0xc055400000000000, double:-85.0)
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0036
            r2 = -4571364728013586432(0xc08f400000000000, double:-1000.0)
            int r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x003b
        L_0x0036:
            r2 = 0
        L_0x0037:
            if (r2 != 0) goto L_0x001d
            r2 = 0
            goto L_0x0010
        L_0x003b:
            r2 = -4571364728013586432(0xc08f400000000000, double:-1000.0)
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x004d
            r2 = -4587690276662804480(0xc055400000000000, double:-85.0)
            int r2 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x004f
        L_0x004d:
            r2 = 0
            goto L_0x0037
        L_0x004f:
            r2 = r12
            r4 = r10
            r6 = r16
            r8 = r14
            double r2 = com.tencent.mm.pluginsdk.s.c(r2, r4, r6, r8)
            r4 = 4617315517961601024(0x4014000000000000, double:5.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0060
            r2 = 1
            goto L_0x0037
        L_0x0060:
            r2 = 0
            goto L_0x0037
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.location.model.f.a(double, double, double, double, int, double):boolean");
    }

    public static double E(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(55690);
        double sqrt = Math.sqrt((double) (((i2 - i4) * (i2 - i4)) + ((i3 - i5) * (i3 - i5))));
        AppMethodBeat.o(55690);
        return sqrt;
    }

    public static boolean v(double d2) {
        return d2 >= 4.0d;
    }
}
