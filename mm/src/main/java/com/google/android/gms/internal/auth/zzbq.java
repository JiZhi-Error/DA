package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

final class zzbq implements ProxyApi.ProxyResult {
    private Status mStatus;
    private ProxyResponse zzee;

    public zzbq(ProxyResponse proxyResponse) {
        this.zzee = proxyResponse;
        this.mStatus = Status.RESULT_SUCCESS;
    }

    public zzbq(Status status) {
        this.mStatus = status;
    }

    @Override // com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult
    public final ProxyResponse getResponse() {
        return this.zzee;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.mStatus;
    }
}
