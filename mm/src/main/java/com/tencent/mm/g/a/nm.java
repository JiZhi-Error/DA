package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nm extends IEvent {
    public a dTE;

    public static final class a {
        public int dCm;
        public boolean dTF;
        public boolean dTG;
        public String talker;
    }

    public nm() {
        this((byte) 0);
    }

    private nm(byte b2) {
        AppMethodBeat.i(116034);
        this.dTE = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116034);
    }
}
