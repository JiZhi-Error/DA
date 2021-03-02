package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.aa;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.f;
import kotlin.l.b.a.b.h.q;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.k.a;
import kotlin.l.b.a.b.k.a.z;
import kotlin.l.b.a.b.m.ab;

public final class d implements c<c, g<?>> {
    private final f TKy;
    private final a TKz;

    public d(y yVar, aa aaVar, a aVar) {
        p.h(yVar, "module");
        p.h(aaVar, "notFoundClasses");
        p.h(aVar, "protocol");
        AppMethodBeat.i(60278);
        this.TKz = aVar;
        this.TKy = new f(yVar, aaVar);
        AppMethodBeat.o(60278);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.l.b.a.b.k.a.c
    public final /* synthetic */ g<?> a(z zVar, a.m mVar, ab abVar) {
        AppMethodBeat.i(60277);
        p.h(zVar, "container");
        p.h(mVar, "proto");
        p.h(abVar, "expectedType");
        a.C2299a.C2301a.b bVar = (a.C2299a.C2301a.b) f.a(mVar, this.TKz.TAK);
        if (bVar == null) {
            AppMethodBeat.o(60277);
            return null;
        }
        g<?> b2 = this.TKy.b(abVar, bVar, zVar.SZH);
        AppMethodBeat.o(60277);
        return b2;
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final List<c> a(z zVar, q qVar, b bVar) {
        v vVar;
        AppMethodBeat.i(60269);
        p.h(zVar, "container");
        p.h(qVar, "proto");
        p.h(bVar, "kind");
        if (qVar instanceof a.c) {
            vVar = (List) ((a.c) qVar).e(this.TKz.TAE);
        } else if (qVar instanceof a.h) {
            vVar = (List) ((a.h) qVar).e(this.TKz.TAF);
        } else if (qVar instanceof a.m) {
            switch (e.$EnumSwitchMapping$0[bVar.ordinal()]) {
                case 1:
                    vVar = (List) ((a.m) qVar).e(this.TKz.TAH);
                    break;
                case 2:
                    vVar = (List) ((a.m) qVar).e(this.TKz.TAI);
                    break;
                case 3:
                    vVar = (List) ((a.m) qVar).e(this.TKz.TAJ);
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Unsupported callable kind with property proto".toString());
                    AppMethodBeat.o(60269);
                    throw illegalStateException;
            }
        } else {
            IllegalStateException illegalStateException2 = new IllegalStateException("Unknown message: ".concat(String.valueOf(qVar)).toString());
            AppMethodBeat.o(60269);
            throw illegalStateException2;
        }
        if (vVar == null) {
            vVar = v.SXr;
        }
        List<a.C2299a> list = vVar;
        ArrayList arrayList = new ArrayList(j.a(list, 10));
        for (a.C2299a aVar : list) {
            arrayList.add(this.TKy.b(aVar, zVar.SZH));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(60269);
        return arrayList2;
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final List<c> a(z zVar, a.f fVar) {
        AppMethodBeat.i(60272);
        p.h(zVar, "container");
        p.h(fVar, "proto");
        v vVar = (List) fVar.e(this.TKz.TAL);
        if (vVar == null) {
            vVar = v.SXr;
        }
        List<a.C2299a> list = vVar;
        ArrayList arrayList = new ArrayList(j.a(list, 10));
        for (a.C2299a aVar : list) {
            arrayList.add(this.TKy.b(aVar, zVar.SZH));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(60272);
        return arrayList2;
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final List<c> a(z zVar, q qVar, b bVar, int i2, a.t tVar) {
        AppMethodBeat.i(60273);
        p.h(zVar, "container");
        p.h(qVar, "callableProto");
        p.h(bVar, "kind");
        p.h(tVar, "proto");
        v vVar = (List) tVar.e(this.TKz.TAM);
        if (vVar == null) {
            vVar = v.SXr;
        }
        List<a.C2299a> list = vVar;
        ArrayList arrayList = new ArrayList(j.a(list, 10));
        for (a.C2299a aVar : list) {
            arrayList.add(this.TKy.b(aVar, zVar.SZH));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(60273);
        return arrayList2;
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final List<c> a(a.p pVar, kotlin.l.b.a.b.e.b.c cVar) {
        AppMethodBeat.i(60275);
        p.h(pVar, "proto");
        p.h(cVar, "nameResolver");
        v vVar = (List) pVar.e(this.TKz.TAN);
        if (vVar == null) {
            vVar = v.SXr;
        }
        List<a.C2299a> list = vVar;
        ArrayList arrayList = new ArrayList(j.a(list, 10));
        for (a.C2299a aVar : list) {
            arrayList.add(this.TKy.b(aVar, cVar));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(60275);
        return arrayList2;
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final List<c> a(a.r rVar, kotlin.l.b.a.b.e.b.c cVar) {
        AppMethodBeat.i(60276);
        p.h(rVar, "proto");
        p.h(cVar, "nameResolver");
        v vVar = (List) rVar.e(this.TKz.TAO);
        if (vVar == null) {
            vVar = v.SXr;
        }
        List<a.C2299a> list = vVar;
        ArrayList arrayList = new ArrayList(j.a(list, 10));
        for (a.C2299a aVar : list) {
            arrayList.add(this.TKy.b(aVar, cVar));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(60276);
        return arrayList2;
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final List<c> b(z.a aVar) {
        AppMethodBeat.i(60268);
        p.h(aVar, "container");
        v vVar = (List) aVar.TKA.e(this.TKz.TAD);
        if (vVar == null) {
            vVar = v.SXr;
        }
        List<a.C2299a> list = vVar;
        ArrayList arrayList = new ArrayList(j.a(list, 10));
        for (a.C2299a aVar2 : list) {
            arrayList.add(this.TKy.b(aVar2, aVar.SZH));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(60268);
        return arrayList2;
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final List<c> a(z zVar, a.m mVar) {
        AppMethodBeat.i(60270);
        p.h(zVar, "container");
        p.h(mVar, "proto");
        v vVar = v.SXr;
        AppMethodBeat.o(60270);
        return vVar;
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final List<c> b(z zVar, a.m mVar) {
        AppMethodBeat.i(60271);
        p.h(zVar, "container");
        p.h(mVar, "proto");
        v vVar = v.SXr;
        AppMethodBeat.o(60271);
        return vVar;
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final List<c> b(z zVar, q qVar, b bVar) {
        AppMethodBeat.i(60274);
        p.h(zVar, "container");
        p.h(qVar, "proto");
        p.h(bVar, "kind");
        v vVar = v.SXr;
        AppMethodBeat.o(60274);
        return vVar;
    }
}
