package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
public final class zzv implements Runnable {
    private final /* synthetic */ Callable val$callable;
    private final /* synthetic */ zzu zzagj;

    zzv(zzu zzu, Callable callable) {
        this.zzagj = zzu;
        this.val$callable = callable;
    }

    public final void run() {
        AppMethodBeat.i(13446);
        try {
            this.zzagj.setResult(this.val$callable.call());
            AppMethodBeat.o(13446);
        } catch (Exception e2) {
            this.zzagj.setException(e2);
            AppMethodBeat.o(13446);
        }
    }
}
