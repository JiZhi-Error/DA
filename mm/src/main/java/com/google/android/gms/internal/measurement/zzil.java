package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
public final class zzil implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzii zzape;
    private final /* synthetic */ AtomicReference zzapf;

    zzil(zzii zzii, AtomicReference atomicReference, zzdz zzdz) {
        this.zzape = zzii;
        this.zzapf = atomicReference;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.i(1847);
        synchronized (this.zzapf) {
            try {
                zzey zzey = this.zzape.zzaoy;
                if (zzey == null) {
                    this.zzape.zzge().zzim().log("Failed to get app instance id");
                    try {
                        this.zzapf.notify();
                    } finally {
                        AppMethodBeat.o(1847);
                    }
                } else {
                    this.zzapf.set(zzey.zzc(this.zzane));
                    String str = (String) this.zzapf.get();
                    if (str != null) {
                        this.zzape.zzfu().zzbr(str);
                        this.zzape.zzgf().zzakb.zzbs(str);
                    }
                    zzii.zze(this.zzape);
                    this.zzapf.notify();
                    AppMethodBeat.o(1847);
                }
            } catch (RemoteException e2) {
                this.zzape.zzge().zzim().zzg("Failed to get app instance id", e2);
                this.zzapf.notify();
            } catch (Throwable th) {
                this.zzapf.notify();
                AppMethodBeat.o(1847);
                throw th;
            }
        }
    }
}
