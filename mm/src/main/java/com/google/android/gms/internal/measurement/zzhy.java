package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
public final class zzhy implements Runnable {
    private final /* synthetic */ AtomicReference zzanv;
    private final /* synthetic */ zzhk zzanw;

    zzhy(zzhk zzhk, AtomicReference atomicReference) {
        this.zzanw = zzhk;
        this.zzanv = atomicReference;
    }

    public final void run() {
        AppMethodBeat.i(1753);
        synchronized (this.zzanv) {
            try {
                AtomicReference atomicReference = this.zzanv;
                zzef zzgg = this.zzanw.zzgg();
                atomicReference.set(Double.valueOf(zzgg.zzc(zzgg.zzfv().zzah(), zzew.zzaht)));
                try {
                    this.zzanv.notify();
                } finally {
                    AppMethodBeat.o(1753);
                }
            } catch (Throwable th) {
                this.zzanv.notify();
                AppMethodBeat.o(1753);
                throw th;
            }
        }
    }
}
