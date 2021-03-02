package kotlinx.coroutines.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.g.b.p;
import kotlin.j.c;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.an;
import kotlinx.coroutines.internal.u;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0000\u0018\u0000 \\2\u00020`2\u00020a:\u0003\\]^B+\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001f\u001a\u00020\n2\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010 \u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\b¢\u0006\u0004\b \u0010\u0011J\u0015\u0010\"\u001a\b\u0018\u00010!R\u00020\u0000H\u0002¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0013H\b¢\u0006\u0004\b$\u0010\u0015J\u0010\u0010%\u001a\u00020\u0001H\b¢\u0006\u0004\b%\u0010\u0017J-\u0010'\u001a\u00020\u00132\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020\f¢\u0006\u0004\b'\u0010(J\u001b\u0010*\u001a\u00020\u00132\n\u0010)\u001a\u00060\u0018j\u0002`\u0019H\u0016¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0004H\b¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0001H\b¢\u0006\u0004\b.\u0010\u0017J\u001b\u00100\u001a\u00020\u00012\n\u0010/\u001a\u00060!R\u00020\u0000H\u0002¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\b\u0018\u00010!R\u00020\u0000H\u0002¢\u0006\u0004\b2\u0010#J\u001b\u00105\u001a\u00020\f2\n\u0010/\u001a\u00060!R\u00020\u0000H\u0000¢\u0006\u0004\b3\u00104J+\u0010:\u001a\u00020\u00132\n\u0010/\u001a\u00060!R\u00020\u00002\u0006\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u0001H\u0000¢\u0006\u0004\b8\u00109J\u0010\u0010;\u001a\u00020\u0004H\b¢\u0006\u0004\b;\u0010-J\u0015\u0010<\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u0004¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\u00132\u0006\u0010A\u001a\u00020\fH\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020\u0013H\u0000¢\u0006\u0004\bD\u0010\u0015J\u000f\u0010F\u001a\u00020\u0006H\u0016¢\u0006\u0004\bF\u0010GJ\u0010\u0010H\u001a\u00020\fH\b¢\u0006\u0004\bH\u0010IJ\u0019\u0010J\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\fH\u0002¢\u0006\u0004\bL\u0010IJ+\u0010M\u001a\u0004\u0018\u00010\n*\b\u0018\u00010!R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\bM\u0010NR\u0017\u0010\u0010\u001a\u00020\u00018Â\u0002@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010PR\u0017\u0010 \u001a\u00020\u00018Â\u0002@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u0017R\u0016\u0010S\u001a\u00020R8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020R8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bU\u0010TR\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010VR\u0013\u0010W\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\bW\u0010IR\u0016\u0010\u0003\u001a\u00020\u00018\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010PR\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010XR\"\u0010Z\u001a\u000e\u0012\n\u0012\b\u0018\u00010!R\u00020\u00000Y8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006_"}, hxF = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createTask", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "parkedWorkersStackPush", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "parkedWorkersStackTopUpdate", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork$kotlinx_coroutines_core", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"})
public final class a implements Closeable, Executor {
    public static final u TWC = new u("NOT_IN_STACK");
    public static final C2379a TWD = new C2379a((byte) 0);
    static final AtomicLongFieldUpdater TWw = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
    static final AtomicLongFieldUpdater TWy = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
    private static final AtomicIntegerFieldUpdater TWz = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");
    public final int RUr;
    public final long TWA;
    public final String TWB;
    public final e TWu;
    public final e TWv;
    public final AtomicReferenceArray<b> TWx;
    volatile int _isTerminated;
    volatile long controlState;
    public final int dvP;
    volatile long parkedWorkersStack;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, hxF = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"})
    public enum c {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED;

        static {
            AppMethodBeat.i(118012);
            AppMethodBeat.o(118012);
        }

        public static c valueOf(String str) {
            AppMethodBeat.i(118014);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(118014);
            return cVar;
        }
    }

    public a(int i2, int i3, long j2, String str) {
        boolean z = true;
        AppMethodBeat.i(118005);
        this.dvP = i2;
        this.RUr = i3;
        this.TWA = j2;
        this.TWB = str;
        if (!(this.dvP > 0)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("Core pool size " + this.dvP + " should be at least 1").toString());
            AppMethodBeat.o(118005);
            throw illegalArgumentException;
        }
        if (!(this.RUr >= this.dvP)) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(("Max pool size " + this.RUr + " should be greater than or equals to core pool size " + this.dvP).toString());
            AppMethodBeat.o(118005);
            throw illegalArgumentException2;
        }
        if (!(this.RUr <= 2097150)) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(("Max pool size " + this.RUr + " should not exceed maximal supported number of threads 2097150").toString());
            AppMethodBeat.o(118005);
            throw illegalArgumentException3;
        }
        if (!(this.TWA <= 0 ? false : z)) {
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(("Idle worker keep alive time " + this.TWA + " must be positive").toString());
            AppMethodBeat.o(118005);
            throw illegalArgumentException4;
        }
        this.TWu = new e();
        this.TWv = new e();
        this.parkedWorkersStack = 0;
        this.TWx = new AtomicReferenceArray<>(this.RUr + 1);
        this.controlState = ((long) this.dvP) << 42;
        this._isTerminated = 0;
        AppMethodBeat.o(118005);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.b.a$a  reason: collision with other inner class name */
    public static final class C2379a {
        private C2379a() {
        }

        public /* synthetic */ C2379a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(118011);
        AppMethodBeat.o(118011);
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.i(117995);
        a(this, runnable);
        AppMethodBeat.o(117995);
    }

    public static /* synthetic */ void a(a aVar, Runnable runnable) {
        AppMethodBeat.i(117998);
        aVar.a(runnable, (j) h.TWY, false);
        AppMethodBeat.o(117998);
    }

    public final void a(Runnable runnable, j jVar, boolean z) {
        i a2;
        boolean z2;
        boolean gg;
        boolean z3 = true;
        AppMethodBeat.i(117997);
        i a3 = a(runnable, jVar);
        b hNZ = hNZ();
        if (hNZ == null) {
            a2 = a3;
        } else if (hNZ.TWF == c.TERMINATED) {
            a2 = a3;
        } else if (a3.TXa.hOf() == 0 && hNZ.TWF == c.BLOCKING) {
            a2 = a3;
        } else {
            hNZ.TWK = true;
            a2 = hNZ.TWE.a(a3, z);
        }
        if (a2 != null) {
            if (a2.TXa.hOf() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                gg = this.TWv.gg(a2);
            } else {
                gg = this.TWu.gg(a2);
            }
            if (!gg) {
                RejectedExecutionException rejectedExecutionException = new RejectedExecutionException(this.TWB + " was terminated");
                AppMethodBeat.o(117997);
                throw rejectedExecutionException;
            }
        }
        if (!z || hNZ == null) {
            z3 = false;
        }
        if (a3.TXa.hOf() != 0) {
            long addAndGet = TWy.addAndGet(this, 2097152);
            if (!z3 && !hNX() && !Pp(addAndGet)) {
                hNX();
            }
            AppMethodBeat.o(117997);
        } else if (z3) {
            AppMethodBeat.o(117997);
        } else {
            hNW();
            AppMethodBeat.o(117997);
        }
    }

    public static i a(Runnable runnable, j jVar) {
        AppMethodBeat.i(117999);
        long nanoTime = l.TXe.nanoTime();
        if (runnable instanceof i) {
            ((i) runnable).TWZ = nanoTime;
            ((i) runnable).TXa = jVar;
            i iVar = (i) runnable;
            AppMethodBeat.o(117999);
            return iVar;
        }
        k kVar = new k(runnable, nanoTime, jVar);
        AppMethodBeat.o(117999);
        return kVar;
    }

    public final void hNW() {
        AppMethodBeat.i(192365);
        if (hNX()) {
            AppMethodBeat.o(192365);
        } else if (a(this)) {
            AppMethodBeat.o(192365);
        } else {
            hNX();
            AppMethodBeat.o(192365);
        }
    }

    private static /* synthetic */ boolean a(a aVar) {
        AppMethodBeat.i(192367);
        boolean Pp = aVar.Pp(aVar.controlState);
        AppMethodBeat.o(192367);
        return Pp;
    }

    private final boolean hNX() {
        b hNV;
        AppMethodBeat.i(118001);
        do {
            hNV = hNV();
            if (hNV == null) {
                AppMethodBeat.o(118001);
                return false;
            }
        } while (!b.TWG.compareAndSet(hNV, -1, 0));
        LockSupport.unpark(hNV);
        AppMethodBeat.o(118001);
        return true;
    }

    private final int hNY() {
        boolean z = false;
        AppMethodBeat.i(118002);
        synchronized (this.TWx) {
            try {
                if (this._isTerminated != 0) {
                    AppMethodBeat.o(118002);
                    return -1;
                }
                long j2 = this.controlState;
                int i2 = (int) (j2 & 2097151);
                int mZ = j.mZ(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
                if (mZ >= this.dvP) {
                    return 0;
                }
                if (i2 >= this.RUr) {
                    AppMethodBeat.o(118002);
                    return 0;
                }
                int i3 = ((int) (this.controlState & 2097151)) + 1;
                if (!(i3 > 0 && this.TWx.get(i3) == null)) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
                    AppMethodBeat.o(118002);
                    throw illegalArgumentException;
                }
                b bVar = new b(this, i3);
                this.TWx.set(i3, bVar);
                if (i3 == ((int) (TWy.incrementAndGet(this) & 2097151))) {
                    z = true;
                }
                if (!z) {
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Failed requirement.".toString());
                    AppMethodBeat.o(118002);
                    throw illegalArgumentException2;
                }
                bVar.start();
                int i4 = mZ + 1;
                AppMethodBeat.o(118002);
                return i4;
            } finally {
                AppMethodBeat.o(118002);
            }
        }
    }

    private final b hNZ() {
        AppMethodBeat.i(192368);
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof b)) {
            currentThread = null;
        }
        b bVar = (b) currentThread;
        if (bVar == null) {
            AppMethodBeat.o(192368);
            return null;
        } else if (p.j(a.this, this)) {
            AppMethodBeat.o(192368);
            return bVar;
        } else {
            AppMethodBeat.o(192368);
            return null;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final String toString() {
        int i2;
        AppMethodBeat.i(118003);
        ArrayList arrayList = new ArrayList();
        int length = this.TWx.length();
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i3 < length) {
            b bVar = this.TWx.get(i3);
            if (bVar != null) {
                int hOh = bVar.TWE.hOh();
                switch (b.$EnumSwitchMapping$0[bVar.TWF.ordinal()]) {
                    case 1:
                        i8++;
                        i2 = i4;
                        break;
                    case 2:
                        i7++;
                        arrayList.add(String.valueOf(hOh) + "b");
                        i2 = i4;
                        break;
                    case 3:
                        i6++;
                        arrayList.add(String.valueOf(hOh) + "c");
                        i2 = i4;
                        break;
                    case 4:
                        i5++;
                        if (hOh > 0) {
                            arrayList.add(String.valueOf(hOh) + "d");
                            i2 = i4;
                            break;
                        }
                        i2 = i4;
                        break;
                    case 5:
                        i2 = i4 + 1;
                        break;
                    default:
                        i2 = i4;
                        break;
                }
            } else {
                i2 = i4;
            }
            i3++;
            i4 = i2;
        }
        long j2 = this.controlState;
        String str = this.TWB + '@' + Integer.toHexString(System.identityHashCode(this)) + '[' + "Pool Size {core = " + this.dvP + ", max = " + this.RUr + "}, Worker States {CPU = " + i6 + ", blocking = " + i7 + ", parked = " + i8 + ", dormant = " + i5 + ", terminated = " + i4 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.TWu.getSize() + ", global blocking queue size = " + this.TWv.getSize() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.dvP - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
        AppMethodBeat.o(118003);
        return str;
    }

    public static void a(i iVar) {
        AppMethodBeat.i(118004);
        try {
            iVar.run();
        } catch (Throwable th) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        } finally {
            AppMethodBeat.o(118004);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0004\u0018\u00002\u00020IB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u001dJ\u000f\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\u001dJ\u000f\u0010\"\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010\u0017J\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\u001dJ\u0017\u0010(\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$H\u0000¢\u0006\u0004\b&\u0010'J\u0019\u0010*\u001a\u0004\u0018\u00010\u000b2\u0006\u0010)\u001a\u00020\u000fH\u0002¢\u0006\u0004\b*\u0010\u0012J\u000f\u0010+\u001a\u00020\u0007H\u0002¢\u0006\u0004\b+\u0010\u001dR*\u0010,\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00018\u0006@FX\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u0010\tR\u0016\u00102\u001a\u0002018\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R$\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010-R\u0014\u0010D\u001a\u00020A8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020$8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u00108¨\u0006H"}, hxF = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "", FirebaseAnalytics.b.INDEX, "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt$kotlinx_coroutines_core", "(I)I", "nextInt", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "tryReleaseCpu", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"})
    public final class b extends Thread {
        static final AtomicIntegerFieldUpdater TWG = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");
        public final n TWE;
        public c TWF;
        private long TWH;
        private long TWI;
        private int TWJ;
        public boolean TWK;
        volatile int indexInArray;
        volatile Object nextParkedWorker;
        volatile int workerCtl;

        static {
            AppMethodBeat.i(118028);
            AppMethodBeat.o(118028);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        private b() {
            AppMethodBeat.i(118026);
            setDaemon(true);
            this.TWE = new n();
            this.TWF = c.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = a.TWC;
            c.b bVar = kotlin.j.c.SYP;
            this.TWJ = kotlin.j.c.SYN.nextInt();
            AppMethodBeat.o(118026);
        }

        private void avZ(int i2) {
            AppMethodBeat.i(118015);
            setName(a.this.TWB + "-worker-" + (i2 == 0 ? "TERMINATED" : String.valueOf(i2)));
            this.indexInArray = i2;
            AppMethodBeat.o(118015);
        }

        public b(a aVar, int i2) {
            this();
            AppMethodBeat.i(118027);
            avZ(i2);
            AppMethodBeat.o(118027);
        }

        private final boolean hOa() {
            boolean z;
            AppMethodBeat.i(118017);
            if (this.TWF == c.CPU_ACQUIRED) {
                AppMethodBeat.o(118017);
                return true;
            }
            a aVar = a.this;
            while (true) {
                long j2 = aVar.controlState;
                if (((int) ((9223367638808264704L & j2) >> 42)) != 0) {
                    if (a.TWy.compareAndSet(aVar, j2, j2 - 4398046511104L)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.TWF = c.CPU_ACQUIRED;
                AppMethodBeat.o(118017);
                return true;
            }
            AppMethodBeat.o(118017);
            return false;
        }

        public final boolean a(c cVar) {
            AppMethodBeat.i(118018);
            c cVar2 = this.TWF;
            boolean z = cVar2 == c.CPU_ACQUIRED;
            if (z) {
                a.TWy.addAndGet(a.this, 4398046511104L);
            }
            if (cVar2 != cVar) {
                this.TWF = cVar;
            }
            AppMethodBeat.o(118018);
            return z;
        }

        private final void hOb() {
            long j2;
            long j3;
            int i2;
            AppMethodBeat.i(192369);
            if (!hOc()) {
                a aVar = a.this;
                if (this.nextParkedWorker == a.TWC) {
                    do {
                        j2 = aVar.parkedWorkersStack;
                        int i3 = (int) (2097151 & j2);
                        j3 = (2097152 + j2) & -2097152;
                        i2 = this.indexInArray;
                        if (an.hMK()) {
                            if (!(i2 != 0)) {
                                AssertionError assertionError = new AssertionError();
                                AppMethodBeat.o(192369);
                                throw assertionError;
                            }
                        }
                        this.nextParkedWorker = aVar.TWx.get(i3);
                    } while (!a.TWw.compareAndSet(aVar, j2, ((long) i2) | j3));
                }
                AppMethodBeat.o(192369);
                return;
            }
            if (an.hMK()) {
                if (!(this.TWE.hOh() == 0)) {
                    AssertionError assertionError2 = new AssertionError();
                    AppMethodBeat.o(192369);
                    throw assertionError2;
                }
            }
            this.workerCtl = -1;
            while (hOc() && a.this._isTerminated == 0 && this.TWF != c.TERMINATED) {
                a(c.PARKING);
                Thread.interrupted();
                if (this.TWH == 0) {
                    this.TWH = System.nanoTime() + a.this.TWA;
                }
                LockSupport.parkNanos(a.this.TWA);
                if (System.nanoTime() - this.TWH >= 0) {
                    this.TWH = 0;
                    synchronized (a.this.TWx) {
                        try {
                            if (a.this._isTerminated == 0) {
                                if (a.b(a.this) > a.this.dvP) {
                                    if (TWG.compareAndSet(this, -1, 1)) {
                                        int i4 = this.indexInArray;
                                        avZ(0);
                                        a.this.a(this, i4, 0);
                                        int andDecrement = (int) (a.TWy.getAndDecrement(a.this) & 2097151);
                                        if (andDecrement != i4) {
                                            b bVar = a.this.TWx.get(andDecrement);
                                            if (bVar == null) {
                                                p.hyc();
                                            }
                                            b bVar2 = bVar;
                                            a.this.TWx.set(i4, bVar2);
                                            bVar2.avZ(i4);
                                            a.this.a(bVar2, andDecrement, i4);
                                        }
                                        a.this.TWx.set(andDecrement, null);
                                        x xVar = x.SXb;
                                        this.TWF = c.TERMINATED;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(192369);
                            throw th;
                        }
                    }
                }
            }
            AppMethodBeat.o(192369);
        }

        private final boolean hOc() {
            return this.nextParkedWorker != a.TWC;
        }

        private int awa(int i2) {
            int i3 = this.TWJ;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.TWJ = i6;
            int i7 = i2 - 1;
            if ((i7 & i2) == 0) {
                return i6 & i7;
            }
            return (i6 & Integer.MAX_VALUE) % i2;
        }

        public final i EY(boolean z) {
            i iVar;
            AppMethodBeat.i(192370);
            if (hOa()) {
                i EZ = EZ(z);
                AppMethodBeat.o(192370);
                return EZ;
            }
            if (!z || (iVar = this.TWE.hOi()) == null) {
                iVar = (i) a.this.TWv.hNC();
            }
            if (iVar == null) {
                iVar = Fa(true);
            }
            AppMethodBeat.o(192370);
            return iVar;
        }

        private final i EZ(boolean z) {
            i hOd;
            i hOd2;
            AppMethodBeat.i(192371);
            if (z) {
                boolean z2 = awa(a.this.dvP * 2) == 0;
                if (!z2 || (hOd2 = hOd()) == null) {
                    i hOi = this.TWE.hOi();
                    if (hOi != null) {
                        AppMethodBeat.o(192371);
                        return hOi;
                    } else if (!z2 && (hOd = hOd()) != null) {
                        AppMethodBeat.o(192371);
                        return hOd;
                    }
                } else {
                    AppMethodBeat.o(192371);
                    return hOd2;
                }
            } else {
                i hOd3 = hOd();
                if (hOd3 != null) {
                    AppMethodBeat.o(192371);
                    return hOd3;
                }
            }
            i Fa = Fa(false);
            AppMethodBeat.o(192371);
            return Fa;
        }

        private final i hOd() {
            AppMethodBeat.i(192372);
            if (awa(2) == 0) {
                i iVar = (i) a.this.TWu.hNC();
                if (iVar != null) {
                    AppMethodBeat.o(192372);
                    return iVar;
                }
                i iVar2 = (i) a.this.TWv.hNC();
                AppMethodBeat.o(192372);
                return iVar2;
            }
            i iVar3 = (i) a.this.TWv.hNC();
            if (iVar3 != null) {
                AppMethodBeat.o(192372);
                return iVar3;
            }
            i iVar4 = (i) a.this.TWu.hNC();
            AppMethodBeat.o(192372);
            return iVar4;
        }

        private final i Fa(boolean z) {
            long j2;
            long a2;
            AppMethodBeat.i(192373);
            if (an.hMK()) {
                if (!(this.TWE.hOh() == 0)) {
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.o(192373);
                    throw assertionError;
                }
            }
            int b2 = a.b(a.this);
            if (b2 < 2) {
                AppMethodBeat.o(192373);
                return null;
            }
            int awa = awa(b2);
            long j3 = MAlarmHandler.NEXT_FIRE_INTERVAL;
            int i2 = 0;
            while (i2 < b2) {
                int i3 = awa + 1;
                if (i3 > b2) {
                    awa = 1;
                } else {
                    awa = i3;
                }
                b bVar = a.this.TWx.get(awa);
                if (!(bVar == null || bVar == this)) {
                    if (an.hMK()) {
                        if (!(this.TWE.hOh() == 0)) {
                            AssertionError assertionError2 = new AssertionError();
                            AppMethodBeat.o(192373);
                            throw assertionError2;
                        }
                    }
                    if (z) {
                        a2 = this.TWE.b(bVar.TWE);
                    } else {
                        a2 = this.TWE.a(bVar.TWE);
                    }
                    if (a2 == -1) {
                        i hOi = this.TWE.hOi();
                        AppMethodBeat.o(192373);
                        return hOi;
                    } else if (a2 > 0) {
                        j2 = Math.min(j3, a2);
                        i2++;
                        j3 = j2;
                    }
                }
                j2 = j3;
                i2++;
                j3 = j2;
            }
            if (j3 == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                j3 = 0;
            }
            this.TWI = j3;
            AppMethodBeat.o(192373);
            return null;
        }

        public final void run() {
            AppMethodBeat.i(118019);
            boolean z = false;
            while (a.this._isTerminated == 0 && this.TWF != c.TERMINATED) {
                i EY = EY(this.TWK);
                if (EY != null) {
                    this.TWI = 0;
                    int hOf = EY.TXa.hOf();
                    this.TWH = 0;
                    if (this.TWF == c.PARKING) {
                        if (an.hMK()) {
                            if (!(hOf == 1)) {
                                AssertionError assertionError = new AssertionError();
                                AppMethodBeat.o(118019);
                                throw assertionError;
                            }
                        }
                        this.TWF = c.BLOCKING;
                    }
                    if (hOf != 0 && a(c.BLOCKING)) {
                        a.this.hNW();
                    }
                    a.a(EY);
                    if (hOf != 0) {
                        a.TWy.addAndGet(a.this, -2097152);
                        c cVar = this.TWF;
                        if (cVar != c.TERMINATED) {
                            if (an.hMK()) {
                                if (!(cVar == c.BLOCKING)) {
                                    AssertionError assertionError2 = new AssertionError();
                                    AppMethodBeat.o(118019);
                                    throw assertionError2;
                                }
                            }
                            this.TWF = c.DORMANT;
                        }
                    }
                    z = false;
                } else {
                    this.TWK = false;
                    if (this.TWI == 0) {
                        hOb();
                    } else if (!z) {
                        z = true;
                    } else {
                        a(c.PARKING);
                        Thread.interrupted();
                        LockSupport.parkNanos(this.TWI);
                        this.TWI = 0;
                        z = false;
                    }
                }
            }
            a(c.TERMINATED);
            AppMethodBeat.o(118019);
        }
    }

    public final void a(b bVar, int i2, int i3) {
        int i4;
        AppMethodBeat.i(192364);
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i5 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & -2097152;
            if (i5 == i2) {
                i4 = i3 == 0 ? a(bVar) : i3;
            } else {
                i4 = i5;
            }
            if (i4 >= 0 && TWw.compareAndSet(this, j2, j3 | ((long) i4))) {
                AppMethodBeat.o(192364);
                return;
            }
        }
    }

    private final b hNV() {
        AppMethodBeat.i(117994);
        while (true) {
            long j2 = this.parkedWorkersStack;
            b bVar = this.TWx.get((int) (2097151 & j2));
            if (bVar == null) {
                AppMethodBeat.o(117994);
                return null;
            }
            long j3 = -2097152 & (2097152 + j2);
            int a2 = a(bVar);
            if (a2 >= 0 && TWw.compareAndSet(this, j2, j3 | ((long) a2))) {
                bVar.nextParkedWorker = TWC;
                AppMethodBeat.o(117994);
                return bVar;
            }
        }
    }

    private final boolean Pp(long j2) {
        AppMethodBeat.i(192366);
        if (j.mZ(((int) (2097151 & j2)) - ((int) ((4398044413952L & j2) >> 21)), 0) < this.dvP) {
            int hNY = hNY();
            if (hNY == 1 && this.dvP > 1) {
                hNY();
            }
            if (hNY > 0) {
                AppMethodBeat.o(192366);
                return true;
            }
        }
        AppMethodBeat.o(192366);
        return false;
    }

    private static int a(b bVar) {
        Object obj = bVar.nextParkedWorker;
        while (obj != TWC) {
            if (obj == null) {
                return 0;
            }
            b bVar2 = (b) obj;
            int i2 = bVar2.indexInArray;
            if (i2 != 0) {
                return i2;
            }
            obj = bVar2.nextParkedWorker;
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0084, code lost:
        if (r0 == null) goto L_0x0086;
     */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        /*
        // Method dump skipped, instructions count: 210
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.b.a.close():void");
    }

    public static final /* synthetic */ int b(a aVar) {
        return (int) (aVar.controlState & 2097151);
    }
}
