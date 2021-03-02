package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.c.k;

public final class aq extends aj implements k {
    private final boolean TIm;
    private final at TNJ;
    private final at TOy;
    private final h Tly;

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg EF(boolean z) {
        AppMethodBeat.i(60821);
        aj EG = EG(z);
        AppMethodBeat.o(60821);
        return EG;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg b(g gVar) {
        AppMethodBeat.i(60819);
        aj d2 = d(gVar);
        AppMethodBeat.o(60819);
        return d2;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final /* synthetic */ ab d(i iVar) {
        AppMethodBeat.i(60823);
        p.h(iVar, "kotlinTypeRefiner");
        aq aqVar = this;
        AppMethodBeat.o(60823);
        return aqVar;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg e(i iVar) {
        AppMethodBeat.i(60824);
        p.h(iVar, "kotlinTypeRefiner");
        aq aqVar = this;
        AppMethodBeat.o(60824);
        return aqVar;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final boolean hEa() {
        return this.TIm;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final at hKE() {
        return this.TNJ;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final h hAp() {
        return this.Tly;
    }

    private aq(at atVar, boolean z, at atVar2, h hVar) {
        p.h(atVar, "originalTypeVariable");
        p.h(atVar2, "constructor");
        p.h(hVar, "memberScope");
        AppMethodBeat.i(60825);
        this.TOy = atVar;
        this.TIm = z;
        this.TNJ = atVar2;
        this.Tly = hVar;
        AppMethodBeat.o(60825);
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public final g hzL() {
        AppMethodBeat.i(60817);
        g.a aVar = g.TiC;
        g hBP = g.a.hBP();
        AppMethodBeat.o(60817);
        return hBP;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final aj d(g gVar) {
        AppMethodBeat.i(60818);
        p.h(gVar, "newAnnotations");
        aq aqVar = this;
        AppMethodBeat.o(60818);
        return aqVar;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final String toString() {
        AppMethodBeat.i(60822);
        String str = "NonFixed: " + this.TOy;
        AppMethodBeat.o(60822);
        return str;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final List<av> hKB() {
        return v.SXr;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final aj EG(boolean z) {
        AppMethodBeat.i(60820);
        if (z == this.TIm) {
            aq aqVar = this;
            AppMethodBeat.o(60820);
            return aqVar;
        }
        aq aqVar2 = new aq(this.TOy, z, this.TNJ, this.Tly);
        AppMethodBeat.o(60820);
        return aqVar2;
    }
}
