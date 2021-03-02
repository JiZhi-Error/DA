package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;

public final class b extends g<List<? extends g<?>>> {
    private final kotlin.g.a.b<y, ab> TIs;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.g.a.b<? super kotlin.l.b.a.b.b.y, ? extends kotlin.l.b.a.b.m.ab> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(List<? extends g<?>> list, kotlin.g.a.b<? super y, ? extends ab> bVar) {
        super(list);
        p.h(list, "value");
        p.h(bVar, "computeType");
        AppMethodBeat.i(60041);
        this.TIs = bVar;
        AppMethodBeat.o(60041);
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final ab b(y yVar) {
        AppMethodBeat.i(60040);
        p.h(yVar, "module");
        ab invoke = this.TIs.invoke(yVar);
        ab abVar = invoke;
        boolean z = g.m(abVar) || g.n(abVar);
        if (!aa.SXc || z) {
            ab abVar2 = invoke;
            AppMethodBeat.o(60040);
            return abVar2;
        }
        AssertionError assertionError = new AssertionError("Type should be an array, but was " + abVar + ": " + ((List) getValue()));
        AppMethodBeat.o(60040);
        throw assertionError;
    }
}
