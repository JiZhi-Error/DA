package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nj extends IEvent {
    public a dTv;
    public b dTw;

    public static final class a {
        public String chatroomName;
        public boolean dSQ = false;
        public String dTx;
    }

    public static final class b {
        public int errCode;
    }

    public nj() {
        this((byte) 0);
    }

    private nj(byte b2) {
        AppMethodBeat.i(116462);
        this.dTv = new a();
        this.dTw = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116462);
    }
}
