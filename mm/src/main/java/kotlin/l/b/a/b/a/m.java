package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.bc;

public final class m {
    private static final Set<f> Tfk;
    private static final HashMap<a, a> Tfl = new HashMap<>();
    private static final HashMap<a, a> Tfm = new HashMap<>();
    private static final Set<f> Tfn;
    public static final m Tfo = new m();

    static {
        AppMethodBeat.i(56704);
        l[] values = l.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (l lVar : values) {
            arrayList.add(lVar.TeD);
        }
        Tfk = j.r((Iterable) arrayList);
        l[] values2 = l.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (l lVar2 : values2) {
            linkedHashSet.add(lVar2.Tfi.hJa());
        }
        Tfn = linkedHashSet;
        l[] values3 = l.values();
        for (l lVar3 : values3) {
            Tfl.put(lVar3.Tfi, lVar3.Tfj);
            Tfm.put(lVar3.Tfj, lVar3.Tfi);
        }
        AppMethodBeat.o(56704);
    }

    private m() {
    }

    public static boolean c(f fVar) {
        AppMethodBeat.i(56701);
        p.h(fVar, "name");
        boolean contains = Tfn.contains(fVar);
        AppMethodBeat.o(56701);
        return contains;
    }

    public static a a(a aVar) {
        AppMethodBeat.i(56702);
        p.h(aVar, "arrayClassId");
        a aVar2 = Tfl.get(aVar);
        AppMethodBeat.o(56702);
        return aVar2;
    }

    public static boolean E(ab abVar) {
        AppMethodBeat.i(56703);
        p.h(abVar, "type");
        if (bc.aA(abVar)) {
            AppMethodBeat.o(56703);
            return false;
        }
        h hzS = abVar.hKE().hzS();
        if (hzS == null) {
            AppMethodBeat.o(56703);
            return false;
        }
        p.g(hzS, "type.constructor.declara…escriptor ?: return false");
        h hVar = hzS;
        p.h(hVar, "descriptor");
        l hzx = hVar.hzx();
        if (!(hzx instanceof kotlin.l.b.a.b.b.ab) || !p.j(((kotlin.l.b.a.b.b.ab) hzx).hBk(), g.TcD) || !Tfk.contains(hVar.hAH())) {
            AppMethodBeat.o(56703);
            return false;
        }
        AppMethodBeat.o(56703);
        return true;
    }
}
