package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ep extends IEvent {
    public a dHX;

    public static final class a {
        public String dGL;
        public boolean dGT;
    }

    public ep() {
        this((byte) 0);
    }

    private ep(byte b2) {
        AppMethodBeat.i(115999);
        this.dHX = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115999);
    }
}
