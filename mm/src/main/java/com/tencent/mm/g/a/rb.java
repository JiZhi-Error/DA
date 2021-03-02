package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rb extends IEvent {
    public a dXE;

    public static final class a {
        public boolean dQA = false;
        public String errMsg;
        public long msgId;
    }

    public rb() {
        this((byte) 0);
    }

    private rb(byte b2) {
        AppMethodBeat.i(215177);
        this.dXE = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(215177);
    }
}
