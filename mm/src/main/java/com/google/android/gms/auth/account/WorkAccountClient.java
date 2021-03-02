package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.auth.zzk;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WorkAccountClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    private final WorkAccountApi zzae = new zzk();

    WorkAccountClient(Activity activity) {
        super(activity, (Api) WorkAccount.API, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
        AppMethodBeat.i(10625);
        AppMethodBeat.o(10625);
    }

    WorkAccountClient(Context context) {
        super(context, WorkAccount.API, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
        AppMethodBeat.i(10624);
        AppMethodBeat.o(10624);
    }

    public Task<Account> addWorkAccount(String str) {
        AppMethodBeat.i(10627);
        Task<Account> task = PendingResultUtil.toTask(this.zzae.addWorkAccount(asGoogleApiClient(), str), new zzj(this));
        AppMethodBeat.o(10627);
        return task;
    }

    public Task<Void> removeWorkAccount(Account account) {
        AppMethodBeat.i(10628);
        Task<Void> voidTask = PendingResultUtil.toVoidTask(this.zzae.removeWorkAccount(asGoogleApiClient(), account));
        AppMethodBeat.o(10628);
        return voidTask;
    }

    public Task<Void> setWorkAuthenticatorEnabled(boolean z) {
        AppMethodBeat.i(10626);
        Task<Void> voidTask = PendingResultUtil.toVoidTask(this.zzae.setWorkAuthenticatorEnabledWithResult(asGoogleApiClient(), z));
        AppMethodBeat.o(10626);
        return voidTask;
    }
}
