package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nf extends IEvent {
    public a dTf;

    public static final class a {
        public String chatroomName;
        public boolean dSQ = false;
        public int dTg;
    }

    public nf() {
        this((byte) 0);
    }

    private nf(byte b2) {
        AppMethodBeat.i(116461);
        this.dTf = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116461);
    }
}
