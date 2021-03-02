package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzat extends zzav<Status> {
    zzat(zzao zzao, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.auth.zzav
    public final void zzd(Context context, zzbc zzbc) {
        AppMethodBeat.i(88378);
        zzbc.zzd(new zzau(this));
        AppMethodBeat.o(88378);
    }
}
