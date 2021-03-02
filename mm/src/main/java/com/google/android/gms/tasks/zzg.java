package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* access modifiers changed from: package-private */
public final class zzg<TResult> implements zzq<TResult> {
    private final Object mLock = new Object();
    private final Executor zzafk;
    @GuardedBy("mLock")
    private OnCanceledListener zzafq;

    public zzg(Executor executor, OnCanceledListener onCanceledListener) {
        AppMethodBeat.i(13389);
        this.zzafk = executor;
        this.zzafq = onCanceledListener;
        AppMethodBeat.o(13389);
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void cancel() {
        synchronized (this.mLock) {
            this.zzafq = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        r3.zzafk.execute(new com.google.android.gms.tasks.zzh(r3));
     */
    @Override // com.google.android.gms.tasks.zzq
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onComplete(com.google.android.gms.tasks.Task r4) {
        /*
            r3 = this;
            r2 = 13390(0x344e, float:1.8763E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            boolean r0 = r4.isCanceled()
            if (r0 == 0) goto L_0x0022
            java.lang.Object r1 = r3.mLock
            monitor-enter(r1)
            com.google.android.gms.tasks.OnCanceledListener r0 = r3.zzafq     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x0017
            monitor-exit(r1)     // Catch:{ all -> 0x0026 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0016:
            return
        L_0x0017:
            monitor-exit(r1)
            java.util.concurrent.Executor r0 = r3.zzafk
            com.google.android.gms.tasks.zzh r1 = new com.google.android.gms.tasks.zzh
            r1.<init>(r3)
            r0.execute(r1)
        L_0x0022:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0016
        L_0x0026:
            r0 = move-exception
            monitor-exit(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tasks.zzg.onComplete(com.google.android.gms.tasks.Task):void");
    }
}
