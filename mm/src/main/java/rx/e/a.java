package rx.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import rx.a.b;
import rx.d;
import rx.e.c;
import rx.internal.a.c;

public final class a<T> extends b<T, T> {
    private final c<T> Ukv = c.hQG();
    final c<T> Uov;

    public a(d.a<T> aVar, c<T> cVar) {
        super(aVar);
        AppMethodBeat.i(90423);
        this.Uov = cVar;
        AppMethodBeat.o(90423);
    }

    @Override // rx.e
    public final void hQw() {
        AppMethodBeat.i(90424);
        if (this.Uov.active) {
            Object hQH = c.hQH();
            for (c.b<T> bVar : this.Uov.gO(hQH)) {
                bVar.gP(hQH);
            }
        }
        AppMethodBeat.o(90424);
    }

    @Override // rx.e
    public final void onError(Throwable th) {
        AppMethodBeat.i(90425);
        if (this.Uov.active) {
            Object P = rx.internal.a.c.P(th);
            ArrayList arrayList = null;
            for (c.b<T> bVar : this.Uov.gO(P)) {
                try {
                    bVar.gP(P);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            b.kP(arrayList);
        }
        AppMethodBeat.o(90425);
    }

    @Override // rx.e
    public final void gL(T t) {
        AppMethodBeat.i(90426);
        for (c.b bVar : ((c.a) this.Uov.get()).UoD) {
            bVar.gL(t);
        }
        AppMethodBeat.o(90426);
    }
}
