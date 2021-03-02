package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t {
    public static final t bdP = new t(0);
    public final int bdQ;

    static {
        AppMethodBeat.i(92514);
        AppMethodBeat.o(92514);
    }

    public t(int i2) {
        this.bdQ = i2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92513);
        if (this == obj) {
            AppMethodBeat.o(92513);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92513);
            return false;
        } else if (this.bdQ == ((t) obj).bdQ) {
            AppMethodBeat.o(92513);
            return true;
        } else {
            AppMethodBeat.o(92513);
            return false;
        }
    }

    public final int hashCode() {
        return this.bdQ;
    }
}
