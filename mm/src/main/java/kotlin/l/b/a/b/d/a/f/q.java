package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q {
    FLEXIBLE_LOWER,
    FLEXIBLE_UPPER,
    INFLEXIBLE;

    static {
        AppMethodBeat.i(58126);
        AppMethodBeat.o(58126);
    }

    public static q valueOf(String str) {
        AppMethodBeat.i(58128);
        q qVar = (q) Enum.valueOf(q.class, str);
        AppMethodBeat.o(58128);
        return qVar;
    }
}
