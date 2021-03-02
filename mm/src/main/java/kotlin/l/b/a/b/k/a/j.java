package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.e;

public final class j {
    private static final Set<kotlin.l.b.a.b.f.a> TKE = ak.setOf(kotlin.l.b.a.b.f.a.p(g.TcO.TcU.hJj()));
    public static final b TKF = new b((byte) 0);
    private final kotlin.g.a.b<a, e> TKD = this.Tvt.TcN.V(new c(this));
    private final l Tvt;

    /* access modifiers changed from: package-private */
    public static final class c extends q implements kotlin.g.a.b<a, e> {
        final /* synthetic */ j TKH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(j jVar) {
            super(1);
            this.TKH = jVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ e invoke(a aVar) {
            AppMethodBeat.i(60295);
            a aVar2 = aVar;
            p.h(aVar2, "key");
            e a2 = j.a(this.TKH, aVar2);
            AppMethodBeat.o(60295);
            return a2;
        }
    }

    public j(l lVar) {
        p.h(lVar, "components");
        AppMethodBeat.i(60298);
        this.Tvt = lVar;
        AppMethodBeat.o(60298);
    }

    public static /* synthetic */ e a(j jVar, kotlin.l.b.a.b.f.a aVar) {
        AppMethodBeat.i(60297);
        e a2 = jVar.a(aVar, (h) null);
        AppMethodBeat.o(60297);
        return a2;
    }

    public final e a(kotlin.l.b.a.b.f.a aVar, h hVar) {
        AppMethodBeat.i(60296);
        p.h(aVar, "classId");
        e invoke = this.TKD.invoke(new a(aVar, hVar));
        AppMethodBeat.o(60296);
        return invoke;
    }

    public static final class a {
        final h TKG;
        final kotlin.l.b.a.b.f.a Tfj;

        public a(kotlin.l.b.a.b.f.a aVar, h hVar) {
            p.h(aVar, "classId");
            AppMethodBeat.i(60294);
            this.Tfj = aVar;
            this.TKG = hVar;
            AppMethodBeat.o(60294);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(60292);
            if (!(obj instanceof a) || !p.j(this.Tfj, ((a) obj).Tfj)) {
                AppMethodBeat.o(60292);
                return false;
            }
            AppMethodBeat.o(60292);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.i(60293);
            int hashCode = this.Tfj.hashCode();
            AppMethodBeat.o(60293);
            return hashCode;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(60299);
        AppMethodBeat.o(60299);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ed A[EDGE_INSN: B:49:0x00ed->B:40:0x00ed ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ kotlin.l.b.a.b.b.e a(kotlin.l.b.a.b.k.a.j r14, kotlin.l.b.a.b.k.a.j.a r15) {
        /*
        // Method dump skipped, instructions count: 287
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.k.a.j.a(kotlin.l.b.a.b.k.a.j, kotlin.l.b.a.b.k.a.j$a):kotlin.l.b.a.b.b.e");
    }
}
