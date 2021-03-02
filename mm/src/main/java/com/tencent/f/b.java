package com.tencent.f;

import com.tencent.f.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class b extends AbstractExecutorService {
    public static ConcurrentLinkedQueue<WeakReference<b>> RSA = new ConcurrentLinkedQueue<>();
    private static final e RSL = new a();
    private final BlockingQueue<Runnable> RSB;
    private final HashSet<C0136b> RSC;
    private final LinkedList<C0136b> RSD;
    private final Condition RSE;
    private int RSF;
    private long RSG;
    private volatile ThreadFactory RSH;
    private volatile e RSI;
    private volatile long RSJ;
    private volatile int RSK;
    public final AtomicInteger RSz;
    private volatile int dvP;
    private volatile String name;
    private final ReentrantLock uVH;

    static {
        AppMethodBeat.i(183133);
        AppMethodBeat.o(183133);
    }

    public static boolean mw(int i2, int i3) {
        return i2 < i3;
    }

    private static boolean mx(int i2, int i3) {
        return i2 >= i3;
    }

    public static boolean aqP(int i2) {
        return i2 < 0;
    }

    private void hlZ() {
        int i2;
        AppMethodBeat.i(183109);
        do {
            i2 = this.RSz.get();
        } while (!this.RSz.compareAndSet(i2, i2 - 1));
        AppMethodBeat.o(183109);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.f.b$b  reason: collision with other inner class name */
    public final class C0136b extends AbstractQueuedSynchronizer implements h {
        Runnable RSM;
        AtomicLong RSN = new AtomicLong(0);
        AtomicBoolean RSO = new AtomicBoolean(false);
        Future dBz;
        String gWK;

        C0136b(Runnable runnable) {
            AppMethodBeat.i(183100);
            setState(-1);
            aU(runnable);
            AppMethodBeat.o(183100);
        }

        /* access modifiers changed from: package-private */
        public final void aU(Runnable runnable) {
            AppMethodBeat.i(183101);
            this.RSM = runnable;
            if (runnable == null) {
                this.gWK = b.this.name + "#Worker";
                AppMethodBeat.o(183101);
            } else if (runnable instanceof h) {
                this.gWK = ((h) runnable).getKey();
                AppMethodBeat.o(183101);
            } else {
                this.gWK = b.this.name + "#" + runnable.getClass().getName();
                AppMethodBeat.o(183101);
            }
        }

        /* access modifiers changed from: package-private */
        public final void start() {
            AppMethodBeat.i(183102);
            this.dBz = h.RTc.aX(this);
            AppMethodBeat.o(183102);
        }

        /* access modifiers changed from: package-private */
        public final void hmc() {
            AppMethodBeat.i(183103);
            d.RSS.i("ForkThreadPoolExecutor", "[releaseWork] name=" + b.this.name, new Object[0]);
            if (this.dBz != null && !this.dBz.isDone()) {
                this.dBz.cancel(true);
            }
            AppMethodBeat.o(183103);
        }

        public final void run() {
            AppMethodBeat.i(183104);
            b.this.b(this);
            AppMethodBeat.o(183104);
        }

        /* access modifiers changed from: protected */
        public final boolean isHeldExclusively() {
            AppMethodBeat.i(183105);
            if (getState() != 0) {
                AppMethodBeat.o(183105);
                return true;
            }
            AppMethodBeat.o(183105);
            return false;
        }

        /* access modifiers changed from: protected */
        public final boolean tryAcquire(int i2) {
            AppMethodBeat.i(183106);
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                AppMethodBeat.o(183106);
                return true;
            }
            AppMethodBeat.o(183106);
            return false;
        }

        /* access modifiers changed from: protected */
        public final boolean tryRelease(int i2) {
            AppMethodBeat.i(183107);
            setExclusiveOwnerThread(null);
            setState(0);
            AppMethodBeat.o(183107);
            return true;
        }

        public final boolean isLocked() {
            AppMethodBeat.i(183108);
            boolean isHeldExclusively = isHeldExclusively();
            AppMethodBeat.o(183108);
            return isHeldExclusively;
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return this.gWK;
        }
    }

    private void aqQ(int i2) {
        int i3;
        AppMethodBeat.i(183110);
        do {
            i3 = this.RSz.get();
            if (mx(i3, i2)) {
                break;
            }
        } while (!this.RSz.compareAndSet(i3, (536870911 & i3) | i2));
        AppMethodBeat.o(183110);
    }

    public final String getName() {
        return this.name;
    }

    private void hma() {
        boolean z;
        AppMethodBeat.i(183111);
        while (true) {
            int i2 = this.RSz.get();
            if (i2 < 0) {
                z = true;
            } else {
                z = false;
            }
            if (z || mx(i2, 1073741824) || ((-536870912 & i2) == 0 && !this.RSB.isEmpty())) {
                AppMethodBeat.o(183111);
            } else if ((536870911 & i2) != 0) {
                DS(true);
                AppMethodBeat.o(183111);
                return;
            } else {
                ReentrantLock reentrantLock = this.uVH;
                reentrantLock.lock();
                try {
                    if (this.RSz.compareAndSet(i2, 1073741824)) {
                        try {
                            terminated();
                            this.RSz.set(1610612736);
                            this.RSE.signalAll();
                            return;
                        } catch (Throwable th) {
                            this.RSz.set(1610612736);
                            this.RSE.signalAll();
                            AppMethodBeat.o(183111);
                            throw th;
                        }
                    } else {
                        reentrantLock.unlock();
                    }
                } finally {
                    reentrantLock.unlock();
                    AppMethodBeat.o(183111);
                }
            }
        }
        AppMethodBeat.o(183111);
    }

    private void DS(boolean z) {
        AppMethodBeat.i(183112);
        ReentrantLock reentrantLock = this.uVH;
        reentrantLock.lock();
        try {
            Iterator<C0136b> it = this.RSC.iterator();
            while (it.hasNext()) {
                it.next().hmc();
                if (z) {
                    break;
                }
            }
        } finally {
            reentrantLock.unlock();
            AppMethodBeat.o(183112);
        }
    }

    private void aS(Runnable runnable) {
        AppMethodBeat.i(183113);
        this.RSI.a(runnable, this);
        AppMethodBeat.o(183113);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(183114);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(183114);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(java.lang.Runnable r10, boolean r11) {
        /*
        // Method dump skipped, instructions count: 175
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.f.b.c(java.lang.Runnable, boolean):boolean");
    }

    private void a(C0136b bVar) {
        AppMethodBeat.i(183115);
        ReentrantLock reentrantLock = this.uVH;
        reentrantLock.lock();
        if (bVar != null) {
            try {
                this.RSC.remove(bVar);
            } catch (Throwable th) {
                reentrantLock.unlock();
                AppMethodBeat.o(183115);
                throw th;
            }
        }
        hlZ();
        hma();
        reentrantLock.unlock();
        AppMethodBeat.o(183115);
    }

    private Runnable hmb() {
        AppMethodBeat.i(183117);
        int i2 = this.RSz.get() & -536870912;
        if (i2 < 0 || (i2 < 536870912 && !this.RSB.isEmpty())) {
            Runnable poll = this.RSB.poll();
            AppMethodBeat.o(183117);
            return poll;
        }
        hlZ();
        AppMethodBeat.o(183117);
        return null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001a, code lost:
        if (r0 != null) goto L_0x001c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.tencent.f.b.C0136b r9) {
        /*
        // Method dump skipped, instructions count: 210
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.f.b.b(com.tencent.f.b$b):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(java.lang.String r9, int r10, int r11, java.util.concurrent.BlockingQueue<java.lang.Runnable> r12, com.tencent.f.e r13) {
        /*
            r8 = this;
            r7 = 183119(0x2cb4f, float:2.56604E-40)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.DAYS
            if (r13 != 0) goto L_0x001b
            com.tencent.f.b$a r6 = new com.tencent.f.b$a
            r6.<init>()
        L_0x000c:
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            return
        L_0x001b:
            r6 = r13
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.f.b.<init>(java.lang.String, int, int, java.util.concurrent.BlockingQueue, com.tencent.f.e):void");
    }

    public b(String str, int i2, int i3, BlockingQueue<Runnable> blockingQueue) {
        this(str, i2, i3, blockingQueue, null);
    }

    @Deprecated
    private b(String str, int i2, int i3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, e eVar) {
        this(str, i2, i3, timeUnit, blockingQueue, Executors.defaultThreadFactory(), eVar);
        AppMethodBeat.i(183120);
        AppMethodBeat.o(183120);
    }

    private b(String str, int i2, int i3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, e eVar) {
        AppMethodBeat.i(183121);
        this.RSz = new AtomicInteger(-536870912);
        this.uVH = new ReentrantLock();
        this.RSC = new HashSet<>();
        this.RSD = new LinkedList<>();
        this.RSE = this.uVH.newCondition();
        if (i2 < 0 || i3 <= 0 || i3 < i2 || MAlarmHandler.NEXT_FIRE_INTERVAL < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(183121);
            throw illegalArgumentException;
        } else if (blockingQueue == null || threadFactory == null || eVar == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(183121);
            throw nullPointerException;
        } else {
            this.dvP = i2;
            this.RSK = i3;
            this.RSB = blockingQueue;
            this.RSJ = timeUnit.toNanos(MAlarmHandler.NEXT_FIRE_INTERVAL);
            this.RSH = threadFactory;
            this.RSI = eVar;
            this.name = str;
            AppMethodBeat.o(183121);
        }
    }

    public void execute(Runnable runnable) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(183122);
        if (runnable == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(183122);
            throw nullPointerException;
        }
        int i2 = this.RSz.get();
        if ((i2 & 536870911) < this.dvP) {
            if (c(runnable, true)) {
                AppMethodBeat.o(183122);
                return;
            }
            i2 = this.RSz.get();
        }
        if (i2 < 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !this.RSB.offer(runnable)) {
            if (!c(runnable, false)) {
                aS(runnable);
            }
            AppMethodBeat.o(183122);
            return;
        }
        int i3 = this.RSz.get();
        if (i3 >= 0) {
            z2 = false;
        }
        if (!z2) {
            boolean remove = this.RSB.remove(runnable);
            hma();
            if (remove) {
                aS(runnable);
                AppMethodBeat.o(183122);
                return;
            }
        }
        if ((i3 & 536870911) == 0) {
            c(null, false);
            AppMethodBeat.o(183122);
            return;
        }
        aT(null);
        AppMethodBeat.o(183122);
    }

    private boolean aT(Runnable runnable) {
        AppMethodBeat.i(183123);
        if ((this.RSz.get() & -536870912) >= 0) {
            AppMethodBeat.o(183123);
            return false;
        }
        ReentrantLock reentrantLock = this.uVH;
        reentrantLock.lock();
        try {
            C0136b remove = this.RSD.isEmpty() ? null : this.RSD.remove();
            if (remove != null) {
                remove.RSO.compareAndSet(true, false);
                remove.aU(runnable);
                remove.start();
                return true;
            }
            reentrantLock.unlock();
            AppMethodBeat.o(183123);
            return false;
        } finally {
            reentrantLock.unlock();
            AppMethodBeat.o(183123);
        }
    }

    public void shutdown() {
        AppMethodBeat.i(183124);
        ReentrantLock reentrantLock = this.uVH;
        reentrantLock.lock();
        try {
            aqQ(0);
            DS(false);
            reentrantLock.unlock();
            hma();
            AppMethodBeat.o(183124);
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.o(183124);
            throw th;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        AppMethodBeat.i(183125);
        ReentrantLock reentrantLock = this.uVH;
        reentrantLock.lock();
        try {
            aqQ(536870912);
            ReentrantLock reentrantLock2 = this.uVH;
            reentrantLock2.lock();
            try {
                Iterator<C0136b> it = this.RSC.iterator();
                while (it.hasNext()) {
                    it.next().hmc();
                }
                reentrantLock2.unlock();
                BlockingQueue<Runnable> blockingQueue = this.RSB;
                ArrayList arrayList = new ArrayList();
                blockingQueue.drainTo(arrayList);
                if (!blockingQueue.isEmpty()) {
                    Runnable[] runnableArr = (Runnable[]) blockingQueue.toArray(new Runnable[0]);
                    for (Runnable runnable : runnableArr) {
                        if (blockingQueue.remove(runnable)) {
                            arrayList.add(runnable);
                        }
                    }
                }
                reentrantLock.unlock();
                hma();
                AppMethodBeat.o(183125);
                return arrayList;
            } catch (Throwable th) {
                reentrantLock2.unlock();
                AppMethodBeat.o(183125);
                throw th;
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            AppMethodBeat.o(183125);
            throw th2;
        }
    }

    public boolean isShutdown() {
        boolean z;
        AppMethodBeat.i(183126);
        if (this.RSz.get() < 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(183126);
            return true;
        }
        AppMethodBeat.o(183126);
        return false;
    }

    public boolean isTerminated() {
        AppMethodBeat.i(183127);
        boolean mx = mx(this.RSz.get(), 1610612736);
        AppMethodBeat.o(183127);
        return mx;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(183128);
        long nanos = timeUnit.toNanos(j2);
        ReentrantLock reentrantLock = this.uVH;
        reentrantLock.lock();
        while (!mx(this.RSz.get(), 1610612736)) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    AppMethodBeat.o(183128);
                    return false;
                }
                nanos = this.RSE.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                AppMethodBeat.o(183128);
                throw th;
            }
        }
        reentrantLock.unlock();
        AppMethodBeat.o(183128);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(183129);
        shutdown();
        AppMethodBeat.o(183129);
    }

    public final BlockingQueue<Runnable> getQueue() {
        return this.RSB;
    }

    public final long getCompletedTaskCount() {
        AppMethodBeat.i(183130);
        ReentrantLock reentrantLock = this.uVH;
        reentrantLock.lock();
        try {
            long j2 = this.RSG;
            Iterator<C0136b> it = this.RSC.iterator();
            while (it.hasNext()) {
                j2 = it.next().RSN.get() + j2;
            }
            return j2;
        } finally {
            reentrantLock.unlock();
            AppMethodBeat.o(183130);
        }
    }

    public String toString() {
        String str;
        AppMethodBeat.i(183131);
        ReentrantLock reentrantLock = this.uVH;
        StringBuilder sb = new StringBuilder();
        reentrantLock.lock();
        try {
            long j2 = this.RSG;
            int size = this.RSC.size();
            Iterator<C0136b> it = this.RSC.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                C0136b next = it.next();
                j2 += next.RSN.get();
                if (next.isLocked()) {
                    i2++;
                    sb.append(next.gWK);
                }
                i2 = i2;
            }
            reentrantLock.unlock();
            int i3 = this.RSz.get();
            if (mw(i3, 0)) {
                str = "Running";
            } else {
                str = mx(i3, 1610612736) ? "Terminated" : "Shutting down";
            }
            String str2 = super.toString() + "[" + str + ", pool size = " + size + ", active threads = " + i2 + ", queued tasks = " + this.RSB.size() + ", completed tasks = " + j2 + ", running tasks = " + ((Object) sb) + "]";
            AppMethodBeat.o(183131);
            return str2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            AppMethodBeat.o(183131);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void beforeExecute(Thread thread, Runnable runnable) {
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
    }

    /* access modifiers changed from: protected */
    public void terminated() {
        AppMethodBeat.i(183132);
        Iterator<WeakReference<b>> it = RSA.iterator();
        while (it.hasNext()) {
            if (this == it.next().get()) {
                it.remove();
            }
        }
        AppMethodBeat.o(183132);
    }

    public static class a implements e {
        @Override // com.tencent.f.e
        public final void a(Runnable runnable, b bVar) {
            AppMethodBeat.i(183099);
            RejectedExecutionException rejectedExecutionException = new RejectedExecutionException("Task " + runnable.toString() + " rejected from " + bVar.toString());
            AppMethodBeat.o(183099);
            throw rejectedExecutionException;
        }
    }

    private void a(C0136b bVar, boolean z) {
        AppMethodBeat.i(183116);
        bVar.release(1);
        if (z) {
            hlZ();
        }
        ReentrantLock reentrantLock = this.uVH;
        reentrantLock.lock();
        if (z) {
            try {
                this.RSG += bVar.RSN.get();
                this.RSC.remove(bVar);
                bVar.RSM = null;
                bVar.dBz = null;
            } catch (Throwable th) {
                reentrantLock.unlock();
                hma();
                AppMethodBeat.o(183116);
                throw th;
            }
        } else if (bVar.RSO.compareAndSet(false, true)) {
            this.RSD.add(bVar);
            Runnable hmb = hmb();
            if (hmb != null) {
                aT(hmb);
            }
        }
        reentrantLock.unlock();
        hma();
        AppMethodBeat.o(183116);
    }
}
