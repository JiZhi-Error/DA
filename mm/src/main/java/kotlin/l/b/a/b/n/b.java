package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.t;

public interface b {
    String getDescription();

    boolean h(t tVar);

    String i(t tVar);

    public static final class a {
        public static String a(b bVar, t tVar) {
            AppMethodBeat.i(61278);
            p.h(tVar, "functionDescriptor");
            if (!bVar.h(tVar)) {
                String description = bVar.getDescription();
                AppMethodBeat.o(61278);
                return description;
            }
            AppMethodBeat.o(61278);
            return null;
        }
    }
}
