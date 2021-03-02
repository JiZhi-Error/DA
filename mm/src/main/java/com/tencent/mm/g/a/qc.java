package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qc extends IEvent {
    public a dWm;
    public b dWn;

    public static final class a {
        public String dWo;
        public String dWp;
        public String dWq;
        public int dWr = 0;
        public int dWs = 0;
        public int opType = 0;
    }

    public static final class b {
        public boolean dFE;
    }

    public qc() {
        this((byte) 0);
    }

    private qc(byte b2) {
        AppMethodBeat.i(155374);
        this.dWm = new a();
        this.dWn = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(155374);
    }
}
