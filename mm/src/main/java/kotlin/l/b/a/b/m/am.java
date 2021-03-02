package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.m.l;

public final class am {
    public static final aj aq(ab abVar) {
        AppMethodBeat.i(60802);
        p.h(abVar, "$this$getAbbreviation");
        p.h(abVar, "$this$getAbbreviatedType");
        bg hLF = abVar.hLF();
        if (!(hLF instanceof a)) {
            hLF = null;
        }
        a aVar = (a) hLF;
        if (aVar != null) {
            aj ajVar = aVar.TNh;
            AppMethodBeat.o(60802);
            return ajVar;
        }
        AppMethodBeat.o(60802);
        return null;
    }

    public static final aj b(aj ajVar, aj ajVar2) {
        AppMethodBeat.i(60803);
        p.h(ajVar, "$this$withAbbreviation");
        p.h(ajVar2, "abbreviatedType");
        if (ad.ap(ajVar)) {
            AppMethodBeat.o(60803);
            return ajVar;
        }
        a aVar = new a(ajVar, ajVar2);
        AppMethodBeat.o(60803);
        return aVar;
    }

    public static final boolean ar(ab abVar) {
        AppMethodBeat.i(60804);
        p.h(abVar, "$this$isDefinitelyNotNullType");
        boolean z = abVar.hLF() instanceof l;
        AppMethodBeat.o(60804);
        return z;
    }

    public static final bg b(bg bgVar) {
        aj as;
        AppMethodBeat.i(60805);
        p.h(bgVar, "$this$makeDefinitelyNotNullOrNotNull");
        l.a aVar = l.TNF;
        l a2 = l.a.a(bgVar);
        if (a2 != null) {
            as = a2;
        } else {
            as = as(bgVar);
        }
        if (as == null) {
            as = bgVar.EF(false);
        }
        AppMethodBeat.o(60805);
        return as;
    }

    public static final aj as(ab abVar) {
        AppMethodBeat.i(60806);
        at hKE = abVar.hKE();
        if (!(hKE instanceof aa)) {
            hKE = null;
        }
        aa aaVar = (aa) hKE;
        if (aaVar == null) {
            AppMethodBeat.o(60806);
            return null;
        }
        aa a2 = a(aaVar);
        if (a2 == null) {
            AppMethodBeat.o(60806);
            return null;
        }
        aj hLE = a2.hLE();
        AppMethodBeat.o(60806);
        return hLE;
    }

    private static final aa a(aa aaVar) {
        AppMethodBeat.i(60807);
        boolean z = false;
        LinkedHashSet<ab> linkedHashSet = aaVar.TOe;
        ArrayList arrayList = new ArrayList(j.a(linkedHashSet, 10));
        for (T t : linkedHashSet) {
            if (bc.aE(t)) {
                z = true;
                t = (T) b(t.hLF());
            }
            arrayList.add(t);
        }
        ArrayList arrayList2 = arrayList;
        if (!z) {
            AppMethodBeat.o(60807);
            return null;
        }
        aa aaVar2 = new aa(arrayList2);
        AppMethodBeat.o(60807);
        return aaVar2;
    }
}
