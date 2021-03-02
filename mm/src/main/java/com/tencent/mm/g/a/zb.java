package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zb extends IEvent {
    public a efl;

    public static final class a {
        public boolean efm;
        public long msgId;
        public boolean success;
    }

    public zb() {
        this((byte) 0);
    }

    private zb(byte b2) {
        AppMethodBeat.i(187329);
        this.efl = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(187329);
    }
}
