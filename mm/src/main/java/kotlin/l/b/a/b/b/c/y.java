package kotlin.l.b.a.b.b.c;

import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.f.b;
import kotlin.t;

public abstract class y extends k implements ab {
    public final b TiI;

    @Override // kotlin.l.b.a.b.b.ab
    public final b hBk() {
        return this.TiI;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(kotlin.l.b.a.b.b.y yVar, b bVar) {
        super(yVar, g.a.hBP(), bVar.hJh(), an.ThK);
        p.h(yVar, "module");
        p.h(bVar, "fqName");
        g.a aVar = g.TiC;
        this.TiI = bVar;
    }

    @Override // kotlin.l.b.a.b.b.l
    public final <R, D> R a(n<R, D> nVar, D d2) {
        p.h(nVar, "visitor");
        return nVar.a(this, d2);
    }

    @Override // kotlin.l.b.a.b.b.ab
    /* renamed from: hBj */
    public final kotlin.l.b.a.b.b.y hzx() {
        l hzx = super.hzx();
        if (hzx != null) {
            return (kotlin.l.b.a.b.b.y) hzx;
        }
        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
    }

    @Override // kotlin.l.b.a.b.b.c.k, kotlin.l.b.a.b.b.o
    public an hzM() {
        an anVar = an.ThK;
        p.g(anVar, "SourceElement.NO_SOURCE");
        return anVar;
    }

    @Override // kotlin.l.b.a.b.b.c.j
    public String toString() {
        return "package " + this.TiI;
    }
}
