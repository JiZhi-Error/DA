package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.aa;
import kotlin.l.b.a.b.b.c.ab;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.r;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.b.i;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.h.q;
import kotlin.l.b.a.b.k.a.b.g;
import kotlin.x;

public final class j extends aa implements c {
    public final a.m SZF;
    public final c SZH;
    public final h SZI;
    private g.a TLU = g.a.COMPATIBLE;
    private final i TLa;
    public final f TLb;

    @Override // kotlin.l.b.a.b.k.a.b.g
    public final c hLj() {
        return this.SZH;
    }

    @Override // kotlin.l.b.a.b.k.a.b.g
    public final h hLk() {
        return this.SZI;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(l lVar, ah ahVar, kotlin.l.b.a.b.b.a.g gVar, w wVar, ba baVar, boolean z, f fVar, b.a aVar, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, a.m mVar, c cVar, h hVar, i iVar, f fVar2) {
        super(lVar, ahVar, gVar, wVar, baVar, z, fVar, aVar, an.ThK, z2, z3, z6, false, z4, z5);
        p.h(lVar, "containingDeclaration");
        p.h(gVar, "annotations");
        p.h(wVar, "modality");
        p.h(baVar, "visibility");
        p.h(fVar, "name");
        p.h(aVar, "kind");
        p.h(mVar, "proto");
        p.h(cVar, "nameResolver");
        p.h(hVar, "typeTable");
        p.h(iVar, "versionRequirementTable");
        AppMethodBeat.i(60477);
        this.SZF = mVar;
        this.SZH = cVar;
        this.SZI = hVar;
        this.TLa = iVar;
        this.TLb = fVar2;
        AppMethodBeat.o(60477);
    }

    public final void a(ab abVar, aj ajVar, r rVar, r rVar2, g.a aVar) {
        AppMethodBeat.i(60474);
        p.h(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        super.a(abVar, ajVar, rVar, rVar2);
        x xVar = x.SXb;
        this.TLU = aVar;
        AppMethodBeat.o(60474);
    }

    @Override // kotlin.l.b.a.b.b.c.aa
    public final aa a(l lVar, w wVar, ba baVar, ah ahVar, b.a aVar, f fVar, an anVar) {
        AppMethodBeat.i(60475);
        p.h(lVar, "newOwner");
        p.h(wVar, "newModality");
        p.h(baVar, "newVisibility");
        p.h(aVar, "kind");
        p.h(fVar, "newName");
        p.h(anVar, "source");
        j jVar = new j(lVar, ahVar, hzL(), wVar, baVar, this.TmC, fVar, aVar, this.TlW, hBH(), isExternal(), this.TlY, this.TkQ, this.SZF, this.SZH, this.SZI, this.TLa, this.TLb);
        AppMethodBeat.o(60475);
        return jVar;
    }

    @Override // kotlin.l.b.a.b.b.v, kotlin.l.b.a.b.b.c.aa
    public final boolean isExternal() {
        AppMethodBeat.i(60476);
        Boolean avk = kotlin.l.b.a.b.e.b.b.TBt.avk(this.SZF.Txb);
        p.g(avk, "Flags.IS_EXTERNAL_PROPERTY.get(proto.flags)");
        boolean booleanValue = avk.booleanValue();
        AppMethodBeat.o(60476);
        return booleanValue;
    }

    @Override // kotlin.l.b.a.b.k.a.b.g
    public final /* bridge */ /* synthetic */ q hLi() {
        return this.SZF;
    }
}
