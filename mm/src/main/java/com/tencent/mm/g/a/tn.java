package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tn extends IEvent {
    public a dZX;

    public static final class a {
        public String dZW;
        public String deviceName;
    }

    public tn() {
        this((byte) 0);
    }

    private tn(byte b2) {
        AppMethodBeat.i(223487);
        this.dZX = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(223487);
    }
}
