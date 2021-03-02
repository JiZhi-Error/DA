package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.event.IEvent;

public final class ib extends IEvent {
    public a dMF;

    public static final class a {
        public WXMediaMessage dCE;
        public int dMG;
        public String dMH;
        public String username;
    }

    public ib() {
        this((byte) 0);
    }

    private ib(byte b2) {
        AppMethodBeat.i(208807);
        this.dMF = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(208807);
    }
}
