package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class za extends IEvent {
    public a efk;

    public static final class a {
        public boolean isStart;
    }

    public za() {
        this((byte) 0);
    }

    private za(byte b2) {
        AppMethodBeat.i(231468);
        this.efk = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(231468);
    }
}
