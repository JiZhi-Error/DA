package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ux extends IEvent {
    public a ebm;

    public static final class a {
        public byte[] data;
    }

    public ux() {
        this((byte) 0);
    }

    private ux(byte b2) {
        AppMethodBeat.i(19836);
        this.ebm = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19836);
    }
}
