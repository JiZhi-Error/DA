package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzen implements Runnable {
    private final /* synthetic */ zzhi zzafk;
    private final /* synthetic */ zzem zzafl;

    zzen(zzem zzem, zzhi zzhi) {
        this.zzafl = zzem;
        this.zzafk = zzhi;
    }

    public final void run() {
        AppMethodBeat.i(1220);
        this.zzafk.zzgd();
        if (zzgg.isMainThread()) {
            this.zzafk.zzgd().zzc(this);
            AppMethodBeat.o(1220);
            return;
        }
        boolean zzef = this.zzafl.zzef();
        zzem.zza(this.zzafl, 0);
        if (zzef) {
            this.zzafl.run();
        }
        AppMethodBeat.o(1220);
    }
}
