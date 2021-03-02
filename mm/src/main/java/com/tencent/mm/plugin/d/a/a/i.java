package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;

public final class i {
    public static BigDecimal i(double d2, double d3) {
        AppMethodBeat.i(22469);
        BigDecimal multiply = new BigDecimal(d2).multiply(new BigDecimal(d3));
        AppMethodBeat.o(22469);
        return multiply;
    }

    public static double x(int[] iArr) {
        AppMethodBeat.i(22470);
        if (iArr == null || iArr.length == 0) {
            NullPointerException nullPointerException = new NullPointerException("null == dataGroup || 0 == dataGroup.length");
            AppMethodBeat.o(22470);
            throw nullPointerException;
        }
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            i2++;
            i3 = iArr[i2] + i3;
        }
        double doubleValue = new BigDecimal((double) i3).divide(new BigDecimal((double) iArr.length), 5, 4).doubleValue();
        AppMethodBeat.o(22470);
        return doubleValue;
    }

    public static double y(int[] iArr) {
        AppMethodBeat.i(22471);
        if (iArr == null || iArr.length == 0) {
            NullPointerException nullPointerException = new NullPointerException("null == dataGroup || 0 == dataGroup.length");
            AppMethodBeat.o(22471);
            throw nullPointerException;
        }
        double x = x(iArr);
        BigDecimal bigDecimal = new BigDecimal(0.0d);
        for (int i2 : iArr) {
            bigDecimal = bigDecimal.add(new BigDecimal((double) i2).subtract(new BigDecimal(x)).pow(2));
        }
        double pow = Math.pow(bigDecimal.divide(new BigDecimal(iArr.length - 1), 5, 4).doubleValue(), 0.5d);
        AppMethodBeat.o(22471);
        return pow;
    }
}
