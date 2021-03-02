package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzix implements Runnable {
    private final /* synthetic */ zzey zzapm;
    private final /* synthetic */ zziw zzapn;

    zzix(zziw zziw, zzey zzey) {
        this.zzapn = zziw;
        this.zzapm = zzey;
    }

    public final void run() {
        AppMethodBeat.i(1865);
        synchronized (this.zzapn) {
            try {
                this.zzapn.zzapk = false;
                if (!this.zzapn.zzape.isConnected()) {
                    this.zzapn.zzape.zzge().zzit().log("Connected to service");
                    this.zzapn.zzape.zza(this.zzapm);
                }
            } finally {
                AppMethodBeat.o(1865);
            }
        }
    }
}
