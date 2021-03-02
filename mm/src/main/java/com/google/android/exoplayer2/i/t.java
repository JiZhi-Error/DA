package com.google.android.exoplayer2.i;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t implements c {
    t() {
    }

    @Override // com.google.android.exoplayer2.i.c
    public final long elapsedRealtime() {
        AppMethodBeat.i(93204);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AppMethodBeat.o(93204);
        return elapsedRealtime;
    }
}
