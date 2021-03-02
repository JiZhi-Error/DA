package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b;

public final class k {
    public static final b z(Collection<? extends b> collection) {
        AppMethodBeat.i(60010);
        p.h(collection, "descriptors");
        boolean z = !collection.isEmpty();
        if (!aa.SXc || z) {
            r0 = null;
            for (b bVar : collection) {
                if (bVar != null) {
                    Integer b2 = az.b(bVar.hzE(), bVar.hzE());
                    if (b2 == null || b2.intValue() >= 0) {
                        bVar = bVar;
                    }
                }
            }
            if (bVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(60010);
            return bVar;
        }
        AssertionError assertionError = new AssertionError("Assertion failed");
        AppMethodBeat.o(60010);
        throw assertionError;
    }
}
