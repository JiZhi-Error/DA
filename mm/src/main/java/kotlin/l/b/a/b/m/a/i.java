package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;

public abstract class i {
    public abstract Collection<ab> D(e eVar);

    public abstract h M(l lVar);

    public abstract ab aK(ab abVar);

    public abstract boolean f(y yVar);

    public abstract e h(kotlin.l.b.a.b.f.a aVar);

    public static final class a extends i {
        public static final a TPf = new a();

        static {
            AppMethodBeat.i(61057);
            AppMethodBeat.o(61057);
        }

        private a() {
        }

        @Override // kotlin.l.b.a.b.m.a.i
        public final /* synthetic */ h M(l lVar) {
            AppMethodBeat.i(61054);
            p.h(lVar, "descriptor");
            AppMethodBeat.o(61054);
            return null;
        }

        @Override // kotlin.l.b.a.b.m.a.i
        public final ab aK(ab abVar) {
            AppMethodBeat.i(61052);
            p.h(abVar, "type");
            AppMethodBeat.o(61052);
            return abVar;
        }

        @Override // kotlin.l.b.a.b.m.a.i
        public final Collection<ab> D(e eVar) {
            AppMethodBeat.i(61053);
            p.h(eVar, "classDescriptor");
            at hzz = eVar.hzz();
            p.g(hzz, "classDescriptor.typeConstructor");
            Collection<ab> hBV = hzz.hBV();
            p.g(hBV, "classDescriptor.typeConstructor.supertypes");
            AppMethodBeat.o(61053);
            return hBV;
        }

        @Override // kotlin.l.b.a.b.m.a.i
        public final e h(kotlin.l.b.a.b.f.a aVar) {
            AppMethodBeat.i(61055);
            p.h(aVar, "classId");
            AppMethodBeat.o(61055);
            return null;
        }

        @Override // kotlin.l.b.a.b.m.a.i
        public final boolean f(y yVar) {
            AppMethodBeat.i(61056);
            p.h(yVar, "moduleDescriptor");
            AppMethodBeat.o(61056);
            return false;
        }
    }
}
