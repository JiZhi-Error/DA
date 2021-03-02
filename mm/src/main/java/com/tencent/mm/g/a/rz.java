package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rz extends IEvent {
    public a dYA;

    public static final class a {
        public byte[] buffer;
        public String dYB;
    }

    public rz() {
        this((byte) 0);
    }

    private rz(byte b2) {
        AppMethodBeat.i(187543);
        this.dYA = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(187543);
    }
}
