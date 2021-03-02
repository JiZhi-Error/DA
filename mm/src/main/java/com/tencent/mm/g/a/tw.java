package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tw extends IEvent {
    public a eaq;

    public static final class a {
        public String content;
        public String dkV;
        public int flags;
        public int type;
    }

    public tw() {
        this((byte) 0);
    }

    private tw(byte b2) {
        AppMethodBeat.i(116048);
        this.eaq = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116048);
    }
}
