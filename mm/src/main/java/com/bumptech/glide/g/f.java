package com.bumptech.glide.g;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    private static final double aNS;

    static {
        double d2 = 1.0d;
        AppMethodBeat.i(77748);
        if (Build.VERSION.SDK_INT >= 17) {
            d2 = 1.0d / Math.pow(10.0d, 6.0d);
        }
        aNS = d2;
        AppMethodBeat.o(77748);
    }

    @TargetApi(17)
    public static long qt() {
        AppMethodBeat.i(77746);
        if (Build.VERSION.SDK_INT >= 17) {
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            AppMethodBeat.o(77746);
            return elapsedRealtimeNanos;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        AppMethodBeat.o(77746);
        return uptimeMillis;
    }

    public static double p(long j2) {
        AppMethodBeat.i(77747);
        double qt = ((double) (qt() - j2)) * aNS;
        AppMethodBeat.o(77747);
        return qt;
    }
}
