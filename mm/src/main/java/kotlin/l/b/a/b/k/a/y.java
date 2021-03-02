package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.a;
import kotlin.l.b.a.b.e.b.c;

public final class y implements i {
    private final c SZH;
    private final a TKB;
    final Map<kotlin.l.b.a.b.f.a, a.b> TLy;
    private final b<kotlin.l.b.a.b.f.a, an> TLz;

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: kotlin.g.a.b<? super kotlin.l.b.a.b.f.a, ? extends kotlin.l.b.a.b.b.an> */
    /* JADX WARN: Multi-variable type inference failed */
    public y(a.l lVar, c cVar, kotlin.l.b.a.b.e.b.a aVar, b<? super kotlin.l.b.a.b.f.a, ? extends an> bVar) {
        p.h(lVar, "proto");
        p.h(cVar, "nameResolver");
        p.h(aVar, "metadataVersion");
        p.h(bVar, "classSource");
        AppMethodBeat.i(60345);
        this.SZH = cVar;
        this.TKB = aVar;
        this.TLz = bVar;
        List<a.b> list = lVar.TyS;
        p.g(list, "proto.class_List");
        List<a.b> list2 = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.mZ(ae.atJ(kotlin.a.j.a(list2, 10)), 16));
        for (T t : list2) {
            T t2 = t;
            c cVar2 = this.SZH;
            p.g(t2, "klass");
            linkedHashMap.put(x.a(cVar2, t2.Txs), t);
        }
        this.TLy = linkedHashMap;
        AppMethodBeat.o(60345);
    }

    @Override // kotlin.l.b.a.b.k.a.i
    public final h d(kotlin.l.b.a.b.f.a aVar) {
        AppMethodBeat.i(60344);
        p.h(aVar, "classId");
        a.b bVar = this.TLy.get(aVar);
        if (bVar == null) {
            AppMethodBeat.o(60344);
            return null;
        }
        h hVar = new h(this.SZH, bVar, this.TKB, this.TLz.invoke(aVar));
        AppMethodBeat.o(60344);
        return hVar;
    }
}
