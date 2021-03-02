package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    INFLEXIBLE,
    FLEXIBLE_UPPER_BOUND,
    FLEXIBLE_LOWER_BOUND;

    static {
        AppMethodBeat.i(57954);
        AppMethodBeat.o(57954);
    }

    public static b valueOf(String str) {
        AppMethodBeat.i(57956);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(57956);
        return bVar;
    }
}
