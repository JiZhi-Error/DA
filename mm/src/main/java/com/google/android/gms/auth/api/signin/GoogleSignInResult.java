package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleSignInResult implements Result {
    private Status mStatus;
    private GoogleSignInAccount zzen;

    public GoogleSignInResult(GoogleSignInAccount googleSignInAccount, Status status) {
        this.zzen = googleSignInAccount;
        this.mStatus = status;
    }

    public GoogleSignInAccount getSignInAccount() {
        return this.zzen;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.mStatus;
    }

    public boolean isSuccess() {
        AppMethodBeat.i(88291);
        boolean isSuccess = this.mStatus.isSuccess();
        AppMethodBeat.o(88291);
        return isSuccess;
    }
}
