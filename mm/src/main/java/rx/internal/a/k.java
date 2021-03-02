package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.a.c;
import rx.d;
import rx.i;
import rx.internal.util.b;

public final class k<T> implements d.b<T, T> {
    private final Long Ulf = null;
    private final rx.b.a Ulg = null;
    private final a.d Ulh = rx.a.UjF;

    @Override // rx.b.e
    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.i(90290);
        i<? super T> b2 = b((i) obj);
        AppMethodBeat.o(90290);
        return b2;
    }

    public static final class b {
        public static final k<?> Ull = new k<>();

        static {
            AppMethodBeat.i(90278);
            AppMethodBeat.o(90278);
        }
    }

    k() {
    }

    private i<? super T> b(i<? super T> iVar) {
        AppMethodBeat.i(90289);
        a aVar = new a(iVar, this.Ulf, this.Ulg, this.Ulh);
        iVar.b(aVar);
        iVar.a(aVar.Ulk);
        AppMethodBeat.o(90289);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public static final class a<T> extends i<T> implements b.a {
        private final i<? super T> UkX;
        private final c<T> UkZ = c.hQG();
        private final rx.b.a Ulg;
        private final a.d Ulh;
        private final AtomicLong Uli;
        private final AtomicBoolean Ulj = new AtomicBoolean(false);
        final rx.internal.util.b Ulk;
        private final ConcurrentLinkedQueue<Object> vTW = new ConcurrentLinkedQueue<>();

        public a(i<? super T> iVar, Long l, rx.b.a aVar, a.d dVar) {
            AppMethodBeat.i(90279);
            this.UkX = iVar;
            this.Uli = l != null ? new AtomicLong(l.longValue()) : null;
            this.Ulg = aVar;
            this.Ulk = new rx.internal.util.b(this);
            this.Ulh = dVar;
            AppMethodBeat.o(90279);
        }

        @Override // rx.i
        public final void onStart() {
            AppMethodBeat.i(90280);
            Pw(MAlarmHandler.NEXT_FIRE_INTERVAL);
            AppMethodBeat.o(90280);
        }

        @Override // rx.e
        public final void hQw() {
            AppMethodBeat.i(90281);
            if (!this.Ulj.get()) {
                rx.internal.util.b bVar = this.Ulk;
                bVar.terminated = true;
                bVar.drain();
            }
            AppMethodBeat.o(90281);
        }

        @Override // rx.e
        public final void onError(Throwable th) {
            AppMethodBeat.i(90282);
            if (!this.Ulj.get()) {
                this.Ulk.S(th);
            }
            AppMethodBeat.o(90282);
        }

        @Override // rx.e
        public final void gL(T t) {
            AppMethodBeat.i(90283);
            if (!hQI()) {
                AppMethodBeat.o(90283);
                return;
            }
            this.vTW.offer(c.gN(t));
            this.Ulk.drain();
            AppMethodBeat.o(90283);
        }

        @Override // rx.internal.util.b.a
        public final boolean accept(Object obj) {
            AppMethodBeat.i(90284);
            boolean a2 = c.a(this.UkX, obj);
            AppMethodBeat.o(90284);
            return a2;
        }

        @Override // rx.internal.util.b.a
        public final void Q(Throwable th) {
            AppMethodBeat.i(90285);
            if (th != null) {
                this.UkX.onError(th);
                AppMethodBeat.o(90285);
                return;
            }
            this.UkX.hQw();
            AppMethodBeat.o(90285);
        }

        @Override // rx.internal.util.b.a
        public final Object peek() {
            AppMethodBeat.i(90286);
            Object peek = this.vTW.peek();
            AppMethodBeat.o(90286);
            return peek;
        }

        @Override // rx.internal.util.b.a
        public final Object poll() {
            AppMethodBeat.i(90287);
            Object poll = this.vTW.poll();
            if (!(this.Uli == null || poll == null)) {
                this.Uli.incrementAndGet();
            }
            AppMethodBeat.o(90287);
            return poll;
        }

        private boolean hQI() {
            long j2;
            boolean z;
            AppMethodBeat.i(90288);
            if (this.Uli == null) {
                AppMethodBeat.o(90288);
                return true;
            }
            do {
                j2 = this.Uli.get();
                if (j2 <= 0) {
                    try {
                        z = this.Ulh.hQu() && poll() != null;
                    } catch (c e2) {
                        if (this.Ulj.compareAndSet(false, true)) {
                            this.Ukg.hQA();
                            this.UkX.onError(e2);
                        }
                        z = false;
                    }
                    if (this.Ulg != null) {
                        try {
                            this.Ulg.call();
                        } catch (Throwable th) {
                            rx.a.b.N(th);
                            this.Ulk.S(th);
                            AppMethodBeat.o(90288);
                            return false;
                        }
                    }
                    if (!z) {
                        AppMethodBeat.o(90288);
                        return false;
                    }
                }
            } while (!this.Uli.compareAndSet(j2, j2 - 1));
            AppMethodBeat.o(90288);
            return true;
        }
    }
}
