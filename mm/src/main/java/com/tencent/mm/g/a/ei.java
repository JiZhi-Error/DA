package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ei extends IEvent {
    public a dHG;

    public static final class a {
        public String dHE;
        public int dHH = 0;
        public int dHI = 0;
        public double dHJ = 0.0d;
        public double dHK = 0.0d;
        public String dHL;
        public int dHM = 0;
    }

    public ei() {
        this((byte) 0);
    }

    private ei(byte b2) {
        AppMethodBeat.i(115992);
        this.dHG = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115992);
    }
}
