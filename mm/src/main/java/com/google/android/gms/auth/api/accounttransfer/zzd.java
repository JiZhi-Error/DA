package com.google.android.gms.auth.api.accounttransfer;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.auth.zzx;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzd extends Api.AbstractClientBuilder<zzx, zzq> {
    zzd() {
    }

    /* Return type fixed from 'com.google.android.gms.common.api.Api$Client' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener] */
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ zzx buildClient(Context context, Looper looper, ClientSettings clientSettings, zzq zzq, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(10651);
        zzx zzx = new zzx(context, looper, clientSettings, zzq, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.o(10651);
        return zzx;
    }
}
