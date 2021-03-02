package com.b.a.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class p {
    final long cke;
    final long ckf;
    final int what;

    private p(int i2, long j2, long j3) {
        this.what = i2;
        this.cke = j2;
        this.ckf = j3;
    }

    p(int i2) {
        this(i2, System.currentTimeMillis(), SystemClock.elapsedRealtime());
        AppMethodBeat.i(88024);
        AppMethodBeat.o(88024);
    }
}
