package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yl extends IEvent {
    public a eeI;

    public static final class a {
        public long eeJ = -1;
        public long eeK = -1;
    }

    public yl() {
        this((byte) 0);
    }

    private yl(byte b2) {
        AppMethodBeat.i(94801);
        this.eeI = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(94801);
    }
}
