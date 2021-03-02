package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import rx.j;

public final class c implements j {
    final AtomicReference<a> UoL = new AtomicReference<>(new a(false, d.hRm()));

    public c() {
        AppMethodBeat.i(90449);
        AppMethodBeat.o(90449);
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        final j UmE;
        final boolean Umo;

        a(boolean z, j jVar) {
            this.Umo = z;
            this.UmE = jVar;
        }

        /* access modifiers changed from: package-private */
        public final a hRl() {
            AppMethodBeat.i(90447);
            a aVar = new a(true, this.UmE);
            AppMethodBeat.o(90447);
            return aVar;
        }

        /* access modifiers changed from: package-private */
        public final a g(j jVar) {
            AppMethodBeat.i(90448);
            a aVar = new a(this.Umo, jVar);
            AppMethodBeat.o(90448);
            return aVar;
        }
    }

    @Override // rx.j
    public final boolean hQB() {
        AppMethodBeat.i(90450);
        boolean z = this.UoL.get().Umo;
        AppMethodBeat.o(90450);
        return z;
    }

    @Override // rx.j
    public final void hQA() {
        a aVar;
        AppMethodBeat.i(90451);
        AtomicReference<a> atomicReference = this.UoL;
        do {
            aVar = atomicReference.get();
            if (aVar.Umo) {
                AppMethodBeat.o(90451);
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.hRl()));
        aVar.UmE.hQA();
        AppMethodBeat.o(90451);
    }

    public final void f(j jVar) {
        a aVar;
        AppMethodBeat.i(90452);
        if (jVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Subscription can not be null");
            AppMethodBeat.o(90452);
            throw illegalArgumentException;
        }
        AtomicReference<a> atomicReference = this.UoL;
        do {
            aVar = atomicReference.get();
            if (aVar.Umo) {
                jVar.hQA();
                AppMethodBeat.o(90452);
                return;
            }
        } while (!atomicReference.compareAndSet(aVar, aVar.g(jVar)));
        AppMethodBeat.o(90452);
    }
}
