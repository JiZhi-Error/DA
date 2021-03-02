package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum n {
    THb,
    ONLY_NON_SYNTHESIZED,
    NONE;

    static {
        AppMethodBeat.i(59861);
        AppMethodBeat.o(59861);
    }

    public static n valueOf(String str) {
        AppMethodBeat.i(59863);
        n nVar = (n) Enum.valueOf(n.class, str);
        AppMethodBeat.o(59863);
        return nVar;
    }
}
