package kotlin.l.b.a.b.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.e;

public interface c {
    boolean a(e eVar, am amVar);

    public static final class a implements c {
        public static final a TjQ = new a();

        static {
            AppMethodBeat.i(56988);
            AppMethodBeat.o(56988);
        }

        private a() {
        }

        @Override // kotlin.l.b.a.b.b.b.c
        public final boolean a(e eVar, am amVar) {
            AppMethodBeat.i(56987);
            p.h(eVar, "classDescriptor");
            p.h(amVar, "functionDescriptor");
            AppMethodBeat.o(56987);
            return true;
        }
    }

    public static final class b implements c {
        public static final b TjR = new b();

        static {
            AppMethodBeat.i(56990);
            AppMethodBeat.o(56990);
        }

        private b() {
        }

        @Override // kotlin.l.b.a.b.b.b.c
        public final boolean a(e eVar, am amVar) {
            AppMethodBeat.i(56989);
            p.h(eVar, "classDescriptor");
            p.h(amVar, "functionDescriptor");
            if (!amVar.hzL().h(d.hBQ())) {
                AppMethodBeat.o(56989);
                return true;
            }
            AppMethodBeat.o(56989);
            return false;
        }
    }
}
