package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccount;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzk implements WorkAccountApi {
    private static final Status zzaf = new Status(13);

    static {
        AppMethodBeat.i(10793);
        AppMethodBeat.o(10793);
    }

    @Override // com.google.android.gms.auth.account.WorkAccountApi
    public final PendingResult<WorkAccountApi.AddAccountResult> addWorkAccount(GoogleApiClient googleApiClient, String str) {
        AppMethodBeat.i(10791);
        BaseImplementation.ApiMethodImpl execute = googleApiClient.execute(new zzm(this, WorkAccount.API, googleApiClient, str));
        AppMethodBeat.o(10791);
        return execute;
    }

    @Override // com.google.android.gms.auth.account.WorkAccountApi
    public final PendingResult<Result> removeWorkAccount(GoogleApiClient googleApiClient, Account account) {
        AppMethodBeat.i(10792);
        BaseImplementation.ApiMethodImpl execute = googleApiClient.execute(new zzo(this, WorkAccount.API, googleApiClient, account));
        AppMethodBeat.o(10792);
        return execute;
    }

    @Override // com.google.android.gms.auth.account.WorkAccountApi
    public final void setWorkAuthenticatorEnabled(GoogleApiClient googleApiClient, boolean z) {
        AppMethodBeat.i(10789);
        setWorkAuthenticatorEnabledWithResult(googleApiClient, z);
        AppMethodBeat.o(10789);
    }

    @Override // com.google.android.gms.auth.account.WorkAccountApi
    public final PendingResult<Result> setWorkAuthenticatorEnabledWithResult(GoogleApiClient googleApiClient, boolean z) {
        AppMethodBeat.i(10790);
        BaseImplementation.ApiMethodImpl execute = googleApiClient.execute(new zzl(this, WorkAccount.API, googleApiClient, z));
        AppMethodBeat.o(10790);
        return execute;
    }
}
