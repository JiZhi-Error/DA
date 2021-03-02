package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hr extends IEvent {
    public a dMk;

    public static final class a {
        public int aHK;
        public String dMl;
        public int eventId;
    }

    public hr() {
        this((byte) 0);
    }

    private hr(byte b2) {
        AppMethodBeat.i(194248);
        this.dMk = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(194248);
    }
}
