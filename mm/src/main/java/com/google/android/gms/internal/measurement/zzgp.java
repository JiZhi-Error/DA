package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgp implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ zzed zzang;

    zzgp(zzgn zzgn, zzed zzed, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzang = zzed;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.i(1634);
        zzgn.zza(this.zzanf).zzkx();
        zzgn.zza(this.zzanf).zzc(this.zzang, this.zzane);
        AppMethodBeat.o(1634);
    }
}
