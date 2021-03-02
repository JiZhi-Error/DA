package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Set;
import kotlin.a.v;
import kotlin.a.x;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.n;
import kotlin.l.b.a.b.d.a.e.q;
import kotlin.l.b.a.b.f.f;

public interface b {
    Set<f> hDK();

    Set<f> hDL();

    Collection<q> j(f fVar);

    n k(f fVar);

    public static final class a implements b {
        public static final a TrL = new a();

        static {
            AppMethodBeat.i(57780);
            AppMethodBeat.o(57780);
        }

        private a() {
        }

        @Override // kotlin.l.b.a.b.d.a.c.a.b
        public final /* synthetic */ Collection j(f fVar) {
            AppMethodBeat.i(57778);
            p.h(fVar, "name");
            v vVar = v.SXr;
            AppMethodBeat.o(57778);
            return vVar;
        }

        @Override // kotlin.l.b.a.b.d.a.c.a.b
        public final n k(f fVar) {
            AppMethodBeat.i(57779);
            p.h(fVar, "name");
            AppMethodBeat.o(57779);
            return null;
        }

        @Override // kotlin.l.b.a.b.d.a.c.a.b
        public final Set<f> hDK() {
            return x.SXt;
        }

        @Override // kotlin.l.b.a.b.d.a.c.a.b
        public final Set<f> hDL() {
            return x.SXt;
        }
    }
}
