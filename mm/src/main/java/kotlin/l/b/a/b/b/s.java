package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.c.a.c;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.d;
import kotlin.m.i;

public final class s {
    public static final h a(y yVar, kotlin.l.b.a.b.f.a aVar) {
        AppMethodBeat.i(56856);
        p.h(yVar, "$this$findClassifierAcrossModuleDependencies");
        p.h(aVar, "classId");
        kotlin.l.b.a.b.f.b hIY = aVar.hIY();
        p.g(hIY, "classId.packageFqName");
        ad e2 = yVar.e(hIY);
        List<f> hJl = aVar.hIZ().TCR.hJl();
        if (hJl == null) {
            kotlin.l.b.a.b.f.b.atM(11);
        }
        p.g(hJl, "classId.relativeClassName.pathSegments()");
        h hAp = e2.hAp();
        Object ks = j.ks(hJl);
        p.g(ks, "segments.first()");
        e c2 = hAp.c((f) ks, c.FROM_DESERIALIZATION);
        if (c2 == null) {
            AppMethodBeat.o(56856);
            return null;
        }
        for (f fVar : hJl.subList(1, hJl.size())) {
            if (!(c2 instanceof e)) {
                AppMethodBeat.o(56856);
                return null;
            }
            h hAN = ((e) c2).hAN();
            p.g(fVar, "name");
            h c3 = hAN.c(fVar, c.FROM_DESERIALIZATION);
            if (!(c3 instanceof e)) {
                c3 = null;
            }
            e eVar = (e) c3;
            if (eVar != null) {
                c2 = eVar;
            } else {
                AppMethodBeat.o(56856);
                return null;
            }
        }
        AppMethodBeat.o(56856);
        return c2;
    }

    public static final e b(y yVar, kotlin.l.b.a.b.f.a aVar) {
        AppMethodBeat.i(56857);
        p.h(yVar, "$this$findClassAcrossModuleDependencies");
        p.h(aVar, "classId");
        h a2 = a(yVar, aVar);
        if (!(a2 instanceof e)) {
            a2 = null;
        }
        e eVar = (e) a2;
        AppMethodBeat.o(56857);
        return eVar;
    }

    public static final e a(y yVar, kotlin.l.b.a.b.f.a aVar, aa aaVar) {
        AppMethodBeat.i(56858);
        p.h(yVar, "$this$findNonGenericClassAcrossDependencies");
        p.h(aVar, "classId");
        p.h(aaVar, "notFoundClasses");
        e b2 = b(yVar, aVar);
        if (b2 != null) {
            AppMethodBeat.o(56858);
            return b2;
        }
        e a2 = aaVar.a(aVar, i.c(i.d(i.b(aVar, a.Thm), b.Thn)));
        AppMethodBeat.o(56858);
        return a2;
    }

    static final /* synthetic */ class a extends n implements kotlin.g.a.b<kotlin.l.b.a.b.f.a, kotlin.l.b.a.b.f.a> {
        public static final a Thm = new a();

        static {
            AppMethodBeat.i(56853);
            AppMethodBeat.o(56853);
        }

        a() {
            super(1);
        }

        @Override // kotlin.g.b.e
        public final d Rs() {
            AppMethodBeat.i(56852);
            kotlin.l.b bp = aa.bp(kotlin.l.b.a.b.f.a.class);
            AppMethodBeat.o(56852);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.l.b.a.b.f.a invoke(kotlin.l.b.a.b.f.a aVar) {
            AppMethodBeat.i(56851);
            kotlin.l.b.a.b.f.a aVar2 = aVar;
            p.h(aVar2, "p1");
            kotlin.l.b.a.b.f.a hJb = aVar2.hJb();
            AppMethodBeat.o(56851);
            return hJb;
        }
    }

    static final class b extends q implements kotlin.g.a.b<kotlin.l.b.a.b.f.a, Integer> {
        public static final b Thn = new b();

        static {
            AppMethodBeat.i(56855);
            AppMethodBeat.o(56855);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(kotlin.l.b.a.b.f.a aVar) {
            AppMethodBeat.i(56854);
            p.h(aVar, LocaleUtil.ITALIAN);
            AppMethodBeat.o(56854);
            return 0;
        }
    }
}
