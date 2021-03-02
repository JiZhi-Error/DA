package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class r {
    public static final r bxh = new r(new q[0]);
    private int aHK;
    public final q[] bxi;
    public final int length;

    static {
        AppMethodBeat.i(92726);
        AppMethodBeat.o(92726);
    }

    public r(q... qVarArr) {
        AppMethodBeat.i(92723);
        this.bxi = qVarArr;
        this.length = qVarArr.length;
        AppMethodBeat.o(92723);
    }

    public final int a(q qVar) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.bxi[i2] == qVar) {
                return i2;
            }
        }
        return -1;
    }

    public final int hashCode() {
        AppMethodBeat.i(92724);
        if (this.aHK == 0) {
            this.aHK = Arrays.hashCode(this.bxi);
        }
        int i2 = this.aHK;
        AppMethodBeat.o(92724);
        return i2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92725);
        if (this == obj) {
            AppMethodBeat.o(92725);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92725);
            return false;
        } else {
            r rVar = (r) obj;
            if (this.length != rVar.length || !Arrays.equals(this.bxi, rVar.bxi)) {
                AppMethodBeat.o(92725);
                return false;
            }
            AppMethodBeat.o(92725);
            return true;
        }
    }
}
