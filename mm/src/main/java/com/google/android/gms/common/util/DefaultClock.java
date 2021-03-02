package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DefaultClock implements Clock {
    private static final DefaultClock zzzk = new DefaultClock();

    static {
        AppMethodBeat.i(5189);
        AppMethodBeat.o(5189);
    }

    private DefaultClock() {
    }

    public static Clock getInstance() {
        return zzzk;
    }

    @Override // com.google.android.gms.common.util.Clock
    public long currentThreadTimeMillis() {
        AppMethodBeat.i(5188);
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        AppMethodBeat.o(5188);
        return currentThreadTimeMillis;
    }

    @Override // com.google.android.gms.common.util.Clock
    public long currentTimeMillis() {
        AppMethodBeat.i(5185);
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.o(5185);
        return currentTimeMillis;
    }

    @Override // com.google.android.gms.common.util.Clock
    public long elapsedRealtime() {
        AppMethodBeat.i(5186);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AppMethodBeat.o(5186);
        return elapsedRealtime;
    }

    @Override // com.google.android.gms.common.util.Clock
    public long nanoTime() {
        AppMethodBeat.i(5187);
        long nanoTime = System.nanoTime();
        AppMethodBeat.o(5187);
        return nanoTime;
    }
}
