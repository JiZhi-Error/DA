package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

public final class zzau implements zzbc {
    private final zzbd zzhf;

    public zzau(zzbd zzbd) {
        this.zzhf = zzbd;
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final void begin() {
        AppMethodBeat.i(11253);
        for (Api.Client client : this.zzhf.zzil.values()) {
            client.disconnect();
        }
        this.zzhf.zzfq.zzim = Collections.emptySet();
        AppMethodBeat.o(11253);
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final void connect() {
        AppMethodBeat.i(11256);
        this.zzhf.zzbc();
        AppMethodBeat.o(11256);
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final boolean disconnect() {
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.i(11254);
        this.zzhf.zzfq.zzgo.add(t);
        AppMethodBeat.o(11254);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.i(11255);
        IllegalStateException illegalStateException = new IllegalStateException("GoogleApiClient is not connected yet.");
        AppMethodBeat.o(11255);
        throw illegalStateException;
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final void onConnectionSuspended(int i2) {
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }
}
