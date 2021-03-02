package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.d.a.a.l;
import kotlin.l.b.a.b.d.a.b.i;
import kotlin.l.b.a.b.d.a.c.b.d;
import kotlin.l.b.a.b.d.a.c.h;
import kotlin.l.b.a.b.d.a.e.m;
import kotlin.l.b.a.b.d.a.e.o;
import kotlin.l.b.a.b.d.a.e.v;
import kotlin.l.b.a.b.j.b.j;
import kotlin.l.b.a.b.j.b.r;
import kotlin.l.b.a.b.j.b.t;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.g;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.u;
import kotlin.l.k;
import kotlin.s;

public final class e implements kotlin.l.b.a.b.b.a.c, i {
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), aa.a(new y(aa.bp(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), aa.a(new y(aa.bp(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    private final f TpP = this.Trn.Trv.TcN.al(new c(this));
    private final boolean TpR = false;
    private final f Tqj = this.Trn.Trv.TcN.al(new a(this));
    private final g TrQ = this.Trn.Trv.TcN.am(new b(this));
    private final kotlin.l.b.a.b.d.a.d.a TrR = this.Trn.Trv.TqY.a(this.TrS);
    private final kotlin.l.b.a.b.d.a.e.a TrS;
    private final h Trn;

    static {
        AppMethodBeat.i(57796);
        AppMethodBeat.o(57796);
    }

    private aj hDN() {
        AppMethodBeat.i(57798);
        aj ajVar = (aj) kotlin.l.b.a.b.l.i.a(this.TpP, cLI[1]);
        AppMethodBeat.o(57798);
        return ajVar;
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final Map<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.j.b.g<?>> hBO() {
        AppMethodBeat.i(57800);
        Map<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.j.b.g<?>> map = (Map) kotlin.l.b.a.b.l.i.a(this.Tqj, cLI[2]);
        AppMethodBeat.o(57800);
        return map;
    }

    public e(h hVar, kotlin.l.b.a.b.d.a.e.a aVar) {
        p.h(hVar, "c");
        p.h(aVar, "javaAnnotation");
        AppMethodBeat.i(57803);
        this.Trn = hVar;
        this.TrS = aVar;
        AppMethodBeat.o(57803);
    }

    public static final /* synthetic */ kotlin.l.b.a.b.j.b.g a(e eVar, kotlin.l.b.a.b.d.a.e.b bVar) {
        AppMethodBeat.i(57805);
        kotlin.l.b.a.b.j.b.g<?> b2 = eVar.b(bVar);
        AppMethodBeat.o(57805);
        return b2;
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final /* synthetic */ ab hBy() {
        AppMethodBeat.i(57799);
        aj hDN = hDN();
        AppMethodBeat.o(57799);
        return hDN;
    }

    private final kotlin.l.b.a.b.j.b.g<?> b(kotlin.l.b.a.b.d.a.e.b bVar) {
        aj ajVar;
        ab hBy;
        AppMethodBeat.i(57801);
        if (bVar instanceof o) {
            kotlin.l.b.a.b.j.b.g<?> fz = kotlin.l.b.a.b.j.b.h.TIu.fz(((o) bVar).getValue());
            AppMethodBeat.o(57801);
            return fz;
        } else if (bVar instanceof m) {
            kotlin.l.b.a.b.f.a hCY = ((m) bVar).hCY();
            kotlin.l.b.a.b.f.f hCZ = ((m) bVar).hCZ();
            if (hCY == null || hCZ == null) {
                AppMethodBeat.o(57801);
                return null;
            }
            j jVar = new j(hCY, hCZ);
            AppMethodBeat.o(57801);
            return jVar;
        } else {
            if (bVar instanceof kotlin.l.b.a.b.d.a.e.e) {
                kotlin.l.b.a.b.f.f hAH = bVar.hAH();
                if (hAH == null) {
                    hAH = kotlin.l.b.a.b.d.a.p.Tpl;
                    p.g(hAH, "DEFAULT_ANNOTATION_MEMBER_NAME");
                }
                List<kotlin.l.b.a.b.d.a.e.b> hCH = ((kotlin.l.b.a.b.d.a.e.e) bVar).hCH();
                aj hDN = hDN();
                p.g(hDN, "type");
                if (!ad.ap(hDN)) {
                    kotlin.l.b.a.b.b.e l = kotlin.l.b.a.b.j.d.a.l(this);
                    if (l == null) {
                        p.hyc();
                    }
                    av b2 = kotlin.l.b.a.b.d.a.a.a.b(hAH, l);
                    if (b2 == null || (hBy = b2.hBy()) == null) {
                        ajVar = this.Trn.Trv.Tfp.hBh().a(bh.INVARIANT, u.bun("Unknown array element type"));
                    } else {
                        ajVar = hBy;
                    }
                    p.g(ajVar, "DescriptorResolverUtils.… type\")\n                )");
                    List<kotlin.l.b.a.b.d.a.e.b> list = hCH;
                    ArrayList arrayList = new ArrayList(kotlin.a.j.a(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        t b3 = b((kotlin.l.b.a.b.d.a.e.b) it.next());
                        if (b3 == null) {
                            b3 = new t();
                        }
                        arrayList.add(b3);
                    }
                    kotlin.l.b.a.b.j.b.h hVar = kotlin.l.b.a.b.j.b.h.TIu;
                    kotlin.l.b.a.b.j.b.b a2 = kotlin.l.b.a.b.j.b.h.a(arrayList, ajVar);
                    AppMethodBeat.o(57801);
                    return a2;
                }
            } else if (bVar instanceof kotlin.l.b.a.b.d.a.e.c) {
                kotlin.l.b.a.b.j.b.a aVar = new kotlin.l.b.a.b.j.b.a(new e(this.Trn, ((kotlin.l.b.a.b.d.a.e.c) bVar).hCF()));
                AppMethodBeat.o(57801);
                return aVar;
            } else if (bVar instanceof kotlin.l.b.a.b.d.a.e.h) {
                v hCS = ((kotlin.l.b.a.b.d.a.e.h) bVar).hCS();
                r.a aVar2 = r.TIJ;
                kotlin.l.b.a.b.j.b.g<?> ae = r.a.ae(this.Trn.Tru.a(hCS, d.a(l.Tqv, false, null, 3)));
                AppMethodBeat.o(57801);
                return ae;
            }
            AppMethodBeat.o(57801);
            return null;
        }
    }

    public final String toString() {
        AppMethodBeat.i(57802);
        String str = kotlin.l.b.a.b.i.c.TFg.a(this, (kotlin.l.b.a.b.b.a.e) null);
        AppMethodBeat.o(57802);
        return str;
    }

    @Override // kotlin.l.b.a.b.d.a.b.i
    public final boolean hDF() {
        return this.TpR;
    }

    static final class b extends q implements kotlin.g.a.a<kotlin.l.b.a.b.f.b> {
        final /* synthetic */ e TrT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar) {
            super(0);
            this.TrT = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.l.b.a.b.f.b invoke() {
            AppMethodBeat.i(57794);
            kotlin.l.b.a.b.f.a hyy = this.TrT.TrS.hyy();
            if (hyy != null) {
                kotlin.l.b.a.b.f.b hJd = hyy.hJd();
                AppMethodBeat.o(57794);
                return hJd;
            }
            AppMethodBeat.o(57794);
            return null;
        }
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final kotlin.l.b.a.b.f.b hBk() {
        AppMethodBeat.i(57797);
        g gVar = this.TrQ;
        k kVar = cLI[0];
        p.h(gVar, "$this$getValue");
        p.h(kVar, "p");
        kotlin.l.b.a.b.f.b bVar = (kotlin.l.b.a.b.f.b) gVar.invoke();
        AppMethodBeat.o(57797);
        return bVar;
    }

    static final class c extends q implements kotlin.g.a.a<aj> {
        final /* synthetic */ e TrT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(e eVar) {
            super(0);
            this.TrT = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ aj invoke() {
            AppMethodBeat.i(57795);
            kotlin.l.b.a.b.f.b hBk = this.TrT.hBk();
            if (hBk == null) {
                aj bun = u.bun("No fqName: " + this.TrT.TrS);
                AppMethodBeat.o(57795);
                return bun;
            }
            p.g(hBk, "fqName ?: return@createL…fqName: $javaAnnotation\")");
            kotlin.l.b.a.b.a.b.c cVar = kotlin.l.b.a.b.a.b.c.TfZ;
            kotlin.l.b.a.b.b.e a2 = kotlin.l.b.a.b.a.b.c.a(hBk, this.TrT.Trn.Trv.Tfp.hBh());
            if (a2 == null) {
                a2 = this.TrT.Trn.Trv.TqZ.c(this.TrT.TrS.hCE());
            }
            if (a2 == null) {
                a2 = e.a(this.TrT, hBk);
            }
            aj hAG = a2.hAG();
            AppMethodBeat.o(57795);
            return hAG;
        }
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final /* bridge */ /* synthetic */ an hzM() {
        return this.TrR;
    }

    static final class a extends q implements kotlin.g.a.a<Map<kotlin.l.b.a.b.f.f, ? extends kotlin.l.b.a.b.j.b.g<?>>> {
        final /* synthetic */ e TrT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e eVar) {
            super(0);
            this.TrT = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Map<kotlin.l.b.a.b.f.f, ? extends kotlin.l.b.a.b.j.b.g<?>> invoke() {
            kotlin.o oVar;
            AppMethodBeat.i(57793);
            ArrayList arrayList = new ArrayList();
            for (T t : this.TrT.TrS.hCD()) {
                kotlin.l.b.a.b.f.f hAH = t.hAH();
                if (hAH == null) {
                    hAH = kotlin.l.b.a.b.d.a.p.Tpl;
                }
                kotlin.l.b.a.b.j.b.g a2 = e.a(this.TrT, (kotlin.l.b.a.b.d.a.e.b) t);
                if (a2 != null) {
                    oVar = s.U(hAH, a2);
                } else {
                    oVar = null;
                }
                if (oVar != null) {
                    arrayList.add(oVar);
                }
            }
            Map E = ae.E(arrayList);
            AppMethodBeat.o(57793);
            return E;
        }
    }

    public static final /* synthetic */ kotlin.l.b.a.b.b.e a(e eVar, kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(57804);
        kotlin.l.b.a.b.b.y yVar = eVar.Trn.Trv.Tfp;
        kotlin.l.b.a.b.f.a p = kotlin.l.b.a.b.f.a.p(bVar);
        p.g(p, "ClassId.topLevel(fqName)");
        kotlin.l.b.a.b.b.e a2 = kotlin.l.b.a.b.b.s.a(yVar, p, eVar.Trn.Trv.TqS.hEh().TeR);
        AppMethodBeat.o(57804);
        return a2;
    }
}
