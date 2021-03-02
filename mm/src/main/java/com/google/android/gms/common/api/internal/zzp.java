package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzp implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final Api<?> mApi;
    private final boolean zzfo;
    private zzq zzfp;

    public zzp(Api<?> api, boolean z) {
        this.mApi = api;
        this.zzfo = z;
    }

    private final void zzy() {
        AppMethodBeat.i(11437);
        Preconditions.checkNotNull(this.zzfp, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        AppMethodBeat.o(11437);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        AppMethodBeat.i(11434);
        zzy();
        this.zzfp.onConnected(bundle);
        AppMethodBeat.o(11434);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        AppMethodBeat.i(11436);
        zzy();
        this.zzfp.zza(connectionResult, this.mApi, this.zzfo);
        AppMethodBeat.o(11436);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
        AppMethodBeat.i(11435);
        zzy();
        this.zzfp.onConnectionSuspended(i2);
        AppMethodBeat.o(11435);
    }

    public final void zza(zzq zzq) {
        this.zzfp = zzq;
    }
}
