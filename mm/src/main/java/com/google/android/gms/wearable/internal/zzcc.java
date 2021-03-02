package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzcc extends zzn<DataApi.GetFdForAssetResult> {
    private final /* synthetic */ Asset zzdd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcc(zzbw zzbw, GoogleApiClient googleApiClient, Asset asset) {
        super(googleApiClient);
        this.zzdd = asset;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(101115);
        zzci zzci = new zzci(status, null);
        AppMethodBeat.o(101115);
        return zzci;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101114);
        zzhg.zza(this, this.zzdd);
        AppMethodBeat.o(101114);
    }
}
