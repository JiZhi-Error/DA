package kotlin.l.b.a.b.m;

import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;
import kotlin.t;

public abstract class n extends aj {
    public abstract n b(aj ajVar);

    /* access modifiers changed from: protected */
    public abstract aj hDW();

    @Override // kotlin.l.b.a.b.b.a.a
    public g hzL() {
        return hDW().hzL();
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final at hKE() {
        return hDW().hKE();
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final List<av> hKB() {
        return hDW().hKB();
    }

    @Override // kotlin.l.b.a.b.m.ab
    public boolean hEa() {
        return hDW().hEa();
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final h hAp() {
        return hDW().hAp();
    }

    /* renamed from: i */
    public aj e(i iVar) {
        p.h(iVar, "kotlinTypeRefiner");
        ab aK = iVar.aK(hDW());
        if (aK != null) {
            return b((aj) aK);
        }
        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }
}
