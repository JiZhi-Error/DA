package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gm extends IEvent {
    public a dKr;

    public static final class a {
        public Activity dKq;
        public String dKs;
        public int dKt;
    }

    public gm() {
        this((byte) 0);
    }

    private gm(byte b2) {
        AppMethodBeat.i(163527);
        this.dKr = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(163527);
    }
}
