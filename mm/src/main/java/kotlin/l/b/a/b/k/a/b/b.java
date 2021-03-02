package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.i;
import kotlin.l.b.a.b.l.j;
import kotlin.l.k;

public class b implements g {
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(b.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    private final f TLT;

    static {
        AppMethodBeat.i(60390);
        AppMethodBeat.o(60390);
    }

    private final List<c> hLh() {
        AppMethodBeat.i(60391);
        List<c> list = (List) i.a(this.TLT, cLI[0]);
        AppMethodBeat.o(60391);
        return list;
    }

    public b(j jVar, a<? extends List<? extends c>> aVar) {
        p.h(jVar, "storageManager");
        p.h(aVar, "compute");
        AppMethodBeat.i(60394);
        this.TLT = jVar.al(aVar);
        AppMethodBeat.o(60394);
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final c g(kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(60395);
        p.h(bVar, "fqName");
        c a2 = g.b.a(this, bVar);
        AppMethodBeat.o(60395);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final boolean h(kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(60396);
        p.h(bVar, "fqName");
        boolean b2 = g.b.b(this, bVar);
        AppMethodBeat.o(60396);
        return b2;
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public boolean isEmpty() {
        AppMethodBeat.i(60392);
        boolean isEmpty = hLh().isEmpty();
        AppMethodBeat.o(60392);
        return isEmpty;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        AppMethodBeat.i(60393);
        Iterator<c> it = hLh().iterator();
        AppMethodBeat.o(60393);
        return it;
    }
}
