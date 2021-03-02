package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzq {
    private static zzq zzfa = null;
    @VisibleForTesting
    private Storage zzfb;
    @VisibleForTesting
    private GoogleSignInAccount zzfc = this.zzfb.getSavedDefaultGoogleSignInAccount();
    @VisibleForTesting
    private GoogleSignInOptions zzfd = this.zzfb.getSavedDefaultGoogleSignInOptions();

    private zzq(Context context) {
        AppMethodBeat.i(88346);
        this.zzfb = Storage.getInstance(context);
        AppMethodBeat.o(88346);
    }

    public static synchronized zzq zze(Context context) {
        zzq zzf;
        synchronized (zzq.class) {
            AppMethodBeat.i(88347);
            zzf = zzf(context.getApplicationContext());
            AppMethodBeat.o(88347);
        }
        return zzf;
    }

    private static synchronized zzq zzf(Context context) {
        zzq zzq;
        synchronized (zzq.class) {
            AppMethodBeat.i(88348);
            if (zzfa == null) {
                zzfa = new zzq(context);
            }
            zzq = zzfa;
            AppMethodBeat.o(88348);
        }
        return zzq;
    }

    public final synchronized void clear() {
        AppMethodBeat.i(88349);
        this.zzfb.clear();
        this.zzfc = null;
        this.zzfd = null;
        AppMethodBeat.o(88349);
    }

    public final synchronized void zzd(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        AppMethodBeat.i(88350);
        this.zzfb.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
        this.zzfc = googleSignInAccount;
        this.zzfd = googleSignInOptions;
        AppMethodBeat.o(88350);
    }

    public final synchronized GoogleSignInAccount zzo() {
        return this.zzfc;
    }

    public final synchronized GoogleSignInOptions zzp() {
        return this.zzfd;
    }
}
