package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;

public class m extends ay {
    private final ay Tlg;

    public m(ay ayVar) {
        p.h(ayVar, "substitution");
        AppMethodBeat.i(60638);
        this.Tlg = ayVar;
        AppMethodBeat.o(60638);
    }

    @Override // kotlin.l.b.a.b.m.ay
    public av N(ab abVar) {
        AppMethodBeat.i(60632);
        p.h(abVar, "key");
        av N = this.Tlg.N(abVar);
        AppMethodBeat.o(60632);
        return N;
    }

    @Override // kotlin.l.b.a.b.m.ay
    public final ab a(ab abVar, bh bhVar) {
        AppMethodBeat.i(60633);
        p.h(abVar, "topLevelType");
        p.h(bhVar, "position");
        ab a2 = this.Tlg.a(abVar, bhVar);
        AppMethodBeat.o(60633);
        return a2;
    }

    @Override // kotlin.l.b.a.b.m.ay
    public final boolean isEmpty() {
        AppMethodBeat.i(60634);
        boolean isEmpty = this.Tlg.isEmpty();
        AppMethodBeat.o(60634);
        return isEmpty;
    }

    @Override // kotlin.l.b.a.b.m.ay
    public final boolean hLy() {
        AppMethodBeat.i(60635);
        boolean hLy = this.Tlg.hLy();
        AppMethodBeat.o(60635);
        return hLy;
    }

    @Override // kotlin.l.b.a.b.m.ay
    public boolean hKG() {
        AppMethodBeat.i(60636);
        boolean hKG = this.Tlg.hKG();
        AppMethodBeat.o(60636);
        return hKG;
    }

    @Override // kotlin.l.b.a.b.m.ay
    public final g h(g gVar) {
        AppMethodBeat.i(60637);
        p.h(gVar, "annotations");
        g h2 = this.Tlg.h(gVar);
        AppMethodBeat.o(60637);
        return h2;
    }
}
