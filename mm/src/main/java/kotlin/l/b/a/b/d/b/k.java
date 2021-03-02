package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.j.e.d;

public abstract class k {
    private k() {
    }

    public /* synthetic */ k(byte b2) {
        this();
    }

    public static final class c extends k {
        final d TvM;

        public c(d dVar) {
            super((byte) 0);
            this.TvM = dVar;
        }
    }

    public static final class b extends k {
        final String TvL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super((byte) 0);
            p.h(str, "internalName");
            AppMethodBeat.i(58207);
            this.TvL = str;
            AppMethodBeat.o(58207);
        }
    }

    public static final class a extends k {
        final k TvK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(k kVar) {
            super((byte) 0);
            p.h(kVar, "elementType");
            AppMethodBeat.i(58206);
            this.TvK = kVar;
            AppMethodBeat.o(58206);
        }
    }

    public String toString() {
        return m.TvN.a(this);
    }
}
