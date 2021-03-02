package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.n.b;

public abstract class f implements b {
    private final String description;

    public static final class b extends f {
        public static final b TQq = new b();

        static {
            AppMethodBeat.i(61300);
            AppMethodBeat.o(61300);
        }

        private b() {
            super("must be a member or an extension function", (byte) 0);
        }

        @Override // kotlin.l.b.a.b.n.b
        public final boolean h(t tVar) {
            AppMethodBeat.i(61299);
            p.h(tVar, "functionDescriptor");
            if (tVar.hAs() == null && tVar.hAr() == null) {
                AppMethodBeat.o(61299);
                return false;
            }
            AppMethodBeat.o(61299);
            return true;
        }
    }

    private f(String str) {
        this.description = str;
    }

    public /* synthetic */ f(String str, byte b2) {
        this(str);
    }

    @Override // kotlin.l.b.a.b.n.b
    public final String getDescription() {
        return this.description;
    }

    @Override // kotlin.l.b.a.b.n.b
    public final String i(t tVar) {
        p.h(tVar, "functionDescriptor");
        return b.a.a(this, tVar);
    }

    public static final class a extends f {
        public static final a TQp = new a();

        static {
            AppMethodBeat.i(61298);
            AppMethodBeat.o(61298);
        }

        private a() {
            super("must be a member function", (byte) 0);
        }

        @Override // kotlin.l.b.a.b.n.b
        public final boolean h(t tVar) {
            AppMethodBeat.i(61297);
            p.h(tVar, "functionDescriptor");
            if (tVar.hAs() != null) {
                AppMethodBeat.o(61297);
                return true;
            }
            AppMethodBeat.o(61297);
            return false;
        }
    }
}
