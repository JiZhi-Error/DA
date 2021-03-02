package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.at;
import kotlin.l.b.a.b.b.c.ag;
import kotlin.l.b.a.b.b.c.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.b.i;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.h.q;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.k.a.b.g;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.ba;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.bh;

public final class l extends d implements g {
    private final c SZH;
    private final h SZI;
    private g.a TLU = g.a.COMPATIBLE;
    private final i TLa;
    private final f TLb;
    private Collection<? extends ag> TMF;
    private aj TMG;
    private aj TMH;
    private aj TMI;
    private final a.q TMJ;
    private final j TcN;
    private List<? extends as> TlE;

    /* Return type fixed from 'kotlin.l.b.a.b.b.m' to match base method */
    @Override // kotlin.l.b.a.b.b.ap
    public final /* synthetic */ kotlin.l.b.a.b.b.i f(ba baVar) {
        l lVar;
        AppMethodBeat.i(60486);
        p.h(baVar, "substitutor");
        if (baVar.Tlg.isEmpty()) {
            lVar = this;
        } else {
            j jVar = this.TcN;
            kotlin.l.b.a.b.b.l hzx = hzx();
            p.g(hzx, "containingDeclaration");
            kotlin.l.b.a.b.b.a.g hzL = hzL();
            p.g(hzL, "annotations");
            f hAH = hAH();
            p.g(hAH, "name");
            l lVar2 = new l(jVar, hzx, hzL, hAH, this.Tkc, this.TMJ, this.SZH, this.SZI, this.TLa, this.TLb);
            List<as> hzO = hzO();
            ab b2 = baVar.b(hBv(), bh.INVARIANT);
            p.g(b2, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
            aj ay = az.ay(b2);
            ab b3 = baVar.b(hBw(), bh.INVARIANT);
            p.g(b3, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
            lVar2.a(hzO, ay, az.ay(b3), this.TLU);
            lVar = lVar2;
        }
        l lVar3 = lVar;
        AppMethodBeat.o(60486);
        return lVar3;
    }

    @Override // kotlin.l.b.a.b.b.c.d
    public final j hAI() {
        return this.TcN;
    }

    @Override // kotlin.l.b.a.b.k.a.b.g
    public final c hLj() {
        return this.SZH;
    }

    @Override // kotlin.l.b.a.b.k.a.b.g
    public final h hLk() {
        return this.SZI;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public l(kotlin.l.b.a.b.l.j r8, kotlin.l.b.a.b.b.l r9, kotlin.l.b.a.b.b.a.g r10, kotlin.l.b.a.b.f.f r11, kotlin.l.b.a.b.b.ba r12, kotlin.l.b.a.b.e.a.q r13, kotlin.l.b.a.b.e.b.c r14, kotlin.l.b.a.b.e.b.h r15, kotlin.l.b.a.b.e.b.i r16, kotlin.l.b.a.b.k.a.b.f r17) {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.k.a.b.l.<init>(kotlin.l.b.a.b.l.j, kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.a.g, kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.b.ba, kotlin.l.b.a.b.e.a$q, kotlin.l.b.a.b.e.b.c, kotlin.l.b.a.b.e.b.h, kotlin.l.b.a.b.e.b.i, kotlin.l.b.a.b.k.a.b.f):void");
    }

    @Override // kotlin.l.b.a.b.b.ar
    public final aj hBv() {
        AppMethodBeat.i(60481);
        aj ajVar = this.TMG;
        if (ajVar == null) {
            p.btv("underlyingType");
        }
        AppMethodBeat.o(60481);
        return ajVar;
    }

    @Override // kotlin.l.b.a.b.b.ar
    public final aj hBw() {
        AppMethodBeat.i(60482);
        aj ajVar = this.TMH;
        if (ajVar == null) {
            p.btv("expandedType");
        }
        AppMethodBeat.o(60482);
        return ajVar;
    }

    public final void a(List<? extends as> list, aj ajVar, aj ajVar2, g.a aVar) {
        h.b bVar;
        kotlin.l.b.a.b.j.f.h hAM;
        AppMethodBeat.i(60483);
        p.h(list, "declaredTypeParameters");
        p.h(ajVar, "underlyingType");
        p.h(ajVar2, "expandedType");
        p.h(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        p.h(list, "declaredTypeParameters");
        this.Tka = list;
        this.TMG = ajVar;
        this.TMH = ajVar2;
        this.TlE = at.a(this);
        l lVar = this;
        e hBx = hBx();
        if (hBx == null || (hAM = hBx.hAM()) == null) {
            bVar = h.b.TKa;
        } else {
            bVar = hAM;
        }
        aj a2 = bc.a(lVar, bVar, new d.a(this));
        p.g(a2, "TypeUtils.makeUnsubstitu…s)?.defaultType\n        }");
        this.TMI = a2;
        this.TMF = hBR();
        this.TLU = aVar;
        AppMethodBeat.o(60483);
    }

    @Override // kotlin.l.b.a.b.b.ar
    public final e hBx() {
        AppMethodBeat.i(60484);
        if (ad.ap(hBw())) {
            AppMethodBeat.o(60484);
            return null;
        }
        kotlin.l.b.a.b.b.h hzS = hBw().hKE().hzS();
        if (!(hzS instanceof e)) {
            hzS = null;
        }
        e eVar = (e) hzS;
        AppMethodBeat.o(60484);
        return eVar;
    }

    @Override // kotlin.l.b.a.b.b.h
    public final aj hAG() {
        AppMethodBeat.i(60485);
        aj ajVar = this.TMI;
        if (ajVar == null) {
            p.btv("defaultTypeImpl");
        }
        AppMethodBeat.o(60485);
        return ajVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends kotlin.l.b.a.b.b.as>, java.util.List<kotlin.l.b.a.b.b.as> */
    @Override // kotlin.l.b.a.b.b.c.d
    public final List<as> hBU() {
        AppMethodBeat.i(60487);
        List list = this.TlE;
        if (list == null) {
            p.btv("typeConstructorParameters");
        }
        AppMethodBeat.o(60487);
        return list;
    }

    @Override // kotlin.l.b.a.b.k.a.b.g
    public final /* bridge */ /* synthetic */ q hLi() {
        return this.TMJ;
    }
}
