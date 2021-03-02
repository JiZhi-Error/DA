package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzin implements Runnable {
    private final /* synthetic */ zzie zzaow;
    private final /* synthetic */ zzii zzape;

    zzin(zzii zzii, zzie zzie) {
        this.zzape = zzii;
        this.zzaow = zzie;
    }

    public final void run() {
        AppMethodBeat.i(1849);
        zzey zzey = this.zzape.zzaoy;
        if (zzey == null) {
            this.zzape.zzge().zzim().log("Failed to send current screen to service");
            AppMethodBeat.o(1849);
            return;
        }
        try {
            if (this.zzaow == null) {
                zzey.zza(0, (String) null, (String) null, this.zzape.getContext().getPackageName());
            } else {
                zzey.zza(this.zzaow.zzaoj, this.zzaow.zzul, this.zzaow.zzaoi, this.zzape.getContext().getPackageName());
            }
            zzii.zze(this.zzape);
            AppMethodBeat.o(1849);
        } catch (RemoteException e2) {
            this.zzape.zzge().zzim().zzg("Failed to send current screen to the service", e2);
            AppMethodBeat.o(1849);
        }
    }
}
