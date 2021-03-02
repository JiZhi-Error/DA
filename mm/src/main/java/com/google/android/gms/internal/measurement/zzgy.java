package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgy implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ zzeu zzank;

    zzgy(zzgn zzgn, zzeu zzeu, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzank = zzeu;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.i(1643);
        zzgn.zza(this.zzanf).zzkx();
        zzgn.zza(this.zzanf).zzb(this.zzank, this.zzane);
        AppMethodBeat.o(1643);
    }
}
