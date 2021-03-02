package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzhq implements Runnable {
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ long zzaoa;

    zzhq(zzhk zzhk, long j2) {
        this.zzanw = zzhk;
        this.zzaoa = j2;
    }

    public final void run() {
        boolean z = true;
        AppMethodBeat.i(1745);
        zzhk zzhk = this.zzanw;
        long j2 = this.zzaoa;
        zzhk.zzab();
        zzhk.zzch();
        zzhk.zzge().zzis().log("Resetting analytics data (FE)");
        zzhk.zzgc().zzkj();
        if (zzhk.zzgg().zzba(zzhk.zzfv().zzah())) {
            zzhk.zzgf().zzajz.set(j2);
        }
        boolean isEnabled = zzhk.zzacw.isEnabled();
        if (!zzhk.zzgg().zzhg()) {
            zzhk.zzgf().zzh(!isEnabled);
        }
        zzhk.zzfx().resetAnalyticsData();
        if (isEnabled) {
            z = false;
        }
        zzhk.zzanu = z;
        AppMethodBeat.o(1745);
    }
}
