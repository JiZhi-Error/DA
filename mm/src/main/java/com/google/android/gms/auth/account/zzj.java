package com.google.android.gms.auth.account;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzj implements PendingResultUtil.ResultConverter<WorkAccountApi.AddAccountResult, Account> {
    zzj(WorkAccountClient workAccountClient) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Result] */
    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ Account convert(WorkAccountApi.AddAccountResult addAccountResult) {
        AppMethodBeat.i(10633);
        Account account = addAccountResult.getAccount();
        AppMethodBeat.o(10633);
        return account;
    }
}
