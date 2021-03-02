package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.k.a.h;
import kotlin.l.b.a.b.k.a.i;

public final class g implements i {
    private final n TqR;
    private final e TqS;

    public g(n nVar, e eVar) {
        p.h(nVar, "kotlinClassFinder");
        p.h(eVar, "deserializedDescriptorResolver");
        AppMethodBeat.i(58194);
        this.TqR = nVar;
        this.TqS = eVar;
        AppMethodBeat.o(58194);
    }

    @Override // kotlin.l.b.a.b.k.a.i
    public final h d(a aVar) {
        AppMethodBeat.i(58193);
        p.h(aVar, "classId");
        p a2 = o.a(this.TqR, aVar);
        if (a2 == null) {
            AppMethodBeat.o(58193);
            return null;
        }
        boolean j2 = p.j(a2.hyy(), aVar);
        if (!aa.SXc || j2) {
            h a3 = this.TqS.a(a2);
            AppMethodBeat.o(58193);
            return a3;
        }
        AssertionError assertionError = new AssertionError("Class with incorrect id found: expected " + aVar + ", actual " + a2.hyy());
        AppMethodBeat.o(58193);
        throw assertionError;
    }
}
