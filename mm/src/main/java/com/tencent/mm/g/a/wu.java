package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wu extends IEvent {
    public wu() {
        this((byte) 0);
    }

    private wu(byte b2) {
        AppMethodBeat.i(43443);
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(43443);
    }
}
