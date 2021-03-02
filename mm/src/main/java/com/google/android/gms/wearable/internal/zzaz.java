package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzaz extends zzn<Status> {
    private final /* synthetic */ zzay zzcm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaz(zzay zzay, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzcm = zzay;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101041);
        ((zzep) zzhg.getService()).zzc(new zzgn(this), this.zzcm.zzce);
        AppMethodBeat.o(101041);
    }
}
