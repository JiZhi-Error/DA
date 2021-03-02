package com.google.android.exoplayer2;

import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class b {
    public static final int CHANNEL_OUT_7POINT1_SURROUND;
    public static final UUID bbJ = new UUID(0, 0);
    public static final UUID bbK = new UUID(1186680826959645954L, -5988876978535335093L);
    public static final UUID bbL = new UUID(-1301668207276963122L, -6645017420763422227L);
    public static final UUID bbM = new UUID(-7348484286925749626L, -6083546864340672619L);

    static {
        int i2;
        AppMethodBeat.i(91846);
        if (x.SDK_INT < 23) {
            i2 = 1020;
        } else {
            i2 = 6396;
        }
        CHANNEL_OUT_7POINT1_SURROUND = i2;
        AppMethodBeat.o(91846);
    }

    public static long v(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 / 1000;
    }

    public static long w(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 * 1000;
    }
}
