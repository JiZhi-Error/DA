package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.f.d;
import rx.g;
import rx.internal.c.i;
import rx.j;

public final class a extends g implements j {
    static final C2392a UlA;
    private static final TimeUnit Uly = TimeUnit.SECONDS;
    static final c Ulz;
    final ThreadFactory RSH;
    final AtomicReference<C2392a> UlB = new AtomicReference<>(UlA);

    static {
        AppMethodBeat.i(90324);
        c cVar = new c(rx.internal.util.g.Unq);
        Ulz = cVar;
        cVar.hQA();
        C2392a aVar = new C2392a(null, 0, null);
        UlA = aVar;
        aVar.shutdown();
        AppMethodBeat.o(90324);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: rx.internal.c.a$a  reason: collision with other inner class name */
    public static final class C2392a {
        private final ThreadFactory RSH;
        final long RSJ;
        final ConcurrentLinkedQueue<c> UlC;
        final rx.f.b UlD;
        private final ScheduledExecutorService UlE;
        private final Future<?> UlF;

        C2392a(final ThreadFactory threadFactory, long j2, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            AppMethodBeat.i(90312);
            this.RSH = threadFactory;
            this.RSJ = timeUnit != null ? timeUnit.toNanos(j2) : 0;
            this.UlC = new ConcurrentLinkedQueue<>();
            this.UlD = new rx.f.b();
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactory() {
                    /* class rx.internal.c.a.C2392a.AnonymousClass1 */

                    public final Thread newThread(Runnable runnable) {
                        AppMethodBeat.i(90310);
                        Thread newThread = threadFactory.newThread(runnable);
                        newThread.setName(newThread.getName() + " (Evictor)");
                        AppMethodBeat.o(90310);
                        return newThread;
                    }
                });
                h.b(scheduledExecutorService);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
                    /* class rx.internal.c.a.C2392a.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(90311);
                        C2392a aVar = C2392a.this;
                        if (!aVar.UlC.isEmpty()) {
                            long nanoTime = System.nanoTime();
                            Iterator<c> it = aVar.UlC.iterator();
                            while (it.hasNext()) {
                                c next = it.next();
                                if (next.UlN > nanoTime) {
                                    break;
                                } else if (aVar.UlC.remove(next)) {
                                    aVar.UlD.e(next);
                                }
                            }
                        }
                        AppMethodBeat.o(90311);
                    }
                }, this.RSJ, this.RSJ, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
                scheduledExecutorService = null;
            }
            this.UlE = scheduledExecutorService;
            this.UlF = scheduledFuture;
            AppMethodBeat.o(90312);
        }

        /* access modifiers changed from: package-private */
        public final c hQJ() {
            AppMethodBeat.i(90313);
            if (this.UlD.UnB) {
                c cVar = a.Ulz;
                AppMethodBeat.o(90313);
                return cVar;
            }
            while (!this.UlC.isEmpty()) {
                c poll = this.UlC.poll();
                if (poll != null) {
                    AppMethodBeat.o(90313);
                    return poll;
                }
            }
            c cVar2 = new c(this.RSH);
            this.UlD.b(cVar2);
            AppMethodBeat.o(90313);
            return cVar2;
        }

        /* access modifiers changed from: package-private */
        public final void shutdown() {
            AppMethodBeat.i(90314);
            try {
                if (this.UlF != null) {
                    this.UlF.cancel(true);
                }
                if (this.UlE != null) {
                    this.UlE.shutdownNow();
                }
            } finally {
                this.UlD.hQA();
                AppMethodBeat.o(90314);
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        AppMethodBeat.i(90320);
        this.RSH = threadFactory;
        start();
        AppMethodBeat.o(90320);
    }

    @Override // rx.internal.c.j
    public final void start() {
        AppMethodBeat.i(90321);
        C2392a aVar = new C2392a(this.RSH, 60, Uly);
        if (!this.UlB.compareAndSet(UlA, aVar)) {
            aVar.shutdown();
        }
        AppMethodBeat.o(90321);
    }

    @Override // rx.internal.c.j
    public final void shutdown() {
        C2392a aVar;
        AppMethodBeat.i(90322);
        do {
            aVar = this.UlB.get();
            if (aVar == UlA) {
                AppMethodBeat.o(90322);
                return;
            }
        } while (!this.UlB.compareAndSet(aVar, UlA));
        aVar.shutdown();
        AppMethodBeat.o(90322);
    }

    @Override // rx.g
    public final g.a createWorker() {
        AppMethodBeat.i(90323);
        b bVar = new b(this.UlB.get());
        AppMethodBeat.o(90323);
        return bVar;
    }

    static final class b extends g.a {
        final rx.f.b UlI = new rx.f.b();
        private final C2392a UlJ;
        private final c UlK;
        final AtomicBoolean UlL;

        b(C2392a aVar) {
            AppMethodBeat.i(90316);
            this.UlJ = aVar;
            this.UlL = new AtomicBoolean();
            this.UlK = aVar.hQJ();
            AppMethodBeat.o(90316);
        }

        @Override // rx.j
        public final void hQA() {
            AppMethodBeat.i(90317);
            if (this.UlL.compareAndSet(false, true)) {
                C2392a aVar = this.UlJ;
                c cVar = this.UlK;
                cVar.UlN = System.nanoTime() + aVar.RSJ;
                aVar.UlC.offer(cVar);
            }
            this.UlI.hQA();
            AppMethodBeat.o(90317);
        }

        @Override // rx.j
        public final boolean hQB() {
            return this.UlI.UnB;
        }

        @Override // rx.g.a
        public final j a(rx.b.a aVar) {
            AppMethodBeat.i(90318);
            j a2 = a(aVar, 0, null);
            AppMethodBeat.o(90318);
            return a2;
        }

        @Override // rx.g.a
        public final j a(final rx.b.a aVar, long j2, TimeUnit timeUnit) {
            AppMethodBeat.i(90319);
            if (this.UlI.UnB) {
                j hRn = d.hRn();
                AppMethodBeat.o(90319);
                return hRn;
            }
            i b2 = this.UlK.b(new rx.b.a() {
                /* class rx.internal.c.a.b.AnonymousClass1 */

                @Override // rx.b.a
                public final void call() {
                    AppMethodBeat.i(90315);
                    if (b.this.UlI.UnB) {
                        AppMethodBeat.o(90315);
                        return;
                    }
                    aVar.call();
                    AppMethodBeat.o(90315);
                }
            }, j2, timeUnit);
            this.UlI.b(b2);
            b2.Umv.b(new i.b(b2, this.UlI));
            AppMethodBeat.o(90319);
            return b2;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c extends h {
        long UlN = 0;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
