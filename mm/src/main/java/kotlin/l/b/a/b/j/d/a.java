package kotlin.l.b.a.b.j.d;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.aa;
import kotlin.g.a.m;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.i;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.j.f.j;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.a.r;
import kotlin.l.b.a.b.o.b;
import kotlin.t;
import kotlin.x;

public final class a {
    private static final kotlin.l.b.a.b.f.f TIM;

    static {
        AppMethodBeat.i(60159);
        kotlin.l.b.a.b.f.f btY = kotlin.l.b.a.b.f.f.btY("value");
        p.g(btY, "Name.identifier(\"value\")");
        TIM = btY;
        AppMethodBeat.o(60159);
    }

    public static final kotlin.l.b.a.b.f.c q(l lVar) {
        AppMethodBeat.i(60142);
        p.h(lVar, "$this$fqNameUnsafe");
        kotlin.l.b.a.b.f.c n = kotlin.l.b.a.b.j.c.n(lVar);
        p.g(n, "DescriptorUtils.getFqName(this)");
        AppMethodBeat.o(60142);
        return n;
    }

    public static final kotlin.l.b.a.b.f.b o(l lVar) {
        AppMethodBeat.i(60143);
        p.h(lVar, "$this$fqNameSafe");
        kotlin.l.b.a.b.f.b o = kotlin.l.b.a.b.j.c.o(lVar);
        p.g(o, "DescriptorUtils.getFqNameSafe(this)");
        AppMethodBeat.o(60143);
        return o;
    }

    public static final y F(l lVar) {
        AppMethodBeat.i(60144);
        p.h(lVar, "$this$module");
        y s = kotlin.l.b.a.b.j.c.s(lVar);
        p.g(s, "DescriptorUtils.getContainingModule(this)");
        AppMethodBeat.o(60144);
        return s;
    }

    public static final kotlin.l.b.a.b.b.e b(y yVar, kotlin.l.b.a.b.f.b bVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(60145);
        p.h(yVar, "$this$resolveTopLevelClass");
        p.h(bVar, "topLevelClassFqName");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        boolean z = !bVar.isRoot();
        if (!aa.SXc || z) {
            kotlin.l.b.a.b.f.b hJf = bVar.hJf();
            p.g(hJf, "topLevelClassFqName.parent()");
            h hAp = yVar.e(hJf).hAp();
            kotlin.l.b.a.b.f.f hJg = bVar.hJg();
            p.g(hJg, "topLevelClassFqName.shortName()");
            kotlin.l.b.a.b.b.h c2 = hAp.c(hJg, aVar);
            if (!(c2 instanceof kotlin.l.b.a.b.b.e)) {
                c2 = null;
            }
            kotlin.l.b.a.b.b.e eVar = (kotlin.l.b.a.b.b.e) c2;
            AppMethodBeat.o(60145);
            return eVar;
        }
        AssertionError assertionError = new AssertionError("Assertion failed");
        AppMethodBeat.o(60145);
        throw assertionError;
    }

    public static final kotlin.l.b.a.b.f.a c(kotlin.l.b.a.b.b.h hVar) {
        l hzx;
        kotlin.l.b.a.b.f.a c2;
        AppMethodBeat.i(60146);
        if (hVar == null || (hzx = hVar.hzx()) == null) {
            AppMethodBeat.o(60146);
            return null;
        } else if (hzx instanceof ab) {
            kotlin.l.b.a.b.f.a aVar = new kotlin.l.b.a.b.f.a(((ab) hzx).hBk(), hVar.hAH());
            AppMethodBeat.o(60146);
            return aVar;
        } else if (!(hzx instanceof i) || (c2 = c((kotlin.l.b.a.b.b.h) hzx)) == null) {
            AppMethodBeat.o(60146);
            return null;
        } else {
            kotlin.l.b.a.b.f.a o = c2.o(hVar.hAH());
            AppMethodBeat.o(60146);
            return o;
        }
    }

    public static final kotlin.l.b.a.b.b.e B(kotlin.l.b.a.b.b.e eVar) {
        AppMethodBeat.i(60147);
        p.h(eVar, "$this$getSuperClassNotAny");
        for (kotlin.l.b.a.b.m.ab abVar : eVar.hAG().hKE().hBV()) {
            if (!g.z(abVar)) {
                kotlin.l.b.a.b.b.h hzS = abVar.hKE().hzS();
                if (kotlin.l.b.a.b.j.c.B(hzS)) {
                    if (hzS == null) {
                        t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        AppMethodBeat.o(60147);
                        throw tVar;
                    }
                    kotlin.l.b.a.b.b.e eVar2 = (kotlin.l.b.a.b.b.e) hzS;
                    AppMethodBeat.o(60147);
                    return eVar2;
                }
            }
        }
        AppMethodBeat.o(60147);
        return null;
    }

    public static final g G(l lVar) {
        AppMethodBeat.i(60148);
        p.h(lVar, "$this$builtIns");
        g hBh = F(lVar).hBh();
        AppMethodBeat.o(60148);
        return hBh;
    }

    public static final boolean b(av avVar) {
        AppMethodBeat.i(60149);
        p.h(avVar, "$this$declaresOrInheritsDefaultValue");
        Boolean a2 = kotlin.l.b.a.b.o.b.a(j.listOf(avVar), b.TIQ, c.TIR);
        p.g(a2, "DFS.ifAny(\n        listO…eclaresDefaultValue\n    )");
        boolean booleanValue = a2.booleanValue();
        AppMethodBeat.o(60149);
        return booleanValue;
    }

    public static final kotlin.m.h<l> H(l lVar) {
        AppMethodBeat.i(60150);
        p.h(lVar, "$this$parents");
        p.h(lVar, "$this$parentsWithSelf");
        kotlin.m.h b2 = kotlin.m.i.b(lVar, f.TIU);
        p.h(b2, "$this$drop");
        if (b2 instanceof kotlin.m.c) {
            kotlin.m.h<l> hMd = ((kotlin.m.c) b2).hMd();
            AppMethodBeat.o(60150);
            return hMd;
        }
        kotlin.m.b bVar = new kotlin.m.b(b2, 1);
        AppMethodBeat.o(60150);
        return bVar;
    }

    public static final kotlin.l.b.a.b.b.b v(kotlin.l.b.a.b.b.b bVar) {
        AppMethodBeat.i(60151);
        p.h(bVar, "$this$propertyIfAccessor");
        if (bVar instanceof ag) {
            ah hBm = ((ag) bVar).hBm();
            p.g(hBm, "correspondingProperty");
            ah ahVar = hBm;
            AppMethodBeat.o(60151);
            return ahVar;
        }
        AppMethodBeat.o(60151);
        return bVar;
    }

    public static final kotlin.l.b.a.b.f.b I(l lVar) {
        AppMethodBeat.i(60152);
        p.h(lVar, "$this$fqNameOrNull");
        kotlin.l.b.a.b.f.c q = q(lVar);
        if (!q.hJi()) {
            q = null;
        }
        if (q != null) {
            kotlin.l.b.a.b.f.b hJj = q.hJj();
            AppMethodBeat.o(60152);
            return hJj;
        }
        AppMethodBeat.o(60152);
        return null;
    }

    public static /* synthetic */ kotlin.l.b.a.b.b.b b(kotlin.l.b.a.b.b.b bVar, kotlin.g.a.b bVar2) {
        AppMethodBeat.i(60153);
        p.h(bVar, "$this$firstOverridden");
        p.h(bVar2, "predicate");
        z.f fVar = new z.f();
        fVar.SYG = null;
        kotlin.l.b.a.b.b.b bVar3 = (kotlin.l.b.a.b.b.b) kotlin.l.b.a.b.o.b.a(j.listOf(bVar), new d(), new e(fVar, bVar2));
        AppMethodBeat.o(60153);
        return bVar3;
    }

    public static final class e extends b.a<kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.b> {
        final /* synthetic */ kotlin.g.a.b TIT;
        final /* synthetic */ z.f wJX;

        e(z.f fVar, kotlin.g.a.b bVar) {
            this.wJX = fVar;
            this.TIT = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.l.b.a.b.o.b.a, kotlin.l.b.a.b.o.b.c
        public final /* synthetic */ void fA(kotlin.l.b.a.b.b.b bVar) {
            AppMethodBeat.i(60139);
            T t = (T) bVar;
            p.h(t, "current");
            if (this.wJX.SYG == null && ((Boolean) this.TIT.invoke(t)).booleanValue()) {
                this.wJX.SYG = t;
            }
            AppMethodBeat.o(60139);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.l.b.a.b.o.b.a, kotlin.l.b.a.b.o.b.c
        public final /* synthetic */ boolean fm(kotlin.l.b.a.b.b.b bVar) {
            AppMethodBeat.i(60138);
            p.h(bVar, "current");
            if (this.wJX.SYG == null) {
                AppMethodBeat.o(60138);
                return true;
            }
            AppMethodBeat.o(60138);
            return false;
        }

        @Override // kotlin.l.b.a.b.o.b.c
        public final /* bridge */ /* synthetic */ Object hAq() {
            return this.wJX.SYG;
        }
    }

    public static final Collection<kotlin.l.b.a.b.b.e> C(kotlin.l.b.a.b.b.e eVar) {
        AppMethodBeat.i(60154);
        p.h(eVar, "sealedClass");
        if (eVar.hzC() != w.SEALED) {
            v vVar = v.SXr;
            AppMethodBeat.o(60154);
            return vVar;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        C2346a aVar = new C2346a(eVar, linkedHashSet);
        l hzx = eVar.hzx();
        p.g(hzx, "sealedClass.containingDeclaration");
        if (hzx instanceof ab) {
            aVar.a(((ab) hzx).hAp(), false);
        }
        h hAN = eVar.hAN();
        p.g(hAN, "sealedClass.unsubstitutedInnerClassesScope");
        aVar.a(hAN, true);
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        AppMethodBeat.o(60154);
        return linkedHashSet2;
    }

    /* renamed from: kotlin.l.b.a.b.j.d.a$a  reason: collision with other inner class name */
    static final class C2346a extends q implements m<h, Boolean, x> {
        final /* synthetic */ kotlin.l.b.a.b.b.e TIN;
        final /* synthetic */ LinkedHashSet TIO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2346a(kotlin.l.b.a.b.b.e eVar, LinkedHashSet linkedHashSet) {
            super(2);
            this.TIN = eVar;
            this.TIO = linkedHashSet;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(h hVar, Boolean bool) {
            AppMethodBeat.i(60130);
            a(hVar, bool.booleanValue());
            x xVar = x.SXb;
            AppMethodBeat.o(60130);
            return xVar;
        }

        public final void a(h hVar, boolean z) {
            AppMethodBeat.i(60131);
            p.h(hVar, "scope");
            for (l lVar : j.a.a(hVar, kotlin.l.b.a.b.j.f.d.TJJ, null, 2)) {
                if (lVar instanceof kotlin.l.b.a.b.b.e) {
                    if (kotlin.l.b.a.b.j.c.b((kotlin.l.b.a.b.b.e) lVar, this.TIN)) {
                        this.TIO.add(lVar);
                    }
                    if (z) {
                        h hAN = ((kotlin.l.b.a.b.b.e) lVar).hAN();
                        p.g(hAN, "descriptor.unsubstitutedInnerClassesScope");
                        a(hAN, z);
                    }
                }
            }
            AppMethodBeat.o(60131);
        }
    }

    public static final kotlin.l.b.a.b.b.e l(kotlin.l.b.a.b.b.a.c cVar) {
        AppMethodBeat.i(60155);
        p.h(cVar, "$this$annotationClass");
        kotlin.l.b.a.b.b.h hzS = cVar.hBy().hKE().hzS();
        if (!(hzS instanceof kotlin.l.b.a.b.b.e)) {
            hzS = null;
        }
        kotlin.l.b.a.b.b.e eVar = (kotlin.l.b.a.b.b.e) hzS;
        AppMethodBeat.o(60155);
        return eVar;
    }

    public static final kotlin.l.b.a.b.j.b.g<?> m(kotlin.l.b.a.b.b.a.c cVar) {
        AppMethodBeat.i(60156);
        p.h(cVar, "$this$firstArgument");
        kotlin.l.b.a.b.j.b.g<?> gVar = (kotlin.l.b.a.b.j.b.g) kotlin.a.j.f(cVar.hBO().values());
        AppMethodBeat.o(60156);
        return gVar;
    }

    public static final kotlin.l.b.a.b.m.a.i d(y yVar) {
        i.a aVar;
        AppMethodBeat.i(60157);
        p.h(yVar, "$this$getKotlinTypeRefiner");
        r rVar = (r) yVar.a(kotlin.l.b.a.b.m.a.j.hLL());
        if (rVar == null || (aVar = rVar.value) == null) {
            aVar = i.a.TPf;
        }
        AppMethodBeat.o(60157);
        return aVar;
    }

    public static final boolean e(y yVar) {
        T t;
        AppMethodBeat.i(60158);
        p.h(yVar, "$this$isTypeRefinementEnabled");
        r rVar = (r) yVar.a(kotlin.l.b.a.b.m.a.j.hLL());
        if (rVar != null) {
            t = rVar.value;
        } else {
            t = null;
        }
        if (t != null) {
            AppMethodBeat.o(60158);
            return true;
        }
        AppMethodBeat.o(60158);
        return false;
    }

    static final class b<N> implements b.AbstractC2365b<N> {
        public static final b TIQ = new b();

        static {
            AppMethodBeat.i(60133);
            AppMethodBeat.o(60133);
        }

        b() {
        }

        @Override // kotlin.l.b.a.b.o.b.AbstractC2365b
        public final /* synthetic */ Iterable fl(Object obj) {
            AppMethodBeat.i(60132);
            av avVar = (av) obj;
            p.g(avVar, "current");
            Collection<av> hAy = avVar.hAy();
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(hAy, 10));
            Iterator<T> it = hAy.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().hBC());
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(60132);
            return arrayList2;
        }
    }

    static final /* synthetic */ class c extends n implements kotlin.g.a.b<av, Boolean> {
        public static final c TIR = new c();

        static {
            AppMethodBeat.i(60136);
            AppMethodBeat.o(60136);
        }

        c() {
            super(1);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(60135);
            kotlin.l.b bp = kotlin.g.b.aa.bp(av.class);
            AppMethodBeat.o(60135);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "declaresDefaultValue";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(av avVar) {
            AppMethodBeat.i(60134);
            av avVar2 = avVar;
            p.h(avVar2, "p1");
            Boolean valueOf = Boolean.valueOf(avVar2.hBA());
            AppMethodBeat.o(60134);
            return valueOf;
        }
    }

    static final class f extends q implements kotlin.g.a.b<l, l> {
        public static final f TIU = new f();

        static {
            AppMethodBeat.i(60141);
            AppMethodBeat.o(60141);
        }

        f() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ l invoke(l lVar) {
            AppMethodBeat.i(60140);
            l lVar2 = lVar;
            p.h(lVar2, LocaleUtil.ITALIAN);
            l hzx = lVar2.hzx();
            AppMethodBeat.o(60140);
            return hzx;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d<N> implements b.AbstractC2365b<N> {
        final /* synthetic */ boolean TIS = false;

        d() {
        }

        @Override // kotlin.l.b.a.b.o.b.AbstractC2365b
        public final /* synthetic */ Iterable fl(Object obj) {
            Collection<? extends kotlin.l.b.a.b.b.b> hAy;
            AppMethodBeat.i(60137);
            kotlin.l.b.a.b.b.b bVar = (kotlin.l.b.a.b.b.b) obj;
            if (this.TIS) {
                bVar = bVar != null ? bVar.hAz() : null;
            }
            if (bVar == null || (hAy = bVar.hAy()) == null) {
                v vVar = v.SXr;
                AppMethodBeat.o(60137);
                return vVar;
            }
            Collection<? extends kotlin.l.b.a.b.b.b> collection = hAy;
            AppMethodBeat.o(60137);
            return collection;
        }
    }
}
