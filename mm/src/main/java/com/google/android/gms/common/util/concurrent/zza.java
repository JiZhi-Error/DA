package com.google.android.gms.common.util.concurrent;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza implements Runnable {
    private final int priority;
    private final Runnable zzaax;

    public zza(Runnable runnable, int i2) {
        this.zzaax = runnable;
        this.priority = i2;
    }

    public final void run() {
        AppMethodBeat.i(5326);
        Process.setThreadPriority(this.priority);
        this.zzaax.run();
        AppMethodBeat.o(5326);
    }
}
