package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.auth.account.zzf;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm extends BaseImplementation.ApiMethodImpl<WorkAccountApi.AddAccountResult, zzu> {
    private final /* synthetic */ String zzt;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzm(zzk zzk, Api api, GoogleApiClient googleApiClient, String str) {
        super(api, googleApiClient);
        this.zzt = str;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(10797);
        zzr zzr = new zzr(status, null);
        AppMethodBeat.o(10797);
        return zzr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzu zzu) {
        AppMethodBeat.i(10796);
        ((zzf) zzu.getService()).zzd(new zzn(this), this.zzt);
        AppMethodBeat.o(10796);
    }
}
