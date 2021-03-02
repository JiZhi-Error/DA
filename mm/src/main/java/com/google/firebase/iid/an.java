package com.google.firebase.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class an implements Runnable {
    private final aj bMN;
    private final c bMO;

    an(aj ajVar, c cVar) {
        this.bMN = ajVar;
        this.bMO = cVar;
    }

    public final void run() {
        AppMethodBeat.i(4269);
        this.bMN.fz(this.bMO.bLs);
        AppMethodBeat.o(4269);
    }
}
