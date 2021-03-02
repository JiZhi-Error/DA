package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzbo<O extends Api.ApiOptions> extends zzaf {
    private final GoogleApi<O> zzks;

    public zzbo(GoogleApi<O> googleApi) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.zzks = googleApi;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.i(11335);
        T t2 = (T) this.zzks.doRead(t);
        AppMethodBeat.o(11335);
        return t2;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.i(11336);
        T t2 = (T) this.zzks.doWrite(t);
        AppMethodBeat.o(11336);
        return t2;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context getContext() {
        AppMethodBeat.i(11338);
        Context applicationContext = this.zzks.getApplicationContext();
        AppMethodBeat.o(11338);
        return applicationContext;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper getLooper() {
        AppMethodBeat.i(11337);
        Looper looper = this.zzks.getLooper();
        AppMethodBeat.o(11337);
        return looper;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zza(zzch zzch) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zzb(zzch zzch) {
    }
}
