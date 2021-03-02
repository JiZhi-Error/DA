package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rh extends IEvent {
    public a dXY;

    public static final class a {
        public int type = 0;
    }

    public rh() {
        this((byte) 0);
    }

    private rh(byte b2) {
        AppMethodBeat.i(114406);
        this.dXY = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(114406);
    }
}
