package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qq extends IEvent {
    public a dXe;

    public static final class a {
        public String content;
        public String dRL;
        public String dXf;
        public String toUser;
        public int type;
    }

    public qq() {
        this((byte) 0);
    }

    private qq(byte b2) {
        AppMethodBeat.i(91213);
        this.dXe = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91213);
    }
}
