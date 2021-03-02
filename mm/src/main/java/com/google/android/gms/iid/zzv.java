package com.google.android.gms.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzv implements Runnable {
    private final zzt zzch;

    zzv(zzt zzt) {
        this.zzch = zzt;
    }

    public final void run() {
        AppMethodBeat.i(2568);
        this.zzch.zzt();
        AppMethodBeat.o(2568);
    }
}
