package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* access modifiers changed from: package-private */
public final class zzr<TResult> {
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    private Queue<zzq<TResult>> zzaga;
    @GuardedBy("mLock")
    private boolean zzagb;

    zzr() {
        AppMethodBeat.i(13407);
        AppMethodBeat.o(13407);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        r1 = r3.mLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0 = r3.zzaga.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        if (r0 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        r3.zzagb = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0034, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0035, code lost:
        r0.onComplete(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0039, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(13409);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.tasks.Task<TResult> r4) {
        /*
            r3 = this;
            r2 = 13409(0x3461, float:1.879E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            java.lang.Object r1 = r3.mLock
            monitor-enter(r1)
            java.util.Queue<com.google.android.gms.tasks.zzq<TResult>> r0 = r3.zzaga     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x0010
            boolean r0 = r3.zzagb     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x0015
        L_0x0010:
            monitor-exit(r1)     // Catch:{ all -> 0x002e }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0014:
            return
        L_0x0015:
            r0 = 1
            r3.zzagb = r0
            monitor-exit(r1)
        L_0x0019:
            java.lang.Object r1 = r3.mLock
            monitor-enter(r1)
            java.util.Queue<com.google.android.gms.tasks.zzq<TResult>> r0 = r3.zzaga     // Catch:{ all -> 0x0039 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0039 }
            com.google.android.gms.tasks.zzq r0 = (com.google.android.gms.tasks.zzq) r0     // Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x0034
            r0 = 0
            r3.zzagb = r0     // Catch:{ all -> 0x0039 }
            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0014
        L_0x002e:
            r0 = move-exception
            monitor-exit(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0034:
            monitor-exit(r1)
            r0.onComplete(r4)
            goto L_0x0019
        L_0x0039:
            r0 = move-exception
            monitor-exit(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tasks.zzr.zza(com.google.android.gms.tasks.Task):void");
    }

    public final void zza(zzq<TResult> zzq) {
        AppMethodBeat.i(13408);
        synchronized (this.mLock) {
            try {
                if (this.zzaga == null) {
                    this.zzaga = new ArrayDeque();
                }
                this.zzaga.add(zzq);
            } finally {
                AppMethodBeat.o(13408);
            }
        }
    }
}
