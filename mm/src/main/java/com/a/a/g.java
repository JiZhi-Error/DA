package com.a.a;

import com.a.a.b;
import com.a.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g {
    b.q aPY = null;
    f aPZ = null;
    String aQa = null;
    h.b aQb = null;
    h.b aQc = null;
    String viewId = null;

    public final boolean qG() {
        int i2;
        AppMethodBeat.i(206473);
        if (this.aPY != null) {
            b.q qVar = this.aPY;
            if (qVar.aPm != null) {
                i2 = qVar.aPm.size();
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                AppMethodBeat.o(206473);
                return true;
            }
        }
        AppMethodBeat.o(206473);
        return false;
    }

    public final boolean qH() {
        return this.aPZ != null;
    }

    public final boolean qI() {
        return this.viewId != null;
    }

    public final boolean qJ() {
        return this.aQb != null;
    }

    public final g p(float f2, float f3) {
        AppMethodBeat.i(206474);
        this.aQc = new h.b(0.0f, 0.0f, f2, f3);
        AppMethodBeat.o(206474);
        return this;
    }

    public final boolean qK() {
        return this.aQa != null;
    }
}
