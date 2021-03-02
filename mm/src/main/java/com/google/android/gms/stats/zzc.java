package com.google.android.gms.stats;

import com.google.android.gms.stats.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class zzc implements Runnable {
    private final /* synthetic */ WeakReference zzaej;

    zzc(WeakReference weakReference) {
        this.zzaej = weakReference;
    }

    public final void run() {
        AppMethodBeat.i(73494);
        WakeLock.HeldLock heldLock = (WakeLock.HeldLock) this.zzaej.get();
        if (heldLock != null) {
            heldLock.release(0);
        }
        AppMethodBeat.o(73494);
    }
}
