package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.d.a.b.f;
import kotlin.l.b.a.b.d.b.k;
import kotlin.l.b.a.b.j.d;
import kotlin.l.b.a.b.m.ab;
import kotlin.o;

public final class m implements d {
    public static final a Tpd = new a((byte) 0);

    static {
        AppMethodBeat.i(57591);
        AppMethodBeat.o(57591);
    }

    @Override // kotlin.l.b.a.b.j.d
    public final d.a hDu() {
        return d.a.CONFLICTS_ONLY;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean a(kotlin.l.b.a.b.b.a aVar, kotlin.l.b.a.b.b.a aVar2) {
            AppMethodBeat.i(57587);
            p.h(aVar, "superDescriptor");
            p.h(aVar2, "subDescriptor");
            if (!(aVar2 instanceof f) || !(aVar instanceof t)) {
                AppMethodBeat.o(57587);
                return false;
            }
            boolean z = ((f) aVar2).hAw().size() == ((t) aVar).hAw().size();
            if (!aa.SXc || z) {
                am hCu = ((f) aVar2).hCu();
                p.g(hCu, "subDescriptor.original");
                List<av> hAw = hCu.hAw();
                p.g(hAw, "subDescriptor.original.valueParameters");
                t hAT = ((t) aVar).hAT();
                p.g(hAT, "superDescriptor.original");
                List<av> hAw2 = hAT.hAw();
                p.g(hAw2, "superDescriptor.original.valueParameters");
                for (o oVar : j.c((Iterable) hAw, (Iterable) hAw2)) {
                    A a2 = oVar.first;
                    B b2 = oVar.second;
                    p.g(a2, "subParameter");
                    boolean z2 = a((t) aVar2, (av) a2) instanceof k.c;
                    p.g(b2, "superParameter");
                    if (z2 != (a((t) aVar, (av) b2) instanceof k.c)) {
                        AppMethodBeat.o(57587);
                        return true;
                    }
                }
                AppMethodBeat.o(57587);
                return false;
            }
            AssertionError assertionError = new AssertionError("External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size");
            AppMethodBeat.o(57587);
            throw assertionError;
        }

        private static k a(t tVar, av avVar) {
            AppMethodBeat.i(57588);
            if (kotlin.l.b.a.b.d.b.t.b(tVar) || f(tVar)) {
                ab hBy = avVar.hBy();
                p.g(hBy, "valueParameterDescriptor.type");
                k U = kotlin.l.b.a.b.d.b.t.U(kotlin.l.b.a.b.m.d.a.aC(hBy));
                AppMethodBeat.o(57588);
                return U;
            }
            ab hBy2 = avVar.hBy();
            p.g(hBy2, "valueParameterDescriptor.type");
            k U2 = kotlin.l.b.a.b.d.b.t.U(hBy2);
            AppMethodBeat.o(57588);
            return U2;
        }

        private static boolean f(t tVar) {
            AppMethodBeat.i(57589);
            if (tVar.hAw().size() != 1) {
                AppMethodBeat.o(57589);
                return false;
            }
            l hzx = tVar.hzx();
            if (!(hzx instanceof e)) {
                hzx = null;
            }
            e eVar = (e) hzx;
            if (eVar == null) {
                AppMethodBeat.o(57589);
                return false;
            }
            List<av> hAw = tVar.hAw();
            p.g(hAw, "f.valueParameters");
            Object kw = j.kw(hAw);
            p.g(kw, "f.valueParameters.single()");
            h hzS = ((av) kw).hBy().hKE().hzS();
            if (!(hzS instanceof e)) {
                hzS = null;
            }
            e eVar2 = (e) hzS;
            if (eVar2 == null) {
                AppMethodBeat.o(57589);
                return false;
            } else if (!g.d(eVar) || !p.j(kotlin.l.b.a.b.j.d.a.o(eVar), kotlin.l.b.a.b.j.d.a.o(eVar2))) {
                AppMethodBeat.o(57589);
                return false;
            } else {
                AppMethodBeat.o(57589);
                return true;
            }
        }
    }

    @Override // kotlin.l.b.a.b.j.d
    public final d.b a(kotlin.l.b.a.b.b.a aVar, kotlin.l.b.a.b.b.a aVar2, e eVar) {
        boolean z;
        kotlin.l.b.a.b.b.a aVar3;
        boolean z2;
        AppMethodBeat.i(57590);
        p.h(aVar, "superDescriptor");
        p.h(aVar2, "subDescriptor");
        if (!(aVar instanceof b) || !(aVar2 instanceof t) || g.c(aVar2)) {
            z = false;
        } else {
            d dVar = d.ToD;
            kotlin.l.b.a.b.f.f hAH = ((t) aVar2).hAH();
            p.g(hAH, "subDescriptor.name");
            if (!d.g(hAH)) {
                c cVar = c.Tou;
                kotlin.l.b.a.b.f.f hAH2 = ((t) aVar2).hAH();
                p.g(hAH2, "subDescriptor.name");
                if (!c.e(hAH2)) {
                    z = false;
                }
            }
            b o = t.o((b) aVar);
            boolean hAV = ((t) aVar2).hAV();
            if (!(aVar instanceof t)) {
                aVar3 = null;
            } else {
                aVar3 = aVar;
            }
            t tVar = (t) aVar3;
            if (tVar == null || hAV != tVar.hAV()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && (o == null || !((t) aVar2).hAV())) {
                z = true;
            } else if (!(eVar instanceof kotlin.l.b.a.b.d.a.b.d) || ((t) aVar2).hAU() != null) {
                z = false;
            } else if (o == null || t.a(eVar, o)) {
                z = false;
            } else {
                if ((o instanceof t) && (aVar instanceof t) && d.e((t) o) != null) {
                    String a2 = kotlin.l.b.a.b.d.b.t.a((t) aVar2, false, false, 2);
                    t hAT = ((t) aVar).hAT();
                    p.g(hAT, "superDescriptor.original");
                    if (p.j(a2, kotlin.l.b.a.b.d.b.t.a(hAT, false, false, 2))) {
                        z = false;
                    }
                }
                z = true;
            }
        }
        if (z) {
            d.b bVar = d.b.INCOMPATIBLE;
            AppMethodBeat.o(57590);
            return bVar;
        } else if (a.a(aVar, aVar2)) {
            d.b bVar2 = d.b.INCOMPATIBLE;
            AppMethodBeat.o(57590);
            return bVar2;
        } else {
            d.b bVar3 = d.b.UNKNOWN;
            AppMethodBeat.o(57590);
            return bVar3;
        }
    }
}
