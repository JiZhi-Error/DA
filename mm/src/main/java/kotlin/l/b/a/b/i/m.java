package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m {
    RENDER_OVERRIDE,
    RENDER_OPEN,
    RENDER_OPEN_OVERRIDE;

    static {
        AppMethodBeat.i(59858);
        AppMethodBeat.o(59858);
    }

    public static m valueOf(String str) {
        AppMethodBeat.i(59860);
        m mVar = (m) Enum.valueOf(m.class, str);
        AppMethodBeat.o(59860);
        return mVar;
    }
}
