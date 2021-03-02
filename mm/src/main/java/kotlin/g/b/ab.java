package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b;
import kotlin.l.e;
import kotlin.l.g;
import kotlin.l.h;
import kotlin.l.l;
import kotlin.l.m;

public class ab {
    public b bp(Class cls) {
        AppMethodBeat.i(128959);
        h hVar = new h(cls);
        AppMethodBeat.o(128959);
        return hVar;
    }

    public String a(q qVar) {
        AppMethodBeat.i(128960);
        String a2 = a((m) qVar);
        AppMethodBeat.o(128960);
        return a2;
    }

    public String a(m mVar) {
        AppMethodBeat.i(128961);
        String obj = mVar.getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            String substring = obj.substring(21);
            AppMethodBeat.o(128961);
            return substring;
        }
        AppMethodBeat.o(128961);
        return obj;
    }

    public e a(n nVar) {
        return nVar;
    }

    public l a(ag agVar) {
        return agVar;
    }

    public g a(t tVar) {
        return tVar;
    }

    public m a(x xVar) {
        return xVar;
    }

    public h a(u uVar) {
        return uVar;
    }
}
