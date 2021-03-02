package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ot extends IEvent {
    public a dUN;

    public static final class a {
        public String talker;
    }

    public ot() {
        this((byte) 0);
    }

    private ot(byte b2) {
        AppMethodBeat.i(19823);
        this.dUN = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19823);
    }
}
