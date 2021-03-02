package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xm extends IEvent {
    public a edJ;
    public b edK;

    public static final class a {
        public String dWq;
        public int dWr = 0;
        public int dWs = 0;
        public int opType = 0;
    }

    public static final class b {
    }

    public xm() {
        this((byte) 0);
    }

    private xm(byte b2) {
        AppMethodBeat.i(19840);
        this.edJ = new a();
        this.edK = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19840);
    }
}
