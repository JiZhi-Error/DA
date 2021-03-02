package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;

public final class u extends n implements t {
    private final b TiI;

    public u(b bVar) {
        p.h(bVar, "fqName");
        AppMethodBeat.i(57501);
        this.TiI = bVar;
        AppMethodBeat.o(57501);
    }

    @Override // kotlin.l.b.a.b.d.a.e.t
    public final b hBk() {
        return this.TiI;
    }

    @Override // kotlin.l.b.a.b.d.a.e.d
    public final a l(b bVar) {
        AppMethodBeat.i(57497);
        p.h(bVar, "fqName");
        AppMethodBeat.o(57497);
        return null;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(57498);
        if (!(obj instanceof u) || !p.j(this.TiI, ((u) obj).TiI)) {
            AppMethodBeat.o(57498);
            return false;
        }
        AppMethodBeat.o(57498);
        return true;
    }

    public final String toString() {
        AppMethodBeat.i(57500);
        String str = getClass().getName() + ": " + this.TiI;
        AppMethodBeat.o(57500);
        return str;
    }

    @Override // kotlin.l.b.a.b.d.a.e.t
    public final Collection<g> S(kotlin.g.a.b<? super f, Boolean> bVar) {
        AppMethodBeat.i(57496);
        p.h(bVar, "nameFilter");
        v vVar = v.SXr;
        AppMethodBeat.o(57496);
        return vVar;
    }

    @Override // kotlin.l.b.a.b.d.a.e.t
    public final Collection<t> hDg() {
        return v.SXr;
    }

    @Override // kotlin.l.b.a.b.d.a.e.d
    public final /* bridge */ /* synthetic */ Collection hCP() {
        return v.SXr;
    }

    public final int hashCode() {
        AppMethodBeat.i(57499);
        int hashCode = this.TiI.hashCode();
        AppMethodBeat.o(57499);
        return hashCode;
    }
}
