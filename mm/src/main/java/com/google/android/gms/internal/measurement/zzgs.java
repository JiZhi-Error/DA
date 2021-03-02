package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgs implements Runnable {
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ zzed zzang;

    zzgs(zzgn zzgn, zzed zzed) {
        this.zzanf = zzgn;
        this.zzang = zzed;
    }

    public final void run() {
        AppMethodBeat.i(1637);
        zzgn.zza(this.zzanf).zzkx();
        zzjr zza = zzgn.zza(this.zzanf);
        zzed zzed = this.zzang;
        zzdz zzcb = zza.zzcb(zzed.packageName);
        if (zzcb != null) {
            zza.zzb(zzed, zzcb);
        }
        AppMethodBeat.o(1637);
    }
}
