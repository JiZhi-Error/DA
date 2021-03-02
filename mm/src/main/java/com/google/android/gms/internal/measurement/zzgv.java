package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Callable;

final class zzgv implements Callable<List<zzed>> {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzani;

    zzgv(zzgn zzgn, zzdz zzdz, String str, String str2) {
        this.zzanf = zzgn;
        this.zzane = zzdz;
        this.zzanh = str;
        this.zzani = str2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzed> call() {
        AppMethodBeat.i(1640);
        zzgn.zza(this.zzanf).zzkx();
        List<zzed> zzc = zzgn.zza(this.zzanf).zzix().zzc(this.zzane.packageName, this.zzanh, this.zzani);
        AppMethodBeat.o(1640);
        return zzc;
    }
}
