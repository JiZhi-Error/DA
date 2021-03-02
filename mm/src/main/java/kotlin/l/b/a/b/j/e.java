package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.c.a.c;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.t;

public final class e {
    private static av A(kotlin.l.b.a.b.b.e eVar) {
        List<av> hAw;
        AppMethodBeat.i(59940);
        p.h(eVar, "$this$underlyingRepresentation");
        if (!eVar.hzI()) {
            AppMethodBeat.o(59940);
            return null;
        }
        d hzD = eVar.hzD();
        if (hzD == null || (hAw = hzD.hAw()) == null) {
            AppMethodBeat.o(59940);
            return null;
        }
        av avVar = (av) j.kx(hAw);
        AppMethodBeat.o(59940);
        return avVar;
    }

    public static final boolean D(l lVar) {
        AppMethodBeat.i(59941);
        p.h(lVar, "$this$isInlineClass");
        if (!(lVar instanceof kotlin.l.b.a.b.b.e) || !((kotlin.l.b.a.b.b.e) lVar).hzI()) {
            AppMethodBeat.o(59941);
            return false;
        }
        AppMethodBeat.o(59941);
        return true;
    }

    public static final boolean aa(ab abVar) {
        AppMethodBeat.i(59942);
        p.h(abVar, "$this$isInlineClassType");
        h hzS = abVar.hKE().hzS();
        if (hzS != null) {
            boolean D = D(hzS);
            AppMethodBeat.o(59942);
            return D;
        }
        AppMethodBeat.o(59942);
        return false;
    }

    public static final ab ab(ab abVar) {
        AppMethodBeat.i(59943);
        p.h(abVar, "$this$substitutedUnderlyingType");
        p.h(abVar, "$this$unsubstitutedUnderlyingParameter");
        h hzS = abVar.hKE().hzS();
        if (!(hzS instanceof kotlin.l.b.a.b.b.e)) {
            hzS = null;
        }
        kotlin.l.b.a.b.b.e eVar = (kotlin.l.b.a.b.b.e) hzS;
        av A = eVar != null ? A(eVar) : null;
        if (A == null) {
            AppMethodBeat.o(59943);
            return null;
        }
        kotlin.l.b.a.b.j.f.h hAp = abVar.hAp();
        f hAH = A.hAH();
        p.g(hAH, "parameter.name");
        ah ahVar = (ah) j.j(hAp.a(hAH, c.FOR_ALREADY_TRACKED));
        if (ahVar != null) {
            ab hBy = ahVar.hBy();
            AppMethodBeat.o(59943);
            return hBy;
        }
        AppMethodBeat.o(59943);
        return null;
    }

    public static final boolean f(a aVar) {
        AppMethodBeat.i(59944);
        p.h(aVar, "$this$isGetterOfUnderlyingPropertyOfInlineClass");
        if (aVar instanceof ai) {
            ah hBm = ((ai) aVar).hBm();
            p.g(hBm, "correspondingProperty");
            if (a(hBm)) {
                AppMethodBeat.o(59944);
                return true;
            }
        }
        AppMethodBeat.o(59944);
        return false;
    }

    public static final boolean a(ax axVar) {
        AppMethodBeat.i(59945);
        p.h(axVar, "$this$isUnderlyingPropertyOfInlineClass");
        l hzx = axVar.hzx();
        p.g(hzx, "this.containingDeclaration");
        if (!D(hzx)) {
            AppMethodBeat.o(59945);
            return false;
        } else if (hzx == null) {
            t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            AppMethodBeat.o(59945);
            throw tVar;
        } else {
            av A = A((kotlin.l.b.a.b.b.e) hzx);
            boolean j2 = p.j(A != null ? A.hAH() : null, axVar.hAH());
            AppMethodBeat.o(59945);
            return j2;
        }
    }
}
