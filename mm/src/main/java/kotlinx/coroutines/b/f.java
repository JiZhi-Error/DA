package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.l;
import kotlinx.coroutines.bk;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00020,2\u00020-2\u00020 B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ#\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0011\u001a\u00020\b2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0011\u0010\u0015J#\u0010\u0016\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\u001b\u0010\u0018\u001a\u00020\b2\n\u0010\u0017\u001a\u00060\u000ej\u0002`\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b%\u0010&R \u0010(\u001a\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010\u0005\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b*\u0010&¨\u0006+"}, hxF = {"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "", "parallelism", "taskMode", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;II)V", "", "afterTask", "()V", "close", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "tailDispatch", "(Ljava/lang/Runnable;Z)V", "dispatchYield", "command", "execute", "(Ljava/lang/Runnable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "I", "getParallelism", "()I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getTaskMode", "kotlinx-coroutines-core", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;"})
final class f extends bk implements Executor, j {
    private static final AtomicIntegerFieldUpdater TWU = AtomicIntegerFieldUpdater.newUpdater(f.class, "inFlightTasks");
    private final d TWV;
    private final int TWW;
    private final int gqO = 1;
    private volatile int inFlightTasks = 0;
    private final ConcurrentLinkedQueue<Runnable> vTW = new ConcurrentLinkedQueue<>();

    static {
        AppMethodBeat.i(118040);
        AppMethodBeat.o(118040);
    }

    public f(d dVar, int i2) {
        AppMethodBeat.i(192363);
        this.TWV = dVar;
        this.TWW = i2;
        AppMethodBeat.o(192363);
    }

    @Override // kotlinx.coroutines.b.j
    public final int hOf() {
        return this.gqO;
    }

    @Override // kotlinx.coroutines.bk
    public final Executor getExecutor() {
        return this;
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.i(118033);
        d(runnable, false);
        AppMethodBeat.o(118033);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(118034);
        IllegalStateException illegalStateException = new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
        AppMethodBeat.o(118034);
        throw illegalStateException;
    }

    @Override // kotlinx.coroutines.ad
    public final void a(kotlin.d.f fVar, Runnable runnable) {
        AppMethodBeat.i(118035);
        d(runnable, false);
        AppMethodBeat.o(118035);
    }

    private final void d(Runnable runnable, boolean z) {
        AppMethodBeat.i(118036);
        while (TWU.incrementAndGet(this) > this.TWW) {
            this.vTW.add(runnable);
            if (TWU.decrementAndGet(this) >= this.TWW) {
                AppMethodBeat.o(118036);
                return;
            }
            Runnable poll = this.vTW.poll();
            if (poll == null) {
                AppMethodBeat.o(118036);
                return;
            }
            runnable = poll;
        }
        this.TWV.b(runnable, this, z);
        AppMethodBeat.o(118036);
    }

    @Override // kotlinx.coroutines.ad
    public final String toString() {
        AppMethodBeat.i(118037);
        String str = super.toString() + "[dispatcher = " + this.TWV + ']';
        AppMethodBeat.o(118037);
        return str;
    }

    @Override // kotlinx.coroutines.b.j
    public final void hOe() {
        AppMethodBeat.i(118038);
        Runnable poll = this.vTW.poll();
        if (poll != null) {
            this.TWV.b(poll, this, true);
            AppMethodBeat.o(118038);
            return;
        }
        TWU.decrementAndGet(this);
        Runnable poll2 = this.vTW.poll();
        if (poll2 == null) {
            AppMethodBeat.o(118038);
            return;
        }
        d(poll2, true);
        AppMethodBeat.o(118038);
    }
}
