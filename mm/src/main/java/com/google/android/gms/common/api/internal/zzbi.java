package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbi implements Runnable {
    private final /* synthetic */ GoogleApiManager.zza zzkk;

    zzbi(GoogleApiManager.zza zza) {
        this.zzkk = zza;
    }

    public final void run() {
        AppMethodBeat.i(11329);
        GoogleApiManager.zza.zzc(this.zzkk);
        AppMethodBeat.o(11329);
    }
}
