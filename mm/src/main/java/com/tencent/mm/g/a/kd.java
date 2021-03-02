package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kd extends IEvent {
    public a dPd;

    public static final class a {
        public boolean isResume = false;
    }

    public kd() {
        this((byte) 0);
    }

    private kd(byte b2) {
        AppMethodBeat.i(125619);
        this.dPd = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125619);
    }
}
