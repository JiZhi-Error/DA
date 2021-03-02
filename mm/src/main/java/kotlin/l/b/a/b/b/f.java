package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f {
    CLASS,
    INTERFACE,
    ENUM_CLASS,
    ENUM_ENTRY,
    ANNOTATION_CLASS,
    OBJECT;

    public static f valueOf(String str) {
        AppMethodBeat.i(56846);
        f fVar = (f) Enum.valueOf(f.class, str);
        AppMethodBeat.o(56846);
        return fVar;
    }

    static {
        AppMethodBeat.i(56847);
        AppMethodBeat.o(56847);
    }

    public final boolean hAQ() {
        return this == OBJECT || this == ENUM_ENTRY;
    }
}
