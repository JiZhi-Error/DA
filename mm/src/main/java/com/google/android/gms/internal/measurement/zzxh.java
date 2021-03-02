package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.List;

final class zzxh extends zzxe {
    private final zzxf zzbod = new zzxf();

    zzxh() {
        AppMethodBeat.i(40333);
        AppMethodBeat.o(40333);
    }

    @Override // com.google.android.gms.internal.measurement.zzxe
    public final void zza(Throwable th, PrintStream printStream) {
        AppMethodBeat.i(40334);
        th.printStackTrace(printStream);
        List<Throwable> zza = this.zzbod.zza(th, false);
        if (zza == null) {
            AppMethodBeat.o(40334);
            return;
        }
        synchronized (zza) {
            try {
                for (Throwable th2 : zza) {
                    printStream.print("Suppressed: ");
                    th2.printStackTrace(printStream);
                }
            } finally {
                AppMethodBeat.o(40334);
            }
        }
    }
}
