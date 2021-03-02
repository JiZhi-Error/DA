package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    FUNCTION,
    PROPERTY,
    PROPERTY_GETTER,
    PROPERTY_SETTER;

    public static b valueOf(String str) {
        AppMethodBeat.i(60265);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(60265);
        return bVar;
    }

    static {
        AppMethodBeat.i(60266);
        AppMethodBeat.o(60266);
    }
}
