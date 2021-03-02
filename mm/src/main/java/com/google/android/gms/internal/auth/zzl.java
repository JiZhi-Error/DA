package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.account.zzf;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzl extends BaseImplementation.ApiMethodImpl<Result, zzu> {
    private final /* synthetic */ boolean zzag;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzl(zzk zzk, Api api, GoogleApiClient googleApiClient, boolean z) {
        super(api, googleApiClient);
        this.zzag = z;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status) {
        AppMethodBeat.i(10794);
        zzs zzs = new zzs(status);
        AppMethodBeat.o(10794);
        return zzs;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzu zzu) {
        AppMethodBeat.i(10795);
        ((zzf) zzu.getService()).zze(this.zzag);
        setResult((Result) new zzs(Status.RESULT_SUCCESS));
        AppMethodBeat.o(10795);
    }
}
