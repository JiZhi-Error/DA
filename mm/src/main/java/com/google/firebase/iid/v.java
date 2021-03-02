package com.google.firebase.iid;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class v implements Runnable {
    private final /* synthetic */ Intent bMe;
    private final /* synthetic */ u bMj;

    v(u uVar, Intent intent) {
        this.bMj = uVar;
        this.bMe = intent;
    }

    public final void run() {
        AppMethodBeat.i(4212);
        String action = this.bMe.getAction();
        new StringBuilder(String.valueOf(action).length() + 61).append("Service took too long to process intent: ").append(action).append(" App may get closed.");
        this.bMj.finish();
        AppMethodBeat.o(4212);
    }
}
