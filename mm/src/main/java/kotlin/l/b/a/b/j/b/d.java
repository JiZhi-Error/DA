package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;

public final class d extends p<Byte> {
    public d(byte b2) {
        super(Byte.valueOf(b2));
        AppMethodBeat.i(60046);
        AppMethodBeat.o(60046);
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final /* synthetic */ ab b(y yVar) {
        AppMethodBeat.i(60044);
        p.h(yVar, "module");
        aj hzl = yVar.hBh().hzl();
        p.g(hzl, "module.builtIns.byteType");
        aj ajVar = hzl;
        AppMethodBeat.o(60044);
        return ajVar;
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final String toString() {
        AppMethodBeat.i(60045);
        String str = ((int) ((Number) getValue()).byteValue()) + ".toByte()";
        AppMethodBeat.o(60045);
        return str;
    }
}
