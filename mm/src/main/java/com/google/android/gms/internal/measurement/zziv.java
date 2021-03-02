package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
public final class zziv implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ boolean zzanz;
    private final /* synthetic */ zzii zzape;
    private final /* synthetic */ AtomicReference zzapf;

    zziv(zzii zzii, AtomicReference atomicReference, zzdz zzdz, boolean z) {
        this.zzape = zzii;
        this.zzapf = atomicReference;
        this.zzane = zzdz;
        this.zzanz = z;
    }

    public final void run() {
        AppMethodBeat.i(1857);
        synchronized (this.zzapf) {
            try {
                zzey zzey = this.zzape.zzaoy;
                if (zzey == null) {
                    this.zzape.zzge().zzim().log("Failed to get user properties");
                    try {
                        this.zzapf.notify();
                    } finally {
                        AppMethodBeat.o(1857);
                    }
                } else {
                    this.zzapf.set(zzey.zza(this.zzane, this.zzanz));
                    zzii.zze(this.zzape);
                    this.zzapf.notify();
                    AppMethodBeat.o(1857);
                }
            } catch (RemoteException e2) {
                this.zzape.zzge().zzim().zzg("Failed to get user properties", e2);
                this.zzapf.notify();
            } catch (Throwable th) {
                this.zzapf.notify();
                AppMethodBeat.o(1857);
                throw th;
            }
        }
    }
}
