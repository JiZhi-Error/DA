package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.f.b;
import rx.f.d;
import rx.g;
import rx.j;

public final class c extends g {
    final Executor executor;

    public c(Executor executor2) {
        this.executor = executor2;
    }

    @Override // rx.g
    public final g.a createWorker() {
        AppMethodBeat.i(90368);
        a aVar = new a(this.executor);
        AppMethodBeat.o(90368);
        return aVar;
    }

    static final class a extends g.a implements Runnable {
        final b UlY = new b();
        final AtomicInteger UlZ = new AtomicInteger();
        final ScheduledExecutorService Uma = d.hQL();
        final Executor executor;
        final ConcurrentLinkedQueue<i> vTW = new ConcurrentLinkedQueue<>();

        public a(Executor executor2) {
            AppMethodBeat.i(90363);
            this.executor = executor2;
            AppMethodBeat.o(90363);
        }

        public final void run() {
            AppMethodBeat.i(90365);
            while (!this.UlY.UnB) {
                i poll = this.vTW.poll();
                if (poll == null) {
                    AppMethodBeat.o(90365);
                    return;
                }
                if (!poll.Umv.UnB) {
                    if (!this.UlY.UnB) {
                        poll.run();
                    } else {
                        this.vTW.clear();
                        AppMethodBeat.o(90365);
                        return;
                    }
                }
                if (this.UlZ.decrementAndGet() == 0) {
                    AppMethodBeat.o(90365);
                    return;
                }
            }
            this.vTW.clear();
            AppMethodBeat.o(90365);
        }

        @Override // rx.g.a
        public final j a(final rx.b.a aVar, long j2, TimeUnit timeUnit) {
            AppMethodBeat.i(90366);
            if (j2 <= 0) {
                j a2 = a(aVar);
                AppMethodBeat.o(90366);
                return a2;
            } else if (this.UlY.UnB) {
                j hRn = d.hRn();
                AppMethodBeat.o(90366);
                return hRn;
            } else {
                rx.f.c cVar = new rx.f.c();
                final rx.f.c cVar2 = new rx.f.c();
                cVar2.f(cVar);
                this.UlY.b(cVar2);
                final j e2 = d.e(new rx.b.a() {
                    /* class rx.internal.c.c.a.AnonymousClass1 */

                    @Override // rx.b.a
                    public final void call() {
                        AppMethodBeat.i(90361);
                        a.this.UlY.e(cVar2);
                        AppMethodBeat.o(90361);
                    }
                });
                i iVar = new i(new rx.b.a() {
                    /* class rx.internal.c.c.a.AnonymousClass2 */

                    @Override // rx.b.a
                    public final void call() {
                        AppMethodBeat.i(90362);
                        if (cVar2.hQB()) {
                            AppMethodBeat.o(90362);
                            return;
                        }
                        j a2 = a.this.a(aVar);
                        cVar2.f(a2);
                        if (a2.getClass() == i.class) {
                            ((i) a2).Umv.b(e2);
                        }
                        AppMethodBeat.o(90362);
                    }
                });
                cVar.f(iVar);
                try {
                    iVar.b(this.Uma.schedule(iVar, j2, timeUnit));
                    AppMethodBeat.o(90366);
                    return e2;
                } catch (RejectedExecutionException e3) {
                    rx.d.c.onError(e3);
                    AppMethodBeat.o(90366);
                    throw e3;
                }
            }
        }

        @Override // rx.j
        public final boolean hQB() {
            return this.UlY.UnB;
        }

        @Override // rx.j
        public final void hQA() {
            AppMethodBeat.i(90367);
            this.UlY.hQA();
            this.vTW.clear();
            AppMethodBeat.o(90367);
        }

        @Override // rx.g.a
        public final j a(rx.b.a aVar) {
            AppMethodBeat.i(90364);
            if (this.UlY.UnB) {
                j hRn = d.hRn();
                AppMethodBeat.o(90364);
                return hRn;
            }
            i iVar = new i(aVar, this.UlY);
            this.UlY.b(iVar);
            this.vTW.offer(iVar);
            if (this.UlZ.getAndIncrement() == 0) {
                try {
                    this.executor.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.UlY.e(iVar);
                    this.UlZ.decrementAndGet();
                    rx.d.c.onError(e2);
                    AppMethodBeat.o(90364);
                    throw e2;
                }
            }
            AppMethodBeat.o(90364);
            return iVar;
        }
    }
}
