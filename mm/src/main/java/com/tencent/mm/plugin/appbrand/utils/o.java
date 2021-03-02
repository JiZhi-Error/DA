package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o {
    private long ogT;
    private long ogU;
    private a ogV;

    public interface a {
        boolean j(Object... objArr);
    }

    public o() {
    }

    public o(long j2, a aVar) {
        this.ogT = j2;
        this.ogV = aVar;
    }

    private boolean bZr() {
        AppMethodBeat.i(137914);
        if (System.currentTimeMillis() - this.ogU < this.ogT) {
            AppMethodBeat.o(137914);
            return true;
        }
        AppMethodBeat.o(137914);
        return false;
    }

    public final boolean l(Object... objArr) {
        boolean z = false;
        AppMethodBeat.i(137915);
        if (bZr()) {
            AppMethodBeat.o(137915);
        } else if (this.ogV == null) {
            AppMethodBeat.o(137915);
        } else {
            z = this.ogV.j(objArr);
            if (z) {
                this.ogU = System.currentTimeMillis();
            }
            AppMethodBeat.o(137915);
        }
        return z;
    }
}
