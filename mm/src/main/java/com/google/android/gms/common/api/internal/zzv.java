package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzv<O extends Api.ApiOptions> extends GoogleApi<O> {
    private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
    private final Api.Client zzgd;
    private final zzp zzge;
    private final ClientSettings zzgf;

    public zzv(Context context, Api<O> api, Looper looper, Api.Client client, zzp zzp, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder) {
        super(context, api, looper);
        AppMethodBeat.i(11472);
        this.zzgd = client;
        this.zzge = zzp;
        this.zzgf = clientSettings;
        this.zzdh = abstractClientBuilder;
        this.zzcq.zza(this);
        AppMethodBeat.o(11472);
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    public final Api.Client zza(Looper looper, GoogleApiManager.zza<O> zza) {
        AppMethodBeat.i(11473);
        this.zzge.zza(zza);
        Api.Client client = this.zzgd;
        AppMethodBeat.o(11473);
        return client;
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    public final zzby zza(Context context, Handler handler) {
        AppMethodBeat.i(11474);
        zzby zzby = new zzby(context, handler, this.zzgf, this.zzdh);
        AppMethodBeat.o(11474);
        return zzby;
    }

    public final Api.Client zzae() {
        return this.zzgd;
    }
}
