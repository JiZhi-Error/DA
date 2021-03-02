package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.aa;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ai;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.v;
import kotlin.n.n;
import kotlin.t;

public final class g extends v implements ai {

    static final class a extends q implements m<String, String, Boolean> {
        public static final a Ttz = new a();

        static {
            AppMethodBeat.i(57991);
            AppMethodBeat.o(57991);
        }

        a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ Boolean invoke(String str, String str2) {
            AppMethodBeat.i(57989);
            Boolean valueOf = Boolean.valueOf(or(str, str2));
            AppMethodBeat.o(57989);
            return valueOf;
        }

        public static boolean or(String str, String str2) {
            AppMethodBeat.i(57990);
            p.h(str, "first");
            p.h(str2, "second");
            if (p.j(str, n.b(str2, "out ")) || p.j(str2, "*")) {
                AppMethodBeat.o(57990);
                return true;
            }
            AppMethodBeat.o(57990);
            return false;
        }
    }

    static final class b extends q implements kotlin.g.a.b<ab, List<? extends String>> {
        final /* synthetic */ kotlin.l.b.a.b.i.c TtA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(kotlin.l.b.a.b.i.c cVar) {
            super(1);
            this.TtA = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ List<? extends String> invoke(ab abVar) {
            AppMethodBeat.i(57992);
            List<String> P = P(abVar);
            AppMethodBeat.o(57992);
            return P;
        }

        public final List<String> P(ab abVar) {
            AppMethodBeat.i(57993);
            p.h(abVar, "type");
            List<av> hKB = abVar.hKB();
            ArrayList arrayList = new ArrayList(j.a(hKB, 10));
            Iterator<T> it = hKB.iterator();
            while (it.hasNext()) {
                arrayList.add(this.TtA.a(it.next()));
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(57993);
            return arrayList2;
        }
    }

    static final class c extends q implements m<String, String, String> {
        public static final c TtB = new c();

        static {
            AppMethodBeat.i(57996);
            AppMethodBeat.o(57996);
        }

        c() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ String invoke(String str, String str2) {
            AppMethodBeat.i(57994);
            String os = os(str, str2);
            AppMethodBeat.o(57994);
            return os;
        }

        public static String os(String str, String str2) {
            AppMethodBeat.i(57995);
            p.h(str, "$this$replaceArgs");
            p.h(str2, "newArgs");
            if (!n.c((CharSequence) str, '<')) {
                AppMethodBeat.o(57995);
                return str;
            }
            String str3 = n.a(str, '<') + '<' + str2 + '>' + n.b(str, '>');
            AppMethodBeat.o(57995);
            return str3;
        }
    }

    static final class d extends q implements kotlin.g.a.b<String, String> {
        public static final d TtC = new d();

        static {
            AppMethodBeat.i(57998);
            AppMethodBeat.o(57998);
        }

        d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(String str) {
            AppMethodBeat.i(57997);
            String str2 = str;
            p.h(str2, LocaleUtil.ITALIAN);
            String concat = "(raw) ".concat(String.valueOf(str2));
            AppMethodBeat.o(57997);
            return concat;
        }
    }

    private g(aj ajVar, aj ajVar2, boolean z) {
        super(ajVar, ajVar2);
        AppMethodBeat.i(58006);
        if (!z) {
            boolean c2 = kotlin.l.b.a.b.m.a.g.TPc.c(ajVar, ajVar2);
            if (aa.SXc && !c2) {
                AssertionError assertionError = new AssertionError("Lower bound " + ajVar + " of a flexible type must be a subtype of the upper bound " + ajVar2);
                AppMethodBeat.o(58006);
                throw assertionError;
            }
        }
        AppMethodBeat.o(58006);
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg b(kotlin.l.b.a.b.b.a.g gVar) {
        AppMethodBeat.i(58000);
        p.h(gVar, "newAnnotations");
        g gVar2 = new g(this.TNV.d(gVar), this.TNW.d(gVar));
        AppMethodBeat.o(58000);
        return gVar2;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final /* synthetic */ ab d(i iVar) {
        AppMethodBeat.i(58004);
        v c2 = c(iVar);
        AppMethodBeat.o(58004);
        return c2;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg e(i iVar) {
        AppMethodBeat.i(58005);
        v c2 = c(iVar);
        AppMethodBeat.o(58005);
        return c2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public g(aj ajVar, aj ajVar2) {
        this(ajVar, ajVar2, false);
        p.h(ajVar, "lowerBound");
        p.h(ajVar2, "upperBound");
        AppMethodBeat.i(58007);
        AppMethodBeat.o(58007);
    }

    @Override // kotlin.l.b.a.b.m.v, kotlin.l.b.a.b.m.ab
    public final h hAp() {
        AppMethodBeat.i(57999);
        kotlin.l.b.a.b.b.h hzS = hKE().hzS();
        if (!(hzS instanceof e)) {
            hzS = null;
        }
        e eVar = (e) hzS;
        if (eVar == null) {
            IllegalStateException illegalStateException = new IllegalStateException(("Incorrect classifier: " + hKE().hzS()).toString());
            AppMethodBeat.o(57999);
            throw illegalStateException;
        }
        h a2 = eVar.a(e.Ttv);
        p.g(a2, "classDescriptor.getMemberScope(RawSubstitution)");
        AppMethodBeat.o(57999);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00e3  */
    @Override // kotlin.l.b.a.b.m.v
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(kotlin.l.b.a.b.i.c r14, kotlin.l.b.a.b.i.i r15) {
        /*
        // Method dump skipped, instructions count: 240
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.c.b.g.a(kotlin.l.b.a.b.i.c, kotlin.l.b.a.b.i.i):java.lang.String");
    }

    private v c(i iVar) {
        AppMethodBeat.i(58003);
        p.h(iVar, "kotlinTypeRefiner");
        ab aK = iVar.aK(this.TNV);
        if (aK == null) {
            t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            AppMethodBeat.o(58003);
            throw tVar;
        }
        aj ajVar = (aj) aK;
        ab aK2 = iVar.aK(this.TNW);
        if (aK2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            AppMethodBeat.o(58003);
            throw tVar2;
        }
        g gVar = new g(ajVar, (aj) aK2, true);
        AppMethodBeat.o(58003);
        return gVar;
    }

    @Override // kotlin.l.b.a.b.m.v
    public final aj hDW() {
        return this.TNV;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg EF(boolean z) {
        AppMethodBeat.i(58001);
        g gVar = new g(this.TNV.EG(z), this.TNW.EG(z));
        AppMethodBeat.o(58001);
        return gVar;
    }
}
