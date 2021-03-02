package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.m.c.h;
import kotlin.l.b.a.b.m.c.j;
import kotlin.l.b.a.b.m.c.n;
import kotlin.l.b.a.b.m.c.o;
import kotlin.l.b.a.b.m.c.q;

public interface bb extends q {
    h a(o oVar);

    o a(n nVar);

    boolean a(h hVar, b bVar);

    boolean b(n nVar);

    kotlin.l.b.a.b.a.h c(n nVar);

    kotlin.l.b.a.b.a.h d(n nVar);

    boolean e(n nVar);

    c f(n nVar);

    h k(h hVar);

    boolean l(h hVar);

    h m(h hVar);

    public static final class a {
        public static boolean b(bb bbVar, h hVar) {
            AppMethodBeat.i(60871);
            p.h(hVar, "$this$isMarkedNullable");
            if (!(hVar instanceof j) || !bbVar.h((j) hVar)) {
                AppMethodBeat.o(60871);
                return false;
            }
            AppMethodBeat.o(60871);
            return true;
        }

        public static h c(bb bbVar, h hVar) {
            j a2;
            AppMethodBeat.i(60872);
            p.h(hVar, "$this$makeNullable");
            j o = bbVar.o(hVar);
            if (o == null || (a2 = bbVar.a(o, true)) == null) {
                AppMethodBeat.o(60872);
                return hVar;
            }
            j jVar = a2;
            AppMethodBeat.o(60872);
            return jVar;
        }
    }
}
