package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kx extends IEvent {
    public a dPZ;

    public static final class a {
        public byte[] dQa;
    }

    public kx() {
        this((byte) 0);
    }

    private kx(byte b2) {
        AppMethodBeat.i(19814);
        this.dPZ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19814);
    }
}
