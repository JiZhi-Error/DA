package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tr extends IEvent {
    public a eae;

    public static final class a {
        public String dkU;
        public long msgId;
    }

    public tr() {
        this((byte) 0);
    }

    private tr(byte b2) {
        AppMethodBeat.i(200180);
        this.eae = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(200180);
    }
}
