package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Result;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbp extends zzbg {
    private final /* synthetic */ zzbo zzed;

    zzbp(zzbo zzbo) {
        this.zzed = zzbo;
    }

    @Override // com.google.android.gms.internal.auth.zzbg, com.google.android.gms.internal.auth.zzbi
    public final void zzd(ProxyResponse proxyResponse) {
        AppMethodBeat.i(10768);
        this.zzed.setResult((Result) new zzbq(proxyResponse));
        AppMethodBeat.o(10768);
    }
}
