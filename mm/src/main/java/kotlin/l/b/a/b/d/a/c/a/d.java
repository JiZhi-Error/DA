package kotlin.l.b.a.b.d.a.c.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.j;
import kotlin.a.x;
import kotlin.g.a.b;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.i;
import kotlin.l.k;

public final class d implements h {
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(d.class), "kotlinScopes", "getKotlinScopes()Ljava/util/List;"))};
    final j TrM;
    private final f TrN = this.Trn.Trv.TcN.al(new a(this));
    private final h TrO;
    private final kotlin.l.b.a.b.d.a.c.h Trn;

    static {
        AppMethodBeat.i(57783);
        AppMethodBeat.o(57783);
    }

    private final List<h> hDM() {
        AppMethodBeat.i(57784);
        List<h> list = (List) i.a(this.TrN, cLI[0]);
        AppMethodBeat.o(57784);
        return list;
    }

    public d(kotlin.l.b.a.b.d.a.c.h hVar, t tVar, h hVar2) {
        p.h(hVar, "c");
        p.h(tVar, "jPackage");
        p.h(hVar2, "packageFragment");
        AppMethodBeat.i(57792);
        this.Trn = hVar;
        this.TrO = hVar2;
        this.TrM = new j(this.Trn, tVar, this.TrO);
        AppMethodBeat.o(57792);
    }

    @Override // kotlin.l.b.a.b.j.f.j
    public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(57785);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        d(fVar, aVar);
        e e2 = this.TrM.e(fVar, aVar);
        if (e2 != null) {
            e eVar = e2;
            AppMethodBeat.o(57785);
            return eVar;
        }
        kotlin.l.b.a.b.b.h hVar = null;
        for (h hVar2 : hDM()) {
            kotlin.l.b.a.b.b.h c2 = hVar2.c(fVar, aVar);
            if (c2 != null) {
                if (!(c2 instanceof kotlin.l.b.a.b.b.i) || !((kotlin.l.b.a.b.b.i) c2).hzJ()) {
                    AppMethodBeat.o(57785);
                    return c2;
                } else if (hVar == null) {
                    hVar = c2;
                }
            }
        }
        AppMethodBeat.o(57785);
        return hVar;
    }

    @Override // kotlin.l.b.a.b.j.f.h
    public final Collection<ah> a(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(57786);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        d(fVar, aVar);
        j jVar = this.TrM;
        List<h> hDM = hDM();
        Collection a2 = jVar.a(fVar, aVar);
        for (h hVar : hDM) {
            a2 = kotlin.l.b.a.b.n.b.a.a(a2, hVar.a(fVar, aVar));
        }
        Collection collection = a2 == null ? (Set) x.SXt : a2;
        AppMethodBeat.o(57786);
        return collection;
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.h
    public final Collection<am> b(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(57787);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        d(fVar, aVar);
        j jVar = this.TrM;
        List<h> hDM = hDM();
        Collection b2 = jVar.b(fVar, aVar);
        for (h hVar : hDM) {
            b2 = kotlin.l.b.a.b.n.b.a.a(b2, hVar.b(fVar, aVar));
        }
        Collection collection = b2 == null ? (Set) x.SXt : b2;
        AppMethodBeat.o(57787);
        return collection;
    }

    @Override // kotlin.l.b.a.b.j.f.j
    public final Collection<l> a(kotlin.l.b.a.b.j.f.d dVar, b<? super kotlin.l.b.a.b.f.f, Boolean> bVar) {
        x xVar;
        AppMethodBeat.i(57788);
        p.h(dVar, "kindFilter");
        p.h(bVar, "nameFilter");
        j jVar = this.TrM;
        List<h> hDM = hDM();
        Collection<l> a2 = jVar.a(dVar, bVar);
        for (h hVar : hDM) {
            a2 = kotlin.l.b.a.b.n.b.a.a(a2, hVar.a(dVar, bVar));
        }
        if (a2 == null) {
            xVar = x.SXt;
        } else {
            xVar = a2;
        }
        AppMethodBeat.o(57788);
        return xVar;
    }

    @Override // kotlin.l.b.a.b.j.f.h
    public final Set<kotlin.l.b.a.b.f.f> hCa() {
        AppMethodBeat.i(57789);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = hDM().iterator();
        while (it.hasNext()) {
            j.a((Collection) linkedHashSet, (Iterable) it.next().hCa());
        }
        linkedHashSet.addAll(this.TrM.hCa());
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        AppMethodBeat.o(57789);
        return linkedHashSet2;
    }

    @Override // kotlin.l.b.a.b.j.f.h
    public final Set<kotlin.l.b.a.b.f.f> hCb() {
        AppMethodBeat.i(57790);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = hDM().iterator();
        while (it.hasNext()) {
            j.a((Collection) linkedHashSet, (Iterable) it.next().hCb());
        }
        linkedHashSet.addAll(this.TrM.hCb());
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        AppMethodBeat.o(57790);
        return linkedHashSet2;
    }

    private void d(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(57791);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        kotlin.l.b.a.b.c.a.a(this.Trn.Trv.Trb, aVar, this.TrO, fVar);
        AppMethodBeat.o(57791);
    }

    static final class a extends q implements kotlin.g.a.a<List<? extends h>> {
        final /* synthetic */ d TrP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d dVar) {
            super(0);
            this.TrP = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends h> invoke() {
            AppMethodBeat.i(57782);
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = this.TrP.TrO.hDT().values().iterator();
            while (it.hasNext()) {
                h a2 = this.TrP.Trn.Trv.TqS.a(this.TrP.TrO, it.next());
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            List p = j.p(arrayList);
            AppMethodBeat.o(57782);
            return p;
        }
    }
}
