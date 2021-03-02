package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgr implements Runnable {
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ zzed zzang;

    zzgr(zzgn zzgn, zzed zzed) {
        this.zzanf = zzgn;
        this.zzang = zzed;
    }

    public final void run() {
        AppMethodBeat.i(1636);
        zzgn.zza(this.zzanf).zzkx();
        zzjr zza = zzgn.zza(this.zzanf);
        zzed zzed = this.zzang;
        zzdz zzcb = zza.zzcb(zzed.packageName);
        if (zzcb != null) {
            zza.zzc(zzed, zzcb);
        }
        AppMethodBeat.o(1636);
    }
}
