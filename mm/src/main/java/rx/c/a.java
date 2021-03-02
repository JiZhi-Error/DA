package rx.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import rx.a.b;
import rx.a.e;
import rx.a.f;
import rx.a.h;
import rx.d.c;
import rx.i;

public final class a<T> extends i<T> {
    private final i<? super T> UkG;
    boolean done;

    public a(i<? super T> iVar) {
        super(iVar);
        this.UkG = iVar;
    }

    @Override // rx.e
    public final void hQw() {
        AppMethodBeat.i(90432);
        if (!this.done) {
            this.done = true;
            try {
                this.UkG.hQw();
                try {
                    hQA();
                    AppMethodBeat.o(90432);
                } catch (Throwable th) {
                    c.onError(th);
                    h hVar = new h(th.getMessage(), th);
                    AppMethodBeat.o(90432);
                    throw hVar;
                }
            } catch (Throwable th2) {
                try {
                    hQA();
                    AppMethodBeat.o(90432);
                    throw th2;
                } catch (Throwable th3) {
                    c.onError(th3);
                    h hVar2 = new h(th3.getMessage(), th3);
                    AppMethodBeat.o(90432);
                    throw hVar2;
                }
            }
        } else {
            AppMethodBeat.o(90432);
        }
    }

    @Override // rx.e
    public final void onError(Throwable th) {
        AppMethodBeat.i(90433);
        b.N(th);
        if (!this.done) {
            this.done = true;
            c.onError(th);
            try {
                this.UkG.onError(th);
                try {
                    hQA();
                    AppMethodBeat.o(90433);
                } catch (Throwable th2) {
                    c.onError(th2);
                    e eVar = new e(th2);
                    AppMethodBeat.o(90433);
                    throw eVar;
                }
            } catch (f e2) {
                hQA();
                AppMethodBeat.o(90433);
                throw e2;
            } catch (Throwable th3) {
                c.onError(th3);
                e eVar2 = new e("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new rx.a.a(Arrays.asList(th, th, th3), (byte) 0));
                AppMethodBeat.o(90433);
                throw eVar2;
            }
        } else {
            AppMethodBeat.o(90433);
        }
    }

    @Override // rx.e
    public final void gL(T t) {
        AppMethodBeat.i(90434);
        try {
            if (!this.done) {
                this.UkG.gL(t);
            }
            AppMethodBeat.o(90434);
        } catch (Throwable th) {
            b.a(th, this);
            AppMethodBeat.o(90434);
        }
    }
}
