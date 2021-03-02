package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class yx extends IEvent {
    public a efh;

    public static final class a {
        public ca dCM;
    }

    public yx() {
        this((byte) 0);
    }

    private yx(byte b2) {
        AppMethodBeat.i(104422);
        this.efh = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(104422);
    }
}
