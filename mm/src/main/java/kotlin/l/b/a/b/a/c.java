package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.b;

public final class c {
    private static final LinkedHashSet<a> Tcy;
    public static final c Tcz = new c();

    static {
        AppMethodBeat.i(56653);
        Set<h> set = h.TeC;
        p.g(set, "PrimitiveType.NUMBER_TYPES");
        Set<h> set2 = set;
        ArrayList arrayList = new ArrayList(j.a(set2, 10));
        Iterator<T> it = set2.iterator();
        while (it.hasNext()) {
            arrayList.add(g.c((h) it.next()));
        }
        LinkedHashSet<a> linkedHashSet = new LinkedHashSet<>();
        for (b bVar : j.b((Collection) j.b((Collection) j.b((Collection) arrayList, (Object) g.TcO.TcY.hJj()), (Object) g.TcO.Tda.hJj()), (Object) g.TcO.Tdj.hJj())) {
            linkedHashSet.add(a.p(bVar));
        }
        Tcy = linkedHashSet;
        AppMethodBeat.o(56653);
    }

    private c() {
    }

    public static Set<a> hza() {
        AppMethodBeat.i(56651);
        Set<a> unmodifiableSet = Collections.unmodifiableSet(Tcy);
        p.g(unmodifiableSet, "Collections.unmodifiableSet(classIds)");
        AppMethodBeat.o(56651);
        return unmodifiableSet;
    }

    public static boolean b(e eVar) {
        AppMethodBeat.i(56652);
        p.h(eVar, "classDescriptor");
        if (kotlin.l.b.a.b.j.c.u(eVar)) {
            LinkedHashSet<a> linkedHashSet = Tcy;
            a c2 = kotlin.l.b.a.b.j.d.a.c(eVar);
            if (j.a(linkedHashSet, c2 != null ? c2.hJb() : null)) {
                AppMethodBeat.o(56652);
                return true;
            }
        }
        AppMethodBeat.o(56652);
        return false;
    }
}
