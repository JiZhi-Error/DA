package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.f.d;
import rx.g;
import rx.internal.util.i;
import rx.j;

public final class b extends g implements j {
    static final int UlO;
    static final c UlP;
    static final C2393b UlQ = new C2393b(null, 0);
    final ThreadFactory RSH;
    public final AtomicReference<C2393b> UlB = new AtomicReference<>(UlQ);

    static {
        AppMethodBeat.i(90360);
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        UlO = intValue;
        c cVar = new c(rx.internal.util.g.Unq);
        UlP = cVar;
        cVar.hQA();
        AppMethodBeat.o(90360);
    }

    /* renamed from: rx.internal.c.b$b  reason: collision with other inner class name */
    public static final class C2393b {
        final int UlW;
        final c[] UlX;
        long n;

        C2393b(ThreadFactory threadFactory, int i2) {
            AppMethodBeat.i(90348);
            this.UlW = i2;
            this.UlX = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.UlX[i3] = new c(threadFactory);
            }
            AppMethodBeat.o(90348);
        }

        public final c hQK() {
            int i2 = this.UlW;
            if (i2 == 0) {
                return b.UlP;
            }
            c[] cVarArr = this.UlX;
            long j2 = this.n;
            this.n = 1 + j2;
            return cVarArr[(int) (j2 % ((long) i2))];
        }

        public final void shutdown() {
            AppMethodBeat.i(90349);
            for (c cVar : this.UlX) {
                cVar.hQA();
            }
            AppMethodBeat.o(90349);
        }
    }

    public b(ThreadFactory threadFactory) {
        AppMethodBeat.i(90356);
        this.RSH = threadFactory;
        start();
        AppMethodBeat.o(90356);
    }

    @Override // rx.g
    public final g.a createWorker() {
        AppMethodBeat.i(90357);
        a aVar = new a(this.UlB.get().hQK());
        AppMethodBeat.o(90357);
        return aVar;
    }

    @Override // rx.internal.c.j
    public final void start() {
        AppMethodBeat.i(90358);
        C2393b bVar = new C2393b(this.RSH, UlO);
        if (!this.UlB.compareAndSet(UlQ, bVar)) {
            bVar.shutdown();
        }
        AppMethodBeat.o(90358);
    }

    @Override // rx.internal.c.j
    public final void shutdown() {
        C2393b bVar;
        AppMethodBeat.i(90359);
        do {
            bVar = this.UlB.get();
            if (bVar == UlQ) {
                AppMethodBeat.o(90359);
                return;
            }
        } while (!this.UlB.compareAndSet(bVar, UlQ));
        bVar.shutdown();
        AppMethodBeat.o(90359);
    }

    static final class a extends g.a {
        private final i UlR = new i();
        private final rx.f.b UlS = new rx.f.b();
        final i UlT = new i(this.UlR, this.UlS);
        private final c UlU;

        a(c cVar) {
            AppMethodBeat.i(90352);
            this.UlU = cVar;
            AppMethodBeat.o(90352);
        }

        @Override // rx.j
        public final void hQA() {
            AppMethodBeat.i(90353);
            this.UlT.hQA();
            AppMethodBeat.o(90353);
        }

        @Override // rx.j
        public final boolean hQB() {
            return this.UlT.UnB;
        }

        @Override // rx.g.a
        public final j a(final rx.b.a aVar) {
            Future<?> schedule;
            AppMethodBeat.i(90354);
            if (this.UlT.UnB) {
                j hRn = d.hRn();
                AppMethodBeat.o(90354);
                return hRn;
            }
            c cVar = this.UlU;
            AnonymousClass1 r1 = new rx.b.a() {
                /* class rx.internal.c.b.a.AnonymousClass1 */

                @Override // rx.b.a
                public final void call() {
                    AppMethodBeat.i(90350);
                    if (a.this.UlT.UnB) {
                        AppMethodBeat.o(90350);
                        return;
                    }
                    aVar.call();
                    AppMethodBeat.o(90350);
                }
            };
            i iVar = this.UlR;
            i iVar2 = new i(rx.d.c.b(r1), iVar);
            iVar.b(iVar2);
            if (0 <= 0) {
                schedule = cVar.Umn.submit(iVar2);
            } else {
                schedule = cVar.Umn.schedule(iVar2, 0, (TimeUnit) null);
            }
            iVar2.b(schedule);
            AppMethodBeat.o(90354);
            return iVar2;
        }

        @Override // rx.g.a
        public final j a(final rx.b.a aVar, long j2, TimeUnit timeUnit) {
            Future<?> schedule;
            AppMethodBeat.i(90355);
            if (this.UlT.UnB) {
                j hRn = d.hRn();
                AppMethodBeat.o(90355);
                return hRn;
            }
            c cVar = this.UlU;
            AnonymousClass2 r1 = new rx.b.a() {
                /* class rx.internal.c.b.a.AnonymousClass2 */

                @Override // rx.b.a
                public final void call() {
                    AppMethodBeat.i(90351);
                    if (a.this.UlT.UnB) {
                        AppMethodBeat.o(90351);
                        return;
                    }
                    aVar.call();
                    AppMethodBeat.o(90351);
                }
            };
            rx.f.b bVar = this.UlS;
            i iVar = new i(rx.d.c.b(r1), bVar);
            bVar.b(iVar);
            if (j2 <= 0) {
                schedule = cVar.Umn.submit(iVar);
            } else {
                schedule = cVar.Umn.schedule(iVar, j2, timeUnit);
            }
            iVar.b(schedule);
            AppMethodBeat.o(90355);
            return iVar;
        }
    }

    public static final class c extends h {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
