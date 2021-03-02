package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.u;
import kotlin.o;
import kotlin.s;

public final class j extends g<o<? extends a, ? extends f>> {
    private final a TIx;
    public final f TIy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(a aVar, f fVar) {
        super(s.U(aVar, fVar));
        p.h(aVar, "enumClassId");
        p.h(fVar, "enumEntryName");
        AppMethodBeat.i(60065);
        this.TIx = aVar;
        this.TIy = fVar;
        AppMethodBeat.o(60065);
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final ab b(y yVar) {
        aj hAG;
        AppMethodBeat.i(60063);
        p.h(yVar, "module");
        e b2 = kotlin.l.b.a.b.b.s.b(yVar, this.TIx);
        if (b2 != null) {
            if (!c.y((l) b2)) {
                b2 = null;
            }
            if (!(b2 == null || (hAG = b2.hAG()) == null)) {
                aj ajVar = hAG;
                AppMethodBeat.o(60063);
                return ajVar;
            }
        }
        aj bun = u.bun("Containing class for error-class based enum entry " + this.TIx + '.' + this.TIy);
        p.g(bun, "ErrorUtils.createErrorTy…mClassId.$enumEntryName\")");
        aj ajVar2 = bun;
        AppMethodBeat.o(60063);
        return ajVar2;
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final String toString() {
        AppMethodBeat.i(60064);
        String sb = new StringBuilder().append(this.TIx.hJa()).append('.').append(this.TIy).toString();
        AppMethodBeat.o(60064);
        return sb;
    }
}
