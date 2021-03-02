package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wj extends IEvent {
    public a ecv;

    public static final class a {
        public String mediaId;
    }

    public wj() {
        this((byte) 0);
    }

    private wj(byte b2) {
        AppMethodBeat.i(94817);
        this.ecv = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(94817);
    }
}
