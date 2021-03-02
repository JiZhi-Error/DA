package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class go extends IEvent {
    public a dKw;
    public b dKx;

    public static final class a {
        public int dKy = 0;
        public int state = -1;
        public String talker;
    }

    public static final class b {
        public int state = -1;
    }

    public go() {
        this((byte) 0);
    }

    private go(byte b2) {
        AppMethodBeat.i(127288);
        this.dKw = new a();
        this.dKx = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(127288);
    }
}
