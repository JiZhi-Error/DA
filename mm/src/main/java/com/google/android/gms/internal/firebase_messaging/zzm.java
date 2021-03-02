package com.google.android.gms.internal.firebase_messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm extends zzi {
    zzm() {
    }

    @Override // com.google.android.gms.internal.firebase_messaging.zzi
    public final void zza(Throwable th, Throwable th2) {
        AppMethodBeat.i(4123);
        th.addSuppressed(th2);
        AppMethodBeat.o(4123);
    }
}
