package com.google.android.gms.common.api.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzak implements Runnable {
    private final /* synthetic */ zzaj zzhv;

    zzak(zzaj zzaj) {
        this.zzhv = zzaj;
    }

    public final void run() {
        AppMethodBeat.i(11241);
        zzaj.zzb(this.zzhv).cancelAvailabilityErrorNotifications(zzaj.zza(this.zzhv));
        AppMethodBeat.o(11241);
    }
}
