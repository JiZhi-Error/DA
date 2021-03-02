package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zze extends Api.AbstractClientBuilder<zzh, GoogleSignInOptions> {
    zze() {
    }

    /* Return type fixed from 'com.google.android.gms.common.api.Api$Client' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener] */
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ zzh buildClient(Context context, Looper looper, ClientSettings clientSettings, GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(88361);
        zzh zzh = new zzh(context, looper, clientSettings, googleSignInOptions, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.o(88361);
        return zzh;
    }

    @Override // com.google.android.gms.common.api.Api.BaseClientBuilder
    public final /* synthetic */ List getImpliedScopes(Object obj) {
        AppMethodBeat.i(88362);
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
        if (googleSignInOptions == null) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(88362);
            return emptyList;
        }
        ArrayList<Scope> scopes = googleSignInOptions.getScopes();
        AppMethodBeat.o(88362);
        return scopes;
    }
}
