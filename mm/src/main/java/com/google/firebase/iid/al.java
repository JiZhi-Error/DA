package com.google.firebase.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final /* synthetic */ class al implements Runnable {
    private final aj bMN;

    al(aj ajVar) {
        this.bMN = ajVar;
    }

    public final void run() {
        AppMethodBeat.i(4267);
        this.bMN.zzv();
        AppMethodBeat.o(4267);
    }
}
