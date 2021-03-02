package com.google.firebase.iid;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t implements Runnable {
    private final /* synthetic */ Intent bMe;
    private final /* synthetic */ Intent bMf;
    private final /* synthetic */ zzb bMg;

    t(zzb zzb, Intent intent, Intent intent2) {
        this.bMg = zzb;
        this.bMe = intent;
        this.bMf = intent2;
    }

    public final void run() {
        AppMethodBeat.i(4209);
        this.bMg.f(this.bMe);
        this.bMg.g(this.bMf);
        AppMethodBeat.o(4209);
    }
}
