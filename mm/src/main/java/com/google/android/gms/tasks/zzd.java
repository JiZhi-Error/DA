package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzd implements Runnable {
    private final /* synthetic */ Task zzafn;
    private final /* synthetic */ zzc zzafo;

    zzd(zzc zzc, Task task) {
        this.zzafo = zzc;
        this.zzafn = task;
    }

    public final void run() {
        AppMethodBeat.i(13382);
        if (this.zzafn.isCanceled()) {
            zzc.zza(this.zzafo).zzdp();
            AppMethodBeat.o(13382);
            return;
        }
        try {
            zzc.zza(this.zzafo).setResult(zzc.zzb(this.zzafo).then(this.zzafn));
            AppMethodBeat.o(13382);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                zzc.zza(this.zzafo).setException((Exception) e2.getCause());
                AppMethodBeat.o(13382);
                return;
            }
            zzc.zza(this.zzafo).setException(e2);
            AppMethodBeat.o(13382);
        } catch (Exception e3) {
            zzc.zza(this.zzafo).setException(e3);
            AppMethodBeat.o(13382);
        }
    }
}
