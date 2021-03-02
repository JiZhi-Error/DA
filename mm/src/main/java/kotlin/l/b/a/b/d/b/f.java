package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.c.h;
import kotlin.l.b.a.b.m.c.j;
import kotlin.l.b.a.b.m.c.n;
import kotlin.l.b.a.b.m.c.o;

public final class f {
    static final h a(bb bbVar, h hVar, HashSet<n> hashSet) {
        AppMethodBeat.i(58192);
        n d2 = bbVar.d(hVar);
        if (!hashSet.add(d2)) {
            AppMethodBeat.o(58192);
            return null;
        }
        o a2 = bbVar.a(d2);
        if (a2 != null) {
            h a3 = a(bbVar, bbVar.a(a2), hashSet);
            if (a3 == null) {
                AppMethodBeat.o(58192);
                return null;
            } else if (bbVar.s(a3) || !bbVar.l(hVar)) {
                AppMethodBeat.o(58192);
                return a3;
            } else {
                h m = bbVar.m(a3);
                AppMethodBeat.o(58192);
                return m;
            }
        } else {
            if (bbVar.b(d2)) {
                h k = bbVar.k(hVar);
                if (k == null) {
                    AppMethodBeat.o(58192);
                    return null;
                }
                h a4 = a(bbVar, k, hashSet);
                if (a4 == null) {
                    AppMethodBeat.o(58192);
                    return null;
                } else if (!bbVar.s(hVar)) {
                    AppMethodBeat.o(58192);
                    return a4;
                } else if (!bbVar.s(a4) && (!(a4 instanceof j) || !bbVar.l((j) a4))) {
                    h m2 = bbVar.m(a4);
                    AppMethodBeat.o(58192);
                    return m2;
                }
            }
            AppMethodBeat.o(58192);
            return hVar;
        }
    }
}
