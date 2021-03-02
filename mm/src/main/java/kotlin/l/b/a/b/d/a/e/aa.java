package kotlin.l.b.a.b.d.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum aa {
    SOURCE,
    BINARY;

    static {
        AppMethodBeat.i(58008);
        AppMethodBeat.o(58008);
    }

    public static aa valueOf(String str) {
        AppMethodBeat.i(58010);
        aa aaVar = (aa) Enum.valueOf(aa.class, str);
        AppMethodBeat.o(58010);
        return aaVar;
    }
}
