package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fg extends IEvent {
    public a dID;

    public static final class a {
        public boolean brW;
        public String dIx;
        public String mac;
    }

    public fg() {
        this((byte) 0);
    }

    private fg(byte b2) {
        AppMethodBeat.i(19799);
        this.dID = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19799);
    }
}
