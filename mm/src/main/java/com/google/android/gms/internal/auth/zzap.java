package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzap extends zzav<CredentialRequestResult> {
    private final /* synthetic */ CredentialRequest zzdr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzap(zzao zzao, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        super(googleApiClient);
        this.zzdr = credentialRequest;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(88373);
        zzan zzf = zzan.zzf(status);
        AppMethodBeat.o(88373);
        return zzf;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.auth.zzav
    public final void zzd(Context context, zzbc zzbc) {
        AppMethodBeat.i(88372);
        zzbc.zzd(new zzaq(this), this.zzdr);
        AppMethodBeat.o(88372);
    }
}
