package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzay implements GoogleApiClient.OnConnectionFailedListener {
    private final /* synthetic */ StatusPendingResult zziv;

    zzay(zzav zzav, StatusPendingResult statusPendingResult) {
        this.zziv = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        AppMethodBeat.i(11303);
        this.zziv.setResult(new Status(8));
        AppMethodBeat.o(11303);
    }
}