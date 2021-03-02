package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g {
    NULLABLE,
    NOT_NULL,
    FORCE_FLEXIBILITY;

    static {
        AppMethodBeat.i(58037);
        AppMethodBeat.o(58037);
    }

    public static g valueOf(String str) {
        AppMethodBeat.i(58039);
        g gVar = (g) Enum.valueOf(g.class, str);
        AppMethodBeat.o(58039);
        return gVar;
    }
}
