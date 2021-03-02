package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.s;
import kotlin.l.b.a.b.m.u;
import kotlin.l.b.a.b.m.v;
import kotlin.l.b.a.b.m.y;
import kotlin.m;

public final class f {
    public static final bg kL(List<? extends bg> list) {
        T t;
        AppMethodBeat.i(61045);
        p.h(list, "types");
        switch (list.size()) {
            case 0:
                IllegalStateException illegalStateException = new IllegalStateException("Expected some types".toString());
                AppMethodBeat.o(61045);
                throw illegalStateException;
            case 1:
                bg bgVar = (bg) j.kw(list);
                AppMethodBeat.o(61045);
                return bgVar;
            default:
                List<? extends bg> list2 = list;
                ArrayList arrayList = new ArrayList(j.a(list2, 10));
                boolean z = false;
                boolean z2 = false;
                for (T t2 : list2) {
                    boolean z3 = z || ad.ap(t2);
                    if (t2 instanceof aj) {
                        t = t2;
                    } else if (!(t2 instanceof v)) {
                        m mVar = new m();
                        AppMethodBeat.o(61045);
                        throw mVar;
                    } else if (s.aj(t2)) {
                        AppMethodBeat.o(61045);
                        return t2;
                    } else {
                        t = (T) t2.TNV;
                        z2 = true;
                    }
                    arrayList.add(t);
                    z = z3;
                }
                ArrayList arrayList2 = arrayList;
                if (z) {
                    aj bun = u.bun("Intersection of error types: ".concat(String.valueOf(list)));
                    p.g(bun, "ErrorUtils.createErrorTy… of error types: $types\")");
                    aj ajVar = bun;
                    AppMethodBeat.o(61045);
                    return ajVar;
                } else if (!z2) {
                    aj kM = y.TPF.kM(arrayList2);
                    AppMethodBeat.o(61045);
                    return kM;
                } else {
                    List<? extends bg> list3 = list;
                    ArrayList arrayList3 = new ArrayList(j.a(list3, 10));
                    Iterator<T> it = list3.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(y.ao(it.next()));
                    }
                    bg a2 = ac.a(y.TPF.kM(arrayList2), y.TPF.kM(arrayList3));
                    AppMethodBeat.o(61045);
                    return a2;
                }
        }
    }
}
