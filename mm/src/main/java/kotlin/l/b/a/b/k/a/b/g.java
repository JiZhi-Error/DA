package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.v;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.h.q;

public interface g extends v, a {

    public enum a {
        COMPATIBLE,
        NEEDS_WRAPPER,
        INCOMPATIBLE;

        static {
            AppMethodBeat.i(60456);
            AppMethodBeat.o(60456);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(60458);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(60458);
            return aVar;
        }
    }

    q hLi();

    c hLj();

    h hLk();
}
