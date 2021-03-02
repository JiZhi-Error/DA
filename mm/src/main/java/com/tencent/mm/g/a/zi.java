package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zi extends IEvent {
    public a efv;

    public static final class a {
        public boolean dCH = false;
        public boolean dCI = false;
        public boolean efw = false;
        public String talker;
    }

    public zi() {
        this((byte) 0);
    }

    private zi(byte b2) {
        AppMethodBeat.i(149894);
        this.efv = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149894);
    }
}
