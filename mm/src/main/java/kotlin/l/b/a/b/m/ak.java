package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.u;

/* access modifiers changed from: package-private */
public final class ak extends aj {
    private final boolean TIm;
    private final at TNJ;
    private final b<i, aj> TOs;
    private final List<av> ThC;
    private final h Tly;

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg EF(boolean z) {
        AppMethodBeat.i(60787);
        aj EG = EG(z);
        AppMethodBeat.o(60787);
        return EG;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg b(g gVar) {
        AppMethodBeat.i(60785);
        aj d2 = d(gVar);
        AppMethodBeat.o(60785);
        return d2;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final /* synthetic */ ab d(i iVar) {
        AppMethodBeat.i(60789);
        aj i2 = i(iVar);
        AppMethodBeat.o(60789);
        return i2;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg e(i iVar) {
        AppMethodBeat.i(60790);
        aj i2 = i(iVar);
        AppMethodBeat.o(60790);
        return i2;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final at hKE() {
        return this.TNJ;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final List<av> hKB() {
        return this.ThC;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final boolean hEa() {
        return this.TIm;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final h hAp() {
        return this.Tly;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<? extends kotlin.l.b.a.b.m.av> */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: kotlin.g.a.b<? super kotlin.l.b.a.b.m.a.i, ? extends kotlin.l.b.a.b.m.aj> */
    /* JADX WARN: Multi-variable type inference failed */
    public ak(at atVar, List<? extends av> list, boolean z, h hVar, b<? super i, ? extends aj> bVar) {
        p.h(atVar, "constructor");
        p.h(list, "arguments");
        p.h(hVar, "memberScope");
        p.h(bVar, "refinedTypeFactory");
        AppMethodBeat.i(60791);
        this.TNJ = atVar;
        this.ThC = list;
        this.TIm = z;
        this.Tly = hVar;
        this.TOs = bVar;
        if (this.Tly instanceof u.b) {
            IllegalStateException illegalStateException = new IllegalStateException("SimpleTypeImpl should not be created for error type: " + this.Tly + '\n' + this.TNJ);
            AppMethodBeat.o(60791);
            throw illegalStateException;
        }
        AppMethodBeat.o(60791);
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public final g hzL() {
        AppMethodBeat.i(60783);
        g.a aVar = g.TiC;
        g hBP = g.a.hBP();
        AppMethodBeat.o(60783);
        return hBP;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final aj d(g gVar) {
        AppMethodBeat.i(60784);
        p.h(gVar, "newAnnotations");
        if (gVar.isEmpty()) {
            ak akVar = this;
            AppMethodBeat.o(60784);
            return akVar;
        }
        i iVar = new i(this, gVar);
        AppMethodBeat.o(60784);
        return iVar;
    }

    private aj i(i iVar) {
        AppMethodBeat.i(60788);
        p.h(iVar, "kotlinTypeRefiner");
        aj invoke = this.TOs.invoke(iVar);
        ak akVar = invoke == null ? this : invoke;
        AppMethodBeat.o(60788);
        return akVar;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final aj EG(boolean z) {
        AppMethodBeat.i(60786);
        if (z == this.TIm) {
            ak akVar = this;
            AppMethodBeat.o(60786);
            return akVar;
        } else if (z) {
            ah ahVar = new ah(this);
            AppMethodBeat.o(60786);
            return ahVar;
        } else {
            af afVar = new af(this);
            AppMethodBeat.o(60786);
            return afVar;
        }
    }
}
