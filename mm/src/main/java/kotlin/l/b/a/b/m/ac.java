package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.c.t;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.j.b.n;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.au;

public final class ac {
    private static final kotlin.g.a.b<i, aj> TOh = a.TOj;
    public static final ac TOi = new ac();

    static final class b {
    }

    static final class a extends q implements kotlin.g.a.b {
        public static final a TOj = new a();

        static {
            AppMethodBeat.i(60762);
            AppMethodBeat.o(60762);
        }

        a() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Object invoke(Object obj) {
            AppMethodBeat.i(60761);
            p.h((i) obj, "<anonymous parameter 0>");
            AppMethodBeat.o(60761);
            return null;
        }
    }

    public static final class c extends q implements kotlin.g.a.b<i, aj> {
        final /* synthetic */ at TOk;
        final /* synthetic */ List TOl;
        final /* synthetic */ g TOm;
        final /* synthetic */ boolean TOn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(at atVar, List list, g gVar, boolean z) {
            super(1);
            this.TOk = atVar;
            this.TOl = list;
            this.TOm = gVar;
            this.TOn = z;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ aj invoke(i iVar) {
            AppMethodBeat.i(60763);
            i iVar2 = iVar;
            p.h(iVar2, "refiner");
            ac acVar = ac.TOi;
            ac.a(this.TOk, iVar2);
            AppMethodBeat.o(60763);
            return null;
        }
    }

    public static final class d extends q implements kotlin.g.a.b<i, aj> {
        final /* synthetic */ at TOk;
        final /* synthetic */ List TOl;
        final /* synthetic */ g TOm;
        final /* synthetic */ boolean TOn;
        final /* synthetic */ h TOo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(at atVar, List list, g gVar, boolean z, h hVar) {
            super(1);
            this.TOk = atVar;
            this.TOl = list;
            this.TOm = gVar;
            this.TOn = z;
            this.TOo = hVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ aj invoke(i iVar) {
            AppMethodBeat.i(60764);
            i iVar2 = iVar;
            p.h(iVar2, "kotlinTypeRefiner");
            ac acVar = ac.TOi;
            ac.a(this.TOk, iVar2);
            AppMethodBeat.o(60764);
            return null;
        }
    }

    static {
        AppMethodBeat.i(60771);
        AppMethodBeat.o(60771);
    }

    private ac() {
    }

    public static /* synthetic */ aj c(g gVar, at atVar, List list, boolean z) {
        h dU;
        AppMethodBeat.i(60765);
        i iVar = null;
        p.h(gVar, "annotations");
        p.h(atVar, "constructor");
        p.h(list, "arguments");
        if (!gVar.isEmpty() || !list.isEmpty() || z || atVar.hzS() == null) {
            kotlin.l.b.a.b.b.h hzS = atVar.hzS();
            if (hzS instanceof as) {
                dU = hzS.hAG().hAp();
            } else if (hzS instanceof e) {
                if (0 == 0) {
                    iVar = kotlin.l.b.a.b.j.d.a.d(kotlin.l.b.a.b.j.d.a.F(hzS));
                }
                if (list.isEmpty()) {
                    e eVar = (e) hzS;
                    p.h(eVar, "$this$getRefinedUnsubstitutedMemberScopeIfPossible");
                    p.h(iVar, "kotlinTypeRefiner");
                    t.a aVar = t.TlH;
                    dU = t.a.a(eVar, iVar);
                } else {
                    e eVar2 = (e) hzS;
                    au.a aVar2 = au.TOz;
                    ay a2 = au.a.a(atVar, list);
                    p.h(eVar2, "$this$getRefinedMemberScopeIfPossible");
                    p.h(a2, "typeSubstitution");
                    p.h(iVar, "kotlinTypeRefiner");
                    t.a aVar3 = t.TlH;
                    dU = t.a.a(eVar2, a2, iVar);
                }
            } else if (hzS instanceof ar) {
                dU = u.dU("Scope for abbreviation: " + ((ar) hzS).hAH(), true);
                p.g(dU, "ErrorUtils.createErrorSc…{descriptor.name}\", true)");
            } else {
                IllegalStateException illegalStateException = new IllegalStateException("Unsupported classifier: " + hzS + " for constructor: " + atVar);
                AppMethodBeat.o(60765);
                throw illegalStateException;
            }
            aj a3 = a(gVar, atVar, list, z, dU, new c(atVar, list, gVar, z));
            AppMethodBeat.o(60765);
            return a3;
        }
        kotlin.l.b.a.b.b.h hzS2 = atVar.hzS();
        if (hzS2 == null) {
            p.hyc();
        }
        p.g(hzS2, "constructor.declarationDescriptor!!");
        aj hAG = hzS2.hAG();
        p.g(hAG, "constructor.declarationDescriptor!!.defaultType");
        AppMethodBeat.o(60765);
        return hAG;
    }

    public static final aj a(g gVar, at atVar, List<? extends av> list, boolean z, h hVar) {
        AppMethodBeat.i(186271);
        p.h(gVar, "annotations");
        p.h(atVar, "constructor");
        p.h(list, "arguments");
        p.h(hVar, "memberScope");
        ak akVar = new ak(atVar, list, z, hVar, new d(atVar, list, gVar, z, hVar));
        if (gVar.isEmpty()) {
            ak akVar2 = akVar;
            AppMethodBeat.o(186271);
            return akVar2;
        }
        i iVar = new i(akVar, gVar);
        AppMethodBeat.o(186271);
        return iVar;
    }

    public static final aj a(g gVar, at atVar, List<? extends av> list, boolean z, h hVar, kotlin.g.a.b<? super i, ? extends aj> bVar) {
        AppMethodBeat.i(60767);
        p.h(gVar, "annotations");
        p.h(atVar, "constructor");
        p.h(list, "arguments");
        p.h(hVar, "memberScope");
        p.h(bVar, "refinedTypeFactory");
        ak akVar = new ak(atVar, list, z, hVar, bVar);
        if (gVar.isEmpty()) {
            ak akVar2 = akVar;
            AppMethodBeat.o(60767);
            return akVar2;
        }
        i iVar = new i(akVar, gVar);
        AppMethodBeat.o(60767);
        return iVar;
    }

    public static final aj a(g gVar, e eVar, List<? extends av> list) {
        AppMethodBeat.i(60768);
        p.h(gVar, "annotations");
        p.h(eVar, "descriptor");
        p.h(list, "arguments");
        at hzz = eVar.hzz();
        p.g(hzz, "descriptor.typeConstructor");
        aj c2 = c(gVar, hzz, list, false);
        AppMethodBeat.o(60768);
        return c2;
    }

    public static final bg a(aj ajVar, aj ajVar2) {
        AppMethodBeat.i(60769);
        p.h(ajVar, "lowerBound");
        p.h(ajVar2, "upperBound");
        if (p.j(ajVar, ajVar2)) {
            aj ajVar3 = ajVar;
            AppMethodBeat.o(60769);
            return ajVar3;
        }
        w wVar = new w(ajVar, ajVar2);
        AppMethodBeat.o(60769);
        return wVar;
    }

    public static final aj a(g gVar, n nVar) {
        AppMethodBeat.i(60770);
        p.h(gVar, "annotations");
        p.h(nVar, "constructor");
        h dU = u.dU("Scope for integer literal type", true);
        p.g(dU, "ErrorUtils.createErrorSc…eger literal type\", true)");
        aj a2 = a(gVar, nVar, v.SXr, false, dU);
        AppMethodBeat.o(60770);
        return a2;
    }

    public static final /* synthetic */ b a(at atVar, i iVar) {
        AppMethodBeat.i(60772);
        kotlin.l.b.a.b.b.h hzS = atVar.hzS();
        if (hzS != null) {
            iVar.M(hzS);
        }
        AppMethodBeat.o(60772);
        return null;
    }
}
