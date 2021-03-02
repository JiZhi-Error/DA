package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ul extends IEvent {
    public a eaM;
    public b eaN;

    public static final class a {
        public String eaO;
        public String eaP;
        public int eaQ = 0;
    }

    public static final class b {
        public String eaO;
        public boolean isSuccess = false;
    }

    public ul() {
        this((byte) 0);
    }

    private ul(byte b2) {
        AppMethodBeat.i(93327);
        this.eaM = new a();
        this.eaN = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(93327);
    }
}
