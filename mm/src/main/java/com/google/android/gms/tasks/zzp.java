package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;

final class zzp implements Runnable {
    private final /* synthetic */ Task zzafn;
    private final /* synthetic */ zzo zzafz;

    zzp(zzo zzo, Task task) {
        this.zzafz = zzo;
        this.zzafn = task;
    }

    public final void run() {
        AppMethodBeat.i(13406);
        try {
            Task then = zzo.zza(this.zzafz).then(this.zzafn.getResult());
            if (then == null) {
                this.zzafz.onFailure(new NullPointerException("Continuation returned null"));
                AppMethodBeat.o(13406);
                return;
            }
            then.addOnSuccessListener(TaskExecutors.zzagd, this.zzafz);
            then.addOnFailureListener(TaskExecutors.zzagd, this.zzafz);
            then.addOnCanceledListener(TaskExecutors.zzagd, this.zzafz);
            AppMethodBeat.o(13406);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.zzafz.onFailure((Exception) e2.getCause());
                AppMethodBeat.o(13406);
                return;
            }
            this.zzafz.onFailure(e2);
            AppMethodBeat.o(13406);
        } catch (CancellationException e3) {
            this.zzafz.onCanceled();
            AppMethodBeat.o(13406);
        } catch (Exception e4) {
            this.zzafz.onFailure(e4);
            AppMethodBeat.o(13406);
        }
    }
}
