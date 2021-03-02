package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzim implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzii zzape;

    zzim(zzii zzii, zzdz zzdz) {
        this.zzape = zzii;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.i(1848);
        zzey zzey = this.zzape.zzaoy;
        if (zzey == null) {
            this.zzape.zzge().zzim().log("Discarding data. Failed to send app launch");
            AppMethodBeat.o(1848);
            return;
        }
        try {
            zzey.zza(this.zzane);
            this.zzape.zza(zzey, null, this.zzane);
            zzii.zze(this.zzape);
            AppMethodBeat.o(1848);
        } catch (RemoteException e2) {
            this.zzape.zzge().zzim().zzg("Failed to send app launch to the service", e2);
            AppMethodBeat.o(1848);
        }
    }
}
