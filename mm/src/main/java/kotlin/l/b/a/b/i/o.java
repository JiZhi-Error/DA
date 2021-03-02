package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum o {
    PRETTY,
    DEBUG,
    NONE;

    static {
        AppMethodBeat.i(59864);
        AppMethodBeat.o(59864);
    }

    public static o valueOf(String str) {
        AppMethodBeat.i(59866);
        o oVar = (o) Enum.valueOf(o.class, str);
        AppMethodBeat.o(59866);
        return oVar;
    }
}
