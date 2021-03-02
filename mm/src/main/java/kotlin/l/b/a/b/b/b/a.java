package kotlin.l.b.a.b.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;

public interface a {
    Collection<am> a(f fVar, e eVar);

    Collection<ab> l(e eVar);

    Collection<f> m(e eVar);

    Collection<d> o(e eVar);

    /* renamed from: kotlin.l.b.a.b.b.b.a$a  reason: collision with other inner class name */
    public static final class C2278a implements a {
        public static final C2278a TjP = new C2278a();

        static {
            AppMethodBeat.i(56986);
            AppMethodBeat.o(56986);
        }

        private C2278a() {
        }

        @Override // kotlin.l.b.a.b.b.b.a
        public final Collection<ab> l(e eVar) {
            AppMethodBeat.i(56982);
            p.h(eVar, "classDescriptor");
            v vVar = v.SXr;
            AppMethodBeat.o(56982);
            return vVar;
        }

        @Override // kotlin.l.b.a.b.b.b.a
        public final Collection<am> a(f fVar, e eVar) {
            AppMethodBeat.i(56983);
            p.h(fVar, "name");
            p.h(eVar, "classDescriptor");
            v vVar = v.SXr;
            AppMethodBeat.o(56983);
            return vVar;
        }

        @Override // kotlin.l.b.a.b.b.b.a
        public final Collection<f> m(e eVar) {
            AppMethodBeat.i(56984);
            p.h(eVar, "classDescriptor");
            v vVar = v.SXr;
            AppMethodBeat.o(56984);
            return vVar;
        }

        @Override // kotlin.l.b.a.b.b.b.a
        public final Collection<d> o(e eVar) {
            AppMethodBeat.i(56985);
            p.h(eVar, "classDescriptor");
            v vVar = v.SXr;
            AppMethodBeat.o(56985);
            return vVar;
        }
    }
}
