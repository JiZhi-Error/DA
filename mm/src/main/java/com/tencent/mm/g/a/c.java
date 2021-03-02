package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class c extends IEvent {
    public a dBO;

    public static final class a {
        public int errCode;
        public String errMsg;
        public int errType;
    }

    public c() {
        this((byte) 0);
    }

    private c(byte b2) {
        AppMethodBeat.i(131787);
        this.dBO = new a();
        this.order = true;
        this.callback = null;
        AppMethodBeat.o(131787);
    }
}
