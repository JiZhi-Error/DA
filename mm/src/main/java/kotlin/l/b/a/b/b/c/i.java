package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ac;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;

public final class i implements ac {
    private final List<ac> Tkw;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.l.b.a.b.b.ac> */
    /* JADX WARN: Multi-variable type inference failed */
    public i(List<? extends ac> list) {
        p.h(list, "providers");
        AppMethodBeat.i(57060);
        this.Tkw = list;
        AppMethodBeat.o(57060);
    }

    @Override // kotlin.l.b.a.b.b.ac
    public final List<ab> f(b bVar) {
        AppMethodBeat.i(57058);
        p.h(bVar, "fqName");
        ArrayList arrayList = new ArrayList();
        for (ac acVar : this.Tkw) {
            arrayList.addAll(acVar.f(bVar));
        }
        List<ab> p = j.p(arrayList);
        AppMethodBeat.o(57058);
        return p;
    }

    @Override // kotlin.l.b.a.b.b.ac
    public final Collection<b> a(b bVar, kotlin.g.a.b<? super f, Boolean> bVar2) {
        AppMethodBeat.i(57059);
        p.h(bVar, "fqName");
        p.h(bVar2, "nameFilter");
        HashSet hashSet = new HashSet();
        for (ac acVar : this.Tkw) {
            hashSet.addAll(acVar.a(bVar, bVar2));
        }
        HashSet hashSet2 = hashSet;
        AppMethodBeat.o(57059);
        return hashSet2;
    }
}
