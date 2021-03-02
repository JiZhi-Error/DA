package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzjo extends zzem {
    private final /* synthetic */ zzjr zzapt;
    private final /* synthetic */ zzjn zzapz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjo(zzjn zzjn, zzhi zzhi, zzjr zzjr) {
        super(zzhi);
        this.zzapz = zzjn;
        this.zzapt = zzjr;
    }

    @Override // com.google.android.gms.internal.measurement.zzem
    public final void run() {
        AppMethodBeat.i(1950);
        this.zzapz.cancel();
        this.zzapz.zzge().zzit().log("Starting upload from DelayedRunnable");
        this.zzapt.zzks();
        AppMethodBeat.o(1950);
    }
}
