package kotlin.l.b.a.b.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.m.a.l;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bh;

public final class c implements b {
    public l TIn;
    public final av TIo;

    public c(av avVar) {
        p.h(avVar, "projection");
        AppMethodBeat.i(60031);
        this.TIo = avVar;
        boolean z = this.TIo.hLI() != bh.INVARIANT;
        if (!aa.SXc || z) {
            AppMethodBeat.o(60031);
            return;
        }
        AssertionError assertionError = new AssertionError("Only nontrivial projections can be captured, not: " + this.TIo);
        AppMethodBeat.o(60031);
        throw assertionError;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final /* bridge */ /* synthetic */ h hzS() {
        return null;
    }

    @Override // kotlin.l.b.a.b.j.a.a.b
    public final av hKF() {
        return this.TIo;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final boolean hzU() {
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(60029);
        String str = "CapturedTypeConstructor(" + this.TIo + ')';
        AppMethodBeat.o(60029);
        return str;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final List<as> getParameters() {
        return v.SXr;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final Collection<ab> hBV() {
        aj hzj;
        AppMethodBeat.i(60028);
        if (this.TIo.hLI() == bh.OUT_VARIANCE) {
            hzj = this.TIo.hBy();
        } else {
            hzj = hBh().hzj();
        }
        p.g(hzj, "if (projection.projectio… builtIns.nullableAnyType");
        List listOf = j.listOf(hzj);
        AppMethodBeat.o(60028);
        return listOf;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final g hBh() {
        AppMethodBeat.i(60030);
        g hBh = this.TIo.hBy().hKE().hBh();
        p.g(hBh, "projection.type.constructor.builtIns");
        AppMethodBeat.o(60030);
        return hBh;
    }
}
