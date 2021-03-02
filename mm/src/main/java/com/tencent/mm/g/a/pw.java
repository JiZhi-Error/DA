package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pw extends IEvent {
    public a dVW;

    public static final class a {
        public boolean dVX;
        public String dVY;
        public String mediaId;
        public int process;
        public int size;
        public int type;
    }

    public pw() {
        this((byte) 0);
    }

    private pw(byte b2) {
        AppMethodBeat.i(168630);
        this.dVW = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(168630);
    }
}
