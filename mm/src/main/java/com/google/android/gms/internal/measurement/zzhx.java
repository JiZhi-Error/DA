package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
public final class zzhx implements Runnable {
    private final /* synthetic */ AtomicReference zzanv;
    private final /* synthetic */ zzhk zzanw;

    zzhx(zzhk zzhk, AtomicReference atomicReference) {
        this.zzanw = zzhk;
        this.zzanv = atomicReference;
    }

    public final void run() {
        AppMethodBeat.i(1752);
        synchronized (this.zzanv) {
            try {
                AtomicReference atomicReference = this.zzanv;
                zzef zzgg = this.zzanw.zzgg();
                atomicReference.set(Integer.valueOf(zzgg.zzb(zzgg.zzfv().zzah(), zzew.zzahs)));
                try {
                    this.zzanv.notify();
                } finally {
                    AppMethodBeat.o(1752);
                }
            } catch (Throwable th) {
                this.zzanv.notify();
                AppMethodBeat.o(1752);
                throw th;
            }
        }
    }
}
