package kotlin.l.b.a.b.j;

import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.b;

public abstract class h {
    public abstract void b(b bVar, b bVar2);

    public abstract void c(b bVar, b bVar2);

    public abstract void e(b bVar);

    public void a(b bVar, Collection<? extends b> collection) {
        p.h(bVar, "member");
        p.h(collection, "overridden");
        bVar.x(collection);
    }
}
