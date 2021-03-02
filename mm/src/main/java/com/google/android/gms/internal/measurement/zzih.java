package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzih implements Runnable {
    private final /* synthetic */ zzif zzaov;
    private final /* synthetic */ zzie zzaow;

    zzih(zzif zzif, zzie zzie) {
        this.zzaov = zzif;
        this.zzaow = zzie;
    }

    public final void run() {
        AppMethodBeat.i(1798);
        zzif.zza(this.zzaov, this.zzaow);
        this.zzaov.zzaol = null;
        this.zzaov.zzfx().zzb((zzie) null);
        AppMethodBeat.o(1798);
    }
}
