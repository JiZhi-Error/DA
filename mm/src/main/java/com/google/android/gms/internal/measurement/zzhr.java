package com.google.android.gms.internal.measurement;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzhr implements Runnable {
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ AppMeasurement.ConditionalUserProperty zzaob;

    zzhr(zzhk zzhk, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.zzanw = zzhk;
        this.zzaob = conditionalUserProperty;
    }

    public final void run() {
        AppMethodBeat.i(1746);
        zzhk.zza(this.zzanw, this.zzaob);
        AppMethodBeat.o(1746);
    }
}
