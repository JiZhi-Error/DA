package com.google.android.gms.internal.measurement;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzhs implements Runnable {
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ AppMeasurement.ConditionalUserProperty zzaob;

    zzhs(zzhk zzhk, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.zzanw = zzhk;
        this.zzaob = conditionalUserProperty;
    }

    public final void run() {
        AppMethodBeat.i(1747);
        zzhk.zzb(this.zzanw, this.zzaob);
        AppMethodBeat.o(1747);
    }
}
