package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class f {
    private static final AtomicInteger lbk = new AtomicInteger();
    private static final AtomicLong lbl = new AtomicLong();
    private static boolean lbm;

    static {
        AppMethodBeat.i(146109);
        AppMethodBeat.o(146109);
    }

    public static void reset() {
        AppMethodBeat.i(146107);
        lbk.set(0);
        lbl.set(0);
        AppMethodBeat.o(146107);
    }

    public static void gU(boolean z) {
        lbm = z;
    }

    public static boolean bzz() {
        return lbm;
    }

    public static String bzA() {
        float f2;
        float f3 = 0.0f;
        AppMethodBeat.i(146108);
        int i2 = lbk.get();
        long j2 = lbl.get();
        StringBuilder sb = new StringBuilder();
        StringBuilder append = sb.append("fps : ");
        int i3 = lbk.get();
        long j3 = lbl.get();
        if (!lbm || j3 <= 0) {
            f2 = 0.0f;
        } else {
            f2 = (((float) i3) * 1000.0f) / ((float) j3);
        }
        append.append(f2);
        sb.append("\ncount : ").append(i2);
        StringBuilder append2 = sb.append("\naverage cost : ");
        if (i2 > 0) {
            f3 = (1.0f * ((float) j2)) / ((float) i2);
        }
        append2.append(f3);
        String sb2 = sb.toString();
        AppMethodBeat.o(146108);
        return sb2;
    }
}
