package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bt extends IEvent {
    public a dEW;

    public static final class a {
        public Boolean dEX = Boolean.FALSE;
        public Boolean dEY = Boolean.FALSE;
        public int type = 0;
    }

    public bt() {
        this((byte) 0);
    }

    private bt(byte b2) {
        AppMethodBeat.i(117355);
        this.dEW = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(117355);
    }
}
