package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.ag;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.m.n;
import kotlin.l.b.a.b.m.v;

public final class f extends n implements ag {
    private final aj TtS;

    public f(aj ajVar) {
        p.h(ajVar, "delegate");
        AppMethodBeat.i(58036);
        this.TtS = ajVar;
        AppMethodBeat.o(58036);
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg EF(boolean z) {
        AppMethodBeat.i(58034);
        aj EG = EG(z);
        AppMethodBeat.o(58034);
        return EG;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg b(g gVar) {
        AppMethodBeat.i(58031);
        f c2 = c(gVar);
        AppMethodBeat.o(58031);
        return c2;
    }

    @Override // kotlin.l.b.a.b.m.n
    public final /* synthetic */ n b(aj ajVar) {
        AppMethodBeat.i(58035);
        p.h(ajVar, "delegate");
        f fVar = new f(ajVar);
        AppMethodBeat.o(58035);
        return fVar;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final /* synthetic */ aj d(g gVar) {
        AppMethodBeat.i(58032);
        f c2 = c(gVar);
        AppMethodBeat.o(58032);
        return c2;
    }

    @Override // kotlin.l.b.a.b.m.n
    public final aj hDW() {
        return this.TtS;
    }

    @Override // kotlin.l.b.a.b.m.k
    public final boolean hDZ() {
        return true;
    }

    @Override // kotlin.l.b.a.b.m.k
    public final ab Q(ab abVar) {
        AppMethodBeat.i(58028);
        p.h(abVar, "replacement");
        bg hLF = abVar.hLF();
        if (!bc.aE(hLF) && !a.aH(hLF)) {
            bg bgVar = hLF;
            AppMethodBeat.o(58028);
            return bgVar;
        } else if (hLF instanceof aj) {
            aj a2 = a((aj) hLF);
            AppMethodBeat.o(58028);
            return a2;
        } else if (hLF instanceof v) {
            bg b2 = be.b(ac.a(a(((v) hLF).TNV), a(((v) hLF).TNW)), be.aJ(hLF));
            AppMethodBeat.o(58028);
            return b2;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Incorrect type: ".concat(String.valueOf(hLF)).toString());
            AppMethodBeat.o(58028);
            throw illegalStateException;
        }
    }

    @Override // kotlin.l.b.a.b.m.n, kotlin.l.b.a.b.m.ab
    public final boolean hEa() {
        return false;
    }

    private static aj a(aj ajVar) {
        AppMethodBeat.i(58029);
        aj EG = ajVar.EG(false);
        if (!a.aH(ajVar)) {
            AppMethodBeat.o(58029);
            return EG;
        }
        f fVar = new f(EG);
        AppMethodBeat.o(58029);
        return fVar;
    }

    private f c(g gVar) {
        AppMethodBeat.i(58030);
        p.h(gVar, "newAnnotations");
        f fVar = new f(this.TtS.d(gVar));
        AppMethodBeat.o(58030);
        return fVar;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final aj EG(boolean z) {
        AppMethodBeat.i(58033);
        if (z) {
            aj EG = this.TtS.EG(true);
            AppMethodBeat.o(58033);
            return EG;
        }
        f fVar = this;
        AppMethodBeat.o(58033);
        return fVar;
    }
}
