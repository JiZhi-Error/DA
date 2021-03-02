package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wk extends IEvent {
    public a ecw;

    public static final class a {
        public String id;
        public int type = 0;
    }

    public wk() {
        this((byte) 0);
    }

    private wk(byte b2) {
        AppMethodBeat.i(125648);
        this.ecw = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125648);
    }
}
