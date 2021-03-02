package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.d.b.w;
import kotlin.l.b.a.b.d.a.e.h;
import kotlin.l.b.a.b.d.a.e.v;
import kotlin.l.b.a.b.f.f;

public final class k extends d implements h {
    private final Class<?> TmJ;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(f fVar, Class<?> cls) {
        super(fVar);
        p.h(cls, "klass");
        AppMethodBeat.i(57469);
        this.TmJ = cls;
        AppMethodBeat.o(57469);
    }

    @Override // kotlin.l.b.a.b.d.a.e.h
    public final v hCS() {
        AppMethodBeat.i(57468);
        w.a aVar = w.Tnu;
        w b2 = w.a.b(this.TmJ);
        AppMethodBeat.o(57468);
        return b2;
    }
}
