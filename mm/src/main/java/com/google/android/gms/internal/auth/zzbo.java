package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbo extends zzbm {
    private final /* synthetic */ ProxyRequest zzec;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbo(zzbn zzbn, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        super(googleApiClient);
        this.zzec = proxyRequest;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.auth.zzbm
    public final void zzd(Context context, zzbk zzbk) {
        AppMethodBeat.i(10767);
        zzbk.zzd(new zzbp(this), this.zzec);
        AppMethodBeat.o(10767);
    }
}
