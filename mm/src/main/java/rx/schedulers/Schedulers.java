package rx.schedulers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.d.c;
import rx.d.f;
import rx.g;
import rx.internal.c.d;
import rx.internal.c.j;
import rx.internal.c.m;

public final class Schedulers {
    private static final AtomicReference<Schedulers> Uop = new AtomicReference<>();
    private final g Uom = rx.d.g.hRc();
    private final g Uon = rx.d.g.hRd();
    private final g Uoo = rx.d.g.hRe();

    static {
        AppMethodBeat.i(90101);
        AppMethodBeat.o(90101);
    }

    private static Schedulers hRh() {
        Schedulers schedulers;
        AppMethodBeat.i(90089);
        while (true) {
            schedulers = Uop.get();
            if (schedulers != null) {
                AppMethodBeat.o(90089);
                break;
            }
            schedulers = new Schedulers();
            if (Uop.compareAndSet(null, schedulers)) {
                AppMethodBeat.o(90089);
                break;
            }
            schedulers.hRj();
        }
        return schedulers;
    }

    private Schedulers() {
        AppMethodBeat.i(90090);
        f.hQW().hRb();
        AppMethodBeat.o(90090);
    }

    public static g immediate() {
        return rx.internal.c.f.Umk;
    }

    public static g trampoline() {
        return m.UmP;
    }

    public static g newThread() {
        AppMethodBeat.i(90091);
        g e2 = c.e(hRh().Uoo);
        AppMethodBeat.o(90091);
        return e2;
    }

    public static g computation() {
        AppMethodBeat.i(90092);
        g c2 = c.c(hRh().Uom);
        AppMethodBeat.o(90092);
        return c2;
    }

    public static g io() {
        AppMethodBeat.i(90093);
        g d2 = c.d(hRh().Uon);
        AppMethodBeat.o(90093);
        return d2;
    }

    public static TestScheduler test() {
        AppMethodBeat.i(90094);
        TestScheduler testScheduler = new TestScheduler();
        AppMethodBeat.o(90094);
        return testScheduler;
    }

    public static g from(Executor executor) {
        AppMethodBeat.i(90095);
        rx.internal.c.c cVar = new rx.internal.c.c(executor);
        AppMethodBeat.o(90095);
        return cVar;
    }

    public static void reset() {
        AppMethodBeat.i(90096);
        Schedulers andSet = Uop.getAndSet(null);
        if (andSet != null) {
            andSet.hRj();
        }
        AppMethodBeat.o(90096);
    }

    public static void start() {
        AppMethodBeat.i(90097);
        Schedulers hRh = hRh();
        hRh.hRi();
        synchronized (hRh) {
            try {
                d.Umf.start();
                rx.internal.util.f.Uno.start();
                rx.internal.util.f.Unp.start();
            } finally {
                AppMethodBeat.o(90097);
            }
        }
    }

    public static void shutdown() {
        AppMethodBeat.i(90098);
        Schedulers hRh = hRh();
        hRh.hRj();
        synchronized (hRh) {
            try {
                d.Umf.shutdown();
                rx.internal.util.f.Uno.shutdown();
                rx.internal.util.f.Unp.shutdown();
            } finally {
                AppMethodBeat.o(90098);
            }
        }
    }

    private synchronized void hRi() {
        AppMethodBeat.i(90099);
        if (this.Uom instanceof j) {
            ((j) this.Uom).start();
        }
        if (this.Uon instanceof j) {
            ((j) this.Uon).start();
        }
        if (this.Uoo instanceof j) {
            ((j) this.Uoo).start();
        }
        AppMethodBeat.o(90099);
    }

    private synchronized void hRj() {
        AppMethodBeat.i(90100);
        if (this.Uom instanceof j) {
            ((j) this.Uom).shutdown();
        }
        if (this.Uon instanceof j) {
            ((j) this.Uon).shutdown();
        }
        if (this.Uoo instanceof j) {
            ((j) this.Uoo).shutdown();
        }
        AppMethodBeat.o(90100);
    }
}
