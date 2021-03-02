package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Set;
import kotlin.g.b.p;

public final class v implements u {
    private final List<w> TlI;
    private final Set<w> TlJ;
    private final List<w> TlK;

    public v(List<w> list, Set<w> set, List<w> list2) {
        p.h(list, "allDependencies");
        p.h(set, "modulesWhoseInternalsAreVisible");
        p.h(list2, "expectedByDependencies");
        AppMethodBeat.i(57170);
        this.TlI = list;
        this.TlJ = set;
        this.TlK = list2;
        AppMethodBeat.o(57170);
    }

    @Override // kotlin.l.b.a.b.b.c.u
    public final List<w> hCg() {
        return this.TlI;
    }

    @Override // kotlin.l.b.a.b.b.c.u
    public final Set<w> hCh() {
        return this.TlJ;
    }

    @Override // kotlin.l.b.a.b.b.c.u
    public final List<w> hCi() {
        return this.TlK;
    }
}
