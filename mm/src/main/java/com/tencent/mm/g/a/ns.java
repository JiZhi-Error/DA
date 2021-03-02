package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ns extends IEvent {
    public a dTP;
    public b dTQ;

    public static final class a {
        public boolean dTR = false;
        public String key;
        public int type = 0;
        public String username;
    }

    public static final class b {
        public long dTS;
        public long msgId;
    }

    public ns() {
        this((byte) 0);
    }

    private ns(byte b2) {
        AppMethodBeat.i(110275);
        this.dTP = new a();
        this.dTQ = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(110275);
    }
}
