package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* access modifiers changed from: package-private */
public final class zzi<TResult> implements zzq<TResult> {
    private final Object mLock = new Object();
    private final Executor zzafk;
    @GuardedBy("mLock")
    private OnCompleteListener<TResult> zzafs;

    public zzi(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        AppMethodBeat.i(13392);
        this.zzafk = executor;
        this.zzafs = onCompleteListener;
        AppMethodBeat.o(13392);
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void cancel() {
        synchronized (this.mLock) {
            this.zzafs = null;
        }
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void onComplete(Task<TResult> task) {
        AppMethodBeat.i(13393);
        synchronized (this.mLock) {
            try {
                if (this.zzafs != null) {
                    this.zzafk.execute(new zzj(this, task));
                    AppMethodBeat.o(13393);
                }
            } finally {
                AppMethodBeat.o(13393);
            }
        }
    }
}
