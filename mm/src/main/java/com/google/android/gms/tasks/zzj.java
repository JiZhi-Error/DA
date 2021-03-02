package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzj implements Runnable {
    private final /* synthetic */ Task zzafn;
    private final /* synthetic */ zzi zzaft;

    zzj(zzi zzi, Task task) {
        this.zzaft = zzi;
        this.zzafn = task;
    }

    public final void run() {
        AppMethodBeat.i(13394);
        synchronized (zzi.zza(this.zzaft)) {
            try {
                if (zzi.zzb(this.zzaft) != null) {
                    zzi.zzb(this.zzaft).onComplete(this.zzafn);
                }
            } finally {
                AppMethodBeat.o(13394);
            }
        }
    }
}
