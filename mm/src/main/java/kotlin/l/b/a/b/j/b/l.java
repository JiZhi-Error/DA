package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;

public final class l extends g<Float> {
    public l(float f2) {
        super(Float.valueOf(f2));
        AppMethodBeat.i(60071);
        AppMethodBeat.o(60071);
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final /* synthetic */ ab b(y yVar) {
        AppMethodBeat.i(60069);
        p.h(yVar, "module");
        aj a2 = yVar.hBh().a(h.FLOAT);
        if (a2 == null) {
            g.atM(59);
        }
        p.g(a2, "module.builtIns.floatType");
        aj ajVar = a2;
        AppMethodBeat.o(60069);
        return ajVar;
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final String toString() {
        AppMethodBeat.i(60070);
        String str = ((Number) getValue()).floatValue() + ".toFloat()";
        AppMethodBeat.o(60070);
        return str;
    }
}
