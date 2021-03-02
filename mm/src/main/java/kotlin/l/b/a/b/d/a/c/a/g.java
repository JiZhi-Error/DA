package kotlin.l.b.a.b.d.a.c.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.ak;
import kotlin.a.v;
import kotlin.g.b.aa;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.ac;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.d.a.a.k;
import kotlin.l.b.a.b.d.a.c.a.k;
import kotlin.l.b.a.b.d.a.e.n;
import kotlin.l.b.a.b.d.a.e.p;
import kotlin.l.b.a.b.d.a.f.l;
import kotlin.l.b.a.b.d.a.j;
import kotlin.l.b.a.b.d.a.m;
import kotlin.l.b.a.b.d.a.o;
import kotlin.l.b.a.b.j.i;
import kotlin.l.b.a.b.k.a.r;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.o.i;

public final class g extends k {
    private final kotlin.l.b.a.b.d.a.e.g TrI;
    final kotlin.l.b.a.b.l.f<List<kotlin.l.b.a.b.b.d>> Tsh;
    private final kotlin.l.b.a.b.l.f<Set<kotlin.l.b.a.b.f.f>> Tsi;
    private final kotlin.l.b.a.b.l.f<Map<kotlin.l.b.a.b.f.f, n>> Tsj;
    private final kotlin.l.b.a.b.l.d<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.b.c.g> Tsk;
    final kotlin.l.b.a.b.b.e Tsl;
    private final boolean Tsm;

    static final class a extends q implements kotlin.g.a.b<p, Boolean> {
        public static final a Tsn = new a();

        static {
            AppMethodBeat.i(57826);
            AppMethodBeat.o(57826);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(p pVar) {
            boolean z;
            AppMethodBeat.i(57825);
            p pVar2 = pVar;
            kotlin.g.b.p.h(pVar2, LocaleUtil.ITALIAN);
            if (!pVar2.hgu()) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(57825);
            return valueOf;
        }
    }

    static final /* synthetic */ class b extends kotlin.g.b.n implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends am>> {
        b(g gVar) {
            super(1, gVar);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(57828);
            kotlin.l.b bp = aa.bp(g.class);
            AppMethodBeat.o(57828);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "searchMethodsByNameWithoutBuiltinMagic";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Collection<? extends am> invoke(kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(57827);
            kotlin.l.b.a.b.f.f fVar2 = fVar;
            kotlin.g.b.p.h(fVar2, "p1");
            Collection a2 = g.a((g) this.SYl, fVar2);
            AppMethodBeat.o(57827);
            return a2;
        }
    }

    static final /* synthetic */ class c extends kotlin.g.b.n implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends am>> {
        c(g gVar) {
            super(1, gVar);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(57830);
            kotlin.l.b bp = aa.bp(g.class);
            AppMethodBeat.o(57830);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Collection<? extends am> invoke(kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(57829);
            kotlin.l.b.a.b.f.f fVar2 = fVar;
            kotlin.g.b.p.h(fVar2, "p1");
            Collection b2 = g.b((g) this.SYl, fVar2);
            AppMethodBeat.o(57829);
            return b2;
        }
    }

    static final class d extends q implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends am>> {
        final /* synthetic */ g Tso;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(g gVar) {
            super(1);
            this.Tso = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Collection<? extends am> invoke(kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(57831);
            kotlin.l.b.a.b.f.f fVar2 = fVar;
            kotlin.g.b.p.h(fVar2, LocaleUtil.ITALIAN);
            Collection a2 = g.a(this.Tso, fVar2);
            AppMethodBeat.o(57831);
            return a2;
        }
    }

    static final class e extends q implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends am>> {
        final /* synthetic */ g Tso;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(g gVar) {
            super(1);
            this.Tso = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Collection<? extends am> invoke(kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(57832);
            kotlin.l.b.a.b.f.f fVar2 = fVar;
            kotlin.g.b.p.h(fVar2, LocaleUtil.ITALIAN);
            Collection b2 = g.b(this.Tso, fVar2);
            AppMethodBeat.o(57832);
            return b2;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class h extends q implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends am>> {
        final /* synthetic */ g Tso;
        final /* synthetic */ am Tsp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(g gVar, am amVar) {
            super(1);
            this.Tso = gVar;
            this.Tsp = amVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Collection<? extends am> invoke(kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(57835);
            kotlin.l.b.a.b.f.f fVar2 = fVar;
            kotlin.g.b.p.h(fVar2, "accessorName");
            if (kotlin.g.b.p.j(this.Tsp.hAH(), fVar2)) {
                List listOf = kotlin.a.j.listOf(this.Tsp);
                AppMethodBeat.o(57835);
                return listOf;
            }
            List b2 = kotlin.a.j.b(g.a(this.Tso, fVar2), (Iterable) g.b(this.Tso, fVar2));
            AppMethodBeat.o(57835);
            return b2;
        }
    }

    static final class j extends q implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.b.c.g> {
        final /* synthetic */ kotlin.l.b.a.b.d.a.c.h TpT;
        final /* synthetic */ g Tso;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(g gVar, kotlin.l.b.a.b.d.a.c.h hVar) {
            super(1);
            this.Tso = gVar;
            this.TpT = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.l.b.a.b.b.c.g invoke(kotlin.l.b.a.b.f.f fVar) {
            f fVar2;
            kotlin.l.b.a.b.b.c.n nVar;
            AppMethodBeat.i(57838);
            kotlin.l.b.a.b.f.f fVar3 = fVar;
            kotlin.g.b.p.h(fVar3, "name");
            if (!((Set) this.Tso.Tsi.invoke()).contains(fVar3)) {
                n nVar2 = (n) ((Map) this.Tso.Tsj.invoke()).get(fVar3);
                if (nVar2 != null) {
                    nVar = kotlin.l.b.a.b.b.c.n.a(this.TpT.Trv.TcN, this.Tso.Tsl, fVar3, this.TpT.Trv.TcN.al(new a(this)), kotlin.l.b.a.b.d.a.c.f.a(this.TpT, nVar2), this.TpT.Trv.TqY.a(nVar2));
                } else {
                    nVar = null;
                }
                kotlin.l.b.a.b.b.c.n nVar3 = nVar;
                AppMethodBeat.o(57838);
                return nVar3;
            }
            kotlin.l.b.a.b.d.a.j jVar = this.TpT.Trv.TqQ;
            kotlin.l.b.a.b.f.a c2 = kotlin.l.b.a.b.j.d.a.c(this.Tso.Tsl);
            if (c2 == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.l.b.a.b.f.a o = c2.o(fVar3);
            kotlin.g.b.p.g(o, "ownerDescriptor.classId!…createNestedClassId(name)");
            kotlin.l.b.a.b.d.a.e.g a2 = jVar.a(new j.a(o, null, this.Tso.TrI, 2));
            if (a2 != null) {
                f fVar4 = new f(this.TpT, this.Tso.Tsl, a2);
                this.TpT.Trv.Trf.a(fVar4);
                fVar2 = fVar4;
            } else {
                fVar2 = null;
            }
            f fVar5 = fVar2;
            AppMethodBeat.o(57838);
            return fVar5;
        }

        static final class a extends q implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>> {
            final /* synthetic */ j Tsq;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(j jVar) {
                super(0);
                this.Tsq = jVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Set<? extends kotlin.l.b.a.b.f.f> invoke() {
                AppMethodBeat.i(57837);
                Set b2 = ak.b(this.Tsq.Tso.hCa(), this.Tsq.Tso.hCb());
                AppMethodBeat.o(57837);
                return b2;
            }
        }
    }

    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final /* synthetic */ Set b(kotlin.l.b.a.b.j.f.d dVar, kotlin.g.a.b bVar) {
        AppMethodBeat.i(57840);
        kotlin.g.b.p.h(dVar, "kindFilter");
        at hzz = this.Tsl.hzz();
        kotlin.g.b.p.g(hzz, "ownerDescriptor.typeConstructor");
        Collection<ab> hBV = hzz.hBV();
        kotlin.g.b.p.g(hBV, "ownerDescriptor.typeConstructor.supertypes");
        HashSet hashSet = new HashSet();
        Iterator<T> it = hBV.iterator();
        while (it.hasNext()) {
            kotlin.a.j.a((Collection) hashSet, (Iterable) it.next().hAp().hCa());
        }
        HashSet hashSet2 = hashSet;
        hashSet2.addAll(((b) this.TsE.invoke()).hDK());
        hashSet2.addAll(c(dVar, bVar));
        HashSet hashSet3 = hashSet;
        AppMethodBeat.o(57840);
        return hashSet3;
    }

    public /* synthetic */ g(kotlin.l.b.a.b.d.a.c.h hVar, kotlin.l.b.a.b.b.e eVar, kotlin.l.b.a.b.d.a.e.g gVar, boolean z) {
        this(hVar, eVar, gVar, z, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(kotlin.l.b.a.b.d.a.c.h hVar, kotlin.l.b.a.b.b.e eVar, kotlin.l.b.a.b.d.a.e.g gVar, boolean z, g gVar2) {
        super(hVar, gVar2);
        kotlin.g.b.p.h(hVar, "c");
        kotlin.g.b.p.h(eVar, "ownerDescriptor");
        kotlin.g.b.p.h(gVar, "jClass");
        AppMethodBeat.i(57876);
        this.Tsl = eVar;
        this.TrI = gVar;
        this.Tsm = z;
        this.Tsh = hVar.Trv.TcN.al(new f(this, hVar));
        this.Tsi = hVar.Trv.TcN.al(new i(this));
        this.Tsj = hVar.Trv.TcN.al(new C2284g(this));
        this.Tsk = hVar.Trv.TcN.V(new j(this, hVar));
        AppMethodBeat.o(57876);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final boolean a(kotlin.l.b.a.b.d.a.b.f fVar) {
        AppMethodBeat.i(57841);
        kotlin.g.b.p.h(fVar, "$this$isVisibleAsFunction");
        if (this.TrI.hCO()) {
            AppMethodBeat.o(57841);
            return false;
        }
        boolean d2 = d(fVar);
        AppMethodBeat.o(57841);
        return d2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean d(kotlin.l.b.a.b.b.am r8) {
        /*
        // Method dump skipped, instructions count: 169
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.c.a.g.d(kotlin.l.b.a.b.b.am):boolean");
    }

    private final boolean e(am amVar) {
        AppMethodBeat.i(57843);
        kotlin.l.b.a.b.d.a.d dVar = kotlin.l.b.a.b.d.a.d.ToD;
        kotlin.l.b.a.b.f.f hAH = amVar.hAH();
        kotlin.g.b.p.g(hAH, "name");
        if (!kotlin.l.b.a.b.d.a.d.g(hAH)) {
            AppMethodBeat.o(57843);
            return false;
        }
        kotlin.l.b.a.b.f.f hAH2 = amVar.hAH();
        kotlin.g.b.p.g(hAH2, "name");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = l(hAH2).iterator();
        while (it.hasNext()) {
            t e2 = kotlin.l.b.a.b.d.a.d.e(it.next());
            if (e2 != null) {
                arrayList.add(e2);
            }
        }
        ArrayList<t> arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            for (t tVar : arrayList2) {
                if (b(amVar, tVar)) {
                    AppMethodBeat.o(57843);
                    return true;
                }
            }
        }
        AppMethodBeat.o(57843);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0094 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean f(kotlin.l.b.a.b.b.am r10) {
        /*
        // Method dump skipped, instructions count: 160
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.c.a.g.f(kotlin.l.b.a.b.b.am):boolean");
    }

    private final boolean g(am amVar) {
        boolean z;
        AppMethodBeat.i(57845);
        am h2 = h(amVar);
        if (h2 == null) {
            AppMethodBeat.o(57845);
            return false;
        }
        kotlin.l.b.a.b.f.f hAH = amVar.hAH();
        kotlin.g.b.p.g(hAH, "name");
        Set<am> l = l(hAH);
        if (!l.isEmpty()) {
            for (T t : l) {
                if (!t.hAZ() || !b((kotlin.l.b.a.b.b.a) h2, (kotlin.l.b.a.b.b.a) t)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    AppMethodBeat.o(57845);
                    return true;
                }
            }
        }
        AppMethodBeat.o(57845);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static kotlin.l.b.a.b.b.am h(kotlin.l.b.a.b.b.am r7) {
        /*
        // Method dump skipped, instructions count: 141
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.c.a.g.h(kotlin.l.b.a.b.b.am):kotlin.l.b.a.b.b.am");
    }

    private static am a(am amVar, kotlin.l.b.a.b.f.f fVar) {
        AppMethodBeat.i(57847);
        t.a<? extends am> hBa = amVar.hBa();
        hBa.d(fVar);
        hBa.hBb();
        hBa.hBc();
        t hBg = hBa.hBg();
        if (hBg == null) {
            kotlin.g.b.p.hyc();
        }
        am amVar2 = (am) hBg;
        AppMethodBeat.o(57847);
        return amVar2;
    }

    private static boolean a(am amVar, t tVar) {
        t tVar2;
        AppMethodBeat.i(57848);
        kotlin.l.b.a.b.d.a.c cVar = kotlin.l.b.a.b.d.a.c.Tou;
        if (kotlin.l.b.a.b.d.a.c.c(amVar)) {
            tVar2 = tVar.hAT();
        } else {
            tVar2 = tVar;
        }
        kotlin.g.b.p.g(tVar2, "if (superDescriptor.isRe…iginal else subDescriptor");
        boolean b2 = b(tVar2, amVar);
        AppMethodBeat.o(57848);
        return b2;
    }

    private static boolean b(kotlin.l.b.a.b.b.a aVar, kotlin.l.b.a.b.b.a aVar2) {
        AppMethodBeat.i(57849);
        i.a b2 = kotlin.l.b.a.b.j.i.THP.b(aVar2, aVar, true);
        kotlin.g.b.p.g(b2, "OverridingUtil.DEFAULT.i…erDescriptor, this, true)");
        i.a.EnumC2349a hKA = b2.hKA();
        kotlin.g.b.p.g(hKA, "OverridingUtil.DEFAULT.i…iptor, this, true).result");
        if (hKA == i.a.EnumC2349a.OVERRIDABLE) {
            m.a aVar3 = m.Tpd;
            if (!m.a.a(aVar2, aVar)) {
                AppMethodBeat.o(57849);
                return true;
            }
        }
        AppMethodBeat.o(57849);
        return false;
    }

    private final am a(ah ahVar, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends am>> bVar) {
        String str;
        AppMethodBeat.i(57850);
        ai hBn = ahVar.hBn();
        ai aiVar = hBn != null ? (ai) kotlin.l.b.a.b.d.a.t.m(hBn) : null;
        if (aiVar != null) {
            kotlin.l.b.a.b.d.a.e eVar = kotlin.l.b.a.b.d.a.e.ToV;
            str = kotlin.l.b.a.b.d.a.e.l(aiVar);
        } else {
            str = null;
        }
        if (str == null || kotlin.l.b.a.b.d.a.t.a(this.Tsl, aiVar)) {
            String btJ = o.btJ(ahVar.hAH().sG());
            kotlin.g.b.p.g(btJ, "JvmAbi.getterName(name.asString())");
            am a2 = a(ahVar, btJ, bVar);
            AppMethodBeat.o(57850);
            return a2;
        }
        am a3 = a(ahVar, str, bVar);
        AppMethodBeat.o(57850);
        return a3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static kotlin.l.b.a.b.b.am a(kotlin.l.b.a.b.b.ah r7, java.lang.String r8, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends java.util.Collection<? extends kotlin.l.b.a.b.b.am>> r9) {
        /*
            r1 = 0
            r6 = 57851(0xe1fb, float:8.1067E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            kotlin.l.b.a.b.f.f r0 = kotlin.l.b.a.b.f.f.btY(r8)
            java.lang.String r2 = "Name.identifier(getterName)"
            kotlin.g.b.p.g(r0, r2)
            java.lang.Object r0 = r9.invoke(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r3 = r0.iterator()
        L_0x001b:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x004d
            java.lang.Object r0 = r3.next()
            kotlin.l.b.a.b.b.am r0 = (kotlin.l.b.a.b.b.am) r0
            java.util.List r2 = r0.hAw()
            int r2 = r2.size()
            if (r2 != 0) goto L_0x004b
            kotlin.l.b.a.b.m.a.g r2 = kotlin.l.b.a.b.m.a.g.TPc
            kotlin.l.b.a.b.m.ab r4 = r0.hAu()
            if (r4 != 0) goto L_0x0042
            r2 = 0
        L_0x003a:
            if (r2 == 0) goto L_0x004b
        L_0x003c:
            if (r0 == 0) goto L_0x001b
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
        L_0x0041:
            return r0
        L_0x0042:
            kotlin.l.b.a.b.m.ab r5 = r7.hBy()
            boolean r2 = r2.c(r4, r5)
            goto L_0x003a
        L_0x004b:
            r0 = r1
            goto L_0x003c
        L_0x004d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            r0 = r1
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.c.a.g.a(kotlin.l.b.a.b.b.ah, java.lang.String, kotlin.g.a.b):kotlin.l.b.a.b.b.am");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static kotlin.l.b.a.b.b.am b(kotlin.l.b.a.b.b.ah r7, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends java.util.Collection<? extends kotlin.l.b.a.b.b.am>> r8) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.c.a.g.b(kotlin.l.b.a.b.b.ah, kotlin.g.a.b):kotlin.l.b.a.b.b.am");
    }

    private final boolean c(ah ahVar, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends am>> bVar) {
        AppMethodBeat.i(57853);
        if (c.e(ahVar)) {
            AppMethodBeat.o(57853);
            return false;
        }
        am a2 = a(ahVar, bVar);
        am b2 = b(ahVar, bVar);
        if (a2 == null) {
            AppMethodBeat.o(57853);
            return false;
        } else if (!ahVar.hBF()) {
            AppMethodBeat.o(57853);
            return true;
        } else if (b2 == null || b2.hzC() != a2.hzC()) {
            AppMethodBeat.o(57853);
            return false;
        } else {
            AppMethodBeat.o(57853);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final void a(Collection<am> collection, kotlin.l.b.a.b.f.f fVar) {
        boolean z;
        AppMethodBeat.i(57854);
        kotlin.g.b.p.h(collection, "result");
        kotlin.g.b.p.h(fVar, "name");
        Set<am> l = l(fVar);
        kotlin.l.b.a.b.d.a.c cVar = kotlin.l.b.a.b.d.a.c.Tou;
        if (!kotlin.l.b.a.b.d.a.c.e(fVar)) {
            kotlin.l.b.a.b.d.a.d dVar = kotlin.l.b.a.b.d.a.d.ToD;
            if (!kotlin.l.b.a.b.d.a.d.g(fVar)) {
                Set<am> set = l;
                if (!set.isEmpty()) {
                    Iterator<T> it = set.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().hAZ()) {
                                z = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    for (T t : l) {
                        if (d((am) t)) {
                            arrayList.add(t);
                        }
                    }
                    a(collection, fVar, (Collection<? extends am>) arrayList, false);
                    AppMethodBeat.o(57854);
                    return;
                }
            }
        }
        i.b bVar = kotlin.l.b.a.b.o.i.TSf;
        kotlin.l.b.a.b.o.i hLZ = i.b.hLZ();
        Collection<? extends am> a2 = kotlin.l.b.a.b.d.a.a.a.a(fVar, l, v.SXr, this.Tsl, r.TLh, this.Trn.Trv.Trh.hLN());
        kotlin.g.b.p.g(a2, "resolveOverridesForNonSt….overridingUtil\n        )");
        a(fVar, collection, a2, collection, new b(this));
        a(fVar, collection, a2, hLZ, new c(this));
        ArrayList arrayList2 = new ArrayList();
        for (T t2 : l) {
            if (d((am) t2)) {
                arrayList2.add(t2);
            }
        }
        a(collection, fVar, (Collection<? extends am>) kotlin.a.j.b((Collection) arrayList2, (Iterable) hLZ), true);
        AppMethodBeat.o(57854);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(kotlin.l.b.a.b.f.f r13, java.util.Collection<? extends kotlin.l.b.a.b.b.am> r14, java.util.Collection<? extends kotlin.l.b.a.b.b.am> r15, java.util.Collection<kotlin.l.b.a.b.b.am> r16, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends java.util.Collection<? extends kotlin.l.b.a.b.b.am>> r17) {
        /*
        // Method dump skipped, instructions count: 329
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.c.a.g.a(kotlin.l.b.a.b.f.f, java.util.Collection, java.util.Collection, java.util.Collection, kotlin.g.a.b):void");
    }

    private static am a(am amVar, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends am>> bVar) {
        am amVar2;
        AppMethodBeat.i(57857);
        if (!amVar.hAZ()) {
            AppMethodBeat.o(57857);
            return null;
        }
        kotlin.l.b.a.b.f.f hAH = amVar.hAH();
        kotlin.g.b.p.g(hAH, "descriptor.name");
        for (am amVar3 : (Iterable) bVar.invoke(hAH)) {
            am h2 = h(amVar3);
            if (h2 == null) {
                amVar2 = null;
                continue;
            } else if (b((kotlin.l.b.a.b.b.a) h2, (kotlin.l.b.a.b.b.a) amVar)) {
                amVar2 = h2;
                continue;
            } else {
                amVar2 = null;
                continue;
            }
            if (amVar2 != null) {
                AppMethodBeat.o(57857);
                return amVar2;
            }
        }
        AppMethodBeat.o(57857);
        return null;
    }

    private static am a(am amVar, kotlin.l.b.a.b.b.a aVar, Collection<? extends am> collection) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(57858);
        Collection<? extends am> collection2 = collection;
        if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
            Iterator<T> it = collection2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (!(!kotlin.g.b.p.j(amVar, next)) || next.hAU() != null || !b(next, aVar)) {
                    z2 = false;
                    continue;
                } else {
                    z2 = true;
                    continue;
                }
                if (z2) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            AppMethodBeat.o(57858);
            return amVar;
        }
        t hBg = amVar.hBa().hBe().hBg();
        if (hBg == null) {
            kotlin.g.b.p.hyc();
        }
        am amVar2 = (am) hBg;
        AppMethodBeat.o(57858);
        return amVar2;
    }

    private final Set<am> l(kotlin.l.b.a.b.f.f fVar) {
        AppMethodBeat.i(57859);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = hzR().iterator();
        while (it.hasNext()) {
            kotlin.a.j.a((Collection) linkedHashSet, (Iterable) it.next().hAp().b(fVar, kotlin.l.b.a.b.c.a.c.WHEN_GET_SUPER_MEMBERS));
        }
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        AppMethodBeat.o(57859);
        return linkedHashSet2;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final void b(kotlin.l.b.a.b.f.f fVar, Collection<ah> collection) {
        kotlin.l.b.a.b.d.a.e.q qVar;
        AppMethodBeat.i(57860);
        kotlin.g.b.p.h(fVar, "name");
        kotlin.g.b.p.h(collection, "result");
        if (this.TrI.hCO() && (qVar = (kotlin.l.b.a.b.d.a.e.q) kotlin.a.j.j(((b) this.TsE.invoke()).j(fVar))) != null) {
            kotlin.l.b.a.b.d.a.b.g a2 = kotlin.l.b.a.b.d.a.b.g.a(this.Tsl, kotlin.l.b.a.b.d.a.c.f.a(this.Trn, qVar), w.FINAL, qVar.hzE(), false, qVar.hAH(), this.Trn.Trv.TqY.a(qVar), false);
            kotlin.g.b.p.g(a2, "JavaPropertyDescriptor.c…inal = */ false\n        )");
            g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
            kotlin.l.b.a.b.b.c.ab a3 = kotlin.l.b.a.b.j.b.a(a2, g.a.hBP());
            kotlin.g.b.p.g(a3, "DescriptorFactory.create…iptor, Annotations.EMPTY)");
            a2.a(a3, (aj) null);
            ab a4 = a(qVar, kotlin.l.b.a.b.d.a.c.a.a(this.Trn, a2, qVar, 0));
            a2.a(a4, v.SXr, hAs(), (kotlin.l.b.a.b.b.ak) null);
            a3.J(a4);
            collection.add(a2);
        }
        Set<ah> m = m(fVar);
        if (m.isEmpty()) {
            AppMethodBeat.o(57860);
            return;
        }
        i.b bVar = kotlin.l.b.a.b.o.i.TSf;
        kotlin.l.b.a.b.o.i hLZ = i.b.hLZ();
        a(m, collection, new d(this));
        a(m, hLZ, new e(this));
        Collection<? extends ah> a5 = kotlin.l.b.a.b.d.a.a.a.a(fVar, ak.b(m, hLZ), collection, this.Tsl, this.Trn.Trv.TqU, this.Trn.Trv.Trh.hLN());
        kotlin.g.b.p.g(a5, "resolveOverridesForNonSt…rridingUtil\n            )");
        collection.addAll(a5);
        AppMethodBeat.o(57860);
    }

    private final void a(Set<? extends ah> set, Collection<ah> collection, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends am>> bVar) {
        AppMethodBeat.i(57861);
        for (ah ahVar : set) {
            kotlin.l.b.a.b.d.a.b.g d2 = d(ahVar, bVar);
            if (d2 != null) {
                collection.add(d2);
                AppMethodBeat.o(57861);
                return;
            }
        }
        AppMethodBeat.o(57861);
    }

    private final kotlin.l.b.a.b.d.a.b.g d(ah ahVar, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends am>> bVar) {
        am amVar;
        ac acVar;
        w wVar;
        boolean z = true;
        AppMethodBeat.i(57862);
        if (!c(ahVar, bVar)) {
            AppMethodBeat.o(57862);
            return null;
        }
        am a2 = a(ahVar, bVar);
        if (a2 == null) {
            kotlin.g.b.p.hyc();
        }
        if (ahVar.hBF()) {
            amVar = b(ahVar, bVar);
            if (amVar == null) {
                kotlin.g.b.p.hyc();
            }
        } else {
            amVar = null;
        }
        if (!(amVar == null || amVar.hzC() == a2.hzC())) {
            z = false;
        }
        if (!kotlin.aa.SXc || z) {
            kotlin.l.b.a.b.d.a.b.e eVar = new kotlin.l.b.a.b.d.a.b.e(this.Tsl, a2, amVar, ahVar);
            ab hAu = a2.hAu();
            if (hAu == null) {
                kotlin.g.b.p.hyc();
            }
            eVar.a(hAu, v.SXr, hAs(), (kotlin.l.b.a.b.b.ak) null);
            kotlin.l.b.a.b.b.c.ab a3 = kotlin.l.b.a.b.j.b.a((ah) eVar, a2.hzL(), false, a2.hzM());
            a3.Tlb = a2;
            a3.J(eVar.hBy());
            kotlin.g.b.p.g(a3, "DescriptorFactory.create…escriptor.type)\n        }");
            if (amVar != null) {
                List<av> hAw = amVar.hAw();
                kotlin.g.b.p.g(hAw, "setterMethod.valueParameters");
                av avVar = (av) kotlin.a.j.kt(hAw);
                if (avVar == null) {
                    AssertionError assertionError = new AssertionError("No parameter found for ".concat(String.valueOf(amVar)));
                    AppMethodBeat.o(57862);
                    throw assertionError;
                }
                ac a4 = kotlin.l.b.a.b.j.b.a(eVar, amVar.hzL(), avVar.hzL(), false, amVar.hzE(), amVar.hzM());
                a4.Tlb = amVar;
                acVar = a4;
            } else {
                acVar = null;
            }
            eVar.a(a3, acVar);
            kotlin.l.b.a.b.d.a.b.e eVar2 = eVar;
            AppMethodBeat.o(57862);
            return eVar2;
        }
        StringBuilder append = new StringBuilder("Different accessors modalities when creating overrides for ").append(ahVar).append(" in ").append(this.Tsl).append("for getter is ").append(a2.hzC()).append(", but for setter is ");
        if (amVar != null) {
            wVar = amVar.hzC();
        } else {
            wVar = null;
        }
        AssertionError assertionError2 = new AssertionError(append.append(wVar).toString());
        AppMethodBeat.o(57862);
        throw assertionError2;
    }

    private final Set<ah> m(kotlin.l.b.a.b.f.f fVar) {
        AppMethodBeat.i(57863);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = hzR().iterator();
        while (it.hasNext()) {
            Collection<? extends ah> a2 = it.next().hAp().a(fVar, kotlin.l.b.a.b.c.a.c.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(a2, 10));
            Iterator<T> it2 = a2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next());
            }
            kotlin.a.j.a((Collection) arrayList, (Iterable) arrayList2);
        }
        Set<ah> r = kotlin.a.j.r((Iterable) arrayList);
        AppMethodBeat.o(57863);
        return r;
    }

    private final Collection<ab> hzR() {
        AppMethodBeat.i(57864);
        if (this.Tsm) {
            at hzz = this.Tsl.hzz();
            kotlin.g.b.p.g(hzz, "ownerDescriptor.typeConstructor");
            Collection<ab> hBV = hzz.hBV();
            kotlin.g.b.p.g(hBV, "ownerDescriptor.typeConstructor.supertypes");
            AppMethodBeat.o(57864);
            return hBV;
        }
        Collection<ab> D = this.Trn.Trv.Trh.hLM().D(this.Tsl);
        AppMethodBeat.o(57864);
        return D;
    }

    private static boolean b(am amVar, t tVar) {
        AppMethodBeat.i(57866);
        String a2 = kotlin.l.b.a.b.d.b.t.a(amVar, false, false, 2);
        t hAT = tVar.hAT();
        kotlin.g.b.p.g(hAT, "builtinWithErasedParameters.original");
        if (!kotlin.g.b.p.j(a2, kotlin.l.b.a.b.d.b.t.a(hAT, false, false, 2)) || b((kotlin.l.b.a.b.b.a) amVar, (kotlin.l.b.a.b.b.a) tVar)) {
            AppMethodBeat.o(57866);
            return false;
        }
        AppMethodBeat.o(57866);
        return true;
    }

    private final void a(List<av> list, k kVar, int i2, kotlin.l.b.a.b.d.a.e.q qVar, ab abVar, ab abVar2) {
        ab abVar3;
        int i3;
        k kVar2;
        AppMethodBeat.i(57867);
        k kVar3 = kVar;
        g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
        kotlin.l.b.a.b.b.a.g hBP = g.a.hBP();
        kotlin.l.b.a.b.f.f hAH = qVar.hAH();
        ab aD = bc.aD(abVar);
        kotlin.g.b.p.g(aD, "TypeUtils.makeNotNullable(returnType)");
        boolean hDf = qVar.hDf();
        if (abVar2 != null) {
            abVar3 = bc.aD(abVar2);
            i3 = i2;
            kVar2 = kVar3;
        } else {
            abVar3 = null;
            i3 = i2;
            kVar2 = kVar3;
        }
        list.add(new kotlin.l.b.a.b.b.c.aj(kVar2, null, i3, hBP, hAH, aD, hDf, false, false, abVar3, this.Trn.Trv.TqY.a(qVar)));
        AppMethodBeat.o(57867);
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
    public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        kotlin.l.b.a.b.l.d<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.b.c.g> dVar;
        kotlin.l.b.a.b.b.c.g invoke;
        AppMethodBeat.i(57869);
        kotlin.g.b.p.h(fVar, "name");
        kotlin.g.b.p.h(aVar, FirebaseAnalytics.b.LOCATION);
        d(fVar, aVar);
        g gVar = (g) this.TsK;
        if (gVar == null || (dVar = gVar.Tsk) == null || (invoke = dVar.invoke(fVar)) == null) {
            kotlin.l.b.a.b.b.c.g invoke2 = this.Tsk.invoke(fVar);
            AppMethodBeat.o(57869);
            return invoke2;
        }
        kotlin.l.b.a.b.b.c.g gVar2 = invoke;
        AppMethodBeat.o(57869);
        return gVar2;
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i, kotlin.l.b.a.b.d.a.c.a.k
    public final Collection<am> b(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(57870);
        kotlin.g.b.p.h(fVar, "name");
        kotlin.g.b.p.h(aVar, FirebaseAnalytics.b.LOCATION);
        d(fVar, aVar);
        Collection<am> b2 = super.b(fVar, aVar);
        AppMethodBeat.o(57870);
        return b2;
    }

    @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i, kotlin.l.b.a.b.d.a.c.a.k
    public final Collection<ah> a(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(57871);
        kotlin.g.b.p.h(fVar, "name");
        kotlin.g.b.p.h(aVar, FirebaseAnalytics.b.LOCATION);
        d(fVar, aVar);
        Collection<ah> a2 = super.a(fVar, aVar);
        AppMethodBeat.o(57871);
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final Set<kotlin.l.b.a.b.f.f> c(kotlin.l.b.a.b.j.f.d dVar, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> bVar) {
        AppMethodBeat.i(57872);
        kotlin.g.b.p.h(dVar, "kindFilter");
        Set<kotlin.l.b.a.b.f.f> b2 = ak.b((Set) this.Tsi.invoke(), ((Map) this.Tsj.invoke()).keySet());
        AppMethodBeat.o(57872);
        return b2;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final Set<kotlin.l.b.a.b.f.f> a(kotlin.l.b.a.b.j.f.d dVar) {
        AppMethodBeat.i(57873);
        kotlin.g.b.p.h(dVar, "kindFilter");
        if (this.TrI.hCO()) {
            Set<kotlin.l.b.a.b.f.f> hCa = hCa();
            AppMethodBeat.o(57873);
            return hCa;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(((b) this.TsE.invoke()).hDL());
        at hzz = this.Tsl.hzz();
        kotlin.g.b.p.g(hzz, "ownerDescriptor.typeConstructor");
        Collection<ab> hBV = hzz.hBV();
        kotlin.g.b.p.g(hBV, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> it = hBV.iterator();
        while (it.hasNext()) {
            kotlin.a.j.a((Collection) linkedHashSet, (Iterable) it.next().hAp().hCb());
        }
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        AppMethodBeat.o(57873);
        return linkedHashSet2;
    }

    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final String toString() {
        AppMethodBeat.i(57875);
        String str = "Lazy Java member scope for " + this.TrI.hBk();
        AppMethodBeat.o(57875);
        return str;
    }

    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final /* synthetic */ b hDR() {
        AppMethodBeat.i(57839);
        a aVar = new a(this.TrI, a.Tsn);
        AppMethodBeat.o(57839);
        return aVar;
    }

    static final class f extends q implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.d>> {
        final /* synthetic */ kotlin.l.b.a.b.d.a.c.h TpT;
        final /* synthetic */ g Tso;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(g gVar, kotlin.l.b.a.b.d.a.c.h hVar) {
            super(0);
            this.Tso = gVar;
            this.TpT = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends kotlin.l.b.a.b.b.d> invoke() {
            AppMethodBeat.i(57833);
            Collection<kotlin.l.b.a.b.d.a.e.k> hxW = this.Tso.TrI.hxW();
            ArrayList arrayList = new ArrayList(hxW.size());
            for (kotlin.l.b.a.b.d.a.e.k kVar : hxW) {
                arrayList.add(g.a(this.Tso, kVar));
            }
            l lVar = this.TpT.Trv.Tre;
            kotlin.l.b.a.b.d.a.c.h hVar = this.TpT;
            List list = arrayList;
            if (list.isEmpty()) {
                list = kotlin.a.j.eR(g.b(this.Tso));
            }
            List p = kotlin.a.j.p(lVar.a(hVar, list));
            AppMethodBeat.o(57833);
            return p;
        }
    }

    static final class i extends q implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>> {
        final /* synthetic */ g Tso;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(g gVar) {
            super(0);
            this.Tso = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Set<? extends kotlin.l.b.a.b.f.f> invoke() {
            AppMethodBeat.i(57836);
            Set r = kotlin.a.j.r((Iterable) this.Tso.TrI.hCK());
            AppMethodBeat.o(57836);
            return r;
        }
    }

    /* renamed from: kotlin.l.b.a.b.d.a.c.a.g$g  reason: collision with other inner class name */
    static final class C2284g extends q implements kotlin.g.a.a<Map<kotlin.l.b.a.b.f.f, ? extends n>> {
        final /* synthetic */ g Tso;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2284g(g gVar) {
            super(0);
            this.Tso = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Map<kotlin.l.b.a.b.f.f, ? extends n> invoke() {
            AppMethodBeat.i(57834);
            ArrayList arrayList = new ArrayList();
            for (T t : this.Tso.TrI.hCN()) {
                if (t.hDa()) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = arrayList;
            LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.k.j.mZ(ae.atJ(kotlin.a.j.a(arrayList2, 10)), 16));
            for (Object obj : arrayList2) {
                linkedHashMap.put(((n) obj).hAH(), obj);
            }
            AppMethodBeat.o(57834);
            return linkedHashMap;
        }
    }

    private final void a(Collection<am> collection, kotlin.l.b.a.b.f.f fVar, Collection<? extends am> collection2, boolean z) {
        AppMethodBeat.i(57855);
        Collection<? extends am> a2 = kotlin.l.b.a.b.d.a.a.a.a(fVar, collection2, collection, this.Tsl, this.Trn.Trv.TqU, this.Trn.Trv.Trh.hLN());
        kotlin.g.b.p.g(a2, "resolveOverridesForNonSt….overridingUtil\n        )");
        if (!z) {
            collection.addAll(a2);
            AppMethodBeat.o(57855);
            return;
        }
        List b2 = kotlin.a.j.b((Collection) collection, (Iterable) a2);
        Collection<? extends am> collection3 = a2;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(collection3, 10));
        for (T t : collection3) {
            am amVar = (am) kotlin.l.b.a.b.d.a.t.o(t);
            if (amVar != null) {
                kotlin.g.b.p.g(t, "resolvedOverride");
                t = (T) a(t, amVar, (Collection<? extends am>) b2);
            }
            arrayList.add(t);
        }
        collection.addAll(arrayList);
        AppMethodBeat.o(57855);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final k.a a(kotlin.l.b.a.b.d.a.e.q qVar, List<? extends as> list, ab abVar, List<? extends av> list2) {
        AppMethodBeat.i(57865);
        kotlin.g.b.p.h(qVar, FirebaseAnalytics.b.METHOD);
        kotlin.g.b.p.h(list, "methodTypeParameters");
        kotlin.g.b.p.h(abVar, "returnType");
        kotlin.g.b.p.h(list2, "valueParameters");
        k.a a2 = this.Trn.Trv.TqT.a(qVar, this.Tsl, abVar, list2, list);
        kotlin.g.b.p.g(a2, "c.components.signaturePr…dTypeParameters\n        )");
        ab abVar2 = a2.Tmg;
        if (abVar2 == null) {
            k.a.atM(4);
        }
        kotlin.g.b.p.g(abVar2, "propagated.returnType");
        ab abVar3 = a2.Tqr;
        List<av> list3 = a2.Tqs;
        if (list3 == null) {
            k.a.atM(5);
        }
        kotlin.g.b.p.g(list3, "propagated.valueParameters");
        List<as> list4 = a2.Thx;
        if (list4 == null) {
            k.a.atM(6);
        }
        kotlin.g.b.p.g(list4, "propagated.typeParameters");
        boolean z = a2.TkV;
        List<String> list5 = a2.Tqt;
        if (list5 == null) {
            k.a.atM(7);
        }
        kotlin.g.b.p.g(list5, "propagated.errors");
        k.a aVar = new k.a(abVar2, abVar3, list3, list4, z, list5);
        AppMethodBeat.o(57865);
        return aVar;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final kotlin.l.b.a.b.b.ak hAs() {
        AppMethodBeat.i(57868);
        kotlin.l.b.a.b.b.ak l = kotlin.l.b.a.b.j.c.l(this.Tsl);
        AppMethodBeat.o(57868);
        return l;
    }

    @Override // kotlin.l.b.a.b.j.f.i
    public final void d(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(57874);
        kotlin.g.b.p.h(fVar, "name");
        kotlin.g.b.p.h(aVar, FirebaseAnalytics.b.LOCATION);
        kotlin.l.b.a.b.c.a.a(this.Trn.Trv.Trb, aVar, this.Tsl, fVar);
        AppMethodBeat.o(57874);
    }

    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.b.l hDS() {
        return this.Tsl;
    }

    public static final /* synthetic */ Collection a(g gVar, kotlin.l.b.a.b.f.f fVar) {
        AppMethodBeat.i(57877);
        Collection<kotlin.l.b.a.b.d.a.e.q> j2 = ((b) gVar.TsE.invoke()).j(fVar);
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(j2, 10));
        Iterator<T> it = j2.iterator();
        while (it.hasNext()) {
            arrayList.add(gVar.a((kotlin.l.b.a.b.d.a.e.q) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(57877);
        return arrayList2;
    }

    public static final /* synthetic */ Collection b(g gVar, kotlin.l.b.a.b.f.f fVar) {
        AppMethodBeat.i(57878);
        ArrayList arrayList = new ArrayList();
        for (T t : gVar.l(fVar)) {
            T t2 = t;
            if (!(kotlin.l.b.a.b.d.a.t.n(t2) || kotlin.l.b.a.b.d.a.d.e(t2) != null)) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(57878);
        return arrayList2;
    }

    public static final /* synthetic */ kotlin.l.b.a.b.d.a.b.c a(g gVar, kotlin.l.b.a.b.d.a.e.k kVar) {
        AppMethodBeat.i(57879);
        kotlin.l.b.a.b.b.e eVar = gVar.Tsl;
        kotlin.l.b.a.b.d.a.b.c a2 = kotlin.l.b.a.b.d.a.b.c.a(eVar, kotlin.l.b.a.b.d.a.c.f.a(gVar.Trn, kVar), false, (an) gVar.Trn.Trv.TqY.a(kVar));
        kotlin.g.b.p.g(a2, "JavaClassConstructorDesc…ce(constructor)\n        )");
        kotlin.l.b.a.b.d.a.c.h a3 = kotlin.l.b.a.b.d.a.c.a.a(gVar.Trn, a2, kVar, eVar.hzO().size());
        k.b a4 = a(a3, a2, kVar.hAw());
        List<as> hzO = eVar.hzO();
        kotlin.g.b.p.g(hzO, "classDescriptor.declaredTypeParameters");
        List<as> list = hzO;
        List<kotlin.l.b.a.b.d.a.e.w> hAt = kVar.hAt();
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(hAt, 10));
        Iterator<T> it = hAt.iterator();
        while (it.hasNext()) {
            as a5 = a3.Trw.a(it.next());
            if (a5 == null) {
                kotlin.g.b.p.hyc();
            }
            arrayList.add(a5);
        }
        a2.a(a4.TsM, kVar.hzE(), kotlin.a.j.b((Collection) list, (Iterable) arrayList));
        a2.EC(false);
        a2.ED(a4.TsN);
        a2.I(eVar.hAG());
        a3.Trv.TqV.a(kVar, a2);
        AppMethodBeat.o(57879);
        return a2;
    }

    public static final /* synthetic */ kotlin.l.b.a.b.b.d b(g gVar) {
        ArrayList emptyList;
        kotlin.o oVar;
        AppMethodBeat.i(57880);
        boolean hCO = gVar.TrI.hCO();
        gVar.TrI.isInterface();
        if (!hCO) {
            AppMethodBeat.o(57880);
            return null;
        }
        kotlin.l.b.a.b.b.e eVar = gVar.Tsl;
        g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
        kotlin.l.b.a.b.d.a.b.c a2 = kotlin.l.b.a.b.d.a.b.c.a(eVar, g.a.hBP(), true, (an) gVar.Trn.Trv.TqY.a(gVar.TrI));
        kotlin.g.b.p.g(a2, "JavaClassConstructorDesc….source(jClass)\n        )");
        if (hCO) {
            kotlin.l.b.a.b.d.a.b.c cVar = a2;
            Collection<kotlin.l.b.a.b.d.a.e.q> hCM = gVar.TrI.hCM();
            ArrayList arrayList = new ArrayList(hCM.size());
            kotlin.l.b.a.b.d.a.c.b.a a3 = kotlin.l.b.a.b.d.a.c.b.d.a(kotlin.l.b.a.b.d.a.a.l.Tqv, true, null, 2);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (T t : hCM) {
                if (kotlin.g.b.p.j(t.hAH(), kotlin.l.b.a.b.d.a.p.Tpl)) {
                    arrayList2.add(t);
                } else {
                    arrayList3.add(t);
                }
            }
            kotlin.o oVar2 = new kotlin.o(arrayList2, arrayList3);
            A a4 = oVar2.first;
            B<kotlin.l.b.a.b.d.a.e.q> b2 = oVar2.second;
            boolean z = a4.size() <= 1;
            if (!kotlin.aa.SXc || z) {
                kotlin.l.b.a.b.d.a.e.q qVar = (kotlin.l.b.a.b.d.a.e.q) kotlin.a.j.kt(a4);
                if (qVar != null) {
                    kotlin.l.b.a.b.d.a.e.v hDd = qVar.hDd();
                    if (hDd instanceof kotlin.l.b.a.b.d.a.e.f) {
                        oVar = new kotlin.o(gVar.Trn.Tru.a((kotlin.l.b.a.b.d.a.e.f) hDd, a3, true), gVar.Trn.Tru.a(((kotlin.l.b.a.b.d.a.e.f) hDd).hCI(), a3));
                    } else {
                        oVar = new kotlin.o(gVar.Trn.Tru.a(hDd, a3), null);
                    }
                    gVar.a(arrayList, cVar, 0, qVar, oVar.first, oVar.second);
                }
                int i2 = qVar != null ? 1 : 0;
                int i3 = 0;
                for (kotlin.l.b.a.b.d.a.e.q qVar2 : b2) {
                    gVar.a(arrayList, cVar, i3 + i2, qVar2, gVar.Trn.Tru.a(qVar2.hDd(), a3), null);
                    i3++;
                }
                emptyList = arrayList;
            } else {
                AssertionError assertionError = new AssertionError("There can't be more than one method named 'value' in annotation class: " + gVar.TrI);
                AppMethodBeat.o(57880);
                throw assertionError;
            }
        } else {
            emptyList = Collections.emptyList();
        }
        a2.ED(false);
        ba hzE = eVar.hzE();
        kotlin.g.b.p.g(hzE, "classDescriptor.visibility");
        if (kotlin.g.b.p.j(hzE, kotlin.l.b.a.b.d.a.n.Tpf)) {
            hzE = kotlin.l.b.a.b.d.a.n.Tpg;
            kotlin.g.b.p.g(hzE, "JavaVisibilities.PROTECTED_AND_PACKAGE");
        }
        a2.a(emptyList, hzE);
        a2.EC(true);
        a2.I(eVar.hAG());
        gVar.Trn.Trv.TqV.a(gVar.TrI, a2);
        kotlin.l.b.a.b.d.a.b.c cVar2 = a2;
        AppMethodBeat.o(57880);
        return cVar2;
    }
}
