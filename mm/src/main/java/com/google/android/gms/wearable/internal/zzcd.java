package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzcd extends zzn<DataApi.GetFdForAssetResult> {
    private final /* synthetic */ DataItemAsset zzde;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcd(zzbw zzbw, GoogleApiClient googleApiClient, DataItemAsset dataItemAsset) {
        super(googleApiClient);
        this.zzde = dataItemAsset;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(101117);
        zzci zzci = new zzci(status, null);
        AppMethodBeat.o(101117);
        return zzci;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101116);
        zzhg.zza(this, Asset.createFromRef(this.zzde.getId()));
        AppMethodBeat.o(101116);
    }
}
