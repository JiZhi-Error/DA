package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.m.a.i;
import kotlin.t;

public final class a extends n {
    public final aj TNh;
    public final aj TtS;

    public a(aj ajVar, aj ajVar2) {
        p.h(ajVar, "delegate");
        p.h(ajVar2, "abbreviation");
        AppMethodBeat.i(60568);
        this.TtS = ajVar;
        this.TNh = ajVar2;
        AppMethodBeat.o(60568);
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg EF(boolean z) {
        AppMethodBeat.i(60561);
        a ET = ET(z);
        AppMethodBeat.o(60561);
        return ET;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final /* synthetic */ aj EG(boolean z) {
        AppMethodBeat.i(60562);
        a ET = ET(z);
        AppMethodBeat.o(60562);
        return ET;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg b(g gVar) {
        AppMethodBeat.i(60558);
        a f2 = f(gVar);
        AppMethodBeat.o(60558);
        return f2;
    }

    @Override // kotlin.l.b.a.b.m.n
    public final /* synthetic */ n b(aj ajVar) {
        AppMethodBeat.i(60563);
        p.h(ajVar, "delegate");
        a aVar = new a(ajVar, this.TNh);
        AppMethodBeat.o(60563);
        return aVar;
    }

    @Override // kotlin.l.b.a.b.m.n, kotlin.l.b.a.b.m.ab
    public final /* synthetic */ ab d(i iVar) {
        AppMethodBeat.i(60565);
        a h2 = h(iVar);
        AppMethodBeat.o(60565);
        return h2;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final /* synthetic */ aj d(g gVar) {
        AppMethodBeat.i(60559);
        a f2 = f(gVar);
        AppMethodBeat.o(60559);
        return f2;
    }

    @Override // kotlin.l.b.a.b.m.bg, kotlin.l.b.a.b.m.n
    public final /* synthetic */ bg e(i iVar) {
        AppMethodBeat.i(60566);
        a h2 = h(iVar);
        AppMethodBeat.o(60566);
        return h2;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.m.n
    public final aj hDW() {
        return this.TtS;
    }

    @Override // kotlin.l.b.a.b.m.n
    public final /* synthetic */ aj i(i iVar) {
        AppMethodBeat.i(60567);
        a h2 = h(iVar);
        AppMethodBeat.o(60567);
        return h2;
    }

    private a f(g gVar) {
        AppMethodBeat.i(60557);
        p.h(gVar, "newAnnotations");
        a aVar = new a(this.TtS.d(gVar), this.TNh);
        AppMethodBeat.o(60557);
        return aVar;
    }

    private a ET(boolean z) {
        AppMethodBeat.i(60560);
        a aVar = new a(this.TtS.EG(z), this.TNh.EG(z));
        AppMethodBeat.o(60560);
        return aVar;
    }

    private a h(i iVar) {
        AppMethodBeat.i(60564);
        p.h(iVar, "kotlinTypeRefiner");
        ab aK = iVar.aK(this.TtS);
        if (aK == null) {
            t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            AppMethodBeat.o(60564);
            throw tVar;
        }
        aj ajVar = (aj) aK;
        ab aK2 = iVar.aK(this.TNh);
        if (aK2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            AppMethodBeat.o(60564);
            throw tVar2;
        }
        a aVar = new a(ajVar, (aj) aK2);
        AppMethodBeat.o(60564);
        return aVar;
    }
}
