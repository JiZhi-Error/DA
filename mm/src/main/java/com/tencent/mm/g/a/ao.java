package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ao extends IEvent {
    public a dDs;

    public static final class a {
        public String userName;
    }

    public ao() {
        this((byte) 0);
    }

    private ao(byte b2) {
        AppMethodBeat.i(5531);
        this.dDs = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(5531);
    }
}
