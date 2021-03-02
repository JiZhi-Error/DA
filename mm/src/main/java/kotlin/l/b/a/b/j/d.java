package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.e;

public interface d {
    b a(kotlin.l.b.a.b.b.a aVar, kotlin.l.b.a.b.b.a aVar2, e eVar);

    a hDu();

    public enum b {
        OVERRIDABLE,
        CONFLICT,
        INCOMPATIBLE,
        UNKNOWN;

        public static b valueOf(String str) {
            AppMethodBeat.i(59938);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(59938);
            return bVar;
        }

        static {
            AppMethodBeat.i(59939);
            AppMethodBeat.o(59939);
        }
    }

    public enum a {
        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH;

        public static a valueOf(String str) {
            AppMethodBeat.i(59935);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(59935);
            return aVar;
        }

        static {
            AppMethodBeat.i(59936);
            AppMethodBeat.o(59936);
        }
    }
}
