package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qh extends IEvent {
    public a dWE;
    public b dWF;

    public static final class a {
        public String dWG;
        public String talker;
    }

    public static final class b {
        public boolean dFE = false;
    }

    public qh() {
        this((byte) 0);
    }

    private qh(byte b2) {
        AppMethodBeat.i(127289);
        this.dWE = new a();
        this.dWF = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(127289);
    }
}
