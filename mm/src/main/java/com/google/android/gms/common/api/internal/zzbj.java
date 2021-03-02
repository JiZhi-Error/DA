package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzbj implements Runnable {
    private final /* synthetic */ GoogleApiManager.zza zzkk;

    zzbj(GoogleApiManager.zza zza) {
        this.zzkk = zza;
    }

    public final void run() {
        AppMethodBeat.i(11330);
        GoogleApiManager.zza.zzd(this.zzkk);
        AppMethodBeat.o(11330);
    }
}
