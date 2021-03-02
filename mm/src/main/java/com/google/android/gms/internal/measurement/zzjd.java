package com.google.android.gms.internal.measurement;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzjd implements Runnable {
    private final int zzabp;
    private final zzjc zzapp;
    private final zzfg zzapq;
    private final Intent zzapr;

    zzjd(zzjc zzjc, int i2, zzfg zzfg, Intent intent) {
        this.zzapp = zzjc;
        this.zzabp = i2;
        this.zzapq = zzfg;
        this.zzapr = intent;
    }

    public final void run() {
        AppMethodBeat.i(1883);
        this.zzapp.zza(this.zzabp, this.zzapq, this.zzapr);
        AppMethodBeat.o(1883);
    }
}
