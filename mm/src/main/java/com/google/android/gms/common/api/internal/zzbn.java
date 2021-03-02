package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

final class zzbn implements Runnable {
    private final /* synthetic */ ConnectionResult zzkl;
    private final /* synthetic */ GoogleApiManager.zzc zzkr;

    zzbn(GoogleApiManager.zzc zzc, ConnectionResult connectionResult) {
        this.zzkr = zzc;
        this.zzkl = connectionResult;
    }

    public final void run() {
        AppMethodBeat.i(11334);
        if (this.zzkl.isSuccess()) {
            this.zzkr.zzkq = true;
            if (this.zzkr.zzka.requiresSignIn()) {
                GoogleApiManager.zzc.zzb(this.zzkr);
                AppMethodBeat.o(11334);
                return;
            }
            this.zzkr.zzka.getRemoteService(null, Collections.emptySet());
            AppMethodBeat.o(11334);
            return;
        }
        ((GoogleApiManager.zza) GoogleApiManager.this.zzju.get(this.zzkr.zzhc)).onConnectionFailed(this.zzkl);
        AppMethodBeat.o(11334);
    }
}
