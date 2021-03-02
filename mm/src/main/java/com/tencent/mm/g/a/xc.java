package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xc extends IEvent {
    public a edy;

    public static final class a {
        public int state = -1;
    }

    public xc() {
        this((byte) 0);
    }

    private xc(byte b2) {
        AppMethodBeat.i(118480);
        this.edy = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(118480);
    }
}
