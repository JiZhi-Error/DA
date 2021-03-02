package kotlin.l.b.a.b.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.ar;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.c.d;
import kotlin.l.b.a.b.m.u;

public final class a extends aj implements ar, d {
    private final av TIk;
    private final b TIl;
    private final boolean TIm;
    private final g Tih;

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg EF(boolean z) {
        AppMethodBeat.i(60018);
        a ER = ER(z);
        AppMethodBeat.o(60018);
        return ER;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final /* synthetic */ aj EG(boolean z) {
        AppMethodBeat.i(60019);
        a ER = ER(z);
        AppMethodBeat.o(60019);
        return ER;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg b(g gVar) {
        AppMethodBeat.i(60021);
        a e2 = e(gVar);
        AppMethodBeat.o(60021);
        return e2;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final /* synthetic */ ab d(i iVar) {
        AppMethodBeat.i(60024);
        a g2 = g(iVar);
        AppMethodBeat.o(60024);
        return g2;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final /* synthetic */ aj d(g gVar) {
        AppMethodBeat.i(60022);
        a e2 = e(gVar);
        AppMethodBeat.o(60022);
        return e2;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg e(i iVar) {
        AppMethodBeat.i(60025);
        a g2 = g(iVar);
        AppMethodBeat.o(60025);
        return g2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(av avVar) {
        this(avVar, new c(avVar), false, g.a.hBP());
        g.a aVar = g.TiC;
        AppMethodBeat.i(60027);
        AppMethodBeat.o(60027);
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final boolean hEa() {
        return this.TIm;
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public final g hzL() {
        return this.Tih;
    }

    private a(av avVar, b bVar, boolean z, g gVar) {
        p.h(avVar, "typeProjection");
        p.h(bVar, "constructor");
        p.h(gVar, "annotations");
        AppMethodBeat.i(60026);
        this.TIk = avVar;
        this.TIl = bVar;
        this.TIm = z;
        this.Tih = gVar;
        AppMethodBeat.o(60026);
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final h hAp() {
        AppMethodBeat.i(60011);
        h dU = u.dU("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        p.g(dU, "ErrorUtils.createErrorSc…solution\", true\n        )");
        AppMethodBeat.o(60011);
        return dU;
    }

    @Override // kotlin.l.b.a.b.m.ar
    public final ab hKC() {
        AppMethodBeat.i(60012);
        bh bhVar = bh.OUT_VARIANCE;
        aj hzj = kotlin.l.b.a.b.m.d.a.aM(this).hzj();
        p.g(hzj, "builtIns.nullableAnyType");
        ab b2 = b(bhVar, hzj);
        AppMethodBeat.o(60012);
        return b2;
    }

    @Override // kotlin.l.b.a.b.m.ar
    public final ab hKD() {
        AppMethodBeat.i(60013);
        bh bhVar = bh.IN_VARIANCE;
        aj hzh = kotlin.l.b.a.b.m.d.a.aM(this).hzh();
        p.g(hzh, "builtIns.nothingType");
        ab b2 = b(bhVar, hzh);
        AppMethodBeat.o(60013);
        return b2;
    }

    private final ab b(bh bhVar, ab abVar) {
        AppMethodBeat.i(60014);
        if (this.TIk.hLI() == bhVar) {
            abVar = this.TIk.hBy();
        }
        p.g(abVar, "if (typeProjection.proje…jection.type else default");
        AppMethodBeat.o(60014);
        return abVar;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final String toString() {
        AppMethodBeat.i(60016);
        String str = "Captured(" + this.TIk + ')' + (this.TIm ? "?" : "");
        AppMethodBeat.o(60016);
        return str;
    }

    private a e(g gVar) {
        AppMethodBeat.i(60020);
        p.h(gVar, "newAnnotations");
        a aVar = new a(this.TIk, this.TIl, this.TIm, gVar);
        AppMethodBeat.o(60020);
        return aVar;
    }

    private a g(i iVar) {
        AppMethodBeat.i(60023);
        p.h(iVar, "kotlinTypeRefiner");
        av m = this.TIk.m(iVar);
        p.g(m, "typeProjection.refine(kotlinTypeRefiner)");
        a aVar = new a(m, this.TIl, this.TIm, this.Tih);
        AppMethodBeat.o(60023);
        return aVar;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final List<av> hKB() {
        return v.SXr;
    }

    @Override // kotlin.l.b.a.b.m.ar
    public final boolean ac(ab abVar) {
        AppMethodBeat.i(60015);
        p.h(abVar, "type");
        if (this.TIl == abVar.hKE()) {
            AppMethodBeat.o(60015);
            return true;
        }
        AppMethodBeat.o(60015);
        return false;
    }

    private a ER(boolean z) {
        AppMethodBeat.i(60017);
        if (z == this.TIm) {
            AppMethodBeat.o(60017);
            return this;
        }
        a aVar = new a(this.TIk, this.TIl, z, this.Tih);
        AppMethodBeat.o(60017);
        return aVar;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final /* bridge */ /* synthetic */ at hKE() {
        return this.TIl;
    }
}
