package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.c.ai;
import kotlin.l.b.a.b.b.c.m;
import kotlin.l.b.a.b.b.c.x;
import kotlin.l.b.a.b.b.f;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.m.u;

public final class k {
    private static final x Tfb;
    private static final x Tfc;

    static {
        AppMethodBeat.i(56696);
        y hLA = u.hLA();
        p.g(hLA, "ErrorUtils.getErrorModule()");
        b bVar = c.THw;
        p.g(bVar, "DescriptorUtils.COROUTIN…KAGE_FQ_NAME_EXPERIMENTAL");
        x xVar = new x(new m(hLA, bVar), f.INTERFACE, c.THy.hJg(), an.ThK, kotlin.l.b.a.b.l.b.TMN);
        xVar.b(w.ABSTRACT);
        xVar.d(az.ThU);
        g.a aVar = g.TiC;
        xVar.kD(j.listOf(ai.a(xVar, g.a.hBP(), bh.IN_VARIANCE, kotlin.l.b.a.b.f.f.btY("T"), 0, kotlin.l.b.a.b.l.b.TMN)));
        xVar.hCn();
        Tfb = xVar;
        y hLA2 = u.hLA();
        p.g(hLA2, "ErrorUtils.getErrorModule()");
        b bVar2 = c.THv;
        p.g(bVar2, "DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE");
        x xVar2 = new x(new m(hLA2, bVar2), f.INTERFACE, c.THz.hJg(), an.ThK, kotlin.l.b.a.b.l.b.TMN);
        xVar2.b(w.ABSTRACT);
        xVar2.d(az.ThU);
        g.a aVar2 = g.TiC;
        xVar2.kD(j.listOf(ai.a(xVar2, g.a.hBP(), bh.IN_VARIANCE, kotlin.l.b.a.b.f.f.btY("T"), 0, kotlin.l.b.a.b.l.b.TMN)));
        xVar2.hCn();
        Tfc = xVar2;
        AppMethodBeat.o(56696);
    }

    public static final aj a(ab abVar, boolean z) {
        AppMethodBeat.i(186239);
        p.h(abVar, "suspendFunType");
        boolean e2 = f.e(abVar);
        if (!aa.SXc || e2) {
            g aM = a.aM(abVar);
            g hzL = abVar.hzL();
            ab h2 = f.h(abVar);
            List<av> j2 = f.j(abVar);
            ArrayList arrayList = new ArrayList(j.a(j2, 10));
            Iterator<T> it = j2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().hBy());
            }
            g.a aVar = g.TiC;
            g hBP = g.a.hBP();
            at hzz = Tfc.hzz();
            p.g(hzz, "if (isReleaseCoroutines)…ERIMENTAL.typeConstructor");
            List b2 = j.b((Collection) arrayList, (Object) ac.c(hBP, hzz, j.listOf(a.aN(f.i(abVar))), false));
            aj hzj = a.aM(abVar).hzj();
            p.g(hzj, "suspendFunType.builtIns.nullableAnyType");
            aj EG = f.a(aM, hzL, h2, b2, hzj).EG(abVar.hEa());
            AppMethodBeat.o(186239);
            return EG;
        }
        AssertionError assertionError = new AssertionError("This type should be suspend function type: ".concat(String.valueOf(abVar)));
        AppMethodBeat.o(186239);
        throw assertionError;
    }

    public static final boolean a(b bVar, boolean z) {
        AppMethodBeat.i(56695);
        if (z) {
            boolean j2 = p.j(bVar, c.THz);
            AppMethodBeat.o(56695);
            return j2;
        }
        boolean j3 = p.j(bVar, c.THy);
        AppMethodBeat.o(56695);
        return j3;
    }
}
