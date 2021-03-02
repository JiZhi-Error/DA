package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a {
    NO_ARGUMENTS(false, 3),
    UNLESS_EMPTY(true, 2),
    ALWAYS_PARENTHESIZED(true, true);
    
    final boolean TEW;
    final boolean TEX;

    public static a valueOf(String str) {
        AppMethodBeat.i(59648);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(59648);
        return aVar;
    }

    private a(boolean z, boolean z2) {
        this.TEW = z;
        this.TEX = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private /* synthetic */ a(boolean z, int i2) {
        this((i2 & 1) != 0 ? false : z, false);
        AppMethodBeat.i(59646);
        AppMethodBeat.o(59646);
    }

    static {
        AppMethodBeat.i(59645);
        AppMethodBeat.o(59645);
    }
}
