package rx.schedulers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.f.d;
import rx.g;
import rx.j;

public class TestScheduler extends g {
    static long RPO;
    final Queue<c> dxk = new PriorityQueue(11, new a());
    long time;

    public TestScheduler() {
        AppMethodBeat.i(90112);
        AppMethodBeat.o(90112);
    }

    /* access modifiers changed from: package-private */
    public static final class c {
        final rx.b.a Umw;
        final g.a Uou;
        final long count;
        final long time;

        c(g.a aVar, long j2, rx.b.a aVar2) {
            AppMethodBeat.i(90102);
            long j3 = TestScheduler.RPO;
            TestScheduler.RPO = 1 + j3;
            this.count = j3;
            this.time = j2;
            this.Umw = aVar2;
            this.Uou = aVar;
            AppMethodBeat.o(90102);
        }

        public final String toString() {
            AppMethodBeat.i(90103);
            String format = String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.time), this.Umw.toString());
            AppMethodBeat.o(90103);
            return format;
        }
    }

    static final class a implements Comparator<c> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(c cVar, c cVar2) {
            c cVar3 = cVar;
            c cVar4 = cVar2;
            if (cVar3.time == cVar4.time) {
                if (cVar3.count < cVar4.count) {
                    return -1;
                }
                return cVar3.count > cVar4.count ? 1 : 0;
            } else if (cVar3.time >= cVar4.time) {
                return cVar3.time > cVar4.time ? 1 : 0;
            } else {
                return -1;
            }
        }
    }

    @Override // rx.g
    public long now() {
        AppMethodBeat.i(90113);
        long millis = TimeUnit.NANOSECONDS.toMillis(this.time);
        AppMethodBeat.o(90113);
        return millis;
    }

    public void advanceTimeBy(long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(90114);
        advanceTimeTo(this.time + timeUnit.toNanos(j2), TimeUnit.NANOSECONDS);
        AppMethodBeat.o(90114);
    }

    public void advanceTimeTo(long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(90115);
        Py(timeUnit.toNanos(j2));
        AppMethodBeat.o(90115);
    }

    public void triggerActions() {
        AppMethodBeat.i(90116);
        Py(this.time);
        AppMethodBeat.o(90116);
    }

    private void Py(long j2) {
        AppMethodBeat.i(90117);
        while (!this.dxk.isEmpty()) {
            c peek = this.dxk.peek();
            if (peek.time > j2) {
                break;
            }
            this.time = peek.time == 0 ? this.time : peek.time;
            this.dxk.remove();
            if (!peek.Uou.hQB()) {
                peek.Umw.call();
            }
        }
        this.time = j2;
        AppMethodBeat.o(90117);
    }

    @Override // rx.g
    public g.a createWorker() {
        AppMethodBeat.i(90118);
        b bVar = new b();
        AppMethodBeat.o(90118);
        return bVar;
    }

    final class b extends g.a {
        private final rx.f.a Uoq = new rx.f.a();

        b() {
            AppMethodBeat.i(90106);
            AppMethodBeat.o(90106);
        }

        @Override // rx.j
        public final void hQA() {
            AppMethodBeat.i(90107);
            this.Uoq.hQA();
            AppMethodBeat.o(90107);
        }

        @Override // rx.j
        public final boolean hQB() {
            AppMethodBeat.i(90108);
            boolean hQB = this.Uoq.hQB();
            AppMethodBeat.o(90108);
            return hQB;
        }

        @Override // rx.g.a
        public final j a(rx.b.a aVar, long j2, TimeUnit timeUnit) {
            AppMethodBeat.i(90109);
            final c cVar = new c(this, TestScheduler.this.time + timeUnit.toNanos(j2), aVar);
            TestScheduler.this.dxk.add(cVar);
            j e2 = d.e(new rx.b.a() {
                /* class rx.schedulers.TestScheduler.b.AnonymousClass1 */

                @Override // rx.b.a
                public final void call() {
                    AppMethodBeat.i(90104);
                    TestScheduler.this.dxk.remove(cVar);
                    AppMethodBeat.o(90104);
                }
            });
            AppMethodBeat.o(90109);
            return e2;
        }

        @Override // rx.g.a
        public final j a(rx.b.a aVar) {
            AppMethodBeat.i(90110);
            final c cVar = new c(this, 0, aVar);
            TestScheduler.this.dxk.add(cVar);
            j e2 = d.e(new rx.b.a() {
                /* class rx.schedulers.TestScheduler.b.AnonymousClass2 */

                @Override // rx.b.a
                public final void call() {
                    AppMethodBeat.i(90105);
                    TestScheduler.this.dxk.remove(cVar);
                    AppMethodBeat.o(90105);
                }
            });
            AppMethodBeat.o(90110);
            return e2;
        }

        @Override // rx.g.a
        public final long now() {
            AppMethodBeat.i(90111);
            long now = TestScheduler.this.now();
            AppMethodBeat.o(90111);
            return now;
        }
    }
}
