package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public /* synthetic */ class Clock$$CC {
    public static long currentThreadTimeMillis(Clock clock) {
        AppMethodBeat.i(5068);
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        AppMethodBeat.o(5068);
        return currentThreadTimeMillis;
    }
}
