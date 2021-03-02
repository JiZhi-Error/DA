package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abi extends IEvent {
    public a opT;

    public static final class a {
        public boolean HHY;
        public String wJe;
    }

    public abi() {
        this((byte) 0);
    }

    private abi(byte b2) {
        AppMethodBeat.i(259080);
        this.opT = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(259080);
    }
}
