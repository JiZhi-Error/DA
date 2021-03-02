package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgo implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;

    zzgo(zzgn zzgn, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.i(1633);
        zzgn.zza(this.zzanf).zzkx();
        zzgn.zza(this.zzanf).zze(this.zzane);
        AppMethodBeat.o(1633);
    }
}
