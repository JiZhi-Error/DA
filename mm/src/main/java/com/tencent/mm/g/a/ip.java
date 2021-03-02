package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ip extends IEvent {
    public a dNj;

    public static final class a {
        public String dNk;
        public int type = 0;
    }

    public ip() {
        this((byte) 0);
    }

    private ip(byte b2) {
        AppMethodBeat.i(91205);
        this.dNj = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91205);
    }
}
