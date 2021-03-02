package com.google.android.gms.common.api.internal;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzaz implements ResultCallback<Status> {
    private final /* synthetic */ zzav zzit;
    private final /* synthetic */ StatusPendingResult zziv;
    private final /* synthetic */ boolean zziw;
    private final /* synthetic */ GoogleApiClient zzix;

    zzaz(zzav zzav, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.zzit = zzav;
        this.zziv = statusPendingResult;
        this.zziw = z;
        this.zzix = googleApiClient;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Result] */
    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* synthetic */ void onResult(Status status) {
        AppMethodBeat.i(11304);
        Status status2 = status;
        Storage.getInstance(this.zzit.mContext).removeSavedDefaultGoogleSignInAccount();
        if (status2.isSuccess() && this.zzit.isConnected()) {
            this.zzit.reconnect();
        }
        this.zziv.setResult(status2);
        if (this.zziw) {
            this.zzix.disconnect();
        }
        AppMethodBeat.o(11304);
    }
}
