package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzan implements CredentialRequestResult {
    private final Status mStatus;
    private final Credential zzdq;

    public zzan(Status status, Credential credential) {
        this.mStatus = status;
        this.zzdq = credential;
    }

    public static zzan zzf(Status status) {
        AppMethodBeat.i(88366);
        zzan zzan = new zzan(status, null);
        AppMethodBeat.o(88366);
        return zzan;
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialRequestResult
    public final Credential getCredential() {
        return this.zzdq;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.mStatus;
    }
}
