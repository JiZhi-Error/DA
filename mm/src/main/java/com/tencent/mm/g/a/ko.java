package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ko extends IEvent {
    public a dPG;

    public static final class a {
        public int keycode = -1;
    }

    public ko() {
        this((byte) 0);
    }

    private ko(byte b2) {
        AppMethodBeat.i(130754);
        this.dPG = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(130754);
    }
}
