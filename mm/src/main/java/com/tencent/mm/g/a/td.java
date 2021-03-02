package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class td extends IEvent {
    public a dZA;
    public b dZB;

    public static final class a {
        public LinkedList dZC;
    }

    public static final class b {
        public int ret = 0;
    }

    public td() {
        this((byte) 0);
    }

    private td(byte b2) {
        AppMethodBeat.i(91218);
        this.dZA = new a();
        this.dZB = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91218);
    }
}
