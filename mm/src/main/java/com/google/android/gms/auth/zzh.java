package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzbr;
import com.google.android.gms.internal.auth.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

/* access modifiers changed from: package-private */
public final class zzh implements zzm<TokenData> {
    private final /* synthetic */ Bundle val$options;
    private final /* synthetic */ Account zzr;
    private final /* synthetic */ String zzs;

    zzh(Account account, String str, Bundle bundle) {
        this.zzr = account;
        this.zzs = str;
        this.val$options = bundle;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.auth.zzm
    public final /* synthetic */ TokenData zze(IBinder iBinder) {
        AppMethodBeat.i(10733);
        Bundle bundle = (Bundle) zzg.zze(zzi.zzd(iBinder).zzd(this.zzr, this.zzs, this.val$options));
        TokenData zzd = TokenData.zzd(bundle, "tokenDetails");
        if (zzd != null) {
            AppMethodBeat.o(10733);
            return zzd;
        }
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzbr zzh = zzbr.zzh(string);
        if (zzbr.zzd(zzh)) {
            Logger logger = zzg.zzq;
            String valueOf = String.valueOf(zzh);
            logger.w("GoogleAuthUtil", new StringBuilder(String.valueOf(valueOf).length() + 31).append("isUserRecoverableError status: ").append(valueOf).toString());
            UserRecoverableAuthException userRecoverableAuthException = new UserRecoverableAuthException(string, intent);
            AppMethodBeat.o(10733);
            throw userRecoverableAuthException;
        }
        if (zzbr.NETWORK_ERROR.equals(zzh) || zzbr.SERVICE_UNAVAILABLE.equals(zzh)) {
            IOException iOException = new IOException(string);
            AppMethodBeat.o(10733);
            throw iOException;
        }
        GoogleAuthException googleAuthException = new GoogleAuthException(string);
        AppMethodBeat.o(10733);
        throw googleAuthException;
    }
}
