package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uc extends IEvent {
    public a eav;

    public static final class a {
        public long eaw;
        public String sessionId;
        public int type;
    }

    public uc() {
        this((byte) 0);
    }

    private uc(byte b2) {
        AppMethodBeat.i(194250);
        this.eav = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(194250);
    }
}
