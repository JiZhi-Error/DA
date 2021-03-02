package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzib implements Runnable {
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ long zzaod;

    zzib(zzhk zzhk, long j2) {
        this.zzanw = zzhk;
        this.zzaod = j2;
    }

    public final void run() {
        AppMethodBeat.i(1756);
        this.zzanw.zzgf().zzakj.set(this.zzaod);
        this.zzanw.zzge().zzis().zzg("Session timeout duration set", Long.valueOf(this.zzaod));
        AppMethodBeat.o(1756);
    }
}
