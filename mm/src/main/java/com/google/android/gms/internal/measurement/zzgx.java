package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgx implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;

    zzgx(zzgn zzgn, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.i(1642);
        zzgn.zza(this.zzanf).zzkx();
        zzgn.zza(this.zzanf).zzd(this.zzane);
        AppMethodBeat.o(1642);
    }
}
