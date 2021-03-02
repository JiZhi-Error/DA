package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Thread;

/* access modifiers changed from: package-private */
public final class zzgi implements Thread.UncaughtExceptionHandler {
    private final String zzaly;
    private final /* synthetic */ zzgg zzalz;

    public zzgi(zzgg zzgg, String str) {
        this.zzalz = zzgg;
        AppMethodBeat.i(1576);
        Preconditions.checkNotNull(str);
        this.zzaly = str;
        AppMethodBeat.o(1576);
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        AppMethodBeat.i(1577);
        this.zzalz.zzge().zzim().zzg(this.zzaly, th);
        AppMethodBeat.o(1577);
    }
}
