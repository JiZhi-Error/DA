package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ff extends IEvent {
    public a dIC;

    public static final class a {
        public byte[] data;
        public String mac;
    }

    public ff() {
        this((byte) 0);
    }

    private ff(byte b2) {
        AppMethodBeat.i(19798);
        this.dIC = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19798);
    }
}
