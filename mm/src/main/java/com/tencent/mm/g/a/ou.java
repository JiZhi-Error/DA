package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.lang.ref.WeakReference;

public final class ou extends IEvent {
    public a dUO;

    public static final class a {
        public WeakReference aWF;
        public int scene;
    }

    public ou() {
        this((byte) 0);
    }

    private ou(byte b2) {
        AppMethodBeat.i(130927);
        this.dUO = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(130927);
    }
}
