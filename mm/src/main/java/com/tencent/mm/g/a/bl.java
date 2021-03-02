package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bl extends IEvent {
    public a dEG;

    public static final class a {
        public boolean isStarted = false;
    }

    public bl() {
        this((byte) 0);
    }

    private bl(byte b2) {
        AppMethodBeat.i(114790);
        this.dEG = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(114790);
    }
}
