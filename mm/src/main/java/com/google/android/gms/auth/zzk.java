package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.auth.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzk implements zzm<Bundle> {
    private final /* synthetic */ Account zzr;

    zzk(Account account) {
        this.zzr = account;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.auth.zzm
    public final /* synthetic */ Bundle zze(IBinder iBinder) {
        AppMethodBeat.i(10736);
        Bundle bundle = (Bundle) zzg.zze(zzi.zzd(iBinder).zzd(this.zzr));
        AppMethodBeat.o(10736);
        return bundle;
    }
}
