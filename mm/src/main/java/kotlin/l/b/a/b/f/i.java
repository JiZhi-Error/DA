package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum i {
    BEGINNING,
    MIDDLE,
    AFTER_DOT;

    static {
        AppMethodBeat.i(59338);
        AppMethodBeat.o(59338);
    }

    public static i valueOf(String str) {
        AppMethodBeat.i(59340);
        i iVar = (i) Enum.valueOf(i.class, str);
        AppMethodBeat.o(59340);
        return iVar;
    }
}
