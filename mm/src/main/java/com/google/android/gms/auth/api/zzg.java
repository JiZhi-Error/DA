package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.auth.zzbh;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzg extends Api.AbstractClientBuilder<zzbh, zzh> {
    zzg() {
    }

    /* Return type fixed from 'com.google.android.gms.common.api.Api$Client' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener] */
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ zzbh buildClient(Context context, Looper looper, ClientSettings clientSettings, zzh zzh, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(10712);
        zzbh zzbh = new zzbh(context, looper, clientSettings, zzh, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.o(10712);
        return zzbh;
    }
}
