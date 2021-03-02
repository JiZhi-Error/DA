package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzf implements Runnable {
    private final /* synthetic */ Task zzafn;
    private final /* synthetic */ zze zzafp;

    zzf(zze zze, Task task) {
        this.zzafp = zze;
        this.zzafn = task;
    }

    public final void run() {
        AppMethodBeat.i(13388);
        try {
            Task task = (Task) zze.zza(this.zzafp).then(this.zzafn);
            if (task == null) {
                this.zzafp.onFailure(new NullPointerException("Continuation returned null"));
                AppMethodBeat.o(13388);
                return;
            }
            task.addOnSuccessListener(TaskExecutors.zzagd, this.zzafp);
            task.addOnFailureListener(TaskExecutors.zzagd, this.zzafp);
            task.addOnCanceledListener(TaskExecutors.zzagd, this.zzafp);
            AppMethodBeat.o(13388);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                zze.zzb(this.zzafp).setException((Exception) e2.getCause());
                AppMethodBeat.o(13388);
                return;
            }
            zze.zzb(this.zzafp).setException(e2);
            AppMethodBeat.o(13388);
        } catch (Exception e3) {
            zze.zzb(this.zzafp).setException(e3);
            AppMethodBeat.o(13388);
        }
    }
}
