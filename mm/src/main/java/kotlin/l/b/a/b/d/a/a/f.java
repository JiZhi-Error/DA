package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.d.a.e.n;
import kotlin.l.b.a.b.j.b.g;

public interface f {
    g<?> a(n nVar, ah ahVar);

    public static final class a implements f {
        public static final a Tql = new a();

        static {
            AppMethodBeat.i(57672);
            AppMethodBeat.o(57672);
        }

        private a() {
        }

        @Override // kotlin.l.b.a.b.d.a.a.f
        public final g<?> a(n nVar, ah ahVar) {
            AppMethodBeat.i(57671);
            p.h(nVar, "field");
            p.h(ahVar, "descriptor");
            AppMethodBeat.o(57671);
            return null;
        }
    }
}
