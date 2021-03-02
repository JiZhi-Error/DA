package kotlin.l.b.a.b.d.a.c.a;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a.v;
import kotlin.a.x;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.d.a.c.a.b;
import kotlin.l.b.a.b.d.a.c.h;
import kotlin.l.b.a.b.d.a.e.aa;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.d.a.j;
import kotlin.l.b.a.b.d.b.a.a;
import kotlin.l.b.a.b.d.b.n;
import kotlin.l.b.a.b.d.b.o;
import kotlin.l.b.a.b.d.b.p;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.d;
import kotlin.l.b.a.b.l.g;
import kotlin.m;

public final class j extends m {
    private final t Tsv;
    private final g<Set<String>> Tsx;
    private final kotlin.l.b.a.b.l.d<a, e> Tsy;
    final h Tsz;

    static final class c extends q implements kotlin.g.a.b<a, e> {
        final /* synthetic */ h TpT;
        final /* synthetic */ j TsD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(j jVar, h hVar) {
            super(1);
            this.TsD = jVar;
            this.TpT = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ e invoke(a aVar) {
            n.a c2;
            p pVar;
            kotlin.l.b.a.b.f.a aVar2;
            kotlin.l.b.a.b.d.a.e.g gVar;
            kotlin.l.b.a.b.f.b bVar;
            f fVar;
            byte[] bArr;
            kotlin.l.b.a.b.f.a aVar3;
            n.a aVar4;
            p pVar2 = null;
            AppMethodBeat.i(57897);
            a aVar5 = aVar;
            kotlin.g.b.p.h(aVar5, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            kotlin.l.b.a.b.f.a aVar6 = new kotlin.l.b.a.b.f.a(this.TsD.Tsz.TiI, aVar5.TjT);
            if (aVar5.TsA != null) {
                c2 = this.TpT.Trv.TqR.a(aVar5.TsA);
            } else {
                c2 = this.TpT.Trv.TqR.c(aVar6);
            }
            if (c2 != null) {
                pVar = c2.hEo();
            } else {
                pVar = null;
            }
            if (pVar != null) {
                aVar2 = pVar.hyy();
            } else {
                aVar2 = null;
            }
            if (aVar2 == null || (!aVar2.hJc() && !aVar2.BPb)) {
                b a2 = j.a(this.TsD, pVar);
                if (a2 instanceof b.a) {
                    e eVar = ((b.a) a2).Tlv;
                    AppMethodBeat.o(57897);
                    return eVar;
                } else if (a2 instanceof b.c) {
                    AppMethodBeat.o(57897);
                    return null;
                } else if (a2 instanceof b.C2285b) {
                    kotlin.l.b.a.b.d.a.e.g gVar2 = aVar5.TsA;
                    if (gVar2 == null) {
                        kotlin.l.b.a.b.d.a.j jVar = this.TpT.Trv.TqQ;
                        if (c2 != null) {
                            if (!(c2 instanceof n.a.C2298a)) {
                                aVar4 = null;
                            } else {
                                aVar4 = c2;
                            }
                            n.a.C2298a aVar7 = (n.a.C2298a) aVar4;
                            if (aVar7 != null) {
                                bArr = aVar7.content;
                                aVar3 = aVar6;
                                gVar = jVar.a(new j.a(aVar3, bArr, null, 4));
                            }
                        }
                        bArr = null;
                        aVar3 = aVar6;
                        jVar = jVar;
                        gVar = jVar.a(new j.a(aVar3, bArr, null, 4));
                    } else {
                        gVar = gVar2;
                    }
                    if (aa.BINARY == null) {
                        StringBuilder append = new StringBuilder("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: ").append(gVar).append('\n').append("ClassId: ").append(aVar6).append('\n').append("findKotlinClass(JavaClass) = ");
                        n nVar = this.TpT.Trv.TqR;
                        kotlin.g.b.p.h(nVar, "$this$findKotlinClass");
                        kotlin.g.b.p.h(gVar, "javaClass");
                        n.a a3 = nVar.a(gVar);
                        if (a3 != null) {
                            pVar2 = a3.hEo();
                        }
                        IllegalStateException illegalStateException = new IllegalStateException(append.append(pVar2).append('\n').append("findKotlinClass(ClassId) = ").append(o.a(this.TpT.Trv.TqR, aVar6)).append('\n').toString());
                        AppMethodBeat.o(57897);
                        throw illegalStateException;
                    }
                    if (gVar != null) {
                        bVar = gVar.hBk();
                    } else {
                        bVar = null;
                    }
                    if (bVar == null || bVar.TCR.TCW.isEmpty() || (!kotlin.g.b.p.j(bVar.hJf(), this.TsD.Tsz.TiI))) {
                        fVar = null;
                    } else {
                        f fVar2 = new f(this.TpT, this.TsD.Tsz, gVar);
                        this.TpT.Trv.Trf.a(fVar2);
                        fVar = fVar2;
                    }
                    f fVar3 = fVar;
                    AppMethodBeat.o(57897);
                    return fVar3;
                } else {
                    m mVar = new m();
                    AppMethodBeat.o(57897);
                    throw mVar;
                }
            } else {
                AppMethodBeat.o(57897);
                return null;
            }
        }
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
    public final /* synthetic */ kotlin.l.b.a.b.b.h c(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(57900);
        e e2 = e(fVar, aVar);
        AppMethodBeat.o(57900);
        return e2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(h hVar, t tVar, h hVar2) {
        super(hVar);
        kotlin.g.b.p.h(hVar, "c");
        kotlin.g.b.p.h(tVar, "jPackage");
        kotlin.g.b.p.h(hVar2, "ownerDescriptor");
        AppMethodBeat.i(57908);
        this.Tsv = tVar;
        this.Tsz = hVar2;
        this.Tsx = hVar.Trv.TcN.am(new d(this, hVar));
        this.Tsy = hVar.Trv.TcN.V(new c(this, hVar));
        AppMethodBeat.o(57908);
    }

    /* access modifiers changed from: package-private */
    public static abstract class b {

        public static final class a extends b {
            final e Tlv;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(e eVar) {
                super((byte) 0);
                kotlin.g.b.p.h(eVar, "descriptor");
                AppMethodBeat.i(57894);
                this.Tlv = eVar;
                AppMethodBeat.o(57894);
            }
        }

        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        /* renamed from: kotlin.l.b.a.b.d.a.c.a.j$b$b  reason: collision with other inner class name */
        public static final class C2285b extends b {
            public static final C2285b TsB = new C2285b();

            static {
                AppMethodBeat.i(57895);
                AppMethodBeat.o(57895);
            }

            private C2285b() {
                super((byte) 0);
            }
        }

        public static final class c extends b {
            public static final c TsC = new c();

            static {
                AppMethodBeat.i(57896);
                AppMethodBeat.o(57896);
            }

            private c() {
                super((byte) 0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        final f TjT;
        final kotlin.l.b.a.b.d.a.e.g TsA;

        public a(f fVar, kotlin.l.b.a.b.d.a.e.g gVar) {
            kotlin.g.b.p.h(fVar, "name");
            AppMethodBeat.i(57893);
            this.TjT = fVar;
            this.TsA = gVar;
            AppMethodBeat.o(57893);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(57891);
            if (!(obj instanceof a) || !kotlin.g.b.p.j(this.TjT, ((a) obj).TjT)) {
                AppMethodBeat.o(57891);
                return false;
            }
            AppMethodBeat.o(57891);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.i(57892);
            int hashCode = this.TjT.hashCode();
            AppMethodBeat.o(57892);
            return hashCode;
        }
    }

    public final e e(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(57899);
        kotlin.g.b.p.h(fVar, "name");
        kotlin.g.b.p.h(aVar, FirebaseAnalytics.b.LOCATION);
        e a2 = a(fVar, (kotlin.l.b.a.b.d.a.e.g) null);
        AppMethodBeat.o(57899);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final e a(f fVar, kotlin.l.b.a.b.d.a.e.g gVar) {
        AppMethodBeat.i(57901);
        if (!kotlin.l.b.a.b.f.h.w(fVar)) {
            AppMethodBeat.o(57901);
            return null;
        }
        Set set = (Set) this.Tsx.invoke();
        if (gVar != null || set == null || set.contains(fVar.sG())) {
            e invoke = this.Tsy.invoke(new a(fVar, gVar));
            AppMethodBeat.o(57901);
            return invoke;
        }
        AppMethodBeat.o(57901);
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final b hDR() {
        return b.a.TrL;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final Set<f> c(kotlin.l.b.a.b.j.f.d dVar, kotlin.g.a.b<? super f, Boolean> bVar) {
        f hAH;
        AppMethodBeat.i(57903);
        kotlin.g.b.p.h(dVar, "kindFilter");
        d.a aVar = kotlin.l.b.a.b.j.f.d.TJQ;
        if (!dVar.avF(kotlin.l.b.a.b.j.f.d.TJu)) {
            x xVar = x.SXt;
            AppMethodBeat.o(57903);
            return xVar;
        }
        Set<String> set = (Set) this.Tsx.invoke();
        if (set != null) {
            HashSet hashSet = new HashSet();
            for (String str : set) {
                hashSet.add(f.btY(str));
            }
            HashSet hashSet2 = hashSet;
            AppMethodBeat.o(57903);
            return hashSet2;
        }
        t tVar = this.Tsv;
        if (bVar == null) {
            bVar = kotlin.l.b.a.b.o.d.hLR();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (T t : tVar.S(bVar)) {
            if (aa.SOURCE == null) {
                hAH = null;
            } else {
                hAH = t.hAH();
            }
            if (hAH != null) {
                linkedHashSet.add(hAH);
            }
        }
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        AppMethodBeat.o(57903);
        return linkedHashSet2;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final void a(Collection<am> collection, f fVar) {
        AppMethodBeat.i(57905);
        kotlin.g.b.p.h(collection, "result");
        kotlin.g.b.p.h(fVar, "name");
        AppMethodBeat.o(57905);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042 A[SYNTHETIC] */
    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i, kotlin.l.b.a.b.d.a.c.a.k
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Collection<kotlin.l.b.a.b.b.l> a(kotlin.l.b.a.b.j.f.d r7, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, java.lang.Boolean> r8) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.c.a.j.a(kotlin.l.b.a.b.j.f.d, kotlin.g.a.b):java.util.Collection");
    }

    static final class d extends q implements kotlin.g.a.a<Set<? extends String>> {
        final /* synthetic */ h TpT;
        final /* synthetic */ j TsD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(j jVar, h hVar) {
            super(0);
            this.TsD = jVar;
            this.TpT = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Set<? extends String> invoke() {
            AppMethodBeat.i(57898);
            Set<String> j2 = this.TpT.Trv.TqQ.j(this.TsD.Tsz.TiI);
            AppMethodBeat.o(57898);
            return j2;
        }
    }

    @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i, kotlin.l.b.a.b.d.a.c.a.k
    public final Collection<ah> a(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(57902);
        kotlin.g.b.p.h(fVar, "name");
        kotlin.g.b.p.h(aVar, FirebaseAnalytics.b.LOCATION);
        v vVar = v.SXr;
        AppMethodBeat.o(57902);
        return vVar;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final Set<f> b(kotlin.l.b.a.b.j.f.d dVar, kotlin.g.a.b<? super f, Boolean> bVar) {
        AppMethodBeat.i(57904);
        kotlin.g.b.p.h(dVar, "kindFilter");
        x xVar = x.SXt;
        AppMethodBeat.o(57904);
        return xVar;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final Set<f> a(kotlin.l.b.a.b.j.f.d dVar) {
        AppMethodBeat.i(57906);
        kotlin.g.b.p.h(dVar, "kindFilter");
        x xVar = x.SXt;
        AppMethodBeat.o(57906);
        return xVar;
    }

    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final /* bridge */ /* synthetic */ l hDS() {
        return this.Tsz;
    }

    public static final /* synthetic */ b a(j jVar, p pVar) {
        e a2;
        AppMethodBeat.i(57909);
        if (pVar == null) {
            b.C2285b bVar = b.C2285b.TsB;
            AppMethodBeat.o(57909);
            return bVar;
        } else if (pVar.hCA().Twl == a.EnumC2293a.CLASS) {
            kotlin.l.b.a.b.d.b.e eVar = jVar.Trn.Trv.TqS;
            kotlin.g.b.p.h(pVar, "kotlinClass");
            kotlin.l.b.a.b.k.a.h a3 = eVar.a(pVar);
            if (a3 == null) {
                a2 = null;
            } else {
                kotlin.l.b.a.b.k.a.l lVar = eVar.Tvt;
                if (lVar == null) {
                    kotlin.g.b.p.btv("components");
                }
                a2 = lVar.TKL.a(pVar.hyy(), a3);
            }
            if (a2 != null) {
                b.a aVar = new b.a(a2);
                AppMethodBeat.o(57909);
                return aVar;
            }
            b.C2285b bVar2 = b.C2285b.TsB;
            AppMethodBeat.o(57909);
            return bVar2;
        } else {
            b.c cVar = b.c.TsC;
            AppMethodBeat.o(57909);
            return cVar;
        }
    }
}
