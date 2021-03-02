package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class va extends IEvent {
    public a ebs;

    public static final class a {
        public boolean enable;
    }

    public va() {
        this((byte) 0);
    }

    private va(byte b2) {
        AppMethodBeat.i(94814);
        this.ebs = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(94814);
    }
}
