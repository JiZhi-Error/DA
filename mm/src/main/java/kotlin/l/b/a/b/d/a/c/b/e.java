package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.d.a.a.l;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.u;
import kotlin.l.b.a.b.m.y;
import kotlin.m;
import kotlin.o;
import kotlin.s;

public final class e extends ay {
    private static final a Ttt = d.a(l.Tqv, false, null, 3).a(b.FLEXIBLE_LOWER_BOUND);
    private static final a Ttu = d.a(l.Tqv, false, null, 3).a(b.FLEXIBLE_UPPER_BOUND);
    public static final e Ttv = new e();

    /* access modifiers changed from: package-private */
    public static final class a extends q implements b<i, aj> {
        final /* synthetic */ kotlin.l.b.a.b.b.e Ttw;
        final /* synthetic */ aj Ttx;
        final /* synthetic */ a Tty;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(kotlin.l.b.a.b.b.e eVar, aj ajVar, a aVar) {
            super(1);
            this.Ttw = eVar;
            this.Ttx = ajVar;
            this.Tty = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ aj invoke(i iVar) {
            kotlin.l.b.a.b.f.a c2;
            AppMethodBeat.i(57983);
            i iVar2 = iVar;
            p.h(iVar2, "kotlinTypeRefiner");
            kotlin.l.b.a.b.b.e eVar = this.Ttw;
            if (!(eVar instanceof kotlin.l.b.a.b.b.e)) {
                eVar = null;
            }
            if (eVar == null || (c2 = kotlin.l.b.a.b.j.d.a.c(eVar)) == null) {
                AppMethodBeat.o(57983);
            } else {
                iVar2.h(c2);
                AppMethodBeat.o(57983);
            }
            return null;
        }
    }

    static {
        AppMethodBeat.i(57988);
        AppMethodBeat.o(57988);
    }

    private e() {
    }

    @Override // kotlin.l.b.a.b.m.ay
    public final /* synthetic */ av N(ab abVar) {
        AppMethodBeat.i(57984);
        p.h(abVar, "key");
        ax axVar = new ax(O(abVar));
        AppMethodBeat.o(57984);
        return axVar;
    }

    private final ab O(ab abVar) {
        h hzS;
        g gVar;
        AppMethodBeat.i(57985);
        while (true) {
            hzS = abVar.hKE().hzS();
            if (!(hzS instanceof as)) {
                break;
            }
            abVar = d.b((as) hzS);
        }
        if (hzS instanceof kotlin.l.b.a.b.b.e) {
            h hzS2 = y.ao(abVar).hKE().hzS();
            if (!(hzS2 instanceof kotlin.l.b.a.b.b.e)) {
                IllegalStateException illegalStateException = new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + hzS2 + "\" while for lower it's \"" + hzS + '\"').toString());
                AppMethodBeat.o(57985);
                throw illegalStateException;
            }
            o<aj, Boolean> a2 = a(y.an(abVar), (kotlin.l.b.a.b.b.e) hzS, Ttt);
            A a3 = a2.first;
            boolean booleanValue = a2.second.booleanValue();
            o<aj, Boolean> a4 = a(y.ao(abVar), (kotlin.l.b.a.b.b.e) hzS2, Ttu);
            A a5 = a4.first;
            boolean booleanValue2 = a4.second.booleanValue();
            if (booleanValue || booleanValue2) {
                gVar = new g(a3, a5);
            } else {
                gVar = ac.a((aj) a3, (aj) a5);
            }
            ab abVar2 = gVar;
            AppMethodBeat.o(57985);
            return abVar2;
        }
        IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected declaration kind: ".concat(String.valueOf(hzS)).toString());
        AppMethodBeat.o(57985);
        throw illegalStateException2;
    }

    private final o<aj, Boolean> a(aj ajVar, kotlin.l.b.a.b.b.e eVar, a aVar) {
        AppMethodBeat.i(57986);
        if (ajVar.hKE().getParameters().isEmpty()) {
            o<aj, Boolean> U = s.U(ajVar, Boolean.FALSE);
            AppMethodBeat.o(57986);
            return U;
        } else if (g.m(ajVar)) {
            av avVar = ajVar.hKB().get(0);
            bh hLI = avVar.hLI();
            ab hBy = avVar.hBy();
            p.g(hBy, "componentTypeProjection.type");
            o<aj, Boolean> U2 = s.U(ac.c(ajVar.hzL(), ajVar.hKE(), j.listOf(new ax(hLI, O(hBy))), ajVar.hEa()), Boolean.FALSE);
            AppMethodBeat.o(57986);
            return U2;
        } else if (ad.ap(ajVar)) {
            o<aj, Boolean> U3 = s.U(u.bun("Raw error type: " + ajVar.hKE()), Boolean.FALSE);
            AppMethodBeat.o(57986);
            return U3;
        } else {
            kotlin.l.b.a.b.j.f.h a2 = eVar.a(Ttv);
            p.g(a2, "declaration.getMemberScope(RawSubstitution)");
            kotlin.l.b.a.b.b.a.g hzL = ajVar.hzL();
            at hzz = eVar.hzz();
            p.g(hzz, "declaration.typeConstructor");
            at hzz2 = eVar.hzz();
            p.g(hzz2, "declaration.typeConstructor");
            List<as> parameters = hzz2.getParameters();
            p.g(parameters, "declaration.typeConstructor.parameters");
            List<as> list = parameters;
            ArrayList arrayList = new ArrayList(j.a(list, 10));
            for (T t : list) {
                p.g(t, "parameter");
                arrayList.add(a(t, aVar, d.b(t)));
            }
            o<aj, Boolean> U4 = s.U(ac.a(hzL, hzz, arrayList, ajVar.hEa(), a2, new a(eVar, ajVar, aVar)), Boolean.TRUE);
            AppMethodBeat.o(57986);
            return U4;
        }
    }

    @Override // kotlin.l.b.a.b.m.ay
    public final boolean isEmpty() {
        return false;
    }

    public static av a(as asVar, a aVar, ab abVar) {
        AppMethodBeat.i(57987);
        p.h(asVar, "parameter");
        p.h(aVar, "attr");
        p.h(abVar, "erasedUpperBound");
        switch (f.$EnumSwitchMapping$0[aVar.Ttc.ordinal()]) {
            case 1:
                ax axVar = new ax(bh.INVARIANT, abVar);
                AppMethodBeat.o(57987);
                return axVar;
            case 2:
            case 3:
                if (!asVar.hAJ().TOV) {
                    ax axVar2 = new ax(bh.INVARIANT, kotlin.l.b.a.b.j.d.a.G(asVar).hzh());
                    AppMethodBeat.o(57987);
                    return axVar2;
                }
                List<as> parameters = abVar.hKE().getParameters();
                p.g(parameters, "erasedUpperBound.constructor.parameters");
                if (!parameters.isEmpty()) {
                    ax axVar3 = new ax(bh.OUT_VARIANCE, abVar);
                    AppMethodBeat.o(57987);
                    return axVar3;
                }
                av a2 = d.a(asVar, aVar);
                AppMethodBeat.o(57987);
                return a2;
            default:
                m mVar = new m();
                AppMethodBeat.o(57987);
                throw mVar;
        }
    }
}
