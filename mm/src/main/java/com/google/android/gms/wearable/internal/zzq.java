package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzq extends zzn<CapabilityApi.GetAllCapabilitiesResult> {
    private final /* synthetic */ int zzbq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzq(zzo zzo, GoogleApiClient googleApiClient, int i2) {
        super(googleApiClient);
        this.zzbq = i2;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(101450);
        zzx zzx = new zzx(status, null);
        AppMethodBeat.o(101450);
        return zzx;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101449);
        ((zzep) zzhg.getService()).zza(new zzgq(this), this.zzbq);
        AppMethodBeat.o(101449);
    }
}
