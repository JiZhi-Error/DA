package kotlin.l.b.a.b.d.a.c.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.d.a.b.k;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.d.a.e.p;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.o.b;
import kotlin.m.i;
import kotlin.x;

public final class l extends m {
    private final g TrI;
    private final f TsR;

    static final class a extends q implements kotlin.g.a.b<p, Boolean> {
        public static final a TsS = new a();

        static {
            AppMethodBeat.i(57926);
            AppMethodBeat.o(57926);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(p pVar) {
            AppMethodBeat.i(57925);
            p pVar2 = pVar;
            kotlin.g.b.p.h(pVar2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(pVar2.hgu());
            AppMethodBeat.o(57925);
            return valueOf;
        }
    }

    static final class b extends q implements kotlin.g.a.b<h, Collection<? extends ah>> {
        final /* synthetic */ f TgT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(f fVar) {
            super(1);
            this.TgT = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Collection<? extends ah> invoke(h hVar) {
            AppMethodBeat.i(57927);
            h hVar2 = hVar;
            kotlin.g.b.p.h(hVar2, LocaleUtil.ITALIAN);
            Collection<? extends ah> a2 = hVar2.a(this.TgT, kotlin.l.b.a.b.c.a.c.WHEN_GET_SUPER_MEMBERS);
            AppMethodBeat.o(57927);
            return a2;
        }
    }

    static final class c extends q implements kotlin.g.a.b<h, Set<? extends f>> {
        public static final c TsT = new c();

        static {
            AppMethodBeat.i(57929);
            AppMethodBeat.o(57929);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Set<? extends f> invoke(h hVar) {
            AppMethodBeat.i(57928);
            h hVar2 = hVar;
            kotlin.g.b.p.h(hVar2, LocaleUtil.ITALIAN);
            Set<f> hCb = hVar2.hCb();
            AppMethodBeat.o(57928);
            return hCb;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d<N> implements b.AbstractC2365b<N> {
        public static final d TsU = new d();

        static {
            AppMethodBeat.i(57933);
            AppMethodBeat.o(57933);
        }

        d() {
        }

        @Override // kotlin.l.b.a.b.o.b.AbstractC2365b
        public final /* synthetic */ Iterable fl(Object obj) {
            AppMethodBeat.i(57932);
            kotlin.l.b.a.b.b.e eVar = (kotlin.l.b.a.b.b.e) obj;
            kotlin.g.b.p.g(eVar, LocaleUtil.ITALIAN);
            at hzz = eVar.hzz();
            kotlin.g.b.p.g(hzz, "it.typeConstructor");
            Collection<ab> hBV = hzz.hBV();
            kotlin.g.b.p.g(hBV, "it.typeConstructor.supertypes");
            Iterable f2 = i.f(i.e(j.z(hBV), AnonymousClass1.TsV));
            AppMethodBeat.o(57932);
            return f2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(kotlin.l.b.a.b.d.a.c.h hVar, g gVar, f fVar) {
        super(hVar);
        kotlin.g.b.p.h(hVar, "c");
        kotlin.g.b.p.h(gVar, "jClass");
        kotlin.g.b.p.h(fVar, "ownerDescriptor");
        AppMethodBeat.i(57944);
        this.TrI = gVar;
        this.TsR = fVar;
        AppMethodBeat.o(57944);
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
    public final kotlin.l.b.a.b.b.h c(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(57939);
        kotlin.g.b.p.h(fVar, "name");
        kotlin.g.b.p.h(aVar, FirebaseAnalytics.b.LOCATION);
        AppMethodBeat.o(57939);
        return null;
    }

    private static <R> Set<R> a(kotlin.l.b.a.b.b.e eVar, Set<R> set, kotlin.g.a.b<? super h, ? extends Collection<? extends R>> bVar) {
        AppMethodBeat.i(57942);
        kotlin.l.b.a.b.o.b.a(j.listOf(eVar), d.TsU, new e(eVar, set, bVar));
        AppMethodBeat.o(57942);
        return set;
    }

    public static final class e extends b.a<kotlin.l.b.a.b.b.e, x> {
        final /* synthetic */ kotlin.l.b.a.b.b.e TsW;
        final /* synthetic */ Set TsX;
        final /* synthetic */ kotlin.g.a.b TsY;

        e(kotlin.l.b.a.b.b.e eVar, Set set, kotlin.g.a.b bVar) {
            this.TsW = eVar;
            this.TsX = set;
            this.TsY = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.l.b.a.b.o.b.a, kotlin.l.b.a.b.o.b.c
        public final /* synthetic */ boolean fm(kotlin.l.b.a.b.b.e eVar) {
            AppMethodBeat.i(57934);
            kotlin.l.b.a.b.b.e eVar2 = eVar;
            kotlin.g.b.p.h(eVar2, "current");
            if (eVar2 != this.TsW) {
                h hzy = eVar2.hzy();
                kotlin.g.b.p.g(hzy, "current.staticScope");
                if (hzy instanceof m) {
                    this.TsX.addAll((Collection) this.TsY.invoke(hzy));
                    AppMethodBeat.o(57934);
                    return false;
                }
            }
            AppMethodBeat.o(57934);
            return true;
        }

        @Override // kotlin.l.b.a.b.o.b.c
        public final /* bridge */ /* synthetic */ Object hAq() {
            return x.SXb;
        }
    }

    private final ah f(ah ahVar) {
        AppMethodBeat.i(57943);
        b.a hAA = ahVar.hAA();
        kotlin.g.b.p.g(hAA, "this.kind");
        if (hAA.hAB()) {
            AppMethodBeat.o(57943);
            return ahVar;
        }
        Collection<? extends ah> hAy = ahVar.hAy();
        kotlin.g.b.p.g(hAy, "this.overriddenDescriptors");
        Collection<? extends ah> collection = hAy;
        ArrayList arrayList = new ArrayList(j.a(collection, 10));
        for (T t : collection) {
            kotlin.g.b.p.g(t, LocaleUtil.ITALIAN);
            arrayList.add(f(t));
        }
        ah ahVar2 = (ah) j.kw(j.t((Iterable) arrayList));
        AppMethodBeat.o(57943);
        return ahVar2;
    }

    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final /* synthetic */ b hDR() {
        AppMethodBeat.i(57935);
        a aVar = new a(this.TrI, a.TsS);
        AppMethodBeat.o(57935);
        return aVar;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final Set<f> b(kotlin.l.b.a.b.j.f.d dVar, kotlin.g.a.b<? super f, Boolean> bVar) {
        kotlin.a.x xVar;
        AppMethodBeat.i(57936);
        kotlin.g.b.p.h(dVar, "kindFilter");
        Set<f> u = j.u((Iterable) ((b) this.TsE.invoke()).hDK());
        l s = k.s(this.TsR);
        if (s != null) {
            xVar = s.hCa();
        } else {
            xVar = null;
        }
        if (xVar == null) {
            xVar = kotlin.a.x.SXt;
        }
        u.addAll(xVar);
        if (this.TrI.isEnum()) {
            u.addAll(j.listOf((Object[]) new f[]{kotlin.l.b.a.b.j.c.THu, kotlin.l.b.a.b.j.c.THt}));
        }
        AppMethodBeat.o(57936);
        return u;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final Set<f> a(kotlin.l.b.a.b.j.f.d dVar) {
        AppMethodBeat.i(57937);
        kotlin.g.b.p.h(dVar, "kindFilter");
        Set<f> u = j.u((Iterable) ((b) this.TsE.invoke()).hDL());
        a(this.TsR, u, c.TsT);
        AppMethodBeat.o(57937);
        return u;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final Set<f> c(kotlin.l.b.a.b.j.f.d dVar, kotlin.g.a.b<? super f, Boolean> bVar) {
        AppMethodBeat.i(57938);
        kotlin.g.b.p.h(dVar, "kindFilter");
        kotlin.a.x xVar = kotlin.a.x.SXt;
        AppMethodBeat.o(57938);
        return xVar;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final void a(Collection<am> collection, f fVar) {
        Set r;
        AppMethodBeat.i(57940);
        kotlin.g.b.p.h(collection, "result");
        kotlin.g.b.p.h(fVar, "name");
        l s = k.s(this.TsR);
        if (s == null) {
            r = kotlin.a.x.SXt;
        } else {
            r = j.r((Iterable) s.b(fVar, kotlin.l.b.a.b.c.a.c.WHEN_GET_SUPER_MEMBERS));
        }
        Collection<? extends am> b2 = kotlin.l.b.a.b.d.a.a.a.b(fVar, r, collection, this.TsR, this.Trn.Trv.TqU, this.Trn.Trv.Trh.hLN());
        kotlin.g.b.p.g(b2, "resolveOverridesForStati….overridingUtil\n        )");
        collection.addAll(b2);
        if (this.TrI.isEnum()) {
            if (kotlin.g.b.p.j(fVar, kotlin.l.b.a.b.j.c.THu)) {
                am x = kotlin.l.b.a.b.j.b.x(this.TsR);
                kotlin.g.b.p.g(x, "createEnumValueOfMethod(ownerDescriptor)");
                collection.add(x);
                AppMethodBeat.o(57940);
                return;
            } else if (kotlin.g.b.p.j(fVar, kotlin.l.b.a.b.j.c.THt)) {
                am w = kotlin.l.b.a.b.j.b.w(this.TsR);
                kotlin.g.b.p.g(w, "createEnumValuesMethod(ownerDescriptor)");
                collection.add(w);
            }
        }
        AppMethodBeat.o(57940);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k, kotlin.l.b.a.b.d.a.c.a.m
    public final void b(f fVar, Collection<ah> collection) {
        AppMethodBeat.i(57941);
        kotlin.g.b.p.h(fVar, "name");
        kotlin.g.b.p.h(collection, "result");
        Set a2 = a(this.TsR, new LinkedHashSet(), new b(fVar));
        if (!collection.isEmpty()) {
            Collection<? extends ah> b2 = kotlin.l.b.a.b.d.a.a.a.b(fVar, a2, collection, this.TsR, this.Trn.Trv.TqU, this.Trn.Trv.Trh.hLN());
            kotlin.g.b.p.g(b2, "resolveOverridesForStati…ingUtil\n                )");
            collection.addAll(b2);
            AppMethodBeat.o(57941);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : a2) {
            ah f2 = f((ah) obj);
            Object obj2 = linkedHashMap.get(f2);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(f2, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            j.a((Collection) arrayList, (Iterable) kotlin.l.b.a.b.d.a.a.a.b(fVar, (Collection) entry.getValue(), collection, this.TsR, this.Trn.Trv.TqU, this.Trn.Trv.Trh.hLN()));
        }
        collection.addAll(arrayList);
        AppMethodBeat.o(57941);
    }

    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.b.l hDS() {
        return this.TsR;
    }
}
