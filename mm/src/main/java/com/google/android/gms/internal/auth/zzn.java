package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzn extends zzq {
    private final /* synthetic */ zzm zzah;

    zzn(zzm zzm) {
        this.zzah = zzm;
    }

    @Override // com.google.android.gms.internal.auth.zzq, com.google.android.gms.auth.account.zzd
    public final void zzf(Account account) {
        AppMethodBeat.i(10798);
        this.zzah.setResult((Result) new zzr(account != null ? Status.RESULT_SUCCESS : zzk.zzaf, account));
        AppMethodBeat.o(10798);
    }
}
