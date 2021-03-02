package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yo extends IEvent {
    public a eeN;

    public static final class a {
        public boolean eeO = false;
        public boolean eeP = false;
    }

    public yo() {
        this((byte) 0);
    }

    private yo(byte b2) {
        AppMethodBeat.i(155376);
        this.eeN = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(155376);
    }
}
