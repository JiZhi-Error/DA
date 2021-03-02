package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.g.b.p;

public final class n {
    public static final d a(g gVar, e eVar, boolean z, boolean z2) {
        AppMethodBeat.i(58118);
        if (!z2 || gVar != g.NOT_NULL) {
            d dVar = new d(gVar, eVar, false, z);
            AppMethodBeat.o(58118);
            return dVar;
        }
        d dVar2 = new d(gVar, eVar, true, z);
        AppMethodBeat.o(58118);
        return dVar2;
    }

    public static final <T> T a(Set<? extends T> set, T t, T t2, T t3, boolean z) {
        Set<? extends T> set2;
        AppMethodBeat.i(58119);
        p.h(set, "$this$select");
        p.h(t, "low");
        p.h(t2, "high");
        if (z) {
            T t4 = set.contains(t) ? t : set.contains(t2) ? t2 : null;
            if (!p.j(t4, t) || !p.j(t3, t2)) {
                if (t3 != null) {
                    t4 = t3;
                }
                AppMethodBeat.o(58119);
                return t4;
            }
            AppMethodBeat.o(58119);
            return null;
        }
        if (t3 == null || (set2 = j.r((Iterable) ak.c(set, t3))) == null) {
            set2 = set;
        }
        T t5 = (T) j.j(set2);
        AppMethodBeat.o(58119);
        return t5;
    }

    public static final g a(Set<? extends g> set, g gVar, boolean z) {
        AppMethodBeat.i(58120);
        p.h(set, "$this$select");
        if (gVar == g.FORCE_FLEXIBILITY) {
            g gVar2 = g.FORCE_FLEXIBILITY;
            AppMethodBeat.o(58120);
            return gVar2;
        }
        g gVar3 = (g) a(set, g.NOT_NULL, g.NULLABLE, gVar, z);
        AppMethodBeat.o(58120);
        return gVar3;
    }
}
