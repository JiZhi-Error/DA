package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.c.aj;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.d.a.c.a.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.ab;
import kotlin.o;

public final class k {
    public static final List<av> a(Collection<l> collection, Collection<? extends av> collection2, a aVar) {
        AppMethodBeat.i(57732);
        p.h(collection, "newValueParametersTypes");
        p.h(collection2, "oldValueParameters");
        p.h(aVar, "newOwner");
        boolean z = collection.size() == collection2.size();
        if (!aa.SXc || z) {
            List<o> c2 = j.c((Iterable) collection, (Iterable) collection2);
            ArrayList arrayList = new ArrayList(j.a(c2, 10));
            for (o oVar : c2) {
                A a2 = oVar.first;
                B b2 = oVar.second;
                int index = b2.getIndex();
                g hzL = b2.hzL();
                f hAH = b2.hAH();
                p.g(hAH, "oldParameter.name");
                ab abVar = a2.Tbs;
                boolean z2 = a2.TqL;
                boolean hBD = b2.hBD();
                boolean hBE = b2.hBE();
                ab l = b2.hBB() != null ? kotlin.l.b.a.b.j.d.a.F(aVar).hBh().l(a2.Tbs) : null;
                an hzM = b2.hzM();
                p.g(hzM, "oldParameter.source");
                arrayList.add(new aj(aVar, null, index, hzL, hAH, abVar, z2, hBD, hBE, l, hzM));
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(57732);
            return arrayList2;
        }
        AssertionError assertionError = new AssertionError("Different value parameters sizes: Enhanced = " + collection.size() + ", Old = " + collection2.size());
        AppMethodBeat.o(57732);
        throw assertionError;
    }

    public static final l s(e eVar) {
        l lVar;
        AppMethodBeat.i(57733);
        do {
            p.h(eVar, "$this$getParentJavaStaticClassScope");
            eVar = kotlin.l.b.a.b.j.d.a.B(eVar);
            if (eVar == null) {
                AppMethodBeat.o(57733);
                return null;
            }
            h hzy = eVar.hzy();
            if (!(hzy instanceof l)) {
                hzy = null;
            }
            lVar = (l) hzy;
        } while (lVar == null);
        AppMethodBeat.o(57733);
        return lVar;
    }
}
