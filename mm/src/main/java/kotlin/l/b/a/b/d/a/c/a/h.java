package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.aa;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.c.y;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.d.a.e.x;
import kotlin.l.b.a.b.d.b.p;
import kotlin.l.b.a.b.d.b.q;
import kotlin.l.b.a.b.d.b.u;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.i;
import kotlin.l.k;
import kotlin.o;
import kotlin.s;

public final class h extends y {
    static final /* synthetic */ k[] cLI = {aa.a(new kotlin.g.b.y(aa.bp(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), aa.a(new kotlin.g.b.y(aa.bp(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    private final g Tih;
    private final kotlin.l.b.a.b.d.a.c.h Trn;
    private final f Tsr = this.Trn.Trv.TcN.al(new a(this));
    private final d Tss = new d(this.Trn, this.Tsv, this);
    public final f<List<kotlin.l.b.a.b.f.b>> Tst = this.Trn.Trv.TcN.a(new c(this), v.SXr);
    private final f Tsu;
    private final t Tsv;

    static {
        AppMethodBeat.i(57885);
        AppMethodBeat.o(57885);
    }

    public final Map<String, p> hDT() {
        AppMethodBeat.i(57886);
        Map<String, p> map = (Map) i.a(this.Tsr, cLI[0]);
        AppMethodBeat.o(57886);
        return map;
    }

    @Override // kotlin.l.b.a.b.b.a.b, kotlin.l.b.a.b.b.a.a
    public final g hzL() {
        return this.Tih;
    }

    public final e d(kotlin.l.b.a.b.d.a.e.g gVar) {
        AppMethodBeat.i(57887);
        kotlin.g.b.p.h(gVar, "jClass");
        j jVar = this.Tss.TrM;
        kotlin.g.b.p.h(gVar, "javaClass");
        e a2 = jVar.a(gVar.hAH(), gVar);
        AppMethodBeat.o(57887);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.c.j, kotlin.l.b.a.b.b.c.y
    public final String toString() {
        AppMethodBeat.i(57888);
        String str = "Lazy Java package fragment: " + this.TiI;
        AppMethodBeat.o(57888);
        return str;
    }

    @Override // kotlin.l.b.a.b.b.c.k, kotlin.l.b.a.b.b.o, kotlin.l.b.a.b.b.c.y
    public final an hzM() {
        AppMethodBeat.i(57889);
        q qVar = new q(this);
        AppMethodBeat.o(57889);
        return qVar;
    }

    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<Map<String, ? extends p>> {
        final /* synthetic */ h Tsw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(h hVar) {
            super(0);
            this.Tsw = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Map<String, ? extends p> invoke() {
            o oVar;
            AppMethodBeat.i(57882);
            u uVar = this.Tsw.Trn.Trv.Tra;
            String sG = this.Tsw.TiI.sG();
            kotlin.g.b.p.g(sG, "fqName.asString()");
            ArrayList arrayList = new ArrayList();
            for (T t : uVar.btQ(sG)) {
                kotlin.l.b.a.b.j.e.c buj = kotlin.l.b.a.b.j.e.c.buj(t);
                kotlin.g.b.p.g(buj, "JvmClassName.byInternalName(partName)");
                kotlin.l.b.a.b.f.a p = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b(buj.TvL.replace('/', '.')));
                kotlin.g.b.p.g(p, "ClassId.topLevel(JvmClas…velClassMaybeWithDollars)");
                p a2 = kotlin.l.b.a.b.d.b.o.a(this.Tsw.Trn.Trv.TqR, p);
                if (a2 != null) {
                    oVar = s.U(t, a2);
                } else {
                    oVar = null;
                }
                if (oVar != null) {
                    arrayList.add(oVar);
                }
            }
            Map E = ae.E(arrayList);
            AppMethodBeat.o(57882);
            return E;
        }
    }

    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.f.b>> {
        final /* synthetic */ h Tsw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(h hVar) {
            super(0);
            this.Tsw = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends kotlin.l.b.a.b.f.b> invoke() {
            AppMethodBeat.i(57884);
            Collection<t> hDg = this.Tsw.Tsv.hDg();
            ArrayList arrayList = new ArrayList(j.a(hDg, 10));
            Iterator<T> it = hDg.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().hBk());
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(57884);
            return arrayList2;
        }
    }

    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<HashMap<kotlin.l.b.a.b.j.e.c, kotlin.l.b.a.b.j.e.c>> {
        final /* synthetic */ h Tsw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(h hVar) {
            super(0);
            this.Tsw = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ HashMap<kotlin.l.b.a.b.j.e.c, kotlin.l.b.a.b.j.e.c> invoke() {
            AppMethodBeat.i(57883);
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, p> entry : this.Tsw.hDT().entrySet()) {
                kotlin.l.b.a.b.j.e.c buj = kotlin.l.b.a.b.j.e.c.buj(entry.getKey());
                kotlin.g.b.p.g(buj, "JvmClassName.byInternalName(partInternalName)");
                kotlin.l.b.a.b.d.b.a.a hCA = entry.getValue().hCA();
                switch (i.$EnumSwitchMapping$0[hCA.Twl.ordinal()]) {
                    case 1:
                        HashMap hashMap2 = hashMap;
                        String hEp = hCA.hEp();
                        if (hEp != null) {
                            kotlin.l.b.a.b.j.e.c buj2 = kotlin.l.b.a.b.j.e.c.buj(hEp);
                            kotlin.g.b.p.g(buj2, "JvmClassName.byInternalN…: continue@kotlinClasses)");
                            hashMap2.put(buj, buj2);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        hashMap.put(buj, buj);
                        break;
                }
            }
            AppMethodBeat.o(57883);
            return hashMap;
        }
    }

    @Override // kotlin.l.b.a.b.b.ab
    public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.j.f.h hAp() {
        return this.Tss;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(kotlin.l.b.a.b.d.a.c.h hVar, t tVar) {
        super(hVar.Trv.Tfp, tVar.hBk());
        g a2;
        kotlin.g.b.p.h(hVar, "outerContext");
        kotlin.g.b.p.h(tVar, "jPackage");
        AppMethodBeat.i(57890);
        this.Tsv = tVar;
        this.Trn = kotlin.l.b.a.b.d.a.c.a.a(hVar, (kotlin.l.b.a.b.b.g) this, (x) null, 6);
        if (this.Trn.Trv.Trd.HIg) {
            g.a aVar = g.TiC;
            a2 = g.a.hBP();
        } else {
            a2 = kotlin.l.b.a.b.d.a.c.f.a(this.Trn, this.Tsv);
        }
        this.Tih = a2;
        this.Tsu = this.Trn.Trv.TcN.al(new b(this));
        AppMethodBeat.o(57890);
    }
}
