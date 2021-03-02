package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public final class i {
    public static final g a(g gVar, g gVar2) {
        AppMethodBeat.i(56955);
        p.h(gVar, "first");
        p.h(gVar2, "second");
        if (gVar.isEmpty()) {
            AppMethodBeat.o(56955);
            return gVar2;
        } else if (gVar2.isEmpty()) {
            AppMethodBeat.o(56955);
            return gVar;
        } else {
            k kVar = new k(gVar, gVar2);
            AppMethodBeat.o(56955);
            return kVar;
        }
    }
}
