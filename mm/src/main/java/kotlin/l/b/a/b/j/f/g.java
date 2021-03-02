package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.l.f;

public final class g extends a {
    private final f<h> TJV;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.l.b.a.b.l.f<? extends kotlin.l.b.a.b.j.f.h> */
    /* JADX WARN: Multi-variable type inference failed */
    public g(f<? extends h> fVar) {
        p.h(fVar, "scope");
        AppMethodBeat.i(60212);
        this.TJV = fVar;
        AppMethodBeat.o(60212);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.j.f.a
    public final h hKM() {
        AppMethodBeat.i(60211);
        h hVar = (h) this.TJV.invoke();
        AppMethodBeat.o(60211);
        return hVar;
    }
}
