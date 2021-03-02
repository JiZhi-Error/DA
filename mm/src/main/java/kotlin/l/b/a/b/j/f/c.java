package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.j.f.d;

public abstract class c {
    public abstract int hKN();

    public String toString() {
        return getClass().getSimpleName();
    }

    public static final class a extends c {
        private static final int TJo;
        public static final a TJp = new a();

        static {
            AppMethodBeat.i(60194);
            d.a aVar = d.TJQ;
            int hKV = d.hKV();
            d.a aVar2 = d.TJQ;
            int hKT = d.hKT();
            d.a aVar3 = d.TJQ;
            TJo = hKV & ((hKT | d.hKU()) ^ -1);
            AppMethodBeat.o(60194);
        }

        private a() {
        }

        @Override // kotlin.l.b.a.b.j.f.c
        public final int hKN() {
            return TJo;
        }
    }

    public static final class b extends c {
        public static final b TJq = new b();

        static {
            AppMethodBeat.i(60195);
            AppMethodBeat.o(60195);
        }

        private b() {
        }

        @Override // kotlin.l.b.a.b.j.f.c
        public final int hKN() {
            return 0;
        }
    }
}
