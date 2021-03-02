package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class bf extends IEvent {
    public a dEo;
    public b dEp;

    public static final class a {
        public ca dCM;
    }

    public static final class b {
        public int dEq = 0;
        public int dEr = 0;
        public int dEs = 0;
        public int dEt = 0;
    }

    public bf() {
        this((byte) 0);
    }

    private bf(byte b2) {
        AppMethodBeat.i(149853);
        this.dEo = new a();
        this.dEp = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149853);
    }
}
