package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sr extends IEvent {
    public a dZh;
    public b dZi;

    public static final class a {
    }

    public static final class b {
    }

    public sr() {
        this((byte) 0);
    }

    private sr(byte b2) {
        AppMethodBeat.i(93326);
        this.dZh = new a();
        this.dZi = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(93326);
    }
}
