package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

final class zzax implements GoogleApiClient.ConnectionCallbacks {
    private final /* synthetic */ zzav zzit;
    private final /* synthetic */ AtomicReference zziu;
    private final /* synthetic */ StatusPendingResult zziv;

    zzax(zzav zzav, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.zzit = zzav;
        this.zziu = atomicReference;
        this.zziv = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        AppMethodBeat.i(11302);
        zzav.zza(this.zzit, (GoogleApiClient) this.zziu.get(), this.zziv, true);
        AppMethodBeat.o(11302);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
    }
}
