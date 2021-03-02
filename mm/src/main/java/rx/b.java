package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.b.e;
import rx.f.d;

public final class b {
    static final b UjM = new b(new a() {
        /* class rx.b.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // rx.b.b
        public final /* synthetic */ void cA(c cVar) {
            AppMethodBeat.i(90068);
            c cVar2 = cVar;
            cVar2.a(d.hRn());
            cVar2.hQw();
            AppMethodBeat.o(90068);
        }
    }, (byte) 0);
    static final b UjN = new b(new a() {
        /* class rx.b.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // rx.b.b
        public final /* synthetic */ void cA(c cVar) {
            AppMethodBeat.i(90069);
            cVar.a(d.hRn());
            AppMethodBeat.o(90069);
        }
    }, (byte) 0);
    private final a UjL;

    public interface a extends rx.b.b<c> {
    }

    /* renamed from: rx.b$b  reason: collision with other inner class name */
    public interface AbstractC2390b extends e<c, c> {
    }

    public interface c {
        void a(j jVar);

        void hQw();
    }

    static {
        AppMethodBeat.i(90077);
        AppMethodBeat.o(90077);
    }

    public static b a(a aVar) {
        AppMethodBeat.i(90072);
        requireNonNull(aVar);
        try {
            b bVar = new b(aVar);
            AppMethodBeat.o(90072);
            return bVar;
        } catch (NullPointerException e2) {
            AppMethodBeat.o(90072);
            throw e2;
        } catch (Throwable th) {
            rx.d.c.onError(th);
            NullPointerException K = K(th);
            AppMethodBeat.o(90072);
            throw K;
        }
    }

    private static <T> T requireNonNull(T t) {
        AppMethodBeat.i(90073);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(90073);
            throw nullPointerException;
        }
        AppMethodBeat.o(90073);
        return t;
    }

    private static NullPointerException K(Throwable th) {
        AppMethodBeat.i(90074);
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        AppMethodBeat.o(90074);
        return nullPointerException;
    }

    private b(a aVar) {
        AppMethodBeat.i(90075);
        this.UjL = rx.d.c.b(aVar);
        AppMethodBeat.o(90075);
    }

    private b(a aVar, byte b2) {
        this.UjL = aVar;
    }

    public final j hQv() {
        AppMethodBeat.i(90076);
        final rx.f.c cVar = new rx.f.c();
        AnonymousClass3 r1 = new c() {
            /* class rx.b.AnonymousClass3 */

            @Override // rx.b.c
            public final void hQw() {
                AppMethodBeat.i(90070);
                cVar.hQA();
                AppMethodBeat.o(90070);
            }

            @Override // rx.b.c
            public final void a(j jVar) {
                AppMethodBeat.i(90071);
                cVar.f(jVar);
                AppMethodBeat.o(90071);
            }
        };
        requireNonNull(r1);
        try {
            rx.d.c.a(this, this.UjL).cA(r1);
            AppMethodBeat.o(90076);
            return cVar;
        } catch (NullPointerException e2) {
            AppMethodBeat.o(90076);
            throw e2;
        } catch (Throwable th) {
            rx.a.b.N(th);
            Throwable W = rx.d.c.W(th);
            rx.d.c.onError(W);
            NullPointerException K = K(W);
            AppMethodBeat.o(90076);
            throw K;
        }
    }
}
