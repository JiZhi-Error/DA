package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhe implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;

    zzhe(zzgn zzgn, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.i(1649);
        zzgn.zza(this.zzanf).zzkx();
        zzgn.zza(this.zzanf).zzf(this.zzane);
        AppMethodBeat.o(1649);
    }
}
