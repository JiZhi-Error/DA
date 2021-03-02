package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m {
    RUNTIME,
    BINARY,
    SOURCE;

    static {
        AppMethodBeat.i(56976);
        AppMethodBeat.o(56976);
    }

    public static m valueOf(String str) {
        AppMethodBeat.i(56978);
        m mVar = (m) Enum.valueOf(m.class, str);
        AppMethodBeat.o(56978);
        return mVar;
    }
}
