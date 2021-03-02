package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Callable;

final class zzgt implements Callable<List<zzjz>> {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzani;

    zzgt(zzgn zzgn, zzdz zzdz, String str, String str2) {
        this.zzanf = zzgn;
        this.zzane = zzdz;
        this.zzanh = str;
        this.zzani = str2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzjz> call() {
        AppMethodBeat.i(1638);
        zzgn.zza(this.zzanf).zzkx();
        List<zzjz> zzb = zzgn.zza(this.zzanf).zzix().zzb(this.zzane.packageName, this.zzanh, this.zzani);
        AppMethodBeat.o(1638);
        return zzb;
    }
}
