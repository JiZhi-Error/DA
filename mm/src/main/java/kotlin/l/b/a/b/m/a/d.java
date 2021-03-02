package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.c.t;
import kotlin.m;

public final class d {
    public static final t a(bh bhVar) {
        AppMethodBeat.i(61044);
        p.h(bhVar, "$this$convertVariance");
        switch (e.haE[bhVar.ordinal()]) {
            case 1:
                t tVar = t.INV;
                AppMethodBeat.o(61044);
                return tVar;
            case 2:
                t tVar2 = t.IN;
                AppMethodBeat.o(61044);
                return tVar2;
            case 3:
                t tVar3 = t.OUT;
                AppMethodBeat.o(61044);
                return tVar3;
            default:
                m mVar = new m();
                AppMethodBeat.o(61044);
                throw mVar;
        }
    }
}
