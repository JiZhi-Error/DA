package kotlin.l.b.a.b.m;

import java.util.List;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.j.f.h;
import kotlin.t;

public abstract class bi extends ab {
    /* access modifiers changed from: protected */
    public abstract ab hLG();

    public bi() {
        super((byte) 0);
    }

    public boolean hLt() {
        return true;
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public final g hzL() {
        return hLG().hzL();
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final at hKE() {
        return hLG().hKE();
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final List<av> hKB() {
        return hLG().hKB();
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final boolean hEa() {
        return hLG().hEa();
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final h hAp() {
        return hLG().hAp();
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final bg hLF() {
        ab hLG = hLG();
        while (hLG instanceof bi) {
            hLG = ((bi) hLG).hLG();
        }
        if (hLG != null) {
            return (bg) hLG;
        }
        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
    }

    public String toString() {
        if (hLt()) {
            return hLG().toString();
        }
        return "<Not computed yet>";
    }
}
