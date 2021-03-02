package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzar extends zzav<Status> {
    private final /* synthetic */ Credential zzdt;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzar(zzao zzao, GoogleApiClient googleApiClient, Credential credential) {
        super(googleApiClient);
        this.zzdt = credential;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.auth.zzav
    public final void zzd(Context context, zzbc zzbc) {
        AppMethodBeat.i(88376);
        zzbc.zzd(new zzau(this), new zzbe(this.zzdt));
        AppMethodBeat.o(88376);
    }
}
