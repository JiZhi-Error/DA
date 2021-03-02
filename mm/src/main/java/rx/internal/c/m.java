package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.f.d;
import rx.g;
import rx.j;

public final class m extends g {
    public static final m UmP = new m();

    static {
        AppMethodBeat.i(90410);
        AppMethodBeat.o(90410);
    }

    @Override // rx.g
    public final g.a createWorker() {
        AppMethodBeat.i(90409);
        a aVar = new a();
        AppMethodBeat.o(90409);
        return aVar;
    }

    private m() {
    }

    static final class a extends g.a implements j {
        private final AtomicInteger UlZ = new AtomicInteger();
        final PriorityBlockingQueue<b> UmQ = new PriorityBlockingQueue<>();
        private final rx.f.a Uml = new rx.f.a();
        final AtomicInteger counter = new AtomicInteger();

        a() {
            AppMethodBeat.i(90402);
            AppMethodBeat.o(90402);
        }

        @Override // rx.g.a
        public final j a(rx.b.a aVar) {
            AppMethodBeat.i(90403);
            j a2 = a(aVar, now());
            AppMethodBeat.o(90403);
            return a2;
        }

        @Override // rx.g.a
        public final j a(rx.b.a aVar, long j2, TimeUnit timeUnit) {
            AppMethodBeat.i(90404);
            long now = now() + timeUnit.toMillis(j2);
            j a2 = a(new l(aVar, this, now), now);
            AppMethodBeat.o(90404);
            return a2;
        }

        private j a(rx.b.a aVar, long j2) {
            AppMethodBeat.i(90405);
            if (this.Uml.hQB()) {
                j hRn = d.hRn();
                AppMethodBeat.o(90405);
                return hRn;
            }
            final b bVar = new b(aVar, Long.valueOf(j2), this.counter.incrementAndGet());
            this.UmQ.add(bVar);
            if (this.UlZ.getAndIncrement() == 0) {
                do {
                    b poll = this.UmQ.poll();
                    if (poll != null) {
                        poll.Umw.call();
                    }
                } while (this.UlZ.decrementAndGet() > 0);
                j hRn2 = d.hRn();
                AppMethodBeat.o(90405);
                return hRn2;
            }
            j e2 = d.e(new rx.b.a() {
                /* class rx.internal.c.m.a.AnonymousClass1 */

                @Override // rx.b.a
                public final void call() {
                    AppMethodBeat.i(90401);
                    a.this.UmQ.remove(bVar);
                    AppMethodBeat.o(90401);
                }
            });
            AppMethodBeat.o(90405);
            return e2;
        }

        @Override // rx.j
        public final void hQA() {
            AppMethodBeat.i(90406);
            this.Uml.hQA();
            AppMethodBeat.o(90406);
        }

        @Override // rx.j
        public final boolean hQB() {
            AppMethodBeat.i(90407);
            boolean hQB = this.Uml.hQB();
            AppMethodBeat.o(90407);
            return hQB;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b implements Comparable<b> {
        final Long UmT;
        final rx.b.a Umw;
        final int count;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(b bVar) {
            AppMethodBeat.i(90408);
            b bVar2 = bVar;
            int compareTo = this.UmT.compareTo(bVar2.UmT);
            if (compareTo == 0) {
                int compare = m.compare(this.count, bVar2.count);
                AppMethodBeat.o(90408);
                return compare;
            }
            AppMethodBeat.o(90408);
            return compareTo;
        }

        b(rx.b.a aVar, Long l, int i2) {
            this.Umw = aVar;
            this.UmT = l;
            this.count = i2;
        }
    }

    static int compare(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }
}
