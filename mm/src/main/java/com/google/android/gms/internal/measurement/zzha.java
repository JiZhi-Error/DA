package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

final class zzha implements Callable<byte[]> {
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ String zzanj;
    private final /* synthetic */ zzeu zzank;

    zzha(zzgn zzgn, zzeu zzeu, String str) {
        this.zzanf = zzgn;
        this.zzank = zzeu;
        this.zzanj = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() {
        AppMethodBeat.i(1645);
        zzgn.zza(this.zzanf).zzkx();
        byte[] zza = zzgn.zza(this.zzanf).zza(this.zzank, this.zzanj);
        AppMethodBeat.o(1645);
        return zza;
    }
}
