package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzbn implements ProxyApi {
    @Override // com.google.android.gms.auth.api.proxy.ProxyApi
    public final PendingResult<ProxyApi.ProxyResult> performProxyRequest(GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        AppMethodBeat.i(10766);
        Preconditions.checkNotNull(googleApiClient);
        Preconditions.checkNotNull(proxyRequest);
        BaseImplementation.ApiMethodImpl execute = googleApiClient.execute(new zzbo(this, googleApiClient, proxyRequest));
        AppMethodBeat.o(10766);
        return execute;
    }
}
