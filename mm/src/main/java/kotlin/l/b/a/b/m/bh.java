package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

public enum bh {
    INVARIANT("", true, true, 0),
    IN_VARIANCE(LocaleUtil.INDONESIAN_NEWNAME, true, false, -1),
    OUT_VARIANCE("out", false, true, 1);
    
    private final boolean TOU;
    public final boolean TOV;
    private final int TOW;
    public final String label;

    public static bh valueOf(String str) {
        AppMethodBeat.i(60914);
        bh bhVar = (bh) Enum.valueOf(bh.class, str);
        AppMethodBeat.o(60914);
        return bhVar;
    }

    private bh(String str, boolean z, boolean z2, int i2) {
        this.label = str;
        this.TOU = z;
        this.TOV = z2;
        this.TOW = i2;
    }

    static {
        AppMethodBeat.i(60912);
        AppMethodBeat.o(60912);
    }

    public final String toString() {
        return this.label;
    }
}
