package com.google.android.gms.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzbr;
import com.google.android.gms.internal.auth.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzl implements zzm<Boolean> {
    private final /* synthetic */ String zzw;

    zzl(String str) {
        this.zzw = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.auth.zzm
    public final /* synthetic */ Boolean zze(IBinder iBinder) {
        AppMethodBeat.i(10737);
        Bundle bundle = (Bundle) zzg.zze(zzi.zzd(iBinder).zzd(this.zzw));
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzbr zzh = zzbr.zzh(string);
        if (zzbr.SUCCESS.equals(zzh)) {
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(10737);
            return bool;
        } else if (zzbr.zzd(zzh)) {
            Logger logger = zzg.zzq;
            String valueOf = String.valueOf(zzh);
            logger.w("GoogleAuthUtil", new StringBuilder(String.valueOf(valueOf).length() + 31).append("isUserRecoverableError status: ").append(valueOf).toString());
            UserRecoverableAuthException userRecoverableAuthException = new UserRecoverableAuthException(string, intent);
            AppMethodBeat.o(10737);
            throw userRecoverableAuthException;
        } else {
            GoogleAuthException googleAuthException = new GoogleAuthException(string);
            AppMethodBeat.o(10737);
            throw googleAuthException;
        }
    }
}
