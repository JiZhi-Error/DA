package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0000\u0018\u00002\u00020\fB%\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/coroutines/Continuation;", "continuation", "", "cause", "", "handled", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "makeResumed", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/CompletedExceptionally;"})
public final class o extends v {
    private static final AtomicIntegerFieldUpdater TTF = AtomicIntegerFieldUpdater.newUpdater(o.class, "_resumed");
    private volatile int _resumed;

    static {
        AppMethodBeat.i(192408);
        AppMethodBeat.o(192408);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public o(kotlin.d.d<?> r5, java.lang.Throwable r6, boolean r7) {
        /*
            r4 = this;
            r3 = 192407(0x2ef97, float:2.6962E-40)
            if (r6 != 0) goto L_0x0030
            java.util.concurrent.CancellationException r0 = new java.util.concurrent.CancellationException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Continuation "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r2 = " was cancelled normally"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
        L_0x0023:
            r4.<init>(r0, r7)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            r0 = 0
            r4._resumed = r0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return
        L_0x0030:
            r0 = r6
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.o.<init>(kotlin.d.d, java.lang.Throwable, boolean):void");
    }

    public final boolean hMA() {
        AppMethodBeat.i(192406);
        boolean compareAndSet = TTF.compareAndSet(this, 0, 1);
        AppMethodBeat.o(192406);
        return compareAndSet;
    }
}
