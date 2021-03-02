package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

abstract class zzbm extends BaseImplementation.ApiMethodImpl<ProxyApi.ProxyResult, zzbh> {
    public zzbm(GoogleApiClient googleApiClient) {
        super(zzf.API, googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzbq(status);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public /* synthetic */ void doExecute(zzbh zzbh) {
        zzbh zzbh2 = zzbh;
        zzd(zzbh2.getContext(), (zzbk) zzbh2.getService());
    }

    /* access modifiers changed from: protected */
    public abstract void zzd(Context context, zzbk zzbk);
}
