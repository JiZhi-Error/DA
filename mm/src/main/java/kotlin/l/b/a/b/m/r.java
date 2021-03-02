package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.c.f;
import kotlin.l.b.a.b.m.d.a;

public final class r extends v implements f {
    private final g Tih;

    @Override // kotlin.l.b.a.b.m.bg
    public final /* bridge */ /* synthetic */ bg EF(boolean z) {
        return this;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg b(g gVar) {
        AppMethodBeat.i(60649);
        p.h(gVar, "newAnnotations");
        r rVar = new r(a.aM(this.TNW), gVar);
        AppMethodBeat.o(60649);
        return rVar;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final /* synthetic */ ab d(i iVar) {
        AppMethodBeat.i(60651);
        p.h(iVar, "kotlinTypeRefiner");
        r rVar = this;
        AppMethodBeat.o(60651);
        return rVar;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg e(i iVar) {
        AppMethodBeat.i(60652);
        p.h(iVar, "kotlinTypeRefiner");
        r rVar = this;
        AppMethodBeat.o(60652);
        return rVar;
    }

    @Override // kotlin.l.b.a.b.b.a.a, kotlin.l.b.a.b.m.v
    public final g hzL() {
        return this.Tih;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private r(kotlin.l.b.a.b.a.g r5, kotlin.l.b.a.b.b.a.g r6) {
        /*
            r4 = this;
            r3 = 60653(0xeced, float:8.4993E-41)
            java.lang.String r0 = "builtIns"
            kotlin.g.b.p.h(r5, r0)
            java.lang.String r0 = "annotations"
            kotlin.g.b.p.h(r6, r0)
            kotlin.l.b.a.b.m.aj r0 = r5.hzh()
            java.lang.String r1 = "builtIns.nothingType"
            kotlin.g.b.p.g(r0, r1)
            kotlin.l.b.a.b.m.aj r1 = r5.hzj()
            java.lang.String r2 = "builtIns.nullableAnyType"
            kotlin.g.b.p.g(r1, r2)
            r4.<init>(r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            r4.Tih = r6
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.m.r.<init>(kotlin.l.b.a.b.a.g, kotlin.l.b.a.b.b.a.g):void");
    }

    @Override // kotlin.l.b.a.b.m.v, kotlin.l.b.a.b.m.ab
    public final boolean hEa() {
        return false;
    }

    @Override // kotlin.l.b.a.b.m.v
    public final String a(c cVar, kotlin.l.b.a.b.i.i iVar) {
        AppMethodBeat.i(60650);
        p.h(cVar, "renderer");
        p.h(iVar, "options");
        AppMethodBeat.o(60650);
        return "dynamic";
    }

    @Override // kotlin.l.b.a.b.m.v
    public final aj hDW() {
        return this.TNW;
    }
}
