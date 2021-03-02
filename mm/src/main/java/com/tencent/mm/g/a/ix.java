package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ix extends IEvent {
    public a dNB;

    public static final class a {
        public String event;
    }

    public ix() {
        this((byte) 0);
    }

    private ix(byte b2) {
        AppMethodBeat.i(201272);
        this.dNB = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(201272);
    }
}
