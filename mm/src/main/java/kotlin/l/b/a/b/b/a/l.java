package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.a.b;
import kotlin.g.b.p;

public final class l implements g {
    private final g TiO;
    private final boolean TiP;
    private final b<kotlin.l.b.a.b.f.b, Boolean> TiQ;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.g.a.b<? super kotlin.l.b.a.b.f.b, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    private l(g gVar, b<? super kotlin.l.b.a.b.f.b, Boolean> bVar) {
        p.h(gVar, "delegate");
        p.h(bVar, "fqNameFilter");
        AppMethodBeat.i(56975);
        this.TiO = gVar;
        this.TiP = false;
        this.TiQ = bVar;
        AppMethodBeat.o(56975);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public l(g gVar, b<? super kotlin.l.b.a.b.f.b, Boolean> bVar, byte b2) {
        this(gVar, bVar);
        p.h(gVar, "delegate");
        p.h(bVar, "fqNameFilter");
        AppMethodBeat.i(186242);
        AppMethodBeat.o(186242);
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final boolean h(kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(56970);
        p.h(bVar, "fqName");
        if (this.TiQ.invoke(bVar).booleanValue()) {
            boolean h2 = this.TiO.h(bVar);
            AppMethodBeat.o(56970);
            return h2;
        }
        AppMethodBeat.o(56970);
        return false;
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final c g(kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(56971);
        p.h(bVar, "fqName");
        if (this.TiQ.invoke(bVar).booleanValue()) {
            c g2 = this.TiO.g(bVar);
            AppMethodBeat.o(56971);
            return g2;
        }
        AppMethodBeat.o(56971);
        return null;
    }

    @Override // java.lang.Iterable
    public final Iterator<c> iterator() {
        AppMethodBeat.i(56972);
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.TiO) {
            if (c((c) obj)) {
                arrayList.add(obj);
            }
        }
        Iterator<c> it = arrayList.iterator();
        AppMethodBeat.o(56972);
        return it;
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final boolean isEmpty() {
        boolean z;
        AppMethodBeat.i(56973);
        g gVar = this.TiO;
        if (!(gVar instanceof Collection) || !((Collection) gVar).isEmpty()) {
            Iterator it = gVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (c((c) it.next())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!this.TiP) {
            AppMethodBeat.o(56973);
            return z;
        } else if (!z) {
            AppMethodBeat.o(56973);
            return true;
        } else {
            AppMethodBeat.o(56973);
            return false;
        }
    }

    private final boolean c(c cVar) {
        AppMethodBeat.i(56974);
        kotlin.l.b.a.b.f.b hBk = cVar.hBk();
        if (hBk == null || !this.TiQ.invoke(hBk).booleanValue()) {
            AppMethodBeat.o(56974);
            return false;
        }
        AppMethodBeat.o(56974);
        return true;
    }
}
