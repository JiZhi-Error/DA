package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.api.Response;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CredentialRequestResponse extends Response<CredentialRequestResult> {
    public Credential getCredential() {
        AppMethodBeat.i(88223);
        Credential credential = ((CredentialRequestResult) getResult()).getCredential();
        AppMethodBeat.o(88223);
        return credential;
    }
}
