package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl implements Runnable {
    private final /* synthetic */ Task zzafn;
    private final /* synthetic */ zzk zzafv;

    zzl(zzk zzk, Task task) {
        this.zzafv = zzk;
        this.zzafn = task;
    }

    public final void run() {
        AppMethodBeat.i(13397);
        synchronized (zzk.zza(this.zzafv)) {
            try {
                if (zzk.zzb(this.zzafv) != null) {
                    zzk.zzb(this.zzafv).onFailure(this.zzafn.getException());
                }
            } finally {
                AppMethodBeat.o(13397);
            }
        }
    }
}
