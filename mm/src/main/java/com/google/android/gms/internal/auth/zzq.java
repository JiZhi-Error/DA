package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.zze;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class zzq extends zze {
    zzq() {
    }

    @Override // com.google.android.gms.auth.account.zzd
    public void zzd(boolean z) {
        AppMethodBeat.i(10803);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(10803);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.auth.account.zzd
    public void zzf(Account account) {
        AppMethodBeat.i(10802);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(10802);
        throw unsupportedOperationException;
    }
}
