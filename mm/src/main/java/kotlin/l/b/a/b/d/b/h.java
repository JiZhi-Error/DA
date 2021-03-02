package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.c.b.g;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.k.a.s;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.u;

public final class h implements s {
    public static final h TvB = new h();

    static {
        AppMethodBeat.i(58196);
        AppMethodBeat.o(58196);
    }

    private h() {
    }

    @Override // kotlin.l.b.a.b.k.a.s
    public final ab a(a.p pVar, String str, aj ajVar, aj ajVar2) {
        AppMethodBeat.i(58195);
        p.h(pVar, "proto");
        p.h(str, "flexibleId");
        p.h(ajVar, "lowerBound");
        p.h(ajVar2, "upperBound");
        if (!p.j(str, "kotlin.jvm.PlatformType")) {
            aj bun = u.bun("Error java flexible type with id: " + str + ". (" + ajVar + ".." + ajVar2 + ')');
            p.g(bun, "ErrorUtils.createErrorTy…owerBound..$upperBound)\")");
            aj ajVar3 = bun;
            AppMethodBeat.o(58195);
            return ajVar3;
        } else if (pVar.c(kotlin.l.b.a.b.e.c.a.TBQ)) {
            g gVar = new g(ajVar, ajVar2);
            AppMethodBeat.o(58195);
            return gVar;
        } else {
            bg a2 = ac.a(ajVar, ajVar2);
            AppMethodBeat.o(58195);
            return a2;
        }
    }
}
