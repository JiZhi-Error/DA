package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import rx.b.e;
import rx.d.c;
import rx.internal.a.g;
import rx.internal.a.j;
import rx.internal.a.k;
import rx.internal.a.m;
import rx.internal.util.f;
import rx.internal.util.h;

public class d<T> {
    final a<T> UjW;

    public interface a<T> extends rx.b.b<i<? super T>> {
    }

    public interface b<R, T> extends e<i<? super R>, i<? super T>> {
    }

    public interface c<T, R> extends e<d<T>, d<R>> {
    }

    protected d(a<T> aVar) {
        this.UjW = aVar;
    }

    public static <T> d<T> a(a<T> aVar) {
        AppMethodBeat.i(90055);
        d<T> dVar = new d<>(c.b(aVar));
        AppMethodBeat.o(90055);
        return dVar;
    }

    public final <R> d<R> a(b<? extends R, ? super T> bVar) {
        AppMethodBeat.i(90056);
        d<R> a2 = a((a) new rx.internal.a.d(this.UjW, bVar));
        AppMethodBeat.o(90056);
        return a2;
    }

    public final <R> d<R> a(c<? super T, ? extends R> cVar) {
        AppMethodBeat.i(90057);
        d<R> dVar = (d) cVar.call(this);
        AppMethodBeat.o(90057);
        return dVar;
    }

    public static d<Long> a(TimeUnit timeUnit, g gVar) {
        AppMethodBeat.i(90058);
        d<Long> a2 = a((a) new g(0, 1000, timeUnit, gVar));
        AppMethodBeat.o(90058);
        return a2;
    }

    public final <R> d<R> a(e<? super T, ? extends R> eVar) {
        AppMethodBeat.i(90059);
        d<R> a2 = a((a) new rx.internal.a.e(this, eVar));
        AppMethodBeat.o(90059);
        return a2;
    }

    public final d<T> a(g gVar) {
        AppMethodBeat.i(90060);
        d<T> a2 = a(gVar, f.SIZE);
        AppMethodBeat.o(90060);
        return a2;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: rx.d<R>, rx.d<T> */
    private d<T> a(g gVar, int i2) {
        AppMethodBeat.i(90061);
        if (this instanceof h) {
            d<T> b2 = ((h) this).b(gVar);
            AppMethodBeat.o(90061);
            return b2;
        }
        d dVar = (d<R>) a((b) new j(gVar, i2));
        AppMethodBeat.o(90061);
        return dVar;
    }

    public final j a(rx.b.b<? super T> bVar) {
        AppMethodBeat.i(90063);
        j a2 = a(new rx.internal.util.a(bVar, rx.internal.util.c.Une, rx.b.c.hQD()), this);
        AppMethodBeat.o(90063);
        return a2;
    }

    public final j a(rx.b.b<? super T> bVar, rx.b.b<Throwable> bVar2) {
        AppMethodBeat.i(90064);
        j a2 = a(new rx.internal.util.a(bVar, bVar2, rx.b.c.hQD()), this);
        AppMethodBeat.o(90064);
        return a2;
    }

    public final j a(i<? super T> iVar) {
        AppMethodBeat.i(90065);
        try {
            iVar.onStart();
            c.a(this, this.UjW).cA(iVar);
            j c2 = c.c(iVar);
            AppMethodBeat.o(90065);
            return c2;
        } catch (Throwable th) {
            rx.a.b.N(th);
            rx.a.e eVar = new rx.a.e("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th);
            c.V(eVar);
            AppMethodBeat.o(90065);
            throw eVar;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: rx.d$a */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> j a(i<? super T> iVar, d<T> dVar) {
        AppMethodBeat.i(90066);
        if (dVar.UjW == null) {
            IllegalStateException illegalStateException = new IllegalStateException("onSubscribe function can not be null.");
            AppMethodBeat.o(90066);
            throw illegalStateException;
        }
        iVar.onStart();
        rx.c.a aVar = new rx.c.a(iVar);
        try {
            c.a(dVar, dVar.UjW).cA(aVar);
            j c2 = c.c(aVar);
            AppMethodBeat.o(90066);
            return c2;
        } catch (Throwable th) {
            rx.a.b.N(th);
            rx.a.e eVar = new rx.a.e("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th);
            c.V(eVar);
            AppMethodBeat.o(90066);
            throw eVar;
        }
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.d<R>, rx.d<T> */
    public final d<T> hQz() {
        AppMethodBeat.i(90067);
        d dVar = (d<R>) a((b) new m());
        AppMethodBeat.o(90067);
        return dVar;
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.d<R>, rx.d<T> */
    public final d<T> hQy() {
        AppMethodBeat.i(90062);
        d dVar = (d<R>) a((b) k.b.Ull);
        AppMethodBeat.o(90062);
        return dVar;
    }
}
