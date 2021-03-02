package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.a.a;
import kotlin.l.b.a.b.a.a.b;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.j.b.v;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.av;

public final class f {
    public static final boolean d(ab abVar) {
        AppMethodBeat.i(56656);
        p.h(abVar, "$this$isFunctionType");
        h hzS = abVar.hKE().hzS();
        if ((hzS != null ? b(hzS) : null) == b.c.Function) {
            AppMethodBeat.o(56656);
            return true;
        }
        AppMethodBeat.o(56656);
        return false;
    }

    public static final boolean e(ab abVar) {
        AppMethodBeat.i(56657);
        p.h(abVar, "$this$isSuspendFunctionType");
        h hzS = abVar.hKE().hzS();
        if ((hzS != null ? b(hzS) : null) == b.c.SuspendFunction) {
            AppMethodBeat.o(56657);
            return true;
        }
        AppMethodBeat.o(56657);
        return false;
    }

    public static final boolean f(ab abVar) {
        AppMethodBeat.i(56658);
        p.h(abVar, "$this$isBuiltinFunctionalType");
        h hzS = abVar.hKE().hzS();
        b.c b2 = hzS != null ? b(hzS) : null;
        if (b2 == b.c.Function || b2 == b.c.SuspendFunction) {
            AppMethodBeat.o(56658);
            return true;
        }
        AppMethodBeat.o(56658);
        return false;
    }

    private static final boolean g(ab abVar) {
        AppMethodBeat.i(56659);
        g hzL = abVar.hzL();
        kotlin.l.b.a.b.f.b bVar = g.TcO.Tds;
        p.g(bVar, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
        if (hzL.g(bVar) != null) {
            AppMethodBeat.o(56659);
            return true;
        }
        AppMethodBeat.o(56659);
        return false;
    }

    private static b.c b(l lVar) {
        AppMethodBeat.i(56660);
        p.h(lVar, "$this$getFunctionalClassKind");
        if (!(lVar instanceof e)) {
            AppMethodBeat.o(56660);
            return null;
        } else if (!g.d(lVar)) {
            AppMethodBeat.o(56660);
            return null;
        } else {
            b.c a2 = a(a.q(lVar));
            AppMethodBeat.o(56660);
            return a2;
        }
    }

    private static final b.c a(c cVar) {
        AppMethodBeat.i(56661);
        if (!cVar.hJi() || cVar.TCW.isEmpty()) {
            AppMethodBeat.o(56661);
            return null;
        }
        a.C2272a aVar = kotlin.l.b.a.b.a.a.a.Tfq;
        String sG = cVar.hJg().sG();
        p.g(sG, "shortName().asString()");
        kotlin.l.b.a.b.f.b hJf = cVar.hJj().hJf();
        p.g(hJf, "toSafe().parent()");
        b.c b2 = a.C2272a.b(sG, hJf);
        AppMethodBeat.o(56661);
        return b2;
    }

    public static final ab h(ab abVar) {
        AppMethodBeat.i(56662);
        p.h(abVar, "$this$getReceiverTypeFromFunctionType");
        boolean f2 = f(abVar);
        if (aa.SXc && !f2) {
            AssertionError assertionError = new AssertionError("Not a function type: ".concat(String.valueOf(abVar)));
            AppMethodBeat.o(56662);
            throw assertionError;
        } else if (g(abVar)) {
            ab hBy = ((av) j.ks(abVar.hKB())).hBy();
            AppMethodBeat.o(56662);
            return hBy;
        } else {
            AppMethodBeat.o(56662);
            return null;
        }
    }

    public static final ab i(ab abVar) {
        AppMethodBeat.i(56663);
        p.h(abVar, "$this$getReturnTypeFromFunctionType");
        boolean f2 = f(abVar);
        if (!aa.SXc || f2) {
            ab hBy = ((av) j.ku(abVar.hKB())).hBy();
            p.g(hBy, "arguments.last().type");
            AppMethodBeat.o(56663);
            return hBy;
        }
        AssertionError assertionError = new AssertionError("Not a function type: ".concat(String.valueOf(abVar)));
        AppMethodBeat.o(56663);
        throw assertionError;
    }

    public static final List<av> j(ab abVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(56664);
        p.h(abVar, "$this$getValueParameterTypesFromFunctionType");
        boolean f2 = f(abVar);
        if (!aa.SXc || f2) {
            List<av> hKB = abVar.hKB();
            p.h(abVar, "$this$isBuiltinExtensionFunctionalType");
            if (!f(abVar) || !g(abVar)) {
                z = false;
            } else {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int size = hKB.size() - 1;
            if (i2 > size) {
                z2 = false;
            }
            if (!aa.SXc || z2) {
                List<av> subList = hKB.subList(i2, size);
                AppMethodBeat.o(56664);
                return subList;
            }
            AssertionError assertionError = new AssertionError("Not an exact function type: ".concat(String.valueOf(abVar)));
            AppMethodBeat.o(56664);
            throw assertionError;
        }
        AssertionError assertionError2 = new AssertionError("Not a function type: ".concat(String.valueOf(abVar)));
        AppMethodBeat.o(56664);
        throw assertionError2;
    }

    public static final kotlin.l.b.a.b.f.f k(ab abVar) {
        String str;
        AppMethodBeat.i(56665);
        p.h(abVar, "$this$extractParameterNameFromFunctionTypeArgument");
        g hzL = abVar.hzL();
        kotlin.l.b.a.b.f.b bVar = g.TcO.Tdt;
        p.g(bVar, "KotlinBuiltIns.FQ_NAMES.parameterName");
        kotlin.l.b.a.b.b.a.c g2 = hzL.g(bVar);
        if (g2 == null) {
            AppMethodBeat.o(56665);
            return null;
        }
        Object j2 = j.j(g2.hBO().values());
        if (!(j2 instanceof v)) {
            j2 = null;
        }
        v vVar = (v) j2;
        if (!(vVar == null || (str = (String) vVar.getValue()) == null)) {
            if (!kotlin.l.b.a.b.f.f.btZ(str)) {
                str = null;
            }
            if (str != null) {
                kotlin.l.b.a.b.f.f btY = kotlin.l.b.a.b.f.f.btY(str);
                AppMethodBeat.o(56665);
                return btY;
            }
        }
        AppMethodBeat.o(56665);
        return null;
    }

    public static /* synthetic */ aj a(g gVar, g gVar2, ab abVar, List list, ab abVar2) {
        AppMethodBeat.i(56667);
        aj a2 = a(gVar, gVar2, abVar, list, abVar2, false);
        AppMethodBeat.o(56667);
        return a2;
    }

    public static final aj a(g gVar, g gVar2, ab abVar, List<? extends ab> list, ab abVar2, boolean z) {
        e btz;
        AppMethodBeat.i(56666);
        p.h(gVar, "builtIns");
        p.h(gVar2, "annotations");
        p.h(list, "parameterTypes");
        p.h(abVar2, "returnType");
        p.h(list, "parameterTypes");
        p.h(abVar2, "returnType");
        p.h(gVar, "builtIns");
        ArrayList arrayList = new ArrayList((abVar != null ? 1 : 0) + list.size() + 1);
        kotlin.l.b.a.b.o.a.c(arrayList, abVar != null ? kotlin.l.b.a.b.m.d.a.aN(abVar) : null);
        int i2 = 0;
        for (T t : list) {
            ArrayList arrayList2 = arrayList;
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            arrayList2.add(kotlin.l.b.a.b.m.d.a.aN(t));
            i2 = i3;
        }
        arrayList.add(kotlin.l.b.a.b.m.d.a.aN(abVar2));
        ArrayList arrayList3 = arrayList;
        int size = list.size();
        if (abVar != null) {
            size++;
        }
        if (z) {
            btz = gVar.atP(size);
        } else {
            btz = gVar.btz(g.atN(size));
        }
        p.g(btz, "if (suspendFunction) bui…tFunction(parameterCount)");
        if (abVar != null) {
            kotlin.l.b.a.b.f.b bVar = g.TcO.Tds;
            p.g(bVar, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
            if (gVar2.g(bVar) == null) {
                g.a aVar = g.TiC;
                kotlin.l.b.a.b.f.b bVar2 = g.TcO.Tds;
                p.g(bVar2, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
                gVar2 = g.a.kA(j.d(gVar2, new kotlin.l.b.a.b.b.a.j(gVar, bVar2, ae.emptyMap())));
            }
        }
        aj a2 = ac.a(gVar2, btz, arrayList3);
        AppMethodBeat.o(56666);
        return a2;
    }
}
