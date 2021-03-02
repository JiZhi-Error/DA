package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzp extends zzn<CapabilityApi.GetCapabilityResult> {
    private final /* synthetic */ String zzbp;
    private final /* synthetic */ int zzbq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzp(zzo zzo, GoogleApiClient googleApiClient, String str, int i2) {
        super(googleApiClient);
        this.zzbp = str;
        this.zzbq = i2;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(101448);
        zzy zzy = new zzy(status, null);
        AppMethodBeat.o(101448);
        return zzy;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101447);
        ((zzep) zzhg.getService()).zza(new zzgr(this), this.zzbp, this.zzbq);
        AppMethodBeat.o(101447);
    }
}
