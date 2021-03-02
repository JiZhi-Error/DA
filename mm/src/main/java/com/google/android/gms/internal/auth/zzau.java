package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzau extends zzam {
    private BaseImplementation.ResultHolder<Status> zzdu;

    zzau(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.zzdu = resultHolder;
    }

    @Override // com.google.android.gms.internal.auth.zzam, com.google.android.gms.internal.auth.zzba
    public final void zze(Status status) {
        AppMethodBeat.i(88379);
        this.zzdu.setResult(status);
        AppMethodBeat.o(88379);
    }
}
