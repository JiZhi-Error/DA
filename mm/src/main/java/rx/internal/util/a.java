package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.b;
import rx.i;

public final class a<T> extends i<T> {
    final b<? super T> UmU;
    final b<Throwable> UmV;
    final rx.b.a UmW;

    public a(b<? super T> bVar, b<Throwable> bVar2, rx.b.a aVar) {
        this.UmU = bVar;
        this.UmV = bVar2;
        this.UmW = aVar;
    }

    @Override // rx.e
    public final void gL(T t) {
        AppMethodBeat.i(90208);
        this.UmU.cA(t);
        AppMethodBeat.o(90208);
    }

    @Override // rx.e
    public final void onError(Throwable th) {
        AppMethodBeat.i(90209);
        this.UmV.cA(th);
        AppMethodBeat.o(90209);
    }

    @Override // rx.e
    public final void hQw() {
        AppMethodBeat.i(90210);
        this.UmW.call();
        AppMethodBeat.o(90210);
    }
}
