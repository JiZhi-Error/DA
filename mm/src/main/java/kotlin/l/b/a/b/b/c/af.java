package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ad;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.c;
import kotlin.l.b.a.b.j.f.d;
import kotlin.l.b.a.b.j.f.i;
import kotlin.l.b.a.b.o.a;

public final class af extends i {
    private final y Tge;
    private final b TiI;

    public af(y yVar, b bVar) {
        p.h(yVar, "moduleDescriptor");
        p.h(bVar, "fqName");
        AppMethodBeat.i(57295);
        this.Tge = yVar;
        this.TiI = bVar;
        AppMethodBeat.o(57295);
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
    public final Collection<l> a(d dVar, kotlin.g.a.b<? super f, Boolean> bVar) {
        ad e2;
        AppMethodBeat.i(57294);
        p.h(dVar, "kindFilter");
        p.h(bVar, "nameFilter");
        d.a aVar = d.TJQ;
        if (!dVar.avF(d.TJx)) {
            v vVar = v.SXr;
            AppMethodBeat.o(57294);
            return vVar;
        } else if (!this.TiI.TCR.TCW.isEmpty() || !dVar.TJs.contains(c.b.TJq)) {
            Collection<b> a2 = this.Tge.a(this.TiI, bVar);
            ArrayList arrayList = new ArrayList(a2.size());
            for (b bVar2 : a2) {
                f hJg = bVar2.hJg();
                p.g(hJg, "subFqName.shortName()");
                if (bVar.invoke(hJg).booleanValue()) {
                    ArrayList arrayList2 = arrayList;
                    p.h(hJg, "name");
                    if (hJg.TDa) {
                        e2 = null;
                    } else {
                        y yVar = this.Tge;
                        b p = this.TiI.p(hJg);
                        p.g(p, "fqName.child(name)");
                        e2 = yVar.e(p);
                        if (e2.isEmpty()) {
                            e2 = null;
                        }
                    }
                    a.c(arrayList2, e2);
                }
            }
            ArrayList arrayList3 = arrayList;
            AppMethodBeat.o(57294);
            return arrayList3;
        } else {
            v vVar2 = v.SXr;
            AppMethodBeat.o(57294);
            return vVar2;
        }
    }
}
