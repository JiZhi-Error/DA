package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.u;

public final class y extends aa<Long> {
    public y(long j2) {
        super(Long.valueOf(j2));
        AppMethodBeat.i(60125);
        AppMethodBeat.o(60125);
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final ab b(kotlin.l.b.a.b.b.y yVar) {
        aj hAG;
        AppMethodBeat.i(60123);
        p.h(yVar, "module");
        a aVar = g.TcO.Tem;
        p.g(aVar, "KotlinBuiltIns.FQ_NAMES.uLong");
        e b2 = s.b(yVar, aVar);
        if (b2 == null || (hAG = b2.hAG()) == null) {
            aj bun = u.bun("Unsigned type ULong not found");
            p.g(bun, "ErrorUtils.createErrorTy…ed type ULong not found\")");
            aj ajVar = bun;
            AppMethodBeat.o(60123);
            return ajVar;
        }
        aj ajVar2 = hAG;
        AppMethodBeat.o(60123);
        return ajVar2;
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final String toString() {
        AppMethodBeat.i(60124);
        String str = ((Number) getValue()).longValue() + ".toULong()";
        AppMethodBeat.o(60124);
        return str;
    }
}
