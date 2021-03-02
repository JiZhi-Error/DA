package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vw extends IEvent {
    public a ebW;

    public static final class a {
        public String dkU;
        public String mediaId;
    }

    public vw() {
        this((byte) 0);
    }

    private vw(byte b2) {
        AppMethodBeat.i(201824);
        this.ebW = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(201824);
    }
}
