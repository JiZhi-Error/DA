package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzjf implements Runnable {
    private final /* synthetic */ Runnable zzabt;
    private final /* synthetic */ zzjr zzapt;

    zzjf(zzjc zzjc, zzjr zzjr, Runnable runnable) {
        this.zzapt = zzjr;
        this.zzabt = runnable;
    }

    public final void run() {
        AppMethodBeat.i(1885);
        this.zzapt.zzkx();
        this.zzapt.zzg(this.zzabt);
        this.zzapt.zzks();
        AppMethodBeat.o(1885);
    }
}
