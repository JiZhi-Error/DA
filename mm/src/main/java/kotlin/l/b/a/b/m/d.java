package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.m.c.g;
import kotlin.l.b.a.b.m.c.h;
import kotlin.l.b.a.b.m.c.j;
import kotlin.l.b.a.b.m.c.m;
import kotlin.l.b.a.b.m.c.q;

public final class d {
    public static final d TNj = new d();

    static {
        AppMethodBeat.i(60575);
        AppMethodBeat.o(60575);
    }

    private d() {
    }

    public final boolean a(q qVar, h hVar, h hVar2) {
        AppMethodBeat.i(60572);
        p.h(qVar, "context");
        p.h(hVar, "a");
        p.h(hVar2, "b");
        boolean b2 = b(qVar, hVar, hVar2);
        AppMethodBeat.o(60572);
        return b2;
    }

    private final boolean b(q qVar, h hVar, h hVar2) {
        AppMethodBeat.i(60573);
        if (hVar == hVar2) {
            AppMethodBeat.o(60573);
            return true;
        }
        j o = qVar.o(hVar);
        j o2 = qVar.o(hVar2);
        if (o == null || o2 == null) {
            g p = qVar.p(hVar);
            g p2 = qVar.p(hVar2);
            if (p == null || p2 == null) {
                AppMethodBeat.o(60573);
                return false;
            } else if (!a(qVar, qVar.c(p), qVar.c(p2)) || !a(qVar, qVar.b(p), qVar.b(p2))) {
                AppMethodBeat.o(60573);
                return false;
            } else {
                AppMethodBeat.o(60573);
                return true;
            }
        } else {
            boolean a2 = a(qVar, o, o2);
            AppMethodBeat.o(60573);
            return a2;
        }
    }

    private final boolean a(q qVar, j jVar, j jVar2) {
        AppMethodBeat.i(60574);
        if (qVar.q(jVar) == qVar.q(jVar2) && qVar.h(jVar) == qVar.h(jVar2)) {
            if ((qVar.g(jVar) == null) == (qVar.g(jVar2) == null) && qVar.b(qVar.i(jVar), qVar.i(jVar2))) {
                if (qVar.a(jVar, jVar2)) {
                    AppMethodBeat.o(60574);
                    return true;
                }
                int q = qVar.q(jVar);
                for (int i2 = 0; i2 < q; i2++) {
                    m a2 = qVar.a(jVar, i2);
                    m a3 = qVar.a(jVar2, i2);
                    if (qVar.a(a2) != qVar.a(a3)) {
                        AppMethodBeat.o(60574);
                        return false;
                    }
                    if (!qVar.a(a2)) {
                        if (qVar.b(a2) != qVar.b(a3)) {
                            AppMethodBeat.o(60574);
                            return false;
                        } else if (!b(qVar, qVar.c(a2), qVar.c(a3))) {
                            AppMethodBeat.o(60574);
                            return false;
                        }
                    }
                }
                AppMethodBeat.o(60574);
                return true;
            }
        }
        AppMethodBeat.o(60574);
        return false;
    }
}
