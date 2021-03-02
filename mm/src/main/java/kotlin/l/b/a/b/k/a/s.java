package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;

public interface s {
    ab a(a.p pVar, String str, aj ajVar, aj ajVar2);

    public static final class a implements s {
        public static final a TLi = new a();

        static {
            AppMethodBeat.i(60318);
            AppMethodBeat.o(60318);
        }

        private a() {
        }

        @Override // kotlin.l.b.a.b.k.a.s
        public final ab a(a.p pVar, String str, aj ajVar, aj ajVar2) {
            AppMethodBeat.i(60317);
            p.h(pVar, "proto");
            p.h(str, "flexibleId");
            p.h(ajVar, "lowerBound");
            p.h(ajVar2, "upperBound");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("This method should not be used.");
            AppMethodBeat.o(60317);
            throw illegalArgumentException;
        }
    }
}
