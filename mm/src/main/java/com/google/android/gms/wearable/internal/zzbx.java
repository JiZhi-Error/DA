package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbx extends zzn<DataApi.DataItemResult> {
    private final /* synthetic */ PutDataRequest zzdb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbx(zzbw zzbw, GoogleApiClient googleApiClient, PutDataRequest putDataRequest) {
        super(googleApiClient);
        this.zzdb = putDataRequest;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(101105);
        zzcg zzcg = new zzcg(status, null);
        AppMethodBeat.o(101105);
        return zzcg;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101104);
        zzhg.zza(this, this.zzdb);
        AppMethodBeat.o(101104);
    }
}
