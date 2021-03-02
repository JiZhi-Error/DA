package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.m.a.i;

public final class an extends aw {
    private final ab TOt;

    public an(g gVar) {
        p.h(gVar, "kotlinBuiltIns");
        AppMethodBeat.i(60809);
        aj hzj = gVar.hzj();
        p.g(hzj, "kotlinBuiltIns.nullableAnyType");
        this.TOt = hzj;
        AppMethodBeat.o(60809);
    }

    @Override // kotlin.l.b.a.b.m.av
    public final boolean hLH() {
        return true;
    }

    @Override // kotlin.l.b.a.b.m.av
    public final bh hLI() {
        return bh.OUT_VARIANCE;
    }

    @Override // kotlin.l.b.a.b.m.av
    public final ab hBy() {
        return this.TOt;
    }

    @Override // kotlin.l.b.a.b.m.av
    public final av m(i iVar) {
        AppMethodBeat.i(60808);
        p.h(iVar, "kotlinTypeRefiner");
        an anVar = this;
        AppMethodBeat.o(60808);
        return anVar;
    }
}
