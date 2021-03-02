package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ao;
import kotlin.l.b.a.b.k.a.b.f;
import kotlin.l.b.a.b.k.a.t;

public final class r implements f {
    private final t<kotlin.l.b.a.b.e.c.a.f> TvH;
    private final boolean TvI;
    public final p TvP;

    public r(p pVar, t<kotlin.l.b.a.b.e.c.a.f> tVar, boolean z) {
        p.h(pVar, "binaryClass");
        AppMethodBeat.i(58231);
        this.TvP = pVar;
        this.TvH = tVar;
        this.TvI = z;
        AppMethodBeat.o(58231);
    }

    @Override // kotlin.l.b.a.b.k.a.b.f
    public final String hEl() {
        AppMethodBeat.i(58228);
        String str = "Class '" + this.TvP.hyy().hJd().sG() + '\'';
        AppMethodBeat.o(58228);
        return str;
    }

    @Override // kotlin.l.b.a.b.b.an
    public final ao hBu() {
        AppMethodBeat.i(58229);
        ao aoVar = ao.ThL;
        p.g(aoVar, "SourceFile.NO_SOURCE_FILE");
        AppMethodBeat.o(58229);
        return aoVar;
    }

    public final String toString() {
        AppMethodBeat.i(58230);
        String str = getClass().getSimpleName() + ": " + this.TvP;
        AppMethodBeat.o(58230);
        return str;
    }
}
