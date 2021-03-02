package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;

public final class i extends g<Double> {
    public i(double d2) {
        super(Double.valueOf(d2));
        AppMethodBeat.i(60062);
        AppMethodBeat.o(60062);
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final /* synthetic */ ab b(y yVar) {
        AppMethodBeat.i(60060);
        p.h(yVar, "module");
        aj a2 = yVar.hBh().a(h.DOUBLE);
        if (a2 == null) {
            g.atM(60);
        }
        p.g(a2, "module.builtIns.doubleType");
        aj ajVar = a2;
        AppMethodBeat.o(60060);
        return ajVar;
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final String toString() {
        AppMethodBeat.i(60061);
        String str = ((Number) getValue()).doubleValue() + ".toDouble()";
        AppMethodBeat.o(60061);
        return str;
    }
}
