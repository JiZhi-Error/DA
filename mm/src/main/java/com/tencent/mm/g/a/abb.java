package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.sdk.event.IEvent;

public final class abb extends IEvent {
    public a ein;

    public static final class a {
        public long dcl;
        public h eio;
        public c.a eip;
        public long eiq;
    }

    public abb() {
        this((byte) 0);
    }

    private abb(byte b2) {
        AppMethodBeat.i(90538);
        this.ein = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(90538);
    }
}
