package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.sdk.event.IEvent;

public final class qu extends IEvent {
    public a dXl;

    public static final class a {
        public String dQp;
        public k.b dXm;
        public long msgId;
    }

    public qu() {
        this((byte) 0);
    }

    private qu(byte b2) {
        AppMethodBeat.i(91215);
        this.dXl = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91215);
    }
}
