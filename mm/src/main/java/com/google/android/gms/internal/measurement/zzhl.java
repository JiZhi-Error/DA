package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
public final class zzhl implements Runnable {
    private final /* synthetic */ AtomicReference zzanv;
    private final /* synthetic */ zzhk zzanw;

    zzhl(zzhk zzhk, AtomicReference atomicReference) {
        this.zzanw = zzhk;
        this.zzanv = atomicReference;
    }

    public final void run() {
        AppMethodBeat.i(1740);
        synchronized (this.zzanv) {
            try {
                this.zzanv.set(Boolean.valueOf(this.zzanw.zzgg().zzhl()));
                try {
                    this.zzanv.notify();
                } finally {
                    AppMethodBeat.o(1740);
                }
            } catch (Throwable th) {
                this.zzanv.notify();
                AppMethodBeat.o(1740);
                throw th;
            }
        }
    }
}
