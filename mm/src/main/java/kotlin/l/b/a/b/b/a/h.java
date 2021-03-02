package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.f.b;

public final class h implements g {
    private final List<c> TiF;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.l.b.a.b.b.a.c> */
    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends c> list) {
        p.h(list, "annotations");
        AppMethodBeat.i(56952);
        this.TiF = list;
        AppMethodBeat.o(56952);
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final c g(b bVar) {
        AppMethodBeat.i(56953);
        p.h(bVar, "fqName");
        c a2 = g.b.a(this, bVar);
        AppMethodBeat.o(56953);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final boolean h(b bVar) {
        AppMethodBeat.i(56954);
        p.h(bVar, "fqName");
        boolean b2 = g.b.b(this, bVar);
        AppMethodBeat.o(56954);
        return b2;
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final boolean isEmpty() {
        AppMethodBeat.i(56949);
        boolean isEmpty = this.TiF.isEmpty();
        AppMethodBeat.o(56949);
        return isEmpty;
    }

    @Override // java.lang.Iterable
    public final Iterator<c> iterator() {
        AppMethodBeat.i(56950);
        Iterator<c> it = this.TiF.iterator();
        AppMethodBeat.o(56950);
        return it;
    }

    public final String toString() {
        AppMethodBeat.i(56951);
        String obj = this.TiF.toString();
        AppMethodBeat.o(56951);
        return obj;
    }
}
