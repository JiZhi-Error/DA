package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.a.b;
import rx.d;
import rx.d.c;
import rx.i;

public final class d<T, R> implements d.a<R> {
    final d.a<T> UkC;
    final d.b<? extends R, ? super T> UkD;

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: rx.d$b */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: rx.d$a<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.b.b
    public final /* synthetic */ void cA(Object obj) {
        AppMethodBeat.i(90249);
        i iVar = (i) obj;
        try {
            i iVar2 = (i) c.b(this.UkD).call(iVar);
            try {
                iVar2.onStart();
                this.UkC.cA(iVar2);
                AppMethodBeat.o(90249);
            } catch (Throwable th) {
                b.N(th);
                iVar2.onError(th);
                AppMethodBeat.o(90249);
            }
        } catch (Throwable th2) {
            b.N(th2);
            iVar.onError(th2);
            AppMethodBeat.o(90249);
        }
    }

    public d(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        this.UkC = aVar;
        this.UkD = bVar;
    }
}
