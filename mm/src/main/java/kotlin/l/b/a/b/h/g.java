package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.l.b.a.b.h.i;

public final class g {
    private static final g TDx = new g((byte) 0);
    private static volatile boolean bUg = false;
    final Map<a, i.f<?, ?>> bUk;

    static {
        AppMethodBeat.i(59446);
        AppMethodBeat.o(59446);
    }

    public static g hJv() {
        AppMethodBeat.i(59442);
        g gVar = new g();
        AppMethodBeat.o(59442);
        return gVar;
    }

    public static g hJw() {
        return TDx;
    }

    public final void a(i.f<?, ?> fVar) {
        AppMethodBeat.i(59443);
        this.bUk.put(new a(fVar.TDF, fVar.TDH.number), fVar);
        AppMethodBeat.o(59443);
    }

    g() {
        AppMethodBeat.i(59444);
        this.bUk = new HashMap();
        AppMethodBeat.o(59444);
    }

    private g(byte b2) {
        AppMethodBeat.i(59445);
        this.bUk = Collections.emptyMap();
        AppMethodBeat.o(59445);
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        private final int number;
        private final Object object;

        a(Object obj, int i2) {
            this.object = obj;
            this.number = i2;
        }

        public final int hashCode() {
            AppMethodBeat.i(59441);
            int identityHashCode = (System.identityHashCode(this.object) * 65535) + this.number;
            AppMethodBeat.o(59441);
            return identityHashCode;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.object == aVar.object && this.number == aVar.number) {
                return true;
            }
            return false;
        }
    }
}
