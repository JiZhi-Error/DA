package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.concurrent.atomic.AtomicLong;
import rx.f;

public final class b extends AtomicLong implements f {
    boolean Ukt;
    final a UmX;
    Throwable exception;
    public volatile boolean terminated;

    public interface a {
        void Q(Throwable th);

        boolean accept(Object obj);

        Object peek();

        Object poll();
    }

    public b(a aVar) {
        this.UmX = aVar;
    }

    public final void S(Throwable th) {
        AppMethodBeat.i(90199);
        if (!this.terminated) {
            this.exception = th;
            this.terminated = true;
            drain();
        }
        AppMethodBeat.o(90199);
    }

    @Override // rx.f
    public final void Pw(long j2) {
        long j3;
        boolean z;
        long j4;
        AppMethodBeat.i(90200);
        if (j2 == 0) {
            AppMethodBeat.o(90200);
            return;
        }
        do {
            j3 = get();
            z = j3 == 0;
            if (j3 == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                break;
            } else if (j2 == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                j4 = j2;
                z = true;
            } else if (j3 > MAlarmHandler.NEXT_FIRE_INTERVAL - j2) {
                j4 = Long.MAX_VALUE;
            } else {
                j4 = j3 + j2;
            }
        } while (!compareAndSet(j3, j4));
        if (z) {
            drain();
        }
        AppMethodBeat.o(90200);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r8 = r9.UmX;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        r5 = 0;
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        if (r6 > 0) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        if (r2 == false) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        if (r2 == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
        if (r8.peek() != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        r8.Q(r9.exception);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(90201);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004d, code lost:
        if (r6 == 0) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004f, code lost:
        r0 = r8.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
        if (r0 == null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
        if (r8.accept(r0) == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005b, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(90201);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0062, code lost:
        r6 = r6 - 1;
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0069, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r2 = r9.terminated;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0070, code lost:
        if (r8.peek() == null) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0072, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007f, code lost:
        if (get() != com.tencent.mm.sdk.platformtools.MAlarmHandler.NEXT_FIRE_INTERVAL) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0081, code lost:
        if (r4 != false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0083, code lost:
        if (r2 != false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0085, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r9.Ukt = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0089, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008a, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(90201);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0091, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0094, code lost:
        r0 = com.tencent.mm.sdk.platformtools.MAlarmHandler.NEXT_FIRE_INTERVAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0099, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x009b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009c, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009d, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(90201);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a4, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a5, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00a6, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00a7, code lost:
        if (r3 == false) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a9, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r9.Ukt = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00b4, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00b5, code lost:
        r0 = addAndGet((long) (-r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00bf, code lost:
        if (r0 == 0) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00c1, code lost:
        if (r4 != false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00c3, code lost:
        if (r2 == false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00c5, code lost:
        if (r4 == false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00c7, code lost:
        r9.Ukt = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00cb, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00cc, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(90201);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00d4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00d6, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(90201);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00dc, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00dd, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00df, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        r0 = get();
        r3 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void drain() {
        /*
        // Method dump skipped, instructions count: 225
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.b.drain():void");
    }
}
