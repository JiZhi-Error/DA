package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zo extends IEvent {
    public a efF;
    public b efG;

    public static final class a {
        public String action;
        public String appId;
        public String buffer;
        public String dQk;
        public String dmc;
        public String efH;
        public int efI;
        public String nonceStr;
        public String signType;
        public String url;
    }

    public static final class b {
        public String buffer;
        public Runnable efJ;
        public int retCode;
    }

    public zo() {
        this((byte) 0);
    }

    private zo(byte b2) {
        AppMethodBeat.i(130930);
        this.efF = new a();
        this.efG = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(130930);
    }
}
