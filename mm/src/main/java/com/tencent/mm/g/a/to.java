package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class to extends IEvent {
    public a dZY;

    public static final class a {
        public int dEb;
        public String filePath;
        public int scene = 0;
    }

    public to() {
        this((byte) 0);
    }

    private to(byte b2) {
        AppMethodBeat.i(120831);
        this.dZY = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(120831);
    }
}
