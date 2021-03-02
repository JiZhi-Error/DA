package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.o;
import kotlin.l.b.a.b.f.f;

public final class q extends d implements o {
    private final Object value;

    @Override // kotlin.l.b.a.b.d.a.e.o
    public final Object getValue() {
        return this.value;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(f fVar, Object obj) {
        super(fVar);
        p.h(obj, "value");
        AppMethodBeat.i(57485);
        this.value = obj;
        AppMethodBeat.o(57485);
    }
}
