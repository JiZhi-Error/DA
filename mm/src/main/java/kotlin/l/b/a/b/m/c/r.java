package kotlin.l.b.a.b.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.m.c.q;

public interface r extends p, q {

    public static final class a {
        public static int a(r rVar, l lVar) {
            AppMethodBeat.i(61243);
            p.h(lVar, "$this$size");
            int a2 = q.a.a(rVar, lVar);
            AppMethodBeat.o(61243);
            return a2;
        }

        public static m a(r rVar, l lVar, int i2) {
            AppMethodBeat.i(61242);
            p.h(lVar, "$this$get");
            m a2 = q.a.a(rVar, lVar, i2);
            AppMethodBeat.o(61242);
            return a2;
        }

        public static n a(r rVar, h hVar) {
            AppMethodBeat.i(61239);
            p.h(hVar, "$this$typeConstructor");
            n f2 = q.a.f(rVar, hVar);
            AppMethodBeat.o(61239);
            return f2;
        }

        public static j b(r rVar, h hVar) {
            AppMethodBeat.i(61240);
            p.h(hVar, "$this$lowerBoundIfFlexible");
            j a2 = q.a.a(rVar, hVar);
            AppMethodBeat.o(61240);
            return a2;
        }

        public static j c(r rVar, h hVar) {
            AppMethodBeat.i(61241);
            p.h(hVar, "$this$upperBoundIfFlexible");
            j b2 = q.a.b(rVar, hVar);
            AppMethodBeat.o(61241);
            return b2;
        }
    }
}
