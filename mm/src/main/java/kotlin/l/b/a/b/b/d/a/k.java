package kotlin.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ao;
import kotlin.l.b.a.b.b.d.b.n;
import kotlin.l.b.a.b.d.a.d.b;
import kotlin.l.b.a.b.d.a.e.l;

public final class k implements b {
    public static final k TmR = new k();

    public static final class a implements kotlin.l.b.a.b.d.a.d.a {
        public final n TmS;

        public a(n nVar) {
            p.h(nVar, "javaElement");
            AppMethodBeat.i(57385);
            this.TmS = nVar;
            AppMethodBeat.o(57385);
        }

        public final String toString() {
            AppMethodBeat.i(57383);
            String str = getClass().getName() + ": " + this.TmS.toString();
            AppMethodBeat.o(57383);
            return str;
        }

        @Override // kotlin.l.b.a.b.b.an
        public final ao hBu() {
            AppMethodBeat.i(57384);
            ao aoVar = ao.ThL;
            p.g(aoVar, "SourceFile.NO_SOURCE_FILE");
            AppMethodBeat.o(57384);
            return aoVar;
        }

        @Override // kotlin.l.b.a.b.d.a.d.a
        public final /* bridge */ /* synthetic */ l hCC() {
            return this.TmS;
        }
    }

    static {
        AppMethodBeat.i(57387);
        AppMethodBeat.o(57387);
    }

    private k() {
    }

    @Override // kotlin.l.b.a.b.d.a.d.b
    public final kotlin.l.b.a.b.d.a.d.a a(l lVar) {
        AppMethodBeat.i(57386);
        p.h(lVar, "javaElement");
        a aVar = new a((n) lVar);
        AppMethodBeat.o(57386);
        return aVar;
    }
}
