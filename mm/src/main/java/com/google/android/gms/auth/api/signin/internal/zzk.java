package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzk extends zzd {
    private final /* synthetic */ zzj zzex;

    zzk(zzj zzj) {
        this.zzex = zzj;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzd, com.google.android.gms.auth.api.signin.internal.zzt
    public final void zzd(GoogleSignInAccount googleSignInAccount, Status status) {
        AppMethodBeat.i(88341);
        if (googleSignInAccount != null) {
            zzq.zze(this.zzex.val$context).zzd(this.zzex.zzew, googleSignInAccount);
        }
        this.zzex.setResult((Result) new GoogleSignInResult(googleSignInAccount, status));
        AppMethodBeat.o(88341);
    }
}
