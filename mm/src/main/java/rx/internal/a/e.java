package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.a.b;
import rx.a.g;
import rx.d;
import rx.d.c;
import rx.f;
import rx.i;

public final class e<T, R> implements d.a<R> {
    final d<T> UkE;
    final rx.b.e<? super T, ? extends R> UkF;

    @Override // rx.b.b
    public final /* synthetic */ void cA(Object obj) {
        AppMethodBeat.i(90254);
        i iVar = (i) obj;
        a aVar = new a(iVar, this.UkF);
        iVar.b(aVar);
        this.UkE.a(aVar);
        AppMethodBeat.o(90254);
    }

    public e(d<T> dVar, rx.b.e<? super T, ? extends R> eVar) {
        this.UkE = dVar;
        this.UkF = eVar;
    }

    static final class a<T, R> extends i<T> {
        final i<? super R> UkG;
        final rx.b.e<? super T, ? extends R> UkH;
        boolean done;

        public a(i<? super R> iVar, rx.b.e<? super T, ? extends R> eVar) {
            this.UkG = iVar;
            this.UkH = eVar;
        }

        @Override // rx.e
        public final void gL(T t) {
            AppMethodBeat.i(90250);
            try {
                this.UkG.gL(this.UkH.call(t));
                AppMethodBeat.o(90250);
            } catch (Throwable th) {
                b.N(th);
                this.Ukg.hQA();
                onError(g.a(th, t));
                AppMethodBeat.o(90250);
            }
        }

        @Override // rx.e
        public final void onError(Throwable th) {
            AppMethodBeat.i(90251);
            if (this.done) {
                c.onError(th);
                AppMethodBeat.o(90251);
                return;
            }
            this.done = true;
            this.UkG.onError(th);
            AppMethodBeat.o(90251);
        }

        @Override // rx.e
        public final void hQw() {
            AppMethodBeat.i(90252);
            if (this.done) {
                AppMethodBeat.o(90252);
                return;
            }
            this.UkG.hQw();
            AppMethodBeat.o(90252);
        }

        @Override // rx.i
        public final void a(f fVar) {
            AppMethodBeat.i(90253);
            this.UkG.a(fVar);
            AppMethodBeat.o(90253);
        }
    }
}
