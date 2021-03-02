package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.n.b;

public abstract class l implements b {
    private final String description;

    public static final class c extends l {
        public static final c TRt = new c();

        static {
            AppMethodBeat.i(61333);
            AppMethodBeat.o(61333);
        }

        private c() {
            super("must have no value parameters", (byte) 0);
        }

        @Override // kotlin.l.b.a.b.n.b
        public final boolean h(t tVar) {
            AppMethodBeat.i(61332);
            p.h(tVar, "functionDescriptor");
            boolean isEmpty = tVar.hAw().isEmpty();
            AppMethodBeat.o(61332);
            return isEmpty;
        }
    }

    private l(String str) {
        this.description = str;
    }

    public /* synthetic */ l(String str, byte b2) {
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

    public static final class d extends l {
        public static final d TRu = new d();

        static {
            AppMethodBeat.i(61335);
            AppMethodBeat.o(61335);
        }

        private d() {
            super("must have a single value parameter", (byte) 0);
        }

        @Override // kotlin.l.b.a.b.n.b
        public final boolean h(t tVar) {
            AppMethodBeat.i(61334);
            p.h(tVar, "functionDescriptor");
            if (tVar.hAw().size() == 1) {
                AppMethodBeat.o(61334);
                return true;
            }
            AppMethodBeat.o(61334);
            return false;
        }
    }

    public static final class a extends l {
        private final int n;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super("must have at least " + i2 + " value parameter" + (i2 > 1 ? "s" : ""), (byte) 0);
            AppMethodBeat.i(61330);
            this.n = i2;
            AppMethodBeat.o(61330);
        }

        @Override // kotlin.l.b.a.b.n.b
        public final boolean h(t tVar) {
            AppMethodBeat.i(61329);
            p.h(tVar, "functionDescriptor");
            if (tVar.hAw().size() >= this.n) {
                AppMethodBeat.o(61329);
                return true;
            }
            AppMethodBeat.o(61329);
            return false;
        }
    }

    public static final class b extends l {
        private final int n = 2;

        public b() {
            super(new StringBuilder("must have exactly 2 value parameters").toString(), (byte) 0);
            AppMethodBeat.i(186278);
            AppMethodBeat.o(186278);
        }

        @Override // kotlin.l.b.a.b.n.b
        public final boolean h(t tVar) {
            AppMethodBeat.i(61331);
            p.h(tVar, "functionDescriptor");
            if (tVar.hAw().size() == this.n) {
                AppMethodBeat.o(61331);
                return true;
            }
            AppMethodBeat.o(61331);
            return false;
        }
    }
}
