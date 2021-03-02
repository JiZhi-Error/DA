package com.google.firebase.iid;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class x implements Runnable {
    private final /* synthetic */ u bMl;
    private final /* synthetic */ w bMm;

    x(w wVar, u uVar) {
        this.bMm = wVar;
        this.bMl = uVar;
    }

    public final void run() {
        AppMethodBeat.i(4213);
        Log.isLoggable("EnhancedIntentService", 3);
        this.bMm.bMk.f(this.bMl.intent);
        this.bMl.finish();
        AppMethodBeat.o(4213);
    }
}
