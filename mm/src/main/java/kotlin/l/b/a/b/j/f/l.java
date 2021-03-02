package kotlin.l.b.a.b.j.f;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.m;
import kotlin.l.b.a.b.j.a.a.d;
import kotlin.l.b.a.b.j.f.j;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.ba;
import kotlin.t;

public final class l implements h {
    private final h TJU;
    private final ba TKd;
    private Map<kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.l> TKe;
    private final f TKf = g.ah(new a(this));

    public l(h hVar, ba baVar) {
        p.h(hVar, "workerScope");
        p.h(baVar, "givenSubstitutor");
        AppMethodBeat.i(60235);
        this.TJU = hVar;
        ay hLK = baVar.hLK();
        p.g(hLK, "givenSubstitutor.substitution");
        this.TKd = d.c(hLK).hLJ();
        AppMethodBeat.o(60235);
    }

    public static final /* synthetic */ Collection a(l lVar, Collection collection) {
        AppMethodBeat.i(60236);
        Collection B = lVar.B(collection);
        AppMethodBeat.o(60236);
        return B;
    }

    private final <D extends kotlin.l.b.a.b.b.l> D J(D d2) {
        AppMethodBeat.i(60227);
        if (this.TKd.Tlg.isEmpty()) {
            AppMethodBeat.o(60227);
            return d2;
        }
        if (this.TKe == null) {
            this.TKe = new HashMap();
        }
        Map<kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.l> map = this.TKe;
        if (map == null) {
            p.hyc();
        }
        m mVar = map.get(d2);
        if (mVar == null) {
            if (d2 instanceof ap) {
                m f2 = ((ap) d2).f(this.TKd);
                if (f2 == null) {
                    AssertionError assertionError = new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d2 + " substitution fails");
                    AppMethodBeat.o(60227);
                    throw assertionError;
                }
                mVar = f2;
                map.put(d2, mVar);
            } else {
                IllegalStateException illegalStateException = new IllegalStateException("Unknown descriptor in scope: ".concat(String.valueOf(d2)).toString());
                AppMethodBeat.o(60227);
                throw illegalStateException;
            }
        }
        D d3 = (D) mVar;
        if (d3 == null) {
            t tVar = new t("null cannot be cast to non-null type D");
            AppMethodBeat.o(60227);
            throw tVar;
        }
        AppMethodBeat.o(60227);
        return d3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.l.b.a.b.j.f.l */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Collection<? extends D extends kotlin.l.b.a.b.b.l> */
    /* JADX WARN: Multi-variable type inference failed */
    private final <D extends kotlin.l.b.a.b.b.l> Collection<D> B(Collection<? extends D> collection) {
        AppMethodBeat.i(60228);
        if (this.TKd.Tlg.isEmpty()) {
            AppMethodBeat.o(60228);
            return collection;
        } else if (collection.isEmpty()) {
            AppMethodBeat.o(60228);
            return collection;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet(kotlin.l.b.a.b.o.a.hp(collection.size()));
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(J((kotlin.l.b.a.b.b.l) it.next()));
            }
            LinkedHashSet linkedHashSet2 = linkedHashSet;
            AppMethodBeat.o(60228);
            return linkedHashSet2;
        }
    }

    @Override // kotlin.l.b.a.b.j.f.h
    public final Collection<? extends ah> a(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(60229);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        Collection<? extends ah> B = B(this.TJU.a(fVar, aVar));
        AppMethodBeat.o(60229);
        return B;
    }

    @Override // kotlin.l.b.a.b.j.f.j
    public final h c(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(60230);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        h c2 = this.TJU.c(fVar, aVar);
        if (c2 != null) {
            h hVar = (h) J(c2);
            AppMethodBeat.o(60230);
            return hVar;
        }
        AppMethodBeat.o(60230);
        return null;
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.h
    public final Collection<? extends am> b(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(60231);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        Collection<? extends am> B = B(this.TJU.b(fVar, aVar));
        AppMethodBeat.o(60231);
        return B;
    }

    @Override // kotlin.l.b.a.b.j.f.h
    public final Set<kotlin.l.b.a.b.f.f> hCa() {
        AppMethodBeat.i(60233);
        Set<kotlin.l.b.a.b.f.f> hCa = this.TJU.hCa();
        AppMethodBeat.o(60233);
        return hCa;
    }

    @Override // kotlin.l.b.a.b.j.f.h
    public final Set<kotlin.l.b.a.b.f.f> hCb() {
        AppMethodBeat.i(60234);
        Set<kotlin.l.b.a.b.f.f> hCb = this.TJU.hCb();
        AppMethodBeat.o(60234);
        return hCb;
    }

    static final class a extends q implements kotlin.g.a.a<Collection<? extends kotlin.l.b.a.b.b.l>> {
        final /* synthetic */ l TKg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(l lVar) {
            super(0);
            this.TKg = lVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Collection<? extends kotlin.l.b.a.b.b.l> invoke() {
            AppMethodBeat.i(60225);
            Collection a2 = l.a(this.TKg, j.a.a(this.TKg.TJU, null, null, 3));
            AppMethodBeat.o(60225);
            return a2;
        }
    }

    @Override // kotlin.l.b.a.b.j.f.j
    public final Collection<kotlin.l.b.a.b.b.l> a(d dVar, b<? super kotlin.l.b.a.b.f.f, Boolean> bVar) {
        AppMethodBeat.i(60232);
        p.h(dVar, "kindFilter");
        p.h(bVar, "nameFilter");
        Collection<kotlin.l.b.a.b.b.l> collection = (Collection) this.TKf.getValue();
        AppMethodBeat.o(60232);
        return collection;
    }
}
