package j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    RELEASE,
    LOOP,
    STOP;

    public static c valueOf(String str) {
        AppMethodBeat.i(204510);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(204510);
        return cVar;
    }

    static {
        AppMethodBeat.i(204511);
        AppMethodBeat.o(204511);
    }
}
