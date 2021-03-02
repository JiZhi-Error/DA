package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaae implements zzaak {
    zzaae() {
    }

    @Override // com.google.android.gms.internal.measurement.zzaak
    public final boolean zzd(Class<?> cls) {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzaak
    public final zzaaj zze(Class<?> cls) {
        AppMethodBeat.i(40125);
        IllegalStateException illegalStateException = new IllegalStateException("This should never be called.");
        AppMethodBeat.o(40125);
        throw illegalStateException;
    }
}
