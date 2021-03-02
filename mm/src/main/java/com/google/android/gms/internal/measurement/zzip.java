package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzip implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzii zzape;

    zzip(zzii zzii, zzdz zzdz) {
        this.zzape = zzii;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.i(1851);
        zzey zzey = this.zzape.zzaoy;
        if (zzey == null) {
            this.zzape.zzge().zzim().log("Failed to send measurementEnabled to service");
            AppMethodBeat.o(1851);
            return;
        }
        try {
            zzey.zzb(this.zzane);
            zzii.zze(this.zzape);
            AppMethodBeat.o(1851);
        } catch (RemoteException e2) {
            this.zzape.zzge().zzim().zzg("Failed to send measurementEnabled to the service", e2);
            AppMethodBeat.o(1851);
        }
    }
}
