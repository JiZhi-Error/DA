package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Callable;

final class zzgw implements Callable<List<zzed>> {
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzani;
    private final /* synthetic */ String zzanj;

    zzgw(zzgn zzgn, String str, String str2, String str3) {
        this.zzanf = zzgn;
        this.zzanj = str;
        this.zzanh = str2;
        this.zzani = str3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzed> call() {
        AppMethodBeat.i(1641);
        zzgn.zza(this.zzanf).zzkx();
        List<zzed> zzc = zzgn.zza(this.zzanf).zzix().zzc(this.zzanj, this.zzanh, this.zzani);
        AppMethodBeat.o(1641);
        return zzc;
    }
}
