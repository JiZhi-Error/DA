package kotlin.l.b.a.b.b;

import kotlin.g.b.p;
import kotlin.l.b.a.b.j.f.a.e;

public abstract class ba {
    public final boolean Tig;
    private final String name;

    public abstract boolean b(e eVar, p pVar, l lVar);

    protected ba(String str, boolean z) {
        p.h(str, "name");
        this.name = str;
        this.Tig = z;
    }

    /* access modifiers changed from: protected */
    public Integer c(ba baVar) {
        p.h(baVar, "visibility");
        return az.a(this, baVar);
    }

    public String hBM() {
        return this.name;
    }

    public final String toString() {
        return hBM();
    }

    public ba hBN() {
        return this;
    }
}
