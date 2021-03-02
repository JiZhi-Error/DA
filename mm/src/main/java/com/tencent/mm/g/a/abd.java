package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.sdk.event.IEvent;

public final class abd extends IEvent {
    public a eit;

    public static final class a {
        public com.tencent.mm.plugin.appbrand.appcache.a.a eiu;
        public m eiv;
        public int event = 0;
    }

    public abd() {
        this((byte) 0);
    }

    private abd(byte b2) {
        AppMethodBeat.i(230551);
        this.eit = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(230551);
    }
}
