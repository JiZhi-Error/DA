package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzs extends zzn<CapabilityApi.RemoveLocalCapabilityResult> {
    private final /* synthetic */ String zzbp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzs(zzo zzo, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zzbp = str;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(101454);
        zzu zzu = new zzu(status);
        AppMethodBeat.o(101454);
        return zzu;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101453);
        ((zzep) zzhg.getService()).zzb(new zzhd(this), this.zzbp);
        AppMethodBeat.o(101453);
    }
}
