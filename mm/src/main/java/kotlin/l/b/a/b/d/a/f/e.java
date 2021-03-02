package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e {
    READ_ONLY,
    MUTABLE;

    static {
        AppMethodBeat.i(58025);
        AppMethodBeat.o(58025);
    }

    public static e valueOf(String str) {
        AppMethodBeat.i(58027);
        e eVar = (e) Enum.valueOf(e.class, str);
        AppMethodBeat.o(58027);
        return eVar;
    }
}
