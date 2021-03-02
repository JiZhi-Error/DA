package kotlin.l.b.a.b.m;

import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;

public abstract class o extends n {
    private final aj TtS;

    public o(aj ajVar) {
        p.h(ajVar, "delegate");
        this.TtS = ajVar;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.m.n
    public final aj hDW() {
        return this.TtS;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public o d(g gVar) {
        p.h(gVar, "newAnnotations");
        if (gVar != hzL()) {
            return new i(this, gVar);
        }
        return this;
    }

    @Override // kotlin.l.b.a.b.m.aj
    /* renamed from: EG */
    public final aj EF(boolean z) {
        if (z == hEa()) {
            return this;
        }
        return this.TtS.EG(z).d(hzL());
    }
}
