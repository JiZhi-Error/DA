package kotlin.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.k.a.r;

public final class i implements r {
    public static final i TmN = new i();

    static {
        AppMethodBeat.i(57381);
        AppMethodBeat.o(57381);
    }

    private i() {
    }

    @Override // kotlin.l.b.a.b.k.a.r
    public final void a(e eVar, List<String> list) {
        AppMethodBeat.i(57379);
        p.h(eVar, "descriptor");
        p.h(list, "unresolvedSuperClasses");
        IllegalStateException illegalStateException = new IllegalStateException("Incomplete hierarchy for class " + eVar.hAH() + ", unresolved classes " + list);
        AppMethodBeat.o(57379);
        throw illegalStateException;
    }

    @Override // kotlin.l.b.a.b.k.a.r
    public final void h(b bVar) {
        AppMethodBeat.i(57380);
        p.h(bVar, "descriptor");
        IllegalStateException illegalStateException = new IllegalStateException("Cannot infer visibility for ".concat(String.valueOf(bVar)));
        AppMethodBeat.o(57380);
        throw illegalStateException;
    }
}
