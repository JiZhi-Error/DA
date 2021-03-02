package kotlin.l.b.a.b.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    FOR_SUBTYPING,
    FOR_INCORPORATION,
    FROM_EXPRESSION;

    static {
        AppMethodBeat.i(61223);
        AppMethodBeat.o(61223);
    }

    public static b valueOf(String str) {
        AppMethodBeat.i(61225);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(61225);
        return bVar;
    }
}
