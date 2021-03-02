package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzn implements Runnable {
    private final /* synthetic */ Task zzafn;
    private final /* synthetic */ zzm zzafx;

    zzn(zzm zzm, Task task) {
        this.zzafx = zzm;
        this.zzafn = task;
    }

    public final void run() {
        AppMethodBeat.i(13400);
        synchronized (zzm.zza(this.zzafx)) {
            try {
                if (zzm.zzb(this.zzafx) != null) {
                    zzm.zzb(this.zzafx).onSuccess(this.zzafn.getResult());
                }
            } finally {
                AppMethodBeat.o(13400);
            }
        }
    }
}
