package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class c {
    public String dfJ = "";
    String pfL = null;
    public e pfM = null;
    public double pfN = 0.0d;

    public final int hashCode() {
        AppMethodBeat.i(22437);
        if (this.pfM == null) {
            AppMethodBeat.o(22437);
            return 0;
        }
        int hashCode = Arrays.hashCode(this.pfM.pfQ.pgr);
        AppMethodBeat.o(22437);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(22438);
        if (this.pfM == null || obj == null) {
            AppMethodBeat.o(22438);
            return false;
        } else if (this == obj) {
            AppMethodBeat.o(22438);
            return true;
        } else {
            boolean equals = Arrays.equals(((c) obj).pfM.pfQ.pgr, this.pfM.pfQ.pgr);
            AppMethodBeat.o(22438);
            return equals;
        }
    }
}
