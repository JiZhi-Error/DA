package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bv extends IEvent {
    public a dFa;

    public static final class a {
        public String bssid;
        public String dFb;
        public String dFc;
        public String dFd;
        public String dFe;
        public String dFf;
        public String ssid;
    }

    public bv() {
        this((byte) 0);
    }

    private bv(byte b2) {
        AppMethodBeat.i(19792);
        this.dFa = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19792);
    }
}
