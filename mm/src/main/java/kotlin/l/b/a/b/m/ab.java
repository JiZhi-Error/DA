package kotlin.l.b.a.b.m;

import java.util.List;
import kotlin.l.b.a.b.b.a.a;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.a.t;
import kotlin.l.b.a.b.m.c.h;

public abstract class ab implements a, h {
    private int TOg;

    public abstract ab d(i iVar);

    public abstract kotlin.l.b.a.b.j.f.h hAp();

    public abstract boolean hEa();

    public abstract List<av> hKB();

    public abstract at hKE();

    public abstract bg hLF();

    private ab() {
    }

    public /* synthetic */ ab(byte b2) {
        this();
    }

    public final int hashCode() {
        int i2 = this.TOg;
        if (i2 == 0) {
            if (ad.ap(this)) {
                i2 = super.hashCode();
            } else {
                i2 = (hEa() ? 1 : 0) + (((hKE().hashCode() * 31) + hKB().hashCode()) * 31);
            }
            this.TOg = i2;
        }
        return i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ab)) {
            return false;
        }
        if (hEa() == ((ab) obj).hEa()) {
            t tVar = t.TPw;
            if (t.a(hLF(), ((ab) obj).hLF())) {
                return true;
            }
        }
        return false;
    }
}
