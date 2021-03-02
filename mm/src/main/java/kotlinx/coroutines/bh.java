package kotlinx.coroutines;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.d.f;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.at;
import kotlinx.coroutines.internal.aa;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.internal.z;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b \u0018\u00002\u0002092\u00020::\u00044567B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0002J\u0017\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00032\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0002J\u000f\u0010\u0018\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0018\u0010\u0002J\u001d\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u00142\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b#\u0010$J%\u0010'\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u001aH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0003H\u0014¢\u0006\u0004\b+\u0010\u0002R$\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00118B@BX\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00118T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b1\u0010.R\u0016\u00103\u001a\u00020\u00148T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0016¨\u00068"}, hxF = {"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"})
public abstract class bh extends bi implements at {
    private static final AtomicReferenceFieldUpdater TUy = AtomicReferenceFieldUpdater.newUpdater(bh.class, Object.class, "_queue");
    private static final AtomicReferenceFieldUpdater TUz = AtomicReferenceFieldUpdater.newUpdater(bh.class, Object.class, "_delayed");
    volatile Object _delayed = null;
    private volatile int _isCompleted = 0;
    volatile Object _queue = null;

    @Override // kotlinx.coroutines.at
    public bc d(long j2, Runnable runnable) {
        return at.a.e(j2, runnable);
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.bg
    public final boolean isEmpty() {
        if (!hNc()) {
            return false;
        }
        d dVar = (d) this._delayed;
        if (dVar != null && !dVar.isEmpty()) {
            return false;
        }
        Object obj = this._queue;
        if (obj == null) {
            return true;
        }
        if (obj instanceof m) {
            return ((m) obj).isEmpty();
        }
        return obj == bj.hNi();
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.bg
    public final long hMZ() {
        c cVar;
        if (super.hMZ() == 0) {
            return 0;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof m) {
                if (!((m) obj).isEmpty()) {
                    return 0;
                }
            } else if (obj == bj.hNi()) {
                return MAlarmHandler.NEXT_FIRE_INTERVAL;
            } else {
                return 0;
            }
        }
        d dVar = (d) this._delayed;
        if (dVar == null || (cVar = (c) dVar.hNS()) == null) {
            return MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        long j2 = cVar.nanoTime;
        cq cqVar = cr.TVl;
        return j.aM(j2 - (cqVar != null ? cqVar.nanoTime() : System.nanoTime()), 0);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 131
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    @Override // kotlinx.coroutines.bg
    protected final void shutdown() {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.bh.shutdown():void");
    }

    @Override // kotlinx.coroutines.at
    public final void a(long j2, k<? super x> kVar) {
        long Pl = bj.Pl(j2);
        if (Pl < 4611686018427387903L) {
            cq cqVar = cr.TVl;
            long nanoTime = cqVar != null ? cqVar.nanoTime() : System.nanoTime();
            a aVar = new a(Pl + nanoTime, kVar);
            n.a(kVar, aVar);
            a(nanoTime, aVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0036 A[EDGE_INSN: B:63:0x0036->B:21:0x0036 ?: BREAK  , SYNTHETIC] */
    @Override // kotlinx.coroutines.bg
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long hMY() {
        /*
        // Method dump skipped, instructions count: 182
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.bh.hMY():long");
    }

    @Override // kotlinx.coroutines.ad
    public final void a(f fVar, Runnable runnable) {
        bd(runnable);
    }

    public final void bd(Runnable runnable) {
        while (!this.be(runnable)) {
            this = ap.TUg;
        }
        this.hNg();
    }

    private final boolean be(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (this._isCompleted != 0) {
                return false;
            }
            if (obj == null) {
                if (TUy.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof m) {
                if (obj == null) {
                    throw new t("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
                switch (((m) obj).gh(runnable)) {
                    case 0:
                        return true;
                    case 1:
                        TUy.compareAndSet(this, obj, ((m) obj).hNM());
                        continue;
                    case 2:
                        return false;
                }
            } else if (obj == bj.hNi()) {
                return false;
            } else {
                m mVar = new m(8, true);
                if (obj == null) {
                    throw new t("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
                mVar.gh((Runnable) obj);
                mVar.gh(runnable);
                if (TUy.compareAndSet(this, obj, mVar)) {
                    return true;
                }
            }
        }
    }

    public final void a(long j2, c cVar) {
        switch (b(j2, cVar)) {
            case 0:
                if (a(cVar)) {
                    hNg();
                    return;
                }
                return;
            case 1:
                c(j2, cVar);
                return;
            case 2:
                return;
            default:
                throw new IllegalStateException("unexpected result".toString());
        }
    }

    private final boolean a(c cVar) {
        d dVar = (d) this._delayed;
        return (dVar != null ? (c) dVar.hNS() : null) == cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0000H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u0007J\b\u0010$\u001a\u00020%H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", FirebaseAnalytics.b.INDEX, "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", FacebookRequestErrorClassification.KEY_OTHER, "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"})
    public static abstract class c implements Comparable<c>, Runnable, bc, aa {
        private Object TUD;
        private int index = -1;
        public long nanoTime;

        public c(long j2) {
            this.nanoTime = j2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(c cVar) {
            long j2 = this.nanoTime - cVar.nanoTime;
            if (j2 > 0) {
                return 1;
            }
            if (j2 < 0) {
                return -1;
            }
            return 0;
        }

        @Override // kotlinx.coroutines.internal.aa
        public final z<?> hNf() {
            Object obj = this.TUD;
            if (!(obj instanceof z)) {
                obj = null;
            }
            return (z) obj;
        }

        @Override // kotlinx.coroutines.internal.aa
        public final void a(z<?> zVar) {
            if (!(this.TUD != bj.hNh())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.TUD = zVar;
        }

        @Override // kotlinx.coroutines.internal.aa
        public final int getIndex() {
            return this.index;
        }

        @Override // kotlinx.coroutines.internal.aa
        public final void setIndex(int i2) {
            this.index = i2;
        }

        public final synchronized int a(long j2, d dVar, bh bhVar) {
            aa[] aaVarArr;
            int i2;
            boolean z;
            if (this.TUD == bj.hNh()) {
                i2 = 2;
            } else {
                d dVar2 = dVar;
                c cVar = this;
                synchronized (dVar2) {
                    c cVar2 = (c) dVar2.hNU();
                    if (bhVar._isCompleted) {
                        i2 = 1;
                    } else {
                        if (cVar2 == null) {
                            dVar.TUE = j2;
                        } else {
                            long j3 = cVar2.nanoTime;
                            if (j3 - j2 < 0) {
                                j2 = j3;
                            }
                            if (j2 - dVar.TUE > 0) {
                                dVar.TUE = j2;
                            }
                        }
                        if (this.nanoTime - dVar.TUE < 0) {
                            this.nanoTime = dVar.TUE;
                        }
                        if (an.hMK()) {
                            if (cVar.hNf() == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                throw new AssertionError();
                            }
                        }
                        cVar.a(dVar2);
                        T[] tArr = dVar2.TWs;
                        if (tArr == null) {
                            tArr = (T[]) new aa[4];
                            dVar2.TWs = tArr;
                        } else if (dVar2._size >= tArr.length) {
                            Object[] copyOf = Arrays.copyOf(tArr, dVar2._size * 2);
                            p.g(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                            dVar2.TWs = (T[]) ((aa[]) copyOf);
                            aaVarArr = (aa[]) copyOf;
                            int i3 = dVar2._size;
                            dVar2._size = i3 + 1;
                            aaVarArr[i3] = cVar;
                            cVar.setIndex(i3);
                            dVar2.avX(i3);
                            i2 = 0;
                        }
                        aaVarArr = tArr;
                        int i32 = dVar2._size;
                        dVar2._size = i32 + 1;
                        aaVarArr[i32] = cVar;
                        cVar.setIndex(i32);
                        dVar2.avX(i32);
                        i2 = 0;
                    }
                }
            }
            return i2;
        }

        @Override // kotlinx.coroutines.bc
        public final synchronized void dispose() {
            Object obj = this.TUD;
            if (obj != bj.hNh()) {
                if (!(obj instanceof d)) {
                    obj = null;
                }
                d dVar = (d) obj;
                if (dVar != null) {
                    dVar.a(this);
                }
                this.TUD = bj.hNh();
            }
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"})
    final class a extends c {
        private final k<x> TUA;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlinx.coroutines.k<? super kotlin.x> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(long j2, k<? super x> kVar) {
            super(j2);
            this.TUA = kVar;
        }

        public final void run() {
            AppMethodBeat.i(192319);
            this.TUA.a(bh.this, x.SXb);
            AppMethodBeat.o(192319);
        }

        @Override // kotlinx.coroutines.bh.c
        public final String toString() {
            AppMethodBeat.i(192320);
            String str = super.toString() + this.TUA.toString();
            AppMethodBeat.o(192320);
            return str;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"})
    static final class b extends c {
        private final Runnable TUC;

        public b(long j2, Runnable runnable) {
            super(j2);
            this.TUC = runnable;
        }

        public final void run() {
            AppMethodBeat.i(192505);
            this.TUC.run();
            AppMethodBeat.o(192505);
        }

        @Override // kotlinx.coroutines.bh.c
        public final String toString() {
            AppMethodBeat.i(192506);
            String str = super.toString() + this.TUC.toString();
            AppMethodBeat.o(192506);
            return str;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"})
    public static final class d extends z<c> {
        public long TUE;

        public d(long j2) {
            this.TUE = j2;
        }
    }

    private final int b(long j2, c cVar) {
        if (this._isCompleted != 0) {
            return 1;
        }
        d dVar = (d) this._delayed;
        if (dVar == null) {
            bh bhVar = this;
            TUz.compareAndSet(bhVar, null, new d(j2));
            Object obj = bhVar._delayed;
            if (obj == null) {
                p.hyc();
            }
            dVar = (d) obj;
        }
        return cVar.a(j2, dVar, this);
    }

    private final void hNe() {
        c cVar;
        cq cqVar = cr.TVl;
        long nanoTime = cqVar != null ? cqVar.nanoTime() : System.nanoTime();
        while (true) {
            d dVar = (d) this._delayed;
            if (dVar != null && (cVar = (c) dVar.hNT()) != null) {
                c(nanoTime, cVar);
            } else {
                return;
            }
        }
    }
}
