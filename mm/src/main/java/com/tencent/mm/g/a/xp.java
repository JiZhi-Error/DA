package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xp extends IEvent {
    public a edP;

    public static final class a {
        public boolean edQ = false;
    }

    public xp() {
        this((byte) 0);
    }

    private xp(byte b2) {
        AppMethodBeat.i(19841);
        this.edP = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19841);
    }
}
