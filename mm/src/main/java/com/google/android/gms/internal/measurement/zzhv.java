package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
public final class zzhv implements Runnable {
    private final /* synthetic */ AtomicReference zzanv;
    private final /* synthetic */ zzhk zzanw;

    zzhv(zzhk zzhk, AtomicReference atomicReference) {
        this.zzanw = zzhk;
        this.zzanv = atomicReference;
    }

    public final void run() {
        AppMethodBeat.i(1750);
        synchronized (this.zzanv) {
            try {
                this.zzanv.set(this.zzanw.zzgg().zzhm());
                try {
                    this.zzanv.notify();
                } finally {
                    AppMethodBeat.o(1750);
                }
            } catch (Throwable th) {
                this.zzanv.notify();
                AppMethodBeat.o(1750);
                throw th;
            }
        }
    }
}
