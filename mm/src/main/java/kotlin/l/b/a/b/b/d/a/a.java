package kotlin.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.b.e;
import kotlin.l.b.a.b.j.f.h;

public final class a {
    public final e TmE;
    public final g TmF;
    public final ConcurrentHashMap<kotlin.l.b.a.b.f.a, h> cache = new ConcurrentHashMap<>();

    public a(e eVar, g gVar) {
        p.h(eVar, "resolver");
        p.h(gVar, "kotlinClassFinder");
        AppMethodBeat.i(57350);
        this.TmE = eVar;
        this.TmF = gVar;
        AppMethodBeat.o(57350);
    }
}
