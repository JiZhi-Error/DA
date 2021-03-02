package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.m.a.i;
import kotlin.t;

public final class al extends n implements bd {
    private final ab TOa;
    private final aj TtS;

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg EF(boolean z) {
        AppMethodBeat.i(60795);
        aj EG = EG(z);
        AppMethodBeat.o(60795);
        return EG;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg b(g gVar) {
        AppMethodBeat.i(60793);
        aj d2 = d(gVar);
        AppMethodBeat.o(60793);
        return d2;
    }

    @Override // kotlin.l.b.a.b.m.n
    public final /* synthetic */ n b(aj ajVar) {
        AppMethodBeat.i(60796);
        p.h(ajVar, "delegate");
        al alVar = new al(ajVar, this.TOa);
        AppMethodBeat.o(60796);
        return alVar;
    }

    @Override // kotlin.l.b.a.b.m.n, kotlin.l.b.a.b.m.ab
    public final /* synthetic */ ab d(i iVar) {
        AppMethodBeat.i(60798);
        al l = l(iVar);
        AppMethodBeat.o(60798);
        return l;
    }

    @Override // kotlin.l.b.a.b.m.bg, kotlin.l.b.a.b.m.n
    public final /* synthetic */ bg e(i iVar) {
        AppMethodBeat.i(60799);
        al l = l(iVar);
        AppMethodBeat.o(60799);
        return l;
    }

    @Override // kotlin.l.b.a.b.m.n
    public final /* synthetic */ aj i(i iVar) {
        AppMethodBeat.i(60800);
        al l = l(iVar);
        AppMethodBeat.o(60800);
        return l;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.m.n
    public final aj hDW() {
        return this.TtS;
    }

    @Override // kotlin.l.b.a.b.m.bd
    public final ab hLD() {
        return this.TOa;
    }

    public al(aj ajVar, ab abVar) {
        p.h(ajVar, "delegate");
        p.h(abVar, "enhancement");
        AppMethodBeat.i(60801);
        this.TtS = ajVar;
        this.TOa = abVar;
        AppMethodBeat.o(60801);
    }

    private al l(i iVar) {
        AppMethodBeat.i(60797);
        p.h(iVar, "kotlinTypeRefiner");
        ab aK = iVar.aK(this.TtS);
        if (aK == null) {
            t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            AppMethodBeat.o(60797);
            throw tVar;
        }
        al alVar = new al((aj) aK, iVar.aK(this.TOa));
        AppMethodBeat.o(60797);
        return alVar;
    }

    @Override // kotlin.l.b.a.b.m.bd
    public final bg hLC() {
        return this.TtS;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final aj d(g gVar) {
        AppMethodBeat.i(60792);
        p.h(gVar, "newAnnotations");
        bg b2 = be.b(this.TtS.b(gVar), this.TOa);
        if (b2 == null) {
            t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            AppMethodBeat.o(60792);
            throw tVar;
        }
        aj ajVar = (aj) b2;
        AppMethodBeat.o(60792);
        return ajVar;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final aj EG(boolean z) {
        AppMethodBeat.i(60794);
        bg b2 = be.b(this.TtS.EF(z), this.TOa.hLF().EF(z));
        if (b2 == null) {
            t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            AppMethodBeat.o(60794);
            throw tVar;
        }
        aj ajVar = (aj) b2;
        AppMethodBeat.o(60794);
        return ajVar;
    }
}
