package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static final d UjE;
    public static final d UjF;
    public static final d UjG = b.UjJ;
    public static final d UjH = C2387a.UjI;

    public interface d {
        boolean hQu();
    }

    static {
        c cVar = c.UjK;
        UjE = cVar;
        UjF = cVar;
    }

    static class b implements d {
        static final b UjJ = new b();

        static {
            AppMethodBeat.i(90030);
            AppMethodBeat.o(90030);
        }

        private b() {
        }

        @Override // rx.a.d
        public final boolean hQu() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    static class C2387a implements d {
        static final C2387a UjI = new C2387a();

        static {
            AppMethodBeat.i(90031);
            AppMethodBeat.o(90031);
        }

        private C2387a() {
        }

        @Override // rx.a.d
        public final boolean hQu() {
            return false;
        }
    }

    static class c implements d {
        static final c UjK = new c();

        static {
            AppMethodBeat.i(90033);
            AppMethodBeat.o(90033);
        }

        private c() {
        }

        @Override // rx.a.d
        public final boolean hQu() {
            AppMethodBeat.i(90032);
            rx.a.c cVar = new rx.a.c("Overflowed buffer");
            AppMethodBeat.o(90032);
            throw cVar;
        }
    }
}
