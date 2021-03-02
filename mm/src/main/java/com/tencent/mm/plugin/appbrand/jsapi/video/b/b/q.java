package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q implements c {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.c
    public final long elapsedRealtime() {
        AppMethodBeat.i(234772);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AppMethodBeat.o(234772);
        return elapsedRealtime;
    }
}
