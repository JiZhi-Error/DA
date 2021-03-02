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

public final class x extends aa<Integer> {
    public x(int i2) {
        super(Integer.valueOf(i2));
        AppMethodBeat.i(60122);
        AppMethodBeat.o(60122);
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final ab b(y yVar) {
        aj hAG;
        AppMethodBeat.i(60120);
        p.h(yVar, "module");
        a aVar = g.TcO.Tel;
        p.g(aVar, "KotlinBuiltIns.FQ_NAMES.uInt");
        e b2 = s.b(yVar, aVar);
        if (b2 == null || (hAG = b2.hAG()) == null) {
            aj bun = u.bun("Unsigned type UInt not found");
            p.g(bun, "ErrorUtils.createErrorTy…ned type UInt not found\")");
            aj ajVar = bun;
            AppMethodBeat.o(60120);
            return ajVar;
        }
        aj ajVar2 = hAG;
        AppMethodBeat.o(60120);
        return ajVar2;
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final String toString() {
        AppMethodBeat.i(60121);
        String str = ((Number) getValue()).intValue() + ".toUInt()";
        AppMethodBeat.o(60121);
        return str;
    }
}
