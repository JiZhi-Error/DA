package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaq extends zzam {
    private final /* synthetic */ zzap zzds;

    zzaq(zzap zzap) {
        this.zzds = zzap;
    }

    @Override // com.google.android.gms.internal.auth.zzam, com.google.android.gms.internal.auth.zzba
    public final void zzd(Status status, Credential credential) {
        AppMethodBeat.i(88374);
        this.zzds.setResult((Result) new zzan(status, credential));
        AppMethodBeat.o(88374);
    }

    @Override // com.google.android.gms.internal.auth.zzam, com.google.android.gms.internal.auth.zzba
    public final void zze(Status status) {
        AppMethodBeat.i(88375);
        this.zzds.setResult((Result) zzan.zzf(status));
        AppMethodBeat.o(88375);
    }
}
