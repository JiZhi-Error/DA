package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzhz implements Runnable {
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ boolean zzaoc;

    zzhz(zzhk zzhk, boolean z) {
        this.zzanw = zzhk;
        this.zzaoc = z;
    }

    public final void run() {
        AppMethodBeat.i(1754);
        zzhk.zza(this.zzanw, this.zzaoc);
        AppMethodBeat.o(1754);
    }
}
