package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ac;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.b;

public final class o implements i {
    private final ac TKP;

    public o(ac acVar) {
        p.h(acVar, "packageFragmentProvider");
        AppMethodBeat.i(60311);
        this.TKP = acVar;
        AppMethodBeat.o(60311);
    }

    @Override // kotlin.l.b.a.b.k.a.i
    public final h d(a aVar) {
        h d2;
        AppMethodBeat.i(60310);
        p.h(aVar, "classId");
        ac acVar = this.TKP;
        b hIY = aVar.hIY();
        p.g(hIY, "classId.packageFqName");
        for (ab abVar : acVar.f(hIY)) {
            if ((abVar instanceof p) && (d2 = ((p) abVar).hLe().d(aVar)) != null) {
                AppMethodBeat.o(60310);
                return d2;
            }
        }
        AppMethodBeat.o(60310);
        return null;
    }
}
