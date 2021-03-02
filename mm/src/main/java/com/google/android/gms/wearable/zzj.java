package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.internal.zzhg;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzj extends Api.AbstractClientBuilder<zzhg, Wearable.WearableOptions> {
    zzj() {
    }

    /* Return type fixed from 'com.google.android.gms.common.api.Api$Client' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener] */
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ zzhg buildClient(Context context, Looper looper, ClientSettings clientSettings, Wearable.WearableOptions wearableOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(101464);
        if (wearableOptions == null) {
            new Wearable.WearableOptions(new Wearable.WearableOptions.Builder(), null);
        }
        zzhg zzhg = new zzhg(context, looper, connectionCallbacks, onConnectionFailedListener, clientSettings);
        AppMethodBeat.o(101464);
        return zzhg;
    }
}
