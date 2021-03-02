package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Callable;

final class zzgu implements Callable<List<zzjz>> {
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzani;
    private final /* synthetic */ String zzanj;

    zzgu(zzgn zzgn, String str, String str2, String str3) {
        this.zzanf = zzgn;
        this.zzanj = str;
        this.zzanh = str2;
        this.zzani = str3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzjz> call() {
        AppMethodBeat.i(1639);
        zzgn.zza(this.zzanf).zzkx();
        List<zzjz> zzb = zzgn.zza(this.zzanf).zzix().zzb(this.zzanj, this.zzanh, this.zzani);
        AppMethodBeat.o(1639);
        return zzb;
    }
}
