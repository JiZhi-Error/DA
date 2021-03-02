package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;

final class zzxi extends zzxe {
    zzxi() {
    }

    @Override // com.google.android.gms.internal.measurement.zzxe
    public final void zza(Throwable th, PrintStream printStream) {
        AppMethodBeat.i(40335);
        th.printStackTrace(printStream);
        AppMethodBeat.o(40335);
    }
}
