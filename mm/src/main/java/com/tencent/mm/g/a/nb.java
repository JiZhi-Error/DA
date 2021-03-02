package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nb extends IEvent {
    public a dSL;
    public b dSM;

    public static final class a {
        public Activity dKq;
        public Runnable dSN;
    }

    public static final class b {
        public boolean dFE = false;
    }

    public nb() {
        this((byte) 0);
    }

    private nb(byte b2) {
        AppMethodBeat.i(155373);
        this.dSL = new a();
        this.dSM = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(155373);
    }
}
