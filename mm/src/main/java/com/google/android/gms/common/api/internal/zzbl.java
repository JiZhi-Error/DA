package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzbl implements BaseGmsClient.SignOutCallbacks {
    final /* synthetic */ GoogleApiManager.zza zzkk;

    zzbl(GoogleApiManager.zza zza) {
        this.zzkk = zza;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void onSignOutComplete() {
        AppMethodBeat.i(11332);
        GoogleApiManager.this.handler.post(new zzbm(this));
        AppMethodBeat.o(11332);
    }
}
