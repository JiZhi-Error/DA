package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.l;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.c.b;
import kotlin.l.b.a.b.m.c.d;
import kotlin.l.b.a.b.m.u;

public final class k extends aj implements d {
    private final boolean TIm;
    private final b TPh;
    final l TPi;
    final bg TPj;
    private final g Tih;

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg EF(boolean z) {
        AppMethodBeat.i(61064);
        k EV = EV(z);
        AppMethodBeat.o(61064);
        return EV;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final /* synthetic */ aj EG(boolean z) {
        AppMethodBeat.i(61065);
        k EV = EV(z);
        AppMethodBeat.o(61065);
        return EV;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg b(g gVar) {
        AppMethodBeat.i(61061);
        k k = k(gVar);
        AppMethodBeat.o(61061);
        return k;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final /* synthetic */ ab d(i iVar) {
        AppMethodBeat.i(61067);
        k o = o(iVar);
        AppMethodBeat.o(61067);
        return o;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final /* synthetic */ aj d(g gVar) {
        AppMethodBeat.i(61062);
        k k = k(gVar);
        AppMethodBeat.o(61062);
        return k;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg e(i iVar) {
        AppMethodBeat.i(61068);
        k o = o(iVar);
        AppMethodBeat.o(61068);
        return o;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private /* synthetic */ k(b bVar, l lVar, bg bgVar) {
        this(bVar, lVar, bgVar, g.a.hBP(), false);
        g.a aVar = g.TiC;
        AppMethodBeat.i(61070);
        AppMethodBeat.o(61070);
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public final g hzL() {
        return this.Tih;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final boolean hEa() {
        return this.TIm;
    }

    public k(b bVar, l lVar, bg bgVar, g gVar, boolean z) {
        p.h(bVar, "captureStatus");
        p.h(lVar, "constructor");
        p.h(gVar, "annotations");
        AppMethodBeat.i(61069);
        this.TPh = bVar;
        this.TPi = lVar;
        this.TPj = bgVar;
        this.Tih = gVar;
        this.TIm = z;
        AppMethodBeat.o(61069);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public k(b bVar, bg bgVar, av avVar, as asVar) {
        this(bVar, new l(avVar, null, null, asVar, 6), bgVar);
        p.h(bVar, "captureStatus");
        p.h(avVar, "projection");
        p.h(asVar, "typeParameter");
        AppMethodBeat.i(186275);
        AppMethodBeat.o(186275);
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final h hAp() {
        AppMethodBeat.i(61059);
        h dU = u.dU("No member resolution should be done on captured type!", true);
        p.g(dU, "ErrorUtils.createErrorSc…on captured type!\", true)");
        AppMethodBeat.o(61059);
        return dU;
    }

    private k k(g gVar) {
        AppMethodBeat.i(61060);
        p.h(gVar, "newAnnotations");
        k kVar = new k(this.TPh, this.TPi, this.TPj, gVar, this.TIm);
        AppMethodBeat.o(61060);
        return kVar;
    }

    private k EV(boolean z) {
        AppMethodBeat.i(61063);
        k kVar = new k(this.TPh, this.TPi, this.TPj, this.Tih, z);
        AppMethodBeat.o(61063);
        return kVar;
    }

    private k o(i iVar) {
        l.c cVar;
        l lVar;
        b bVar;
        bg bgVar = null;
        AppMethodBeat.i(61066);
        p.h(iVar, "kotlinTypeRefiner");
        b bVar2 = this.TPh;
        l lVar2 = this.TPi;
        p.h(iVar, "kotlinTypeRefiner");
        av m = lVar2.TIo.m(iVar);
        p.g(m, "projection.refine(kotlinTypeRefiner)");
        if (lVar2.TPl != null) {
            cVar = new l.c(lVar2, iVar);
        } else {
            cVar = null;
        }
        l lVar3 = lVar2.TPm;
        if (lVar3 == null) {
            lVar3 = lVar2;
        }
        l lVar4 = new l(m, cVar, lVar3, lVar2.TOv);
        bg bgVar2 = this.TPj;
        if (bgVar2 != null) {
            bgVar = iVar.aK(bgVar2).hLF();
            lVar = lVar4;
            bVar = bVar2;
        } else {
            lVar = lVar4;
            bVar = bVar2;
        }
        k kVar = new k(bVar, lVar, bgVar, this.Tih, this.TIm);
        AppMethodBeat.o(61066);
        return kVar;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final List<av> hKB() {
        return v.SXr;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final /* bridge */ /* synthetic */ at hKE() {
        return this.TPi;
    }
}
