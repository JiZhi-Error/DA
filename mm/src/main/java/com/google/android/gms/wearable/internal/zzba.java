package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzba extends zzn<Status> {
    private final /* synthetic */ zzay zzcm;
    private final /* synthetic */ int zzcn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzba(zzay zzay, GoogleApiClient googleApiClient, int i2) {
        super(googleApiClient);
        this.zzcm = zzay;
        this.zzcn = i2;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101045);
        ((zzep) zzhg.getService()).zzb(new zzgo(this), this.zzcm.zzce, this.zzcn);
        AppMethodBeat.o(101045);
    }
}
