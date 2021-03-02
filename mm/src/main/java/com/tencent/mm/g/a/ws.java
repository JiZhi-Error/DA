package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ws extends IEvent {
    public a ede;

    public static final class a {
        public String ebd;
        public String edf;
        public int edg;
        public String nickName;
    }

    public ws() {
        this((byte) 0);
    }

    private ws(byte b2) {
        AppMethodBeat.i(19837);
        this.ede = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19837);
    }
}
