package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.n.k;

public final class g {
    private static final k TDb = new k("[^\\p{L}\\p{Digit}]");
    public static final g TDc = new g();

    static {
        AppMethodBeat.i(59333);
        AppMethodBeat.o(59333);
    }

    private g() {
    }

    public static final String buc(String str) {
        AppMethodBeat.i(59332);
        p.h(str, "name");
        String e2 = TDb.e(str, "_");
        AppMethodBeat.o(59332);
        return e2;
    }
}
