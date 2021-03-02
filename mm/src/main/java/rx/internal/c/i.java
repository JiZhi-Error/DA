package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.a.f;
import rx.j;

public final class i extends AtomicReference<Thread> implements Runnable, j {
    final rx.internal.util.i Umv;
    final rx.b.a Umw;

    public i(rx.b.a aVar) {
        AppMethodBeat.i(90341);
        this.Umw = aVar;
        this.Umv = new rx.internal.util.i();
        AppMethodBeat.o(90341);
    }

    public i(rx.b.a aVar, rx.f.b bVar) {
        AppMethodBeat.i(90342);
        this.Umw = aVar;
        this.Umv = new rx.internal.util.i(new b(this, bVar));
        AppMethodBeat.o(90342);
    }

    public i(rx.b.a aVar, rx.internal.util.i iVar) {
        AppMethodBeat.i(90343);
        this.Umw = aVar;
        this.Umv = new rx.internal.util.i(new c(this, iVar));
        AppMethodBeat.o(90343);
    }

    public final void run() {
        AppMethodBeat.i(90344);
        try {
            lazySet(Thread.currentThread());
            this.Umw.call();
        } catch (f e2) {
            R(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e2));
        } catch (Throwable th) {
            R(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th));
        } finally {
            hQA();
            AppMethodBeat.o(90344);
        }
    }

    private static void R(Throwable th) {
        AppMethodBeat.i(90345);
        rx.d.c.onError(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        AppMethodBeat.o(90345);
    }

    @Override // rx.j
    public final boolean hQB() {
        return this.Umv.UnB;
    }

    @Override // rx.j
    public final void hQA() {
        AppMethodBeat.i(90346);
        if (!this.Umv.UnB) {
            this.Umv.hQA();
        }
        AppMethodBeat.o(90346);
    }

    public final void b(Future<?> future) {
        AppMethodBeat.i(90347);
        this.Umv.b(new a(future));
        AppMethodBeat.o(90347);
    }

    /* access modifiers changed from: package-private */
    public final class a implements j {
        private final Future<?> Umx;

        a(Future<?> future) {
            this.Umx = future;
        }

        @Override // rx.j
        public final void hQA() {
            AppMethodBeat.i(90337);
            if (i.this.get() != Thread.currentThread()) {
                this.Umx.cancel(true);
                AppMethodBeat.o(90337);
                return;
            }
            this.Umx.cancel(false);
            AppMethodBeat.o(90337);
        }

        @Override // rx.j
        public final boolean hQB() {
            AppMethodBeat.i(90338);
            boolean isCancelled = this.Umx.isCancelled();
            AppMethodBeat.o(90338);
            return isCancelled;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b extends AtomicBoolean implements j {
        final rx.f.b UmA;
        final i Umz;

        public b(i iVar, rx.f.b bVar) {
            this.Umz = iVar;
            this.UmA = bVar;
        }

        @Override // rx.j
        public final boolean hQB() {
            return this.Umz.Umv.UnB;
        }

        @Override // rx.j
        public final void hQA() {
            AppMethodBeat.i(90339);
            if (compareAndSet(false, true)) {
                this.UmA.e(this.Umz);
            }
            AppMethodBeat.o(90339);
        }
    }

    static final class c extends AtomicBoolean implements j {
        final rx.internal.util.i UmB;
        final i Umz;

        public c(i iVar, rx.internal.util.i iVar2) {
            this.Umz = iVar;
            this.UmB = iVar2;
        }

        @Override // rx.j
        public final boolean hQB() {
            return this.Umz.Umv.UnB;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
            if (r2 == false) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
            r0.hQA();
         */
        @Override // rx.j
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void hQA() {
            /*
                r5 = this;
                r4 = 90340(0x160e4, float:1.26593E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                r0 = 0
                r1 = 1
                boolean r0 = r5.compareAndSet(r0, r1)
                if (r0 == 0) goto L_0x002e
                rx.internal.util.i r1 = r5.UmB
                rx.internal.c.i r0 = r5.Umz
                boolean r2 = r1.UnB
                if (r2 != 0) goto L_0x002e
                monitor-enter(r1)
                java.util.List<rx.j> r2 = r1.UnA     // Catch:{ all -> 0x0032 }
                boolean r3 = r1.UnB     // Catch:{ all -> 0x0032 }
                if (r3 != 0) goto L_0x001f
                if (r2 != 0) goto L_0x0024
            L_0x001f:
                monitor-exit(r1)     // Catch:{ all -> 0x0032 }
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x0023:
                return
            L_0x0024:
                boolean r2 = r2.remove(r0)
                monitor-exit(r1)
                if (r2 == 0) goto L_0x002e
                r0.hQA()
            L_0x002e:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0023
            L_0x0032:
                r0 = move-exception
                monitor-exit(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.c.i.c.hQA():void");
        }
    }
}
