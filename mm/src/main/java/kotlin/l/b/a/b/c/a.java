package kotlin.l.b.a.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.c.a.b;
import kotlin.l.b.a.b.f.f;

public final class a {
    public static final void a(b bVar, kotlin.l.b.a.b.c.a.a aVar, e eVar, f fVar) {
        AppMethodBeat.i(57521);
        p.h(bVar, "$this$record");
        p.h(aVar, "from");
        p.h(eVar, "scopeOwner");
        p.h(fVar, "name");
        if (bVar == b.a.TnB) {
            AppMethodBeat.o(57521);
        } else {
            AppMethodBeat.o(57521);
        }
    }

    public static final void a(b bVar, kotlin.l.b.a.b.c.a.a aVar, ab abVar, f fVar) {
        AppMethodBeat.i(57522);
        p.h(bVar, "$this$record");
        p.h(aVar, "from");
        p.h(abVar, "scopeOwner");
        p.h(fVar, "name");
        String sG = abVar.hBk().sG();
        p.g(sG, "scopeOwner.fqName.asString()");
        String sG2 = fVar.sG();
        p.g(sG2, "name.asString()");
        p.h(bVar, "$this$recordPackageLookup");
        p.h(aVar, "from");
        p.h(sG, "packageFqName");
        p.h(sG2, "name");
        b.a aVar2 = b.a.TnB;
        AppMethodBeat.o(57522);
    }
}
