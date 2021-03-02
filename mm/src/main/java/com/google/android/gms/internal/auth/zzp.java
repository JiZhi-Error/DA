package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzp extends zzq {
    private final /* synthetic */ zzo zzai;

    zzp(zzo zzo) {
        this.zzai = zzo;
    }

    @Override // com.google.android.gms.internal.auth.zzq, com.google.android.gms.auth.account.zzd
    public final void zzd(boolean z) {
        AppMethodBeat.i(10801);
        this.zzai.setResult((Result) new zzt(z ? Status.RESULT_SUCCESS : zzk.zzaf));
        AppMethodBeat.o(10801);
    }
}
