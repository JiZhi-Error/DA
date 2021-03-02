package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pg extends IEvent {
    public a dVo;

    public static final class a {
        public boolean pause;
        public String talker;
    }

    public pg() {
        this((byte) 0);
    }

    private pg(byte b2) {
        AppMethodBeat.i(149877);
        this.dVo = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149877);
    }
}
