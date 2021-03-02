package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.a.g;

/* access modifiers changed from: package-private */
public final class b implements g {
    private final kotlin.l.b.a.b.f.b TtH;

    public b(kotlin.l.b.a.b.f.b bVar) {
        p.h(bVar, "fqNameToMatch");
        AppMethodBeat.i(58019);
        this.TtH = bVar;
        AppMethodBeat.o(58019);
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final /* synthetic */ c g(kotlin.l.b.a.b.f.b bVar) {
        a aVar;
        AppMethodBeat.i(58017);
        p.h(bVar, "fqName");
        if (p.j(bVar, this.TtH)) {
            aVar = a.TtG;
        } else {
            aVar = null;
        }
        a aVar2 = aVar;
        AppMethodBeat.o(58017);
        return aVar2;
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final boolean h(kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(58020);
        p.h(bVar, "fqName");
        boolean b2 = g.b.b(this, bVar);
        AppMethodBeat.o(58020);
        return b2;
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator<c> iterator() {
        AppMethodBeat.i(58018);
        Iterator<c> it = v.SXr.iterator();
        AppMethodBeat.o(58018);
        return it;
    }
}
