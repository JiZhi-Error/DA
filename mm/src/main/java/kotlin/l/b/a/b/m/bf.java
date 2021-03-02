package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;

public final class bf extends t {
    public final String TNK;

    @Override // kotlin.l.b.a.b.m.bg, kotlin.l.b.a.b.m.t
    public final /* synthetic */ bg EF(boolean z) {
        AppMethodBeat.i(60907);
        aj EG = EG(z);
        AppMethodBeat.o(60907);
        return EG;
    }

    @Override // kotlin.l.b.a.b.m.t, kotlin.l.b.a.b.m.ab
    public final /* synthetic */ ab d(i iVar) {
        AppMethodBeat.i(60908);
        p.h(iVar, "kotlinTypeRefiner");
        bf bfVar = this;
        AppMethodBeat.o(60908);
        return bfVar;
    }

    @Override // kotlin.l.b.a.b.m.bg, kotlin.l.b.a.b.m.t
    public final /* synthetic */ bg e(i iVar) {
        AppMethodBeat.i(60909);
        p.h(iVar, "kotlinTypeRefiner");
        bf bfVar = this;
        AppMethodBeat.o(60909);
        return bfVar;
    }

    @Override // kotlin.l.b.a.b.m.t
    public final /* synthetic */ t j(i iVar) {
        AppMethodBeat.i(60910);
        p.h(iVar, "kotlinTypeRefiner");
        bf bfVar = this;
        AppMethodBeat.o(60910);
        return bfVar;
    }

    @Override // kotlin.l.b.a.b.m.t
    public final String hLz() {
        return this.TNK;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private bf(String str, at atVar, h hVar, List<? extends av> list, boolean z) {
        super(atVar, hVar, list, z, null, 16);
        p.h(str, "presentableName");
        p.h(atVar, "constructor");
        p.h(hVar, "memberScope");
        p.h(list, "arguments");
        AppMethodBeat.i(60911);
        this.TNK = str;
        AppMethodBeat.o(60911);
    }

    @Override // kotlin.l.b.a.b.m.aj, kotlin.l.b.a.b.m.t
    public final aj EG(boolean z) {
        AppMethodBeat.i(60906);
        bf bfVar = new bf(this.TNK, hKE(), hAp(), hKB(), z);
        AppMethodBeat.o(60906);
        return bfVar;
    }
}
