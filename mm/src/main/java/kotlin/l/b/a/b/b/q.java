package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.c.a.a;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.h;

public final class q {
    public static final e a(y yVar, b bVar, a aVar) {
        h hVar;
        h hAN;
        AppMethodBeat.i(56850);
        p.h(yVar, "$this$resolveClassByFqName");
        p.h(bVar, "fqName");
        p.h(aVar, "lookupLocation");
        if (bVar.TCR.TCW.isEmpty()) {
            AppMethodBeat.o(56850);
            return null;
        }
        b hJf = bVar.hJf();
        p.g(hJf, "fqName.parent()");
        h hAp = yVar.e(hJf).hAp();
        f hJg = bVar.hJg();
        p.g(hJg, "fqName.shortName()");
        h c2 = hAp.c(hJg, aVar);
        if (!(c2 instanceof e)) {
            c2 = null;
        }
        e eVar = (e) c2;
        if (eVar != null) {
            AppMethodBeat.o(56850);
            return eVar;
        }
        b hJf2 = bVar.hJf();
        p.g(hJf2, "fqName.parent()");
        e a2 = a(yVar, hJf2, aVar);
        if (a2 == null || (hAN = a2.hAN()) == null) {
            hVar = null;
        } else {
            f hJg2 = bVar.hJg();
            p.g(hJg2, "fqName.shortName()");
            hVar = hAN.c(hJg2, aVar);
        }
        if (!(hVar instanceof e)) {
            hVar = null;
        }
        e eVar2 = (e) hVar;
        AppMethodBeat.o(56850);
        return eVar2;
    }
}
