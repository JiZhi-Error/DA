package com.google.android.gms.auth.api;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzbh;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzf {
    public static final Api<zzh> API = new Api<>("Auth.PROXY_API", zzat, zzas);
    private static final Api.ClientKey<zzbh> zzas = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzbh, zzh> zzat = new zzg();

    static {
        AppMethodBeat.i(10711);
        AppMethodBeat.o(10711);
    }
}
