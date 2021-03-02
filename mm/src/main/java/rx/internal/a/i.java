package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import rx.a.a;
import rx.a.b;
import rx.d;
import rx.e;

public final class i<T> implements d.b<T, T> {
    final e<? super T> UkT;

    @Override // rx.b.e
    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.i(90267);
        final rx.i iVar = (rx.i) obj;
        AnonymousClass1 r0 = new rx.i<T>(iVar) {
            /* class rx.internal.a.i.AnonymousClass1 */
            private boolean done;

            @Override // rx.e
            public final void hQw() {
                AppMethodBeat.i(90264);
                if (this.done) {
                    AppMethodBeat.o(90264);
                    return;
                }
                try {
                    i.this.UkT.hQw();
                    this.done = true;
                    iVar.hQw();
                    AppMethodBeat.o(90264);
                } catch (Throwable th) {
                    b.a(th, this);
                    AppMethodBeat.o(90264);
                }
            }

            @Override // rx.e
            public final void onError(Throwable th) {
                AppMethodBeat.i(90265);
                b.N(th);
                if (this.done) {
                    AppMethodBeat.o(90265);
                    return;
                }
                this.done = true;
                try {
                    i.this.UkT.onError(th);
                    iVar.onError(th);
                    AppMethodBeat.o(90265);
                } catch (Throwable th2) {
                    b.N(th2);
                    iVar.onError(new a(Arrays.asList(th, th2), (byte) 0));
                    AppMethodBeat.o(90265);
                }
            }

            @Override // rx.e
            public final void gL(T t) {
                AppMethodBeat.i(90266);
                if (this.done) {
                    AppMethodBeat.o(90266);
                    return;
                }
                try {
                    i.this.UkT.gL(t);
                    iVar.gL(t);
                    AppMethodBeat.o(90266);
                } catch (Throwable th) {
                    b.a(th, this, t);
                    AppMethodBeat.o(90266);
                }
            }
        };
        AppMethodBeat.o(90267);
        return r0;
    }

    public i(e<? super T> eVar) {
        this.UkT = eVar;
    }
}
