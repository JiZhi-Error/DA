package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzo extends zzd {
    private final /* synthetic */ zzn zzez;

    zzo(zzn zzn) {
        this.zzez = zzn;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzd, com.google.android.gms.auth.api.signin.internal.zzt
    public final void zzh(Status status) {
        AppMethodBeat.i(88345);
        this.zzez.setResult((Result) status);
        AppMethodBeat.o(88345);
    }
}
