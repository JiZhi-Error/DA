package rx.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.internal.c.a;
import rx.internal.c.b;

public class g {
    private static final g Uok = new g();

    static {
        AppMethodBeat.i(90499);
        AppMethodBeat.o(90499);
    }

    public static rx.g hRc() {
        AppMethodBeat.i(90496);
        b bVar = new b(new rx.internal.util.g("RxComputationScheduler-"));
        AppMethodBeat.o(90496);
        return bVar;
    }

    public static rx.g hRd() {
        AppMethodBeat.i(90497);
        a aVar = new a(new rx.internal.util.g("RxIoScheduler-"));
        AppMethodBeat.o(90497);
        return aVar;
    }

    public static rx.g hRe() {
        AppMethodBeat.i(90498);
        rx.internal.c.g gVar = new rx.internal.c.g(new rx.internal.util.g("RxNewThreadScheduler-"));
        AppMethodBeat.o(90498);
        return gVar;
    }

    @Deprecated
    public static rx.b.a c(rx.b.a aVar) {
        return aVar;
    }

    public static g hRf() {
        return Uok;
    }
}
