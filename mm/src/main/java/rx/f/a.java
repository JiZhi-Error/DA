package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import rx.j;

public final class a implements j {
    static final rx.b.a UoJ = new rx.b.a() {
        /* class rx.f.a.AnonymousClass1 */

        @Override // rx.b.a
        public final void call() {
        }
    };
    final AtomicReference<rx.b.a> UoI;

    public a() {
        AppMethodBeat.i(90440);
        this.UoI = new AtomicReference<>();
        AppMethodBeat.o(90440);
    }

    private a(rx.b.a aVar) {
        AppMethodBeat.i(90441);
        this.UoI = new AtomicReference<>(aVar);
        AppMethodBeat.o(90441);
    }

    public static a hRk() {
        AppMethodBeat.i(90442);
        a aVar = new a();
        AppMethodBeat.o(90442);
        return aVar;
    }

    public static a d(rx.b.a aVar) {
        AppMethodBeat.i(90443);
        a aVar2 = new a(aVar);
        AppMethodBeat.o(90443);
        return aVar2;
    }

    @Override // rx.j
    public final boolean hQB() {
        AppMethodBeat.i(90444);
        if (this.UoI.get() == UoJ) {
            AppMethodBeat.o(90444);
            return true;
        }
        AppMethodBeat.o(90444);
        return false;
    }

    @Override // rx.j
    public final void hQA() {
        rx.b.a andSet;
        AppMethodBeat.i(90445);
        if (!(this.UoI.get() == UoJ || (andSet = this.UoI.getAndSet(UoJ)) == null || andSet == UoJ)) {
            andSet.call();
        }
        AppMethodBeat.o(90445);
    }

    static {
        AppMethodBeat.i(90446);
        AppMethodBeat.o(90446);
    }
}
