package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import rx.a.b;
import rx.b.a;
import rx.d;
import rx.g;
import rx.i;

public final class f implements d.a<Long> {
    final TimeUnit UkI;
    final g UkJ;
    final long time = 10;

    @Override // rx.b.b
    public final /* synthetic */ void cA(Object obj) {
        AppMethodBeat.i(90256);
        final i iVar = (i) obj;
        g.a createWorker = this.UkJ.createWorker();
        iVar.b(createWorker);
        createWorker.a(new a() {
            /* class rx.internal.a.f.AnonymousClass1 */

            @Override // rx.b.a
            public final void call() {
                AppMethodBeat.i(90255);
                try {
                    iVar.gL(0L);
                    iVar.hQw();
                    AppMethodBeat.o(90255);
                } catch (Throwable th) {
                    b.a(th, iVar);
                    AppMethodBeat.o(90255);
                }
            }
        }, this.time, this.UkI);
        AppMethodBeat.o(90256);
    }

    public f(TimeUnit timeUnit, g gVar) {
        this.UkI = timeUnit;
        this.UkJ = gVar;
    }
}
