package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzia implements Runnable {
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ long zzaod;

    zzia(zzhk zzhk, long j2) {
        this.zzanw = zzhk;
        this.zzaod = j2;
    }

    public final void run() {
        AppMethodBeat.i(1755);
        this.zzanw.zzgf().zzaki.set(this.zzaod);
        this.zzanw.zzge().zzis().zzg("Minimum session duration set", Long.valueOf(this.zzaod));
        AppMethodBeat.o(1755);
    }
}
