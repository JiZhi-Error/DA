package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.a;
import rx.g;

final class l implements a {
    private final a UmN;
    private final g.a UmO;
    private final long wVP;

    public l(a aVar, g.a aVar2, long j2) {
        this.UmN = aVar;
        this.UmO = aVar2;
        this.wVP = j2;
    }

    @Override // rx.b.a
    public final void call() {
        AppMethodBeat.i(90400);
        if (this.UmO.hQB()) {
            AppMethodBeat.o(90400);
            return;
        }
        long now = this.wVP - this.UmO.now();
        if (now > 0) {
            try {
                Thread.sleep(now);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                RuntimeException runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(90400);
                throw runtimeException;
            }
        }
        if (this.UmO.hQB()) {
            AppMethodBeat.o(90400);
            return;
        }
        this.UmN.call();
        AppMethodBeat.o(90400);
    }
}
