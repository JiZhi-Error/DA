package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* access modifiers changed from: package-private */
public final class zzk<TResult> implements zzq<TResult> {
    private final Object mLock = new Object();
    private final Executor zzafk;
    @GuardedBy("mLock")
    private OnFailureListener zzafu;

    public zzk(Executor executor, OnFailureListener onFailureListener) {
        AppMethodBeat.i(13395);
        this.zzafk = executor;
        this.zzafu = onFailureListener;
        AppMethodBeat.o(13395);
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void cancel() {
        synchronized (this.mLock) {
            this.zzafu = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r3.zzafk.execute(new com.google.android.gms.tasks.zzl(r3, r4));
     */
    @Override // com.google.android.gms.tasks.zzq
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onComplete(com.google.android.gms.tasks.Task<TResult> r4) {
        /*
            r3 = this;
            r2 = 13396(0x3454, float:1.8772E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            boolean r0 = r4.isSuccessful()
            if (r0 != 0) goto L_0x0028
            boolean r0 = r4.isCanceled()
            if (r0 != 0) goto L_0x0028
            java.lang.Object r1 = r3.mLock
            monitor-enter(r1)
            com.google.android.gms.tasks.OnFailureListener r0 = r3.zzafu     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x001d
            monitor-exit(r1)     // Catch:{ all -> 0x002c }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x001c:
            return
        L_0x001d:
            monitor-exit(r1)
            java.util.concurrent.Executor r0 = r3.zzafk
            com.google.android.gms.tasks.zzl r1 = new com.google.android.gms.tasks.zzl
            r1.<init>(r3, r4)
            r0.execute(r1)
        L_0x0028:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x001c
        L_0x002c:
            r0 = move-exception
            monitor-exit(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tasks.zzk.onComplete(com.google.android.gms.tasks.Task):void");
    }
}
