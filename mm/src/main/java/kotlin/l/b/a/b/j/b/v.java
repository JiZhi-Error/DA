package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;

public final class v extends g<String> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(String str) {
        super(str);
        p.h(str, "value");
        AppMethodBeat.i(60116);
        AppMethodBeat.o(60116);
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final /* synthetic */ ab b(y yVar) {
        AppMethodBeat.i(60114);
        p.h(yVar, "module");
        aj hzr = yVar.hBh().hzr();
        p.g(hzr, "module.builtIns.stringType");
        aj ajVar = hzr;
        AppMethodBeat.o(60114);
        return ajVar;
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final String toString() {
        AppMethodBeat.i(60115);
        String str = "\"" + ((String) getValue()) + '\"';
        AppMethodBeat.o(60115);
        return str;
    }
}
