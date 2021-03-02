package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.u;

public final class z extends aa<Short> {
    public z(short s) {
        super(Short.valueOf(s));
        AppMethodBeat.i(60128);
        AppMethodBeat.o(60128);
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final ab b(y yVar) {
        aj hAG;
        AppMethodBeat.i(60126);
        p.h(yVar, "module");
        a aVar = g.TcO.Tek;
        p.g(aVar, "KotlinBuiltIns.FQ_NAMES.uShort");
        e b2 = s.b(yVar, aVar);
        if (b2 == null || (hAG = b2.hAG()) == null) {
            aj bun = u.bun("Unsigned type UShort not found");
            p.g(bun, "ErrorUtils.createErrorTy…d type UShort not found\")");
            aj ajVar = bun;
            AppMethodBeat.o(60126);
            return ajVar;
        }
        aj ajVar2 = hAG;
        AppMethodBeat.o(60126);
        return ajVar2;
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final String toString() {
        AppMethodBeat.i(60127);
        String str = ((int) ((Number) getValue()).shortValue()) + ".toUShort()";
        AppMethodBeat.o(60127);
        return str;
    }
}
