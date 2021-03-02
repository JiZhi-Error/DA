package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am implements al {
    a JWV;
    volatile boolean dQW;
    volatile boolean iMQ;
    volatile boolean lzY;
    volatile boolean lzZ;

    public interface a {
        void u(boolean z, boolean z2);
    }

    public am(a aVar) {
        this.JWV = aVar;
    }

    @Override // com.tencent.mm.pluginsdk.model.app.al
    public final void v(boolean z, boolean z2) {
        AppMethodBeat.i(223766);
        this.iMQ = true;
        this.lzY = z;
        if (this.lzZ && this.JWV != null) {
            this.JWV.u(this.dQW, z);
        }
        AppMethodBeat.o(223766);
    }

    public final void hj(boolean z) {
        AppMethodBeat.i(151833);
        this.dQW = z;
        this.lzZ = true;
        if (this.iMQ && this.JWV != null) {
            this.JWV.u(z, this.lzY);
        }
        AppMethodBeat.o(151833);
    }

    public final void reset() {
        this.iMQ = false;
        this.lzY = false;
        this.lzZ = false;
        this.dQW = false;
    }
}
