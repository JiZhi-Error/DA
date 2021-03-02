package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzik implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzii zzape;

    zzik(zzii zzii, zzdz zzdz) {
        this.zzape = zzii;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.i(1846);
        zzey zzey = this.zzape.zzaoy;
        if (zzey == null) {
            this.zzape.zzge().zzim().log("Failed to reset data on the service; null service");
            AppMethodBeat.o(1846);
            return;
        }
        try {
            zzey.zzd(this.zzane);
        } catch (RemoteException e2) {
            this.zzape.zzge().zzim().zzg("Failed to reset data on the service", e2);
        }
        zzii.zze(this.zzape);
        AppMethodBeat.o(1846);
    }
}
