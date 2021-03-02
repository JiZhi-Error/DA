package kotlin.l.b.a.b.m;

import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.i.i;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.c.g;

public abstract class v extends bg implements ar, g {
    public final aj TNV;
    public final aj TNW;

    public abstract String a(c cVar, i iVar);

    public abstract aj hDW();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(aj ajVar, aj ajVar2) {
        super((byte) 0);
        p.h(ajVar, "lowerBound");
        p.h(ajVar2, "upperBound");
        this.TNV = ajVar;
        this.TNW = ajVar2;
    }

    @Override // kotlin.l.b.a.b.m.ar
    public final ab hKC() {
        return this.TNV;
    }

    @Override // kotlin.l.b.a.b.m.ar
    public final ab hKD() {
        return this.TNW;
    }

    @Override // kotlin.l.b.a.b.m.ar
    public final boolean ac(ab abVar) {
        p.h(abVar, "type");
        return false;
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public kotlin.l.b.a.b.b.a.g hzL() {
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
    public h hAp() {
        return hDW().hAp();
    }

    public String toString() {
        return c.TFj.b(this);
    }
}
