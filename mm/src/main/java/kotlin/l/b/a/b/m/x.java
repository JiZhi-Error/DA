package kotlin.l.b.a.b.m;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.m.a.i;
import kotlin.t;

public final class x extends v implements bd {
    private final v TNZ;
    private final ab TOa;

    @Override // kotlin.l.b.a.b.m.ab
    public final /* synthetic */ ab d(i iVar) {
        AppMethodBeat.i(60744);
        x k = k(iVar);
        AppMethodBeat.o(60744);
        return k;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg e(i iVar) {
        AppMethodBeat.i(60745);
        x k = k(iVar);
        AppMethodBeat.o(60745);
        return k;
    }

    @Override // kotlin.l.b.a.b.m.bd
    public final ab hLD() {
        return this.TOa;
    }

    @Override // kotlin.l.b.a.b.m.v
    public final String a(c cVar, kotlin.l.b.a.b.i.i iVar) {
        AppMethodBeat.i(60741);
        p.h(cVar, "renderer");
        p.h(iVar, "options");
        if (iVar.hJX()) {
            String b2 = cVar.b(this.TOa);
            AppMethodBeat.o(60741);
            return b2;
        }
        String a2 = this.TNZ.a(cVar, iVar);
        AppMethodBeat.o(60741);
        return a2;
    }

    private x k(i iVar) {
        AppMethodBeat.i(60743);
        p.h(iVar, "kotlinTypeRefiner");
        ab aK = iVar.aK(this.TNZ);
        if (aK == null) {
            t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
            AppMethodBeat.o(60743);
            throw tVar;
        }
        x xVar = new x((v) aK, iVar.aK(this.TOa));
        AppMethodBeat.o(60743);
        return xVar;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final bg b(g gVar) {
        AppMethodBeat.i(60739);
        p.h(gVar, "newAnnotations");
        bg b2 = be.b(this.TNZ.b(gVar), this.TOa);
        AppMethodBeat.o(60739);
        return b2;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final bg EF(boolean z) {
        AppMethodBeat.i(60740);
        bg b2 = be.b(this.TNZ.EF(z), this.TOa.hLF().EF(z));
        AppMethodBeat.o(60740);
        return b2;
    }

    @Override // kotlin.l.b.a.b.m.v
    public final aj hDW() {
        AppMethodBeat.i(60742);
        aj hDW = this.TNZ.hDW();
        AppMethodBeat.o(60742);
        return hDW;
    }

    @Override // kotlin.l.b.a.b.m.bd
    public final /* bridge */ /* synthetic */ bg hLC() {
        return this.TNZ;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(v vVar, ab abVar) {
        super(vVar.TNV, vVar.TNW);
        p.h(vVar, FirebaseAnalytics.b.ORIGIN);
        p.h(abVar, "enhancement");
        AppMethodBeat.i(60746);
        this.TNZ = vVar;
        this.TOa = abVar;
        AppMethodBeat.o(60746);
    }
}
