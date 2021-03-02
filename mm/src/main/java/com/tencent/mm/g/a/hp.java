package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class hp extends IEvent {
    public a dMg;
    public b dMh;

    public static final class a {
        public ca dCM;
    }

    public static final class b {
    }

    public hp() {
        this((byte) 0);
    }

    private hp(byte b2) {
        AppMethodBeat.i(55662);
        this.dMg = new a();
        this.dMh = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(55662);
    }
}
