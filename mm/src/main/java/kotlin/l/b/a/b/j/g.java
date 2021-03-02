package kotlin.l.b.a.b.j;

import kotlin.g.b.p;
import kotlin.l.b.a.b.b.b;

public abstract class g extends h {
    /* access modifiers changed from: protected */
    public abstract void a(b bVar, b bVar2);

    @Override // kotlin.l.b.a.b.j.h
    public final void b(b bVar, b bVar2) {
        p.h(bVar, "fromSuper");
        p.h(bVar2, "fromCurrent");
        a(bVar, bVar2);
    }

    @Override // kotlin.l.b.a.b.j.h
    public final void c(b bVar, b bVar2) {
        p.h(bVar, "first");
        p.h(bVar2, "second");
        a(bVar, bVar2);
    }
}
