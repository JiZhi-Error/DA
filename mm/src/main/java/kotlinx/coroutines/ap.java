package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import kotlin.l;
import kotlinx.coroutines.bh;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\r\u0010\u001c\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001dJ\u001c\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\b2\n\u0010!\u001a\u00060\u0002j\u0002`\u0003H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u001aH\u0016J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0004R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00108TX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, hxF = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", "", "_thread", "Ljava/lang/Thread;", "_thread$annotations", "debugStatus", "isShutdownRequested", "", "()Z", "thread", "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "notifyStartup", "run", "shutdown", "timeout", "kotlinx-coroutines-core"})
public final class ap extends bh implements Runnable {
    private static final long TUf;
    public static final ap TUg;
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        Long l;
        AppMethodBeat.i(118144);
        ap apVar = new ap();
        TUg = apVar;
        apVar.EX(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException e2) {
            l = 1000L;
        }
        TUf = timeUnit.toNanos(l.longValue());
        AppMethodBeat.o(118144);
    }

    private ap() {
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.bi
    public final Thread getThread() {
        AppMethodBeat.i(192514);
        Thread thread = _thread;
        if (thread == null) {
            thread = hMO();
        }
        AppMethodBeat.o(192514);
        return thread;
    }

    private static boolean hMN() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 150
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 172
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.ap.run():void");
    }

    private final synchronized Thread hMO() {
        Thread thread;
        AppMethodBeat.i(118140);
        thread = _thread;
        if (thread == null) {
            Thread thread2 = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread2;
            thread2.setDaemon(true);
            thread2.start();
            thread = thread2;
        }
        AppMethodBeat.o(118140);
        return thread;
    }

    private final synchronized boolean hMP() {
        boolean z;
        AppMethodBeat.i(118142);
        if (hMN()) {
            z = false;
            AppMethodBeat.o(118142);
        } else {
            debugStatus = 1;
            notifyAll();
            AppMethodBeat.o(118142);
            z = true;
        }
        return z;
    }

    private final synchronized void hMQ() {
        AppMethodBeat.i(118143);
        if (!hMN()) {
            AppMethodBeat.o(118143);
        } else {
            debugStatus = 3;
            this._queue = null;
            this._delayed = null;
            notifyAll();
            AppMethodBeat.o(118143);
        }
    }

    @Override // kotlinx.coroutines.bh, kotlinx.coroutines.at
    public final bc d(long j2, Runnable runnable) {
        AppMethodBeat.i(192515);
        long Pl = bj.Pl(j2);
        if (Pl < 4611686018427387903L) {
            cq cqVar = cr.TVl;
            long nanoTime = cqVar != null ? cqVar.nanoTime() : System.nanoTime();
            bh.b bVar = new bh.b(Pl + nanoTime, runnable);
            a(nanoTime, bVar);
            bh.b bVar2 = bVar;
            AppMethodBeat.o(192515);
            return bVar2;
        }
        cg cgVar = cg.TVh;
        AppMethodBeat.o(192515);
        return cgVar;
    }
}
