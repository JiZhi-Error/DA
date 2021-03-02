package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzd<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zzb {
    private final A zzdv;

    public zzd(int i2, A a2) {
        super(i2);
        this.zzdv = a2;
    }

    @Override // com.google.android.gms.common.api.internal.zzb
    public final void zza(Status status) {
        AppMethodBeat.i(11394);
        this.zzdv.setFailedResult(status);
        AppMethodBeat.o(11394);
    }

    @Override // com.google.android.gms.common.api.internal.zzb
    public final void zza(GoogleApiManager.zza<?> zza) {
        AppMethodBeat.i(11393);
        try {
            this.zzdv.run(zza.zzae());
            AppMethodBeat.o(11393);
        } catch (RuntimeException e2) {
            zza(e2);
            AppMethodBeat.o(11393);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzb
    public final void zza(zzaa zzaa, boolean z) {
        AppMethodBeat.i(11396);
        zzaa.zza(this.zzdv, z);
        AppMethodBeat.o(11396);
    }

    @Override // com.google.android.gms.common.api.internal.zzb
    public final void zza(RuntimeException runtimeException) {
        AppMethodBeat.i(11395);
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        this.zzdv.setFailedResult(new Status(10, new StringBuilder(String.valueOf(simpleName).length() + 2 + String.valueOf(localizedMessage).length()).append(simpleName).append(": ").append(localizedMessage).toString()));
        AppMethodBeat.o(11395);
    }
}
