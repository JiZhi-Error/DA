package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;

public final class s extends p<Long> {
    public s(long j2) {
        super(Long.valueOf(j2));
        AppMethodBeat.i(60109);
        AppMethodBeat.o(60109);
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final /* synthetic */ ab b(y yVar) {
        AppMethodBeat.i(60107);
        p.h(yVar, "module");
        aj hzo = yVar.hBh().hzo();
        p.g(hzo, "module.builtIns.longType");
        aj ajVar = hzo;
        AppMethodBeat.o(60107);
        return ajVar;
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final String toString() {
        AppMethodBeat.i(60108);
        String str = ((Number) getValue()).longValue() + ".toLong()";
        AppMethodBeat.o(60108);
        return str;
    }
}
