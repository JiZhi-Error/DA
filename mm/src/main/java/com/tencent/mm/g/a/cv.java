package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cv extends IEvent {
    public a dFX;

    public static final class a {
        public long msgId;
        public int msgType;
        public String talker;
    }

    public cv() {
        this((byte) 0);
    }

    private cv(byte b2) {
        AppMethodBeat.i(42652);
        this.dFX = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(42652);
    }
}
