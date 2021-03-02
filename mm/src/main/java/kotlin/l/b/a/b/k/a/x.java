package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.f;

public final class x {
    public static final a a(c cVar, int i2) {
        AppMethodBeat.i(60342);
        p.h(cVar, "$this$getClassId");
        a dT = a.dT(cVar.avl(i2), cVar.avm(i2));
        p.g(dT, "ClassId.fromString(getQu… isLocalClassName(index))");
        AppMethodBeat.o(60342);
        return dT;
    }

    public static final f b(c cVar, int i2) {
        AppMethodBeat.i(60343);
        p.h(cVar, "$this$getName");
        f bub = f.bub(cVar.getString(i2));
        p.g(bub, "Name.guessByFirstCharacter(getString(index))");
        AppMethodBeat.o(60343);
        return bub;
    }
}
