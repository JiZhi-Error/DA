package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.ao;
import kotlin.l.b.a.b.d.a.c.a.h;

public final class q implements an {
    private final h TrO;

    public q(h hVar) {
        p.h(hVar, "packageFragment");
        AppMethodBeat.i(58227);
        this.TrO = hVar;
        AppMethodBeat.o(58227);
    }

    public final String toString() {
        AppMethodBeat.i(58225);
        String str = this.TrO + ": " + this.TrO.hDT().keySet();
        AppMethodBeat.o(58225);
        return str;
    }

    @Override // kotlin.l.b.a.b.b.an
    public final ao hBu() {
        AppMethodBeat.i(58226);
        ao aoVar = ao.ThL;
        p.g(aoVar, "SourceFile.NO_SOURCE_FILE");
        AppMethodBeat.o(58226);
        return aoVar;
    }
}
