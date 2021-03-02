package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzh implements Runnable {
    private final /* synthetic */ zzg zzafr;

    zzh(zzg zzg) {
        this.zzafr = zzg;
    }

    public final void run() {
        AppMethodBeat.i(13391);
        synchronized (zzg.zza(this.zzafr)) {
            try {
                if (zzg.zzb(this.zzafr) != null) {
                    zzg.zzb(this.zzafr).onCanceled();
                }
            } finally {
                AppMethodBeat.o(13391);
            }
        }
    }
}
