package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.l;
import kotlinx.coroutines.bh;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0004J\b\u0010\r\u001a\u00020\bH\u0004R\u0012\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, hxF = {"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "()V", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "reschedule", "", "now", "", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "unpark", "kotlinx-coroutines-core"})
public abstract class bi extends bg {
    /* access modifiers changed from: protected */
    public abstract Thread getThread();

    /* access modifiers changed from: protected */
    public final void hNg() {
        Thread thread = getThread();
        if (Thread.currentThread() != thread && cr.TVl == null) {
            LockSupport.unpark(thread);
        }
    }

    /* access modifiers changed from: protected */
    public final void c(long j2, bh.c cVar) {
        if (an.hMK()) {
            if (!(this != ap.TUg)) {
                throw new AssertionError();
            }
        }
        ap.TUg.a(j2, cVar);
    }
}
