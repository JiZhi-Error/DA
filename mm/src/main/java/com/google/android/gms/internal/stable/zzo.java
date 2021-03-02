package com.google.android.gms.internal.stable;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzo extends zzl {
    private final zzm zzahm = new zzm();

    zzo() {
        AppMethodBeat.i(5521);
        AppMethodBeat.o(5521);
    }

    @Override // com.google.android.gms.internal.stable.zzl
    public final void zza(Throwable th, Throwable th2) {
        AppMethodBeat.i(5522);
        if (th2 == th) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Self suppression is not allowed.", th2);
            AppMethodBeat.o(5522);
            throw illegalArgumentException;
        } else if (th2 == null) {
            NullPointerException nullPointerException = new NullPointerException("The suppressed exception cannot be null.");
            AppMethodBeat.o(5522);
            throw nullPointerException;
        } else {
            this.zzahm.zza(th, true).add(th2);
            AppMethodBeat.o(5522);
        }
    }
}
