package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.NodeApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class zzfi extends zzn<NodeApi.GetConnectedNodesResult> {
    zzfi(zzfg zzfg, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(101302);
        zzfj zzfj = new zzfj(status, new ArrayList());
        AppMethodBeat.o(101302);
        return zzfj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101301);
        ((zzep) zzhg.getService()).zzc(new zzgu(this));
        AppMethodBeat.o(101301);
    }
}
