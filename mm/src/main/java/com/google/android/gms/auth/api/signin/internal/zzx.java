package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzx extends zzs {
    private final Context mContext;

    public zzx(Context context) {
        this.mContext = context;
    }

    private final void zzs() {
        AppMethodBeat.i(88356);
        if (!GooglePlayServicesUtil.isGooglePlayServicesUid(this.mContext, Binder.getCallingUid())) {
            SecurityException securityException = new SecurityException(new StringBuilder(52).append("Calling UID ").append(Binder.getCallingUid()).append(" is not Google Play services.").toString());
            AppMethodBeat.o(88356);
            throw securityException;
        }
        AppMethodBeat.o(88356);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzr
    public final void zzq() {
        AppMethodBeat.i(88354);
        zzs();
        Storage instance = Storage.getInstance(this.mContext);
        GoogleSignInAccount savedDefaultGoogleSignInAccount = instance.getSavedDefaultGoogleSignInAccount();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.DEFAULT_SIGN_IN;
        if (savedDefaultGoogleSignInAccount != null) {
            googleSignInOptions = instance.getSavedDefaultGoogleSignInOptions();
        }
        GoogleApiClient build = new GoogleApiClient.Builder(this.mContext).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions).build();
        try {
            if (build.blockingConnect().isSuccess()) {
                if (savedDefaultGoogleSignInAccount != null) {
                    Auth.GoogleSignInApi.revokeAccess(build);
                } else {
                    build.clearDefaultAccountAndReconnect();
                }
            }
        } finally {
            build.disconnect();
            AppMethodBeat.o(88354);
        }
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzr
    public final void zzr() {
        AppMethodBeat.i(88355);
        zzs();
        zzq.zze(this.mContext).clear();
        AppMethodBeat.o(88355);
    }
}
