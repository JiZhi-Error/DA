package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.d.a.b.d;
import kotlin.l.b.a.b.d.b.v;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.a.w;
import kotlin.l.b.a.b.m.aj;

public final class t {
    static final kotlin.l.b.a.b.f.b a(kotlin.l.b.a.b.f.b bVar, String str) {
        AppMethodBeat.i(57632);
        kotlin.l.b.a.b.f.b p = bVar.p(f.btY(str));
        p.g(p, "child(Name.identifier(name))");
        AppMethodBeat.o(57632);
        return p;
    }

    static final kotlin.l.b.a.b.f.b b(kotlin.l.b.a.b.f.c cVar, String str) {
        AppMethodBeat.i(57633);
        kotlin.l.b.a.b.f.b hJj = cVar.s(f.btY(str)).hJj();
        p.g(hJj, "child(Name.identifier(name)).toSafe()");
        AppMethodBeat.o(57633);
        return hJj;
    }

    static final r H(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(57634);
        f btY = f.btY(str2);
        p.g(btY, "Name.identifier(name)");
        v vVar = v.TvS;
        r rVar = new r(btY, v.ov(str, str2 + '(' + str3 + ')' + str4));
        AppMethodBeat.o(57634);
        return rVar;
    }

    public static final <T extends kotlin.l.b.a.b.b.b> T m(T t) {
        AppMethodBeat.i(57635);
        p.h(t, "$this$getOverriddenBuiltinWithDifferentJvmName");
        c cVar = c.Tou;
        if (!c.hDr().contains(t.hAH())) {
            e eVar = e.ToV;
            if (!e.hDt().contains(kotlin.l.b.a.b.j.d.a.v(t).hAH())) {
                AppMethodBeat.o(57635);
                return null;
            }
        }
        if ((t instanceof ah) || (t instanceof ag)) {
            T t2 = (T) kotlin.l.b.a.b.j.d.a.b(t, a.TpJ);
            AppMethodBeat.o(57635);
            return t2;
        } else if (t instanceof am) {
            T t3 = (T) kotlin.l.b.a.b.j.d.a.b(t, b.TpK);
            AppMethodBeat.o(57635);
            return t3;
        } else {
            AppMethodBeat.o(57635);
            return null;
        }
    }

    public static final boolean n(kotlin.l.b.a.b.b.b bVar) {
        AppMethodBeat.i(57636);
        p.h(bVar, "$this$doesOverrideBuiltinWithDifferentJvmName");
        if (m(bVar) != null) {
            AppMethodBeat.o(57636);
            return true;
        }
        AppMethodBeat.o(57636);
        return false;
    }

    public static final <T extends kotlin.l.b.a.b.b.b> T o(T t) {
        AppMethodBeat.i(57637);
        p.h(t, "$this$getOverriddenSpecialBuiltin");
        T t2 = (T) m(t);
        if (t2 != null) {
            AppMethodBeat.o(57637);
            return t2;
        }
        d dVar = d.ToD;
        f hAH = t.hAH();
        p.g(hAH, "name");
        if (!d.g(hAH)) {
            AppMethodBeat.o(57637);
            return null;
        }
        T t3 = (T) kotlin.l.b.a.b.j.d.a.b(t, c.TpL);
        AppMethodBeat.o(57637);
        return t3;
    }

    public static final String p(kotlin.l.b.a.b.b.b bVar) {
        kotlin.l.b.a.b.b.b v;
        AppMethodBeat.i(57638);
        p.h(bVar, "callableMemberDescriptor");
        kotlin.l.b.a.b.b.b q = q(bVar);
        if (q == null || (v = kotlin.l.b.a.b.j.d.a.v(q)) == null) {
            AppMethodBeat.o(57638);
            return null;
        } else if (v instanceof ah) {
            e eVar = e.ToV;
            String l = e.l(v);
            AppMethodBeat.o(57638);
            return l;
        } else {
            if (v instanceof am) {
                c cVar = c.Tou;
                f a2 = c.a((am) v);
                if (a2 != null) {
                    String sG = a2.sG();
                    AppMethodBeat.o(57638);
                    return sG;
                }
            }
            AppMethodBeat.o(57638);
            return null;
        }
    }

    private static final kotlin.l.b.a.b.b.b q(kotlin.l.b.a.b.b.b bVar) {
        AppMethodBeat.i(57639);
        if (g.c(bVar)) {
            kotlin.l.b.a.b.b.b m = m(bVar);
            AppMethodBeat.o(57639);
            return m;
        }
        AppMethodBeat.o(57639);
        return null;
    }

    public static final boolean a(e eVar, kotlin.l.b.a.b.b.a aVar) {
        AppMethodBeat.i(57640);
        p.h(eVar, "$this$hasRealKotlinSuperClassWithOverrideOf");
        p.h(aVar, "specialCallableDescriptor");
        l hzx = aVar.hzx();
        if (hzx == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            AppMethodBeat.o(57640);
            throw tVar;
        }
        aj hAG = ((e) hzx).hAG();
        p.g(hAG, "(specialCallableDescript…ssDescriptor).defaultType");
        for (e y = kotlin.l.b.a.b.j.c.y(eVar); y != null; y = kotlin.l.b.a.b.j.c.y(y)) {
            if (!(y instanceof d)) {
                if (w.f(y.hAG(), hAG) != null) {
                    if (!g.c((l) y)) {
                        AppMethodBeat.o(57640);
                        return true;
                    }
                    AppMethodBeat.o(57640);
                    return false;
                }
            }
        }
        AppMethodBeat.o(57640);
        return false;
    }

    public static final boolean r(kotlin.l.b.a.b.b.b bVar) {
        AppMethodBeat.i(57641);
        p.h(bVar, "$this$isFromJavaOrBuiltins");
        p.h(bVar, "$this$isFromJava");
        if ((kotlin.l.b.a.b.j.d.a.v(bVar).hzx() instanceof d) || g.c(bVar)) {
            AppMethodBeat.o(57641);
            return true;
        }
        AppMethodBeat.o(57641);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static final class a extends q implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean> {
        public static final a TpJ = new a();

        static {
            AppMethodBeat.i(57627);
            AppMethodBeat.o(57627);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(kotlin.l.b.a.b.b.b bVar) {
            AppMethodBeat.i(57626);
            kotlin.l.b.a.b.b.b bVar2 = bVar;
            p.h(bVar2, LocaleUtil.ITALIAN);
            e eVar = e.ToV;
            Boolean valueOf = Boolean.valueOf(e.k(kotlin.l.b.a.b.j.d.a.v(bVar2)));
            AppMethodBeat.o(57626);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b extends q implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean> {
        public static final b TpK = new b();

        static {
            AppMethodBeat.i(57629);
            AppMethodBeat.o(57629);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(kotlin.l.b.a.b.b.b bVar) {
            AppMethodBeat.i(57628);
            kotlin.l.b.a.b.b.b bVar2 = bVar;
            p.h(bVar2, LocaleUtil.ITALIAN);
            c cVar = c.Tou;
            Boolean valueOf = Boolean.valueOf(c.b((am) bVar2));
            AppMethodBeat.o(57628);
            return valueOf;
        }
    }

    static final class c extends q implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean> {
        public static final c TpL = new c();

        static {
            AppMethodBeat.i(57631);
            AppMethodBeat.o(57631);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(kotlin.l.b.a.b.b.b bVar) {
            AppMethodBeat.i(57630);
            kotlin.l.b.a.b.b.b bVar2 = bVar;
            p.h(bVar2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(g.c(bVar2) && d.i(bVar2) != null);
            AppMethodBeat.o(57630);
            return valueOf;
        }
    }
}
