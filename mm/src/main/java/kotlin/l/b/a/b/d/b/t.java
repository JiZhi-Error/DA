package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.d.b.k;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.j.e.d;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.bc;

public final class t {
    private static String a(kotlin.l.b.a.b.b.t tVar, boolean z, boolean z2) {
        boolean z3;
        String sG;
        AppMethodBeat.i(58241);
        p.h(tVar, "$this$computeJvmDescriptor");
        StringBuilder sb = new StringBuilder();
        if (z2) {
            if (tVar instanceof k) {
                sG = "<init>";
            } else {
                sG = tVar.hAH().sG();
                p.g(sG, "name.asString()");
            }
            sb.append(sG);
        }
        sb.append("(");
        for (av avVar : tVar.hAw()) {
            p.g(avVar, "parameter");
            ab hBy = avVar.hBy();
            p.g(hBy, "parameter.type");
            a(sb, hBy);
        }
        sb.append(")");
        if (z) {
            kotlin.l.b.a.b.b.t tVar2 = tVar;
            p.h(tVar2, "descriptor");
            if (tVar2 instanceof k) {
                z3 = true;
            } else {
                ab hAu = tVar2.hAu();
                if (hAu == null) {
                    p.hyc();
                }
                if (g.C(hAu)) {
                    ab hAu2 = tVar2.hAu();
                    if (hAu2 == null) {
                        p.hyc();
                    }
                    if (!bc.aE(hAu2) && !(tVar2 instanceof ai)) {
                        z3 = true;
                    }
                }
                z3 = false;
            }
            if (z3) {
                sb.append("V");
            } else {
                ab hAu3 = tVar.hAu();
                if (hAu3 == null) {
                    p.hyc();
                }
                p.g(hAu3, "returnType!!");
                a(sb, hAu3);
            }
        }
        String sb2 = sb.toString();
        p.g(sb2, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(58241);
        return sb2;
    }

    public static /* synthetic */ String a(kotlin.l.b.a.b.b.t tVar, boolean z, boolean z2, int i2) {
        AppMethodBeat.i(58242);
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        String a2 = a(tVar, z, z2);
        AppMethodBeat.o(58242);
        return a2;
    }

    public static final boolean b(a aVar) {
        d dVar = null;
        AppMethodBeat.i(58243);
        p.h(aVar, "f");
        if (!(aVar instanceof kotlin.l.b.a.b.b.t)) {
            AppMethodBeat.o(58243);
            return false;
        } else if (((kotlin.l.b.a.b.b.t) aVar).hAw().size() != 1 || kotlin.l.b.a.b.d.a.t.r((b) aVar) || (!p.j(((kotlin.l.b.a.b.b.t) aVar).hAH().sG(), "remove"))) {
            AppMethodBeat.o(58243);
            return false;
        } else {
            kotlin.l.b.a.b.b.t hAT = ((kotlin.l.b.a.b.b.t) aVar).hAT();
            p.g(hAT, "f.original");
            List<av> hAw = hAT.hAw();
            p.g(hAw, "f.original.valueParameters");
            Object kw = j.kw(hAw);
            p.g(kw, "f.original.valueParameters.single()");
            ab hBy = ((av) kw).hBy();
            p.g(hBy, "f.original.valueParameters.single().type");
            k U = U(hBy);
            if (!(U instanceof k.c)) {
                U = null;
            }
            k.c cVar = (k.c) U;
            if (cVar != null) {
                dVar = cVar.TvM;
            }
            if (dVar != d.INT) {
                AppMethodBeat.o(58243);
                return false;
            }
            kotlin.l.b.a.b.b.t e2 = kotlin.l.b.a.b.d.a.d.e((kotlin.l.b.a.b.b.t) aVar);
            if (e2 == null) {
                AppMethodBeat.o(58243);
                return false;
            }
            kotlin.l.b.a.b.b.t hAT2 = e2.hAT();
            p.g(hAT2, "overridden.original");
            List<av> hAw2 = hAT2.hAw();
            p.g(hAw2, "overridden.original.valueParameters");
            Object kw2 = j.kw(hAw2);
            p.g(kw2, "overridden.original.valueParameters.single()");
            ab hBy2 = ((av) kw2).hBy();
            p.g(hBy2, "overridden.original.valueParameters.single().type");
            k U2 = U(hBy2);
            l hzx = e2.hzx();
            p.g(hzx, "overridden.containingDeclaration");
            if (!p.j(kotlin.l.b.a.b.j.d.a.q(hzx), g.TcO.TdN.hJe()) || !(U2 instanceof k.b) || !p.j(((k.b) U2).TvL, "java/lang/Object")) {
                AppMethodBeat.o(58243);
                return false;
            }
            AppMethodBeat.o(58243);
            return true;
        }
    }

    private static final void a(StringBuilder sb, ab abVar) {
        AppMethodBeat.i(58245);
        sb.append(U(abVar));
        AppMethodBeat.o(58245);
    }

    public static final k U(ab abVar) {
        AppMethodBeat.i(58246);
        p.h(abVar, "$this$mapToJvmType");
        k kVar = (k) aa.a(abVar, m.TvN, y.Twf, x.TvU);
        AppMethodBeat.o(58246);
        return kVar;
    }

    public static final String c(a aVar) {
        AppMethodBeat.i(58244);
        p.h(aVar, "$this$computeJvmSignature");
        v vVar = v.TvS;
        if (c.m(aVar)) {
            AppMethodBeat.o(58244);
            return null;
        }
        l hzx = aVar.hzx();
        if (!(hzx instanceof e)) {
            hzx = null;
        }
        e eVar = (e) hzx;
        if (eVar == null) {
            AppMethodBeat.o(58244);
            return null;
        }
        f hAH = eVar.hAH();
        p.g(hAH, "classDescriptor.name");
        if (hAH.TDa) {
            AppMethodBeat.o(58244);
            return null;
        }
        a hAv = aVar.hAv();
        if (!(hAv instanceof am)) {
            hAv = null;
        }
        am amVar = (am) hAv;
        if (amVar == null) {
            AppMethodBeat.o(58244);
            return null;
        }
        String a2 = v.a(eVar, a(amVar, false, false, 3));
        AppMethodBeat.o(58244);
        return a2;
    }
}
