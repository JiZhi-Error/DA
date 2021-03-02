package kotlin.l.b.a.b.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

public enum t {
    IN(LocaleUtil.INDONESIAN_NEWNAME),
    OUT("out"),
    INV("");
    
    private final String TPX;

    public static t valueOf(String str) {
        AppMethodBeat.i(61246);
        t tVar = (t) Enum.valueOf(t.class, str);
        AppMethodBeat.o(61246);
        return tVar;
    }

    private t(String str) {
        this.TPX = str;
    }

    static {
        AppMethodBeat.i(61244);
        AppMethodBeat.o(61244);
    }

    public final String toString() {
        return this.TPX;
    }
}
