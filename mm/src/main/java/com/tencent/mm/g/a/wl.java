package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wl extends IEvent {
    public a ecx;

    public static final class a {
        public String id;
        public int type;
    }

    public wl() {
        this((byte) 0);
    }

    private wl(byte b2) {
        AppMethodBeat.i(125649);
        this.ecx = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125649);
    }
}
