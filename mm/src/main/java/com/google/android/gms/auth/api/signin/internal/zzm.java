package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm extends zzd {
    private final /* synthetic */ zzl zzey;

    zzm(zzl zzl) {
        this.zzey = zzl;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzd, com.google.android.gms.auth.api.signin.internal.zzt
    public final void zzg(Status status) {
        AppMethodBeat.i(88343);
        this.zzey.setResult((Result) status);
        AppMethodBeat.o(88343);
    }
}
