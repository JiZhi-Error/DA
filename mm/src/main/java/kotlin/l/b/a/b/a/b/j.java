package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ae;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.au;
import kotlin.l.b.a.b.m.d.a;

public final class j {
    public static final au a(e eVar, e eVar2) {
        AppMethodBeat.i(56826);
        p.h(eVar, "from");
        p.h(eVar2, "to");
        boolean z = eVar.hzO().size() == eVar2.hzO().size();
        if (!aa.SXc || z) {
            au.a aVar = au.TOz;
            List<as> hzO = eVar.hzO();
            p.g(hzO, "from.declaredTypeParameters");
            List<as> list = hzO;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().hzz());
            }
            ArrayList arrayList2 = arrayList;
            List<as> hzO2 = eVar2.hzO();
            p.g(hzO2, "to.declaredTypeParameters");
            List<as> list2 = hzO2;
            ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(list2, 10));
            for (T t : list2) {
                p.g(t, LocaleUtil.ITALIAN);
                aj hAG = t.hAG();
                p.g(hAG, "it.defaultType");
                arrayList3.add(a.aN(hAG));
            }
            au cC = au.a.cC(ae.E(kotlin.a.j.c((Iterable) arrayList2, (Iterable) arrayList3)));
            AppMethodBeat.o(56826);
            return cC;
        }
        AssertionError assertionError = new AssertionError(eVar + " and " + eVar2 + " should have same number of type parameters, but " + eVar.hzO().size() + " / " + eVar2.hzO().size() + " found");
        AppMethodBeat.o(56826);
        throw assertionError;
    }
}
