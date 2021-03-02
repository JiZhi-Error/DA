package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.m;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.f;

public final class o extends d implements m {
    private final Enum<?> Tnq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(f fVar, Enum<?> r4) {
        super(fVar);
        p.h(r4, "value");
        AppMethodBeat.i(57481);
        this.Tnq = r4;
        AppMethodBeat.o(57481);
    }

    @Override // kotlin.l.b.a.b.d.a.e.m
    public final a hCY() {
        AppMethodBeat.i(57479);
        Class<?> cls = this.Tnq.getClass();
        if (!cls.isEnum()) {
            cls = cls.getEnclosingClass();
        }
        p.g(cls, "enumClass");
        a bB = b.bB(cls);
        AppMethodBeat.o(57479);
        return bB;
    }

    @Override // kotlin.l.b.a.b.d.a.e.m
    public final f hCZ() {
        AppMethodBeat.i(57480);
        f btY = f.btY(this.Tnq.name());
        AppMethodBeat.o(57480);
        return btY;
    }
}
