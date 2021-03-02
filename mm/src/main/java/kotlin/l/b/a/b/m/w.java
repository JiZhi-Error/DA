package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.m.a.g;
import kotlin.l.b.a.b.m.a.i;
import kotlin.m;
import kotlin.t;

public final class w extends v implements k {
    public static final a TNY = new a((byte) 0);
    public static boolean TNk;
    private boolean TNX;

    static {
        AppMethodBeat.i(60738);
        AppMethodBeat.o(60738);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(aj ajVar, aj ajVar2) {
        super(ajVar, ajVar2);
        p.h(ajVar, "lowerBound");
        p.h(ajVar2, "upperBound");
        AppMethodBeat.i(60737);
        AppMethodBeat.o(60737);
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final /* synthetic */ ab d(i iVar) {
        AppMethodBeat.i(60735);
        v c2 = c(iVar);
        AppMethodBeat.o(60735);
        return c2;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg e(i iVar) {
        AppMethodBeat.i(60736);
        v c2 = c(iVar);
        AppMethodBeat.o(60736);
        return c2;
    }

    @Override // kotlin.l.b.a.b.m.k
    public final ab Q(ab abVar) {
        bg a2;
        AppMethodBeat.i(60730);
        p.h(abVar, "replacement");
        bg hLF = abVar.hLF();
        if (hLF instanceof v) {
            a2 = hLF;
        } else if (hLF instanceof aj) {
            a2 = ac.a((aj) hLF, ((aj) hLF).EG(true));
        } else {
            m mVar = new m();
            AppMethodBeat.o(60730);
            throw mVar;
        }
        bg a3 = be.a(a2, hLF);
        AppMethodBeat.o(60730);
        return a3;
    }

    @Override // kotlin.l.b.a.b.m.v
    public final String a(c cVar, kotlin.l.b.a.b.i.i iVar) {
        AppMethodBeat.i(60732);
        p.h(cVar, "renderer");
        p.h(iVar, "options");
        if (iVar.hJW()) {
            String str = "(" + cVar.b(this.TNV) + ".." + cVar.b(this.TNW) + ')';
            AppMethodBeat.o(60732);
            return str;
        }
        String a2 = cVar.a(cVar.b(this.TNV), cVar.b(this.TNW), kotlin.l.b.a.b.m.d.a.aM(this));
        AppMethodBeat.o(60732);
        return a2;
    }

    private v c(i iVar) {
        AppMethodBeat.i(60734);
        p.h(iVar, "kotlinTypeRefiner");
        ab aK = iVar.aK(this.TNV);
        if (aK == null) {
            t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            AppMethodBeat.o(60734);
            throw tVar;
        }
        aj ajVar = (aj) aK;
        ab aK2 = iVar.aK(this.TNW);
        if (aK2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            AppMethodBeat.o(60734);
            throw tVar2;
        }
        w wVar = new w(ajVar, (aj) aK2);
        AppMethodBeat.o(60734);
        return wVar;
    }

    @Override // kotlin.l.b.a.b.m.v
    public final aj hDW() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(60728);
        if (TNk && !this.TNX) {
            this.TNX = true;
            if (!y.al(this.TNV)) {
                z = true;
            } else {
                z = false;
            }
            if (!aa.SXc || z) {
                if (y.al(this.TNW)) {
                    z2 = false;
                }
                if (!aa.SXc || z2) {
                    boolean z3 = !p.j(this.TNV, this.TNW);
                    if (!aa.SXc || z3) {
                        boolean c2 = g.TPc.c(this.TNV, this.TNW);
                        if (aa.SXc && !c2) {
                            AssertionError assertionError = new AssertionError("Lower bound " + this.TNV + " of a flexible type must be a subtype of the upper bound " + this.TNW);
                            AppMethodBeat.o(60728);
                            throw assertionError;
                        }
                    } else {
                        AssertionError assertionError2 = new AssertionError("Lower and upper bounds are equal: " + this.TNV + " == " + this.TNW);
                        AppMethodBeat.o(60728);
                        throw assertionError2;
                    }
                } else {
                    AssertionError assertionError3 = new AssertionError("Upper bound of a flexible type can not be flexible: " + this.TNW);
                    AppMethodBeat.o(60728);
                    throw assertionError3;
                }
            } else {
                AssertionError assertionError4 = new AssertionError("Lower bound of a flexible type can not be flexible: " + this.TNV);
                AppMethodBeat.o(60728);
                throw assertionError4;
            }
        }
        aj ajVar = this.TNV;
        AppMethodBeat.o(60728);
        return ajVar;
    }

    @Override // kotlin.l.b.a.b.m.k
    public final boolean hDZ() {
        AppMethodBeat.i(60729);
        if (!(this.TNV.hKE().hzS() instanceof as) || !p.j(this.TNV.hKE(), this.TNW.hKE())) {
            AppMethodBeat.o(60729);
            return false;
        }
        AppMethodBeat.o(60729);
        return true;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final bg b(kotlin.l.b.a.b.b.a.g gVar) {
        AppMethodBeat.i(60731);
        p.h(gVar, "newAnnotations");
        bg a2 = ac.a(this.TNV.d(gVar), this.TNW.d(gVar));
        AppMethodBeat.o(60731);
        return a2;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final bg EF(boolean z) {
        AppMethodBeat.i(60733);
        bg a2 = ac.a(this.TNV.EG(z), this.TNW.EG(z));
        AppMethodBeat.o(60733);
        return a2;
    }
}
