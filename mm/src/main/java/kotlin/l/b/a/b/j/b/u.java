package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;

public final class u extends p<Short> {
    public u(short s) {
        super(Short.valueOf(s));
        AppMethodBeat.i(60113);
        AppMethodBeat.o(60113);
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final /* synthetic */ ab b(y yVar) {
        AppMethodBeat.i(60111);
        p.h(yVar, "module");
        aj hzm = yVar.hBh().hzm();
        p.g(hzm, "module.builtIns.shortType");
        aj ajVar = hzm;
        AppMethodBeat.o(60111);
        return ajVar;
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final String toString() {
        AppMethodBeat.i(60112);
        String str = ((int) ((Number) getValue()).shortValue()) + ".toShort()";
        AppMethodBeat.o(60112);
        return str;
    }
}
