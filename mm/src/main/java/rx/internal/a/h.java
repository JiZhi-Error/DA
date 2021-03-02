package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.a.b;
import rx.b.e;
import rx.d;
import rx.i;
import rx.internal.b.a;

public final class h<T> implements d.b<Boolean, T> {
    final e<? super T, Boolean> UkO;
    final boolean UkP = true;

    @Override // rx.b.e
    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.i(90263);
        i<? super T> b2 = b((i) obj);
        AppMethodBeat.o(90263);
        return b2;
    }

    public h(e<? super T, Boolean> eVar) {
        this.UkO = eVar;
    }

    private i<? super T> b(final i<? super Boolean> iVar) {
        AppMethodBeat.i(90262);
        final a aVar = new a(iVar);
        AnonymousClass1 r1 = new i<T>() {
            /* class rx.internal.a.h.AnonymousClass1 */
            boolean UkQ;
            boolean done;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: rx.internal.b.a */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.e
            public final void gL(T t) {
                boolean z;
                AppMethodBeat.i(90259);
                this.UkQ = true;
                try {
                    if (h.this.UkO.call(t).booleanValue() && !this.done) {
                        this.done = true;
                        a aVar = aVar;
                        if (!h.this.UkP) {
                            z = true;
                        } else {
                            z = false;
                        }
                        aVar.setValue(Boolean.valueOf(z));
                        this.Ukg.hQA();
                    }
                    AppMethodBeat.o(90259);
                } catch (Throwable th) {
                    b.a(th, this, t);
                    AppMethodBeat.o(90259);
                }
            }

            @Override // rx.e
            public final void onError(Throwable th) {
                AppMethodBeat.i(90260);
                iVar.onError(th);
                AppMethodBeat.o(90260);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: rx.internal.b.a */
            /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: rx.internal.b.a */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.e
            public final void hQw() {
                AppMethodBeat.i(90261);
                if (!this.done) {
                    this.done = true;
                    if (this.UkQ) {
                        aVar.setValue(Boolean.FALSE);
                        AppMethodBeat.o(90261);
                        return;
                    }
                    aVar.setValue(Boolean.valueOf(h.this.UkP));
                }
                AppMethodBeat.o(90261);
            }
        };
        iVar.b(r1);
        iVar.a(aVar);
        AppMethodBeat.o(90262);
        return r1;
    }
}
