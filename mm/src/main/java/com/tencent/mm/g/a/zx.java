package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.sdk.event.IEvent;

public final class zx extends IEvent {
    public a egC;

    public static final class a {
        public s.h egD;
    }

    public zx() {
        this((byte) 0);
    }

    private zx(byte b2) {
        AppMethodBeat.i(63294);
        this.egC = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(63294);
    }
}
