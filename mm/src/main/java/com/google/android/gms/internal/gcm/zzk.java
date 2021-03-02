package com.google.android.gms.internal.gcm;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzk extends zzg {
    zzk() {
    }

    @Override // com.google.android.gms.internal.gcm.zzg
    public final void zzd(Throwable th, Throwable th2) {
        AppMethodBeat.i(2586);
        th.addSuppressed(th2);
        AppMethodBeat.o(2586);
    }
}
