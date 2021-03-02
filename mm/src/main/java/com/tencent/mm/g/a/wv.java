package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wv extends IEvent {
    public a edj;

    public static final class a {
        public int status;
    }

    public wv() {
        this((byte) 0);
    }

    private wv(byte b2) {
        AppMethodBeat.i(116049);
        this.edj = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116049);
    }
}
