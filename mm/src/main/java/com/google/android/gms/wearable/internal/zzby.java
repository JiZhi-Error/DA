package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzby extends zzn<DataApi.DataItemResult> {
    private final /* synthetic */ Uri zzco;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzby(zzbw zzbw, GoogleApiClient googleApiClient, Uri uri) {
        super(googleApiClient);
        this.zzco = uri;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(101107);
        zzcg zzcg = new zzcg(status, null);
        AppMethodBeat.o(101107);
        return zzcg;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101106);
        ((zzep) zzhg.getService()).zza(new zzgv(this), this.zzco);
        AppMethodBeat.o(101106);
    }
}
