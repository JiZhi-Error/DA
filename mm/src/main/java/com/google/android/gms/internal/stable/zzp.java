package com.google.android.gms.internal.stable;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzp extends zzl {
    zzp() {
    }

    @Override // com.google.android.gms.internal.stable.zzl
    public final void zza(Throwable th, Throwable th2) {
        AppMethodBeat.i(5523);
        th.addSuppressed(th2);
        AppMethodBeat.o(5523);
    }
}
