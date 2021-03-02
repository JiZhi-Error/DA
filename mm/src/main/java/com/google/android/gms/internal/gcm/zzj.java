package com.google.android.gms.internal.gcm;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzj extends zzg {
    private final zzh zzdi = new zzh();

    zzj() {
        AppMethodBeat.i(2584);
        AppMethodBeat.o(2584);
    }

    @Override // com.google.android.gms.internal.gcm.zzg
    public final void zzd(Throwable th, Throwable th2) {
        AppMethodBeat.i(2585);
        if (th2 == th) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Self suppression is not allowed.", th2);
            AppMethodBeat.o(2585);
            throw illegalArgumentException;
        } else if (th2 == null) {
            NullPointerException nullPointerException = new NullPointerException("The suppressed exception cannot be null.");
            AppMethodBeat.o(2585);
            throw nullPointerException;
        } else {
            this.zzdi.zzd(th, true).add(th2);
            AppMethodBeat.o(2585);
        }
    }
}
