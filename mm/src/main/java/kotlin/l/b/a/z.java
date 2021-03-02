package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.ab;
import kotlin.g.b.ag;
import kotlin.g.b.m;
import kotlin.g.b.n;
import kotlin.g.b.q;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.x;
import kotlin.l.b;
import kotlin.l.d;
import kotlin.l.e;
import kotlin.l.g;
import kotlin.l.h;
import kotlin.l.l;

public class z extends ab {
    @Override // kotlin.g.b.ab
    public final b bp(Class cls) {
        AppMethodBeat.i(56523);
        g bq = f.bq(cls);
        AppMethodBeat.o(56523);
        return bq;
    }

    @Override // kotlin.g.b.ab
    public final String a(q qVar) {
        AppMethodBeat.i(56524);
        String a2 = a((m) qVar);
        AppMethodBeat.o(56524);
        return a2;
    }

    @Override // kotlin.g.b.ab
    public final String a(m mVar) {
        j fh;
        AppMethodBeat.i(56525);
        e a2 = kotlin.l.b.b.a(mVar);
        if (a2 == null || (fh = ae.fh(a2)) == null) {
            String a3 = super.a(mVar);
            AppMethodBeat.o(56525);
            return a3;
        }
        aa aaVar = aa.TbF;
        String b2 = aa.b(fh.hyE());
        AppMethodBeat.o(56525);
        return b2;
    }

    @Override // kotlin.g.b.ab
    public final e a(n nVar) {
        AppMethodBeat.i(56526);
        j jVar = new j(a((kotlin.g.b.e) nVar), nVar.getName(), nVar.getSignature(), nVar.hxQ());
        AppMethodBeat.o(56526);
        return jVar;
    }

    @Override // kotlin.g.b.ab
    public final l a(ag agVar) {
        AppMethodBeat.i(56527);
        o oVar = new o(a((kotlin.g.b.e) agVar), agVar.getName(), agVar.getSignature(), agVar.hxQ());
        AppMethodBeat.o(56527);
        return oVar;
    }

    @Override // kotlin.g.b.ab
    public final g a(t tVar) {
        AppMethodBeat.i(186237);
        k kVar = new k(a((kotlin.g.b.e) tVar), tVar.getName(), tVar.getSignature(), tVar.hxQ());
        AppMethodBeat.o(186237);
        return kVar;
    }

    @Override // kotlin.g.b.ab
    public final kotlin.l.m a(x xVar) {
        AppMethodBeat.i(56528);
        p pVar = new p(a((kotlin.g.b.e) xVar), xVar.getName(), xVar.getSignature(), xVar.hxQ());
        AppMethodBeat.o(56528);
        return pVar;
    }

    @Override // kotlin.g.b.ab
    public final h a(u uVar) {
        AppMethodBeat.i(56529);
        l lVar = new l(a((kotlin.g.b.e) uVar), uVar.getName(), uVar.getSignature(), uVar.hxQ());
        AppMethodBeat.o(56529);
        return lVar;
    }

    private static i a(kotlin.g.b.e eVar) {
        AppMethodBeat.i(56530);
        d Rs = eVar.Rs();
        if (Rs instanceof i) {
            i iVar = (i) Rs;
            AppMethodBeat.o(56530);
            return iVar;
        }
        a aVar = a.SZv;
        AppMethodBeat.o(56530);
        return aVar;
    }
}
