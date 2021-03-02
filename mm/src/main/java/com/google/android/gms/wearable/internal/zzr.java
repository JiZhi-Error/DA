package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzr extends zzn<CapabilityApi.AddLocalCapabilityResult> {
    private final /* synthetic */ String zzbp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzr(zzo zzo, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zzbp = str;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(101452);
        zzu zzu = new zzu(status);
        AppMethodBeat.o(101452);
        return zzu;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101451);
        ((zzep) zzhg.getService()).zza(new zzgl(this), this.zzbp);
        AppMethodBeat.o(101451);
    }
}
