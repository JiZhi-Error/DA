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

public final class w extends aa<Byte> {
    public w(byte b2) {
        super(Byte.valueOf(b2));
        AppMethodBeat.i(60119);
        AppMethodBeat.o(60119);
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final ab b(y yVar) {
        aj hAG;
        AppMethodBeat.i(60117);
        p.h(yVar, "module");
        a aVar = g.TcO.Tej;
        p.g(aVar, "KotlinBuiltIns.FQ_NAMES.uByte");
        e b2 = s.b(yVar, aVar);
        if (b2 == null || (hAG = b2.hAG()) == null) {
            aj bun = u.bun("Unsigned type UByte not found");
            p.g(bun, "ErrorUtils.createErrorTy…ed type UByte not found\")");
            aj ajVar = bun;
            AppMethodBeat.o(60117);
            return ajVar;
        }
        aj ajVar2 = hAG;
        AppMethodBeat.o(60117);
        return ajVar2;
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final String toString() {
        AppMethodBeat.i(60118);
        String str = ((int) ((Number) getValue()).byteValue()) + ".toUByte()";
        AppMethodBeat.o(60118);
        return str;
    }
}
