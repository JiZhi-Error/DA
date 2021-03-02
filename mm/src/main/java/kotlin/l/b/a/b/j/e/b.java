package kotlin.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.c.a.c;
import kotlin.l.b.a.b.d.a.c.g;
import kotlin.l.b.a.b.d.a.e.aa;
import kotlin.l.b.a.b.j.f.h;

public final class b {
    public final g TIV;
    private final kotlin.l.b.a.b.d.a.a.g TqV;

    public b(g gVar, kotlin.l.b.a.b.d.a.a.g gVar2) {
        p.h(gVar, "packageFragmentProvider");
        p.h(gVar2, "javaResolverCache");
        AppMethodBeat.i(60164);
        this.TIV = gVar;
        this.TqV = gVar2;
        AppMethodBeat.o(60164);
    }

    public final e c(kotlin.l.b.a.b.d.a.e.g gVar) {
        h hVar;
        kotlin.l.b.a.b.b.h hVar2;
        AppMethodBeat.i(60163);
        p.h(gVar, "javaClass");
        kotlin.l.b.a.b.f.b hBk = gVar.hBk();
        if (hBk == null || aa.SOURCE != null) {
            kotlin.l.b.a.b.d.a.e.g hCL = gVar.hCL();
            if (hCL != null) {
                e c2 = c(hCL);
                if (c2 != null) {
                    hVar = c2.hAN();
                } else {
                    hVar = null;
                }
                if (hVar != null) {
                    hVar2 = hVar.c(gVar.hAH(), c.FROM_JAVA_LOADER);
                } else {
                    hVar2 = null;
                }
                if (!(hVar2 instanceof e)) {
                    hVar2 = null;
                }
                e eVar = (e) hVar2;
                AppMethodBeat.o(60163);
                return eVar;
            } else if (hBk == null) {
                AppMethodBeat.o(60163);
                return null;
            } else {
                g gVar2 = this.TIV;
                kotlin.l.b.a.b.f.b hJf = hBk.hJf();
                p.g(hJf, "fqName.parent()");
                kotlin.l.b.a.b.d.a.c.a.h hVar3 = (kotlin.l.b.a.b.d.a.c.a.h) j.kt(gVar2.f(hJf));
                if (hVar3 != null) {
                    e d2 = hVar3.d(gVar);
                    AppMethodBeat.o(60163);
                    return d2;
                }
                AppMethodBeat.o(60163);
                return null;
            }
        } else {
            e n = this.TqV.n(hBk);
            AppMethodBeat.o(60163);
            return n;
        }
    }
}
