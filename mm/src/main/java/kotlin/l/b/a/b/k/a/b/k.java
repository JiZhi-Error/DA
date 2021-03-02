package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.ae;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.b.i;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.h.q;
import kotlin.l.b.a.b.k.a.b.g;
import kotlin.l.b.a.b.m.ab;

public final class k extends ae implements c {
    private final c SZH;
    private final h SZI;
    private g.a TLU;
    private final i TLa;
    private final f TLb;
    private final a.h TME;

    @Override // kotlin.l.b.a.b.k.a.b.g
    public final c hLj() {
        return this.SZH;
    }

    @Override // kotlin.l.b.a.b.k.a.b.g
    public final h hLk() {
        return this.SZI;
    }

    public /* synthetic */ k(l lVar, kotlin.l.b.a.b.b.a.g gVar, f fVar, b.a aVar, a.h hVar, c cVar, h hVar2, i iVar, f fVar2) {
        this(lVar, null, gVar, fVar, aVar, hVar, cVar, hVar2, iVar, fVar2, null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private k(kotlin.l.b.a.b.b.l r9, kotlin.l.b.a.b.b.am r10, kotlin.l.b.a.b.b.a.g r11, kotlin.l.b.a.b.f.f r12, kotlin.l.b.a.b.b.b.a r13, kotlin.l.b.a.b.e.a.h r14, kotlin.l.b.a.b.e.b.c r15, kotlin.l.b.a.b.e.b.h r16, kotlin.l.b.a.b.e.b.i r17, kotlin.l.b.a.b.k.a.b.f r18, kotlin.l.b.a.b.b.an r19) {
        /*
        // Method dump skipped, instructions count: 101
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.k.a.b.k.<init>(kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.am, kotlin.l.b.a.b.b.a.g, kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.b.b$a, kotlin.l.b.a.b.e.a$h, kotlin.l.b.a.b.e.b.c, kotlin.l.b.a.b.e.b.h, kotlin.l.b.a.b.e.b.i, kotlin.l.b.a.b.k.a.b.f, kotlin.l.b.a.b.b.an):void");
    }

    public final ae a(ak akVar, ak akVar2, List<? extends as> list, List<? extends av> list2, ab abVar, w wVar, ba baVar, Map<? extends a.AbstractC2276a<?>, ?> map, g.a aVar) {
        AppMethodBeat.i(60478);
        p.h(list, "typeParameters");
        p.h(list2, "unsubstitutedValueParameters");
        p.h(baVar, "visibility");
        p.h(map, "userDataMap");
        p.h(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        ae a2 = super.a(akVar, akVar2, list, list2, abVar, wVar, baVar, map);
        this.TLU = aVar;
        p.g(a2, "super.initialize(\n      …easeEnvironment\n        }");
        AppMethodBeat.o(60478);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.c.p, kotlin.l.b.a.b.b.c.ae
    public final kotlin.l.b.a.b.b.c.p a(l lVar, t tVar, b.a aVar, f fVar, kotlin.l.b.a.b.b.a.g gVar, an anVar) {
        f fVar2;
        AppMethodBeat.i(60479);
        p.h(lVar, "newOwner");
        p.h(aVar, "kind");
        p.h(gVar, "annotations");
        p.h(anVar, "source");
        am amVar = (am) tVar;
        if (fVar == null) {
            fVar2 = hAH();
            p.g(fVar2, "name");
        } else {
            fVar2 = fVar;
        }
        k kVar = new k(lVar, amVar, gVar, fVar2, aVar, this.TME, this.SZH, this.SZI, this.TLa, this.TLb, anVar);
        kVar.TLU = this.TLU;
        k kVar2 = kVar;
        AppMethodBeat.o(60479);
        return kVar2;
    }

    @Override // kotlin.l.b.a.b.k.a.b.g
    public final /* bridge */ /* synthetic */ q hLi() {
        return this.TME;
    }
}
