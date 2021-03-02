package com.google.android.gms.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.ISignInCallbacks;

public class BaseSignInCallbacks extends ISignInCallbacks.Stub {
    @Override // com.google.android.gms.signin.internal.ISignInCallbacks
    public void onAuthAccountComplete(ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
    }

    @Override // com.google.android.gms.signin.internal.ISignInCallbacks
    public void onGetCurrentAccountComplete(Status status, GoogleSignInAccount googleSignInAccount) {
    }

    @Override // com.google.android.gms.signin.internal.ISignInCallbacks
    public void onRecordConsentComplete(Status status) {
    }

    @Override // com.google.android.gms.signin.internal.ISignInCallbacks
    public void onSaveAccountToSessionStoreComplete(Status status) {
    }

    @Override // com.google.android.gms.signin.internal.ISignInCallbacks
    public void onSignInComplete(SignInResponse signInResponse) {
    }
}
