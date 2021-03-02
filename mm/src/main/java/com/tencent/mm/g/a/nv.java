package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class nv extends IEvent {
    public a dTW;

    public static final class a {
        public ca dTX;
    }

    public nv() {
        this((byte) 0);
    }

    private nv(byte b2) {
        AppMethodBeat.i(185944);
        this.dTW = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(185944);
    }
}
