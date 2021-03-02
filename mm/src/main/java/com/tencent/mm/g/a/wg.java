package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wg extends IEvent {
    public a ecq;

    public static final class a {
        public int state;
    }

    public wg() {
        this((byte) 0);
    }

    private wg(byte b2) {
        AppMethodBeat.i(192721);
        this.ecq = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(192721);
    }
}
