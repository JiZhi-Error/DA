package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.zzf;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzo extends BaseImplementation.ApiMethodImpl<Result, zzu> {
    private final /* synthetic */ Account zzr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzo(zzk zzk, Api api, GoogleApiClient googleApiClient, Account account) {
        super(api, googleApiClient);
        this.zzr = account;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status) {
        AppMethodBeat.i(10799);
        zzt zzt = new zzt(status);
        AppMethodBeat.o(10799);
        return zzt;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzu zzu) {
        AppMethodBeat.i(10800);
        ((zzf) zzu.getService()).zzd(new zzp(this), this.zzr);
        AppMethodBeat.o(10800);
    }
}
