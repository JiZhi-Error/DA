package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;

/* access modifiers changed from: package-private */
public final class i extends o {
    private final g Tih;

    @Override // kotlin.l.b.a.b.m.n
    public final /* synthetic */ n b(aj ajVar) {
        AppMethodBeat.i(60611);
        p.h(ajVar, "delegate");
        i iVar = new i(ajVar, this.Tih);
        AppMethodBeat.o(60611);
        return iVar;
    }

    @Override // kotlin.l.b.a.b.b.a.a, kotlin.l.b.a.b.m.n
    public final g hzL() {
        return this.Tih;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(aj ajVar, g gVar) {
        super(ajVar);
        p.h(ajVar, "delegate");
        p.h(gVar, "annotations");
        AppMethodBeat.i(60612);
        this.Tih = gVar;
        AppMethodBeat.o(60612);
    }
}
