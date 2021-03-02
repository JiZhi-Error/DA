package kotlinx.coroutines;

import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.d.f;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\r\u0010\u0013\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0014J\u001c\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\fj\u0002`\rH\u0016J*\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 H\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcherBase;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "()V", "removesFutureOnCancellation", "", "close", "", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "initFutureCancellation", "initFutureCancellation$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "scheduleBlock", "Ljava/util/concurrent/ScheduledFuture;", "time", "unit", "Ljava/util/concurrent/TimeUnit;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "", "kotlinx-coroutines-core"})
public abstract class bl extends bk implements at {
    boolean TUJ;

    @Override // kotlinx.coroutines.ad
    public final void a(f fVar, Runnable runnable) {
        Runnable runnable2;
        try {
            Executor executor = getExecutor();
            cq cqVar = cr.TVl;
            if (cqVar == null || (runnable2 = cqVar.hNB()) == null) {
                runnable2 = runnable;
            }
            executor.execute(runnable2);
        } catch (RejectedExecutionException e2) {
            ap.TUg.bd(runnable);
        }
    }

    @Override // kotlinx.coroutines.at
    public final void a(long j2, k<? super x> kVar) {
        ScheduledFuture<?> scheduledFuture;
        if (this.TUJ) {
            scheduledFuture = a(new ck(this, kVar), j2, TimeUnit.MILLISECONDS);
        } else {
            scheduledFuture = null;
        }
        if (scheduledFuture != null) {
            kVar.W(new h(scheduledFuture));
        } else {
            ap.TUg.a(j2, kVar);
        }
    }

    @Override // kotlinx.coroutines.at
    public final bc d(long j2, Runnable runnable) {
        ScheduledFuture<?> scheduledFuture;
        if (this.TUJ) {
            scheduledFuture = a(runnable, j2, TimeUnit.MILLISECONDS);
        } else {
            scheduledFuture = null;
        }
        return scheduledFuture != null ? new bb(scheduledFuture) : ap.TUg.d(j2, runnable);
    }

    private final ScheduledFuture<?> a(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            Executor executor = getExecutor();
            if (!(executor instanceof ScheduledExecutorService)) {
                executor = null;
            }
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) executor;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService.schedule(runnable, j2, timeUnit);
            }
            return null;
        } catch (RejectedExecutionException e2) {
            return null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executor = getExecutor();
        if (!(executor instanceof ExecutorService)) {
            executor = null;
        }
        ExecutorService executorService = (ExecutorService) executor;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.ad
    public String toString() {
        return getExecutor().toString();
    }

    public boolean equals(Object obj) {
        return (obj instanceof bl) && ((bl) obj).getExecutor() == getExecutor();
    }

    public int hashCode() {
        return System.identityHashCode(getExecutor());
    }
}
