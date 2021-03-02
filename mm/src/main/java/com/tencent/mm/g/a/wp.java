package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wp extends IEvent {
    public a ecH;

    public static final class a {
        public int action = 0;
    }

    public wp() {
        this((byte) 0);
    }

    private wp(byte b2) {
        AppMethodBeat.i(116809);
        this.ecH = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116809);
    }
}
