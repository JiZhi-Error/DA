package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Callable;

final class zzhd implements Callable<List<zzjz>> {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;

    zzhd(zzgn zzgn, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzane = zzdz;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzjz> call() {
        AppMethodBeat.i(1648);
        zzgn.zza(this.zzanf).zzkx();
        List<zzjz> zzbb = zzgn.zza(this.zzanf).zzix().zzbb(this.zzane.packageName);
        AppMethodBeat.o(1648);
        return zzbb;
    }
}
