package kotlin.l.b.a.b.d.a.c.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.v;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.r;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.d.a.e.n;
import kotlin.l.b.a.b.d.a.e.q;
import kotlin.l.b.a.b.j.f.c;
import kotlin.l.b.a.b.j.f.d;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.j.j;
import kotlin.l.b.a.b.m.ab;
import kotlin.s;

public abstract class k extends kotlin.l.b.a.b.j.f.i {
    static final /* synthetic */ kotlin.l.k[] cLI = {aa.a(new y(aa.bp(k.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), aa.a(new y(aa.bp(k.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), aa.a(new y(aa.bp(k.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    private final kotlin.l.b.a.b.l.c<kotlin.l.b.a.b.f.f, List<ah>> TkA;
    final kotlin.l.b.a.b.l.f<Collection<kotlin.l.b.a.b.b.l>> TkB;
    private final kotlin.l.b.a.b.l.c<kotlin.l.b.a.b.f.f, Collection<am>> Tkz;
    final kotlin.l.b.a.b.d.a.c.h Trn;
    final kotlin.l.b.a.b.l.f<b> TsE;
    private final kotlin.l.b.a.b.l.c<kotlin.l.b.a.b.f.f, Collection<am>> TsF;
    private final kotlin.l.b.a.b.l.d<kotlin.l.b.a.b.f.f, ah> TsG;
    private final kotlin.l.b.a.b.l.f TsH;
    private final kotlin.l.b.a.b.l.f TsI;
    private final kotlin.l.b.a.b.l.f TsJ;
    final k TsK;

    /* access modifiers changed from: protected */
    public abstract Set<kotlin.l.b.a.b.f.f> a(kotlin.l.b.a.b.j.f.d dVar);

    /* access modifiers changed from: protected */
    public abstract a a(q qVar, List<? extends as> list, ab abVar, List<? extends av> list2);

    /* access modifiers changed from: protected */
    public abstract void a(Collection<am> collection, kotlin.l.b.a.b.f.f fVar);

    /* access modifiers changed from: protected */
    public abstract Set<kotlin.l.b.a.b.f.f> b(kotlin.l.b.a.b.j.f.d dVar, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> bVar);

    /* access modifiers changed from: protected */
    public abstract void b(kotlin.l.b.a.b.f.f fVar, Collection<ah> collection);

    /* access modifiers changed from: protected */
    public abstract Set<kotlin.l.b.a.b.f.f> c(kotlin.l.b.a.b.j.f.d dVar, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> bVar);

    /* access modifiers changed from: protected */
    public abstract ak hAs();

    /* access modifiers changed from: protected */
    public abstract b hDR();

    /* access modifiers changed from: protected */
    public abstract kotlin.l.b.a.b.b.l hDS();

    static final class e extends kotlin.g.b.q implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, ah> {
        final /* synthetic */ k TsO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(k kVar) {
            super(1);
            this.TsO = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ ah invoke(kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(57917);
            kotlin.l.b.a.b.f.f fVar2 = fVar;
            p.h(fVar2, "name");
            if (this.TsO.TsK != null) {
                ah ahVar = (ah) this.TsO.TsK.TsG.invoke(fVar2);
                AppMethodBeat.o(57917);
                return ahVar;
            }
            n k = ((b) this.TsO.TsE.invoke()).k(fVar2);
            if (k == null || k.hDa()) {
                AppMethodBeat.o(57917);
                return null;
            }
            ah a2 = k.a(this.TsO, k);
            AppMethodBeat.o(57917);
            return a2;
        }
    }

    static final class f extends kotlin.g.b.q implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends am>> {
        final /* synthetic */ k TsO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(k kVar) {
            super(1);
            this.TsO = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Collection<? extends am> invoke(kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(57918);
            kotlin.l.b.a.b.f.f fVar2 = fVar;
            p.h(fVar2, "name");
            if (this.TsO.TsK != null) {
                Collection collection = (Collection) this.TsO.TsK.TsF.invoke(fVar2);
                AppMethodBeat.o(57918);
                return collection;
            }
            ArrayList arrayList = new ArrayList();
            for (q qVar : ((b) this.TsO.TsE.invoke()).j(fVar2)) {
                kotlin.l.b.a.b.d.a.b.f a2 = this.TsO.a(qVar);
                if (this.TsO.a(a2)) {
                    this.TsO.Trn.Trv.TqV.a(qVar, a2);
                    arrayList.add(a2);
                }
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(57918);
            return arrayList2;
        }
    }

    static final class i extends kotlin.g.b.q implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, List<? extends am>> {
        final /* synthetic */ k TsO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(k kVar) {
            super(1);
            this.TsO = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ List<? extends am> invoke(kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(57921);
            kotlin.l.b.a.b.f.f fVar2 = fVar;
            p.h(fVar2, "name");
            LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) this.TsO.TsF.invoke(fVar2));
            LinkedHashSet linkedHashSet2 = linkedHashSet;
            p.h(linkedHashSet2, "$this$retainMostSpecificInEachOverridableGroup");
            Collection<?> b2 = kotlin.l.b.a.b.j.j.b(linkedHashSet2, j.a.TIi);
            if (linkedHashSet2.size() != b2.size()) {
                linkedHashSet2.retainAll(b2);
            }
            this.TsO.a(linkedHashSet, fVar2);
            List p = kotlin.a.j.p(this.TsO.Trn.Trv.Tre.a(this.TsO.Trn, linkedHashSet));
            AppMethodBeat.o(57921);
            return p;
        }
    }

    static final class j extends kotlin.g.b.q implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, List<? extends ah>> {
        final /* synthetic */ k TsO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(k kVar) {
            super(1);
            this.TsO = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ List<? extends ah> invoke(kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(57922);
            kotlin.l.b.a.b.f.f fVar2 = fVar;
            p.h(fVar2, "name");
            ArrayList arrayList = new ArrayList();
            kotlin.l.b.a.b.o.a.c(arrayList, this.TsO.TsG.invoke(fVar2));
            this.TsO.b(fVar2, arrayList);
            if (kotlin.l.b.a.b.j.c.z(this.TsO.hDS())) {
                List p = kotlin.a.j.p(arrayList);
                AppMethodBeat.o(57922);
                return p;
            }
            List p2 = kotlin.a.j.p(this.TsO.Trn.Trv.Tre.a(this.TsO.Trn, arrayList));
            AppMethodBeat.o(57922);
            return p2;
        }
    }

    public static final /* synthetic */ ah a(k kVar, n nVar) {
        kotlin.l.b.a.b.d.a.b.g a2 = kotlin.l.b.a.b.d.a.b.g.a(kVar.hDS(), kotlin.l.b.a.b.d.a.c.f.a(kVar.Trn, nVar), w.FINAL, nVar.hzE(), !nVar.hCR(), nVar.hAH(), kVar.Trn.Trv.TqY.a(nVar), a(nVar));
        p.g(a2, "JavaPropertyDescriptor.c…d.isFinalStatic\n        )");
        kotlin.l.b.a.b.d.a.b.g gVar = a2;
        gVar.a((kotlin.l.b.a.b.b.c.ab) null, (aj) null, (r) null, (r) null);
        ab a3 = kVar.Trn.Tru.a(nVar.hDb(), kotlin.l.b.a.b.d.a.c.b.d.a(kotlin.l.b.a.b.d.a.a.l.Tqv, false, null, 3));
        if (kotlin.l.b.a.b.a.g.o(a3) || kotlin.l.b.a.b.a.g.D(a3)) {
            a(nVar);
        }
        gVar.a(a3, v.SXr, kVar.hAs(), (ak) null);
        if (kotlin.l.b.a.b.j.c.a(gVar, gVar.hBy())) {
            gVar.a(kVar.Trn.Trv.TcN.am(new l(kVar, nVar, gVar)));
        }
        kVar.Trn.Trv.TqV.b(nVar, gVar);
        return gVar;
    }

    public /* synthetic */ k(kotlin.l.b.a.b.d.a.c.h hVar) {
        this(hVar, null);
    }

    public k(kotlin.l.b.a.b.d.a.c.h hVar, k kVar) {
        p.h(hVar, "c");
        this.Trn = hVar;
        this.TsK = kVar;
        this.TkB = this.Trn.Trv.TcN.a(new c(this), v.SXr);
        this.TsE = this.Trn.Trv.TcN.al(new g(this));
        this.TsF = this.Trn.Trv.TcN.U(new f(this));
        this.TsG = this.Trn.Trv.TcN.V(new e(this));
        this.Tkz = this.Trn.Trv.TcN.U(new i(this));
        this.TsH = this.Trn.Trv.TcN.al(new h(this));
        this.TsI = this.Trn.Trv.TcN.al(new C2286k(this));
        this.TsJ = this.Trn.Trv.TcN.al(new d(this));
        this.TkA = this.Trn.Trv.TcN.U(new j(this));
    }

    /* access modifiers changed from: protected */
    public boolean a(kotlin.l.b.a.b.d.a.b.f fVar) {
        p.h(fVar, "$this$isVisibleAsFunction");
        return true;
    }

    /* access modifiers changed from: protected */
    public static final class a {
        final List<as> Thx;
        final boolean TkV;
        final ab Tmg;
        final ab Tqr;
        final List<av> Tqs;
        final List<String> TsL;

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
            if (kotlin.g.b.p.j(r3.TsL, r4.TsL) != false) goto L_0x0046;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 57913(0xe239, float:8.1153E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0046
                boolean r0 = r4 instanceof kotlin.l.b.a.b.d.a.c.a.k.a
                if (r0 == 0) goto L_0x004b
                kotlin.l.b.a.b.d.a.c.a.k$a r4 = (kotlin.l.b.a.b.d.a.c.a.k.a) r4
                kotlin.l.b.a.b.m.ab r0 = r3.Tmg
                kotlin.l.b.a.b.m.ab r1 = r4.Tmg
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x004b
                kotlin.l.b.a.b.m.ab r0 = r3.Tqr
                kotlin.l.b.a.b.m.ab r1 = r4.Tqr
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x004b
                java.util.List<kotlin.l.b.a.b.b.av> r0 = r3.Tqs
                java.util.List<kotlin.l.b.a.b.b.av> r1 = r4.Tqs
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x004b
                java.util.List<kotlin.l.b.a.b.b.as> r0 = r3.Thx
                java.util.List<kotlin.l.b.a.b.b.as> r1 = r4.Thx
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x004b
                boolean r0 = r3.TkV
                boolean r1 = r4.TkV
                if (r0 != r1) goto L_0x004b
                java.util.List<java.lang.String> r0 = r3.TsL
                java.util.List<java.lang.String> r1 = r4.TsL
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x004b
            L_0x0046:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x004a:
                return r0
            L_0x004b:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x004a
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.c.a.k.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(57912);
            ab abVar = this.Tmg;
            int hashCode = (abVar != null ? abVar.hashCode() : 0) * 31;
            ab abVar2 = this.Tqr;
            int hashCode2 = ((abVar2 != null ? abVar2.hashCode() : 0) + hashCode) * 31;
            List<av> list = this.Tqs;
            int hashCode3 = ((list != null ? list.hashCode() : 0) + hashCode2) * 31;
            List<as> list2 = this.Thx;
            int hashCode4 = ((list2 != null ? list2.hashCode() : 0) + hashCode3) * 31;
            boolean z = this.TkV;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = (i3 + hashCode4) * 31;
            List<String> list3 = this.TsL;
            if (list3 != null) {
                i2 = list3.hashCode();
            }
            int i7 = i6 + i2;
            AppMethodBeat.o(57912);
            return i7;
        }

        public final String toString() {
            AppMethodBeat.i(57911);
            String str = "MethodSignatureData(returnType=" + this.Tmg + ", receiverType=" + this.Tqr + ", valueParameters=" + this.Tqs + ", typeParameters=" + this.Thx + ", hasStableParameterNames=" + this.TkV + ", errors=" + this.TsL + ")";
            AppMethodBeat.o(57911);
            return str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends kotlin.l.b.a.b.b.av> */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<? extends kotlin.l.b.a.b.b.as> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(ab abVar, ab abVar2, List<? extends av> list, List<? extends as> list2, boolean z, List<String> list3) {
            p.h(abVar, "returnType");
            p.h(list, "valueParameters");
            p.h(list2, "typeParameters");
            p.h(list3, "errors");
            AppMethodBeat.i(57910);
            this.Tmg = abVar;
            this.Tqr = abVar2;
            this.Tqs = list;
            this.Thx = list2;
            this.TkV = z;
            this.TsL = list3;
            AppMethodBeat.o(57910);
        }
    }

    /* access modifiers changed from: protected */
    public final kotlin.l.b.a.b.d.a.b.f a(q qVar) {
        ak akVar;
        kotlin.l.b.a.b.d.a.b.f fVar;
        Map<? extends a.AbstractC2276a<?>, ?> emptyMap;
        boolean z;
        p.h(qVar, FirebaseAnalytics.b.METHOD);
        kotlin.l.b.a.b.d.a.b.f a2 = kotlin.l.b.a.b.d.a.b.f.a(hDS(), kotlin.l.b.a.b.d.a.c.f.a(this.Trn, qVar), qVar.hAH(), this.Trn.Trv.TqY.a(qVar));
        p.g(a2, "JavaMethodDescriptor.cre….source(method)\n        )");
        kotlin.l.b.a.b.d.a.c.h a3 = kotlin.l.b.a.b.d.a.c.a.a(this.Trn, a2, qVar, 0);
        List<kotlin.l.b.a.b.d.a.e.w> hAt = qVar.hAt();
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(hAt, 10));
        Iterator<T> it = hAt.iterator();
        while (it.hasNext()) {
            as a4 = a3.Trw.a(it.next());
            if (a4 == null) {
                p.hyc();
            }
            arrayList.add(a4);
        }
        b a5 = a(a3, a2, qVar.hAw());
        a a6 = a(qVar, arrayList, a(qVar, a3), a5.TsM);
        ab abVar = a6.Tqr;
        if (abVar != null) {
            g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
            akVar = kotlin.l.b.a.b.j.b.a(a2, abVar, g.a.hBP());
            fVar = a2;
        } else {
            akVar = null;
            fVar = a2;
        }
        ak hAs = hAs();
        List<as> list = a6.Thx;
        List<av> list2 = a6.Tqs;
        ab abVar2 = a6.Tmg;
        w.a aVar2 = w.Tht;
        w bn = w.a.bn(qVar.hCQ(), !qVar.hCR());
        ba hzE = qVar.hzE();
        if (a6.Tqr != null) {
            emptyMap = ae.b(s.U(kotlin.l.b.a.b.d.a.b.f.Tqz, kotlin.a.j.ks(a5.TsM)));
        } else {
            emptyMap = ae.emptyMap();
        }
        fVar.a(akVar, hAs, list, list2, abVar2, bn, hzE, emptyMap);
        a2.bo(a6.TkV, a5.TsN);
        if (!a6.TsL.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            a3.Trv.TqT.a(a2, a6.TsL);
        }
        return a2;
    }

    protected static ab a(q qVar, kotlin.l.b.a.b.d.a.c.h hVar) {
        p.h(qVar, FirebaseAnalytics.b.METHOD);
        p.h(hVar, "c");
        return hVar.Tru.a(qVar.hDd(), kotlin.l.b.a.b.d.a.c.b.d.a(kotlin.l.b.a.b.d.a.a.l.Tqv, qVar.hDc().hCO(), null, 2));
    }

    /* access modifiers changed from: protected */
    public static final class b {
        final List<av> TsM;
        final boolean TsN;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.l.b.a.b.b.av> */
        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends av> list, boolean z) {
            p.h(list, "descriptors");
            AppMethodBeat.i(57914);
            this.TsM = list;
            this.TsN = z;
            AppMethodBeat.o(57914);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0104 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static kotlin.l.b.a.b.d.a.c.a.k.b a(kotlin.l.b.a.b.d.a.c.h r18, kotlin.l.b.a.b.b.t r19, java.util.List<? extends kotlin.l.b.a.b.d.a.e.y> r20) {
        /*
        // Method dump skipped, instructions count: 396
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.c.a.k.a(kotlin.l.b.a.b.d.a.c.h, kotlin.l.b.a.b.b.t, java.util.List):kotlin.l.b.a.b.d.a.c.a.k$b");
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
    public Collection<am> b(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        if (!hCa().contains(fVar)) {
            return v.SXr;
        }
        return this.Tkz.invoke(fVar);
    }

    private static boolean a(n nVar) {
        return nVar.hCR() && nVar.hgu();
    }

    @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
    public Collection<ah> a(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        if (!hCb().contains(fVar)) {
            return v.SXr;
        }
        return this.TkA.invoke(fVar);
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
    public Collection<kotlin.l.b.a.b.b.l> a(kotlin.l.b.a.b.j.f.d dVar, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> bVar) {
        p.h(dVar, "kindFilter");
        p.h(bVar, "nameFilter");
        return (Collection) this.TkB.invoke();
    }

    /* access modifiers changed from: protected */
    public final List<kotlin.l.b.a.b.b.l> d(kotlin.l.b.a.b.j.f.d dVar, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> bVar) {
        p.h(dVar, "kindFilter");
        p.h(bVar, "nameFilter");
        kotlin.l.b.a.b.c.a.c cVar = kotlin.l.b.a.b.c.a.c.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        d.a aVar = kotlin.l.b.a.b.j.f.d.TJQ;
        if (dVar.avF(kotlin.l.b.a.b.j.f.d.TJB)) {
            for (kotlin.l.b.a.b.f.f fVar : c(dVar, bVar)) {
                if (bVar.invoke(fVar).booleanValue()) {
                    kotlin.l.b.a.b.o.a.c(linkedHashSet, c(fVar, cVar));
                }
            }
        }
        d.a aVar2 = kotlin.l.b.a.b.j.f.d.TJQ;
        if (dVar.avF(kotlin.l.b.a.b.j.f.d.TJy) && !dVar.TJs.contains(c.a.TJp)) {
            for (kotlin.l.b.a.b.f.f fVar2 : b(dVar, bVar)) {
                if (bVar.invoke(fVar2).booleanValue()) {
                    linkedHashSet.addAll(b(fVar2, cVar));
                }
            }
        }
        d.a aVar3 = kotlin.l.b.a.b.j.f.d.TJQ;
        if (dVar.avF(kotlin.l.b.a.b.j.f.d.TJz) && !dVar.TJs.contains(c.a.TJp)) {
            for (kotlin.l.b.a.b.f.f fVar3 : a(dVar)) {
                if (bVar.invoke(fVar3).booleanValue()) {
                    linkedHashSet.addAll(a(fVar3, cVar));
                }
            }
        }
        return kotlin.a.j.p(linkedHashSet);
    }

    public String toString() {
        return "Lazy scope for " + hDS();
    }

    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.l>> {
        final /* synthetic */ k TsO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(k kVar) {
            super(0);
            this.TsO = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends kotlin.l.b.a.b.b.l> invoke() {
            AppMethodBeat.i(57915);
            k kVar = this.TsO;
            kotlin.l.b.a.b.j.f.d dVar = kotlin.l.b.a.b.j.f.d.TJE;
            h.a aVar = kotlin.l.b.a.b.j.f.h.TJW;
            List<kotlin.l.b.a.b.b.l> d2 = kVar.d(dVar, h.a.hKZ());
            AppMethodBeat.o(57915);
            return d2;
        }
    }

    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<b> {
        final /* synthetic */ k TsO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(k kVar) {
            super(0);
            this.TsO = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ b invoke() {
            AppMethodBeat.i(57919);
            b hDR = this.TsO.hDR();
            AppMethodBeat.o(57919);
            return hDR;
        }
    }

    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>> {
        final /* synthetic */ k TsO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(k kVar) {
            super(0);
            this.TsO = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Set<? extends kotlin.l.b.a.b.f.f> invoke() {
            AppMethodBeat.i(57920);
            Set<kotlin.l.b.a.b.f.f> b2 = this.TsO.b(kotlin.l.b.a.b.j.f.d.TJL, (kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean>) null);
            AppMethodBeat.o(57920);
            return b2;
        }
    }

    /* renamed from: kotlin.l.b.a.b.d.a.c.a.k$k  reason: collision with other inner class name */
    static final class C2286k extends kotlin.g.b.q implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>> {
        final /* synthetic */ k TsO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2286k(k kVar) {
            super(0);
            this.TsO = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Set<? extends kotlin.l.b.a.b.f.f> invoke() {
            AppMethodBeat.i(57923);
            Set<kotlin.l.b.a.b.f.f> a2 = this.TsO.a(kotlin.l.b.a.b.j.f.d.TJM);
            AppMethodBeat.o(57923);
            return a2;
        }
    }

    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>> {
        final /* synthetic */ k TsO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(k kVar) {
            super(0);
            this.TsO = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Set<? extends kotlin.l.b.a.b.f.f> invoke() {
            AppMethodBeat.i(57916);
            Set<kotlin.l.b.a.b.f.f> c2 = this.TsO.c(kotlin.l.b.a.b.j.f.d.TJJ, (kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean>) null);
            AppMethodBeat.o(57916);
            return c2;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class l extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.l.b.a.b.j.b.g<?>> {
        final /* synthetic */ k TsO;
        final /* synthetic */ n TsP;
        final /* synthetic */ kotlin.l.b.a.b.b.c.aa TsQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(k kVar, n nVar, kotlin.l.b.a.b.b.c.aa aaVar) {
            super(0);
            this.TsO = kVar;
            this.TsP = nVar;
            this.TsQ = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.l.b.a.b.j.b.g<?> invoke() {
            AppMethodBeat.i(57924);
            kotlin.l.b.a.b.j.b.g<?> a2 = this.TsO.Trn.Trv.TqW.a(this.TsP, this.TsQ);
            AppMethodBeat.o(57924);
            return a2;
        }
    }

    @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
    public final Set<kotlin.l.b.a.b.f.f> hCa() {
        return (Set) kotlin.l.b.a.b.l.i.a(this.TsH, cLI[0]);
    }

    @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
    public final Set<kotlin.l.b.a.b.f.f> hCb() {
        return (Set) kotlin.l.b.a.b.l.i.a(this.TsI, cLI[1]);
    }
}
