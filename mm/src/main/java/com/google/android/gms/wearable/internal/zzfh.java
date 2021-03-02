package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.NodeApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzfh extends zzn<NodeApi.GetLocalNodeResult> {
    zzfh(zzfg zzfg, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(101300);
        zzfk zzfk = new zzfk(status, null);
        AppMethodBeat.o(101300);
        return zzfk;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101299);
        ((zzep) zzhg.getService()).zzb(new zzgy(this));
        AppMethodBeat.o(101299);
    }
}
