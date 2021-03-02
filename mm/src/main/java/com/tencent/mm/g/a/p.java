package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class p extends IEvent {
    public a dCt;

    public static final class a {
        public int action;
        public String appId;
        public int appVersion;
        public int cyo;
        public int dCA;
        public int dCB;
        public String dCC;
        public String dCu;
        public int dCv;
        public String dCw;
        public String dCx;
        public String dCy;
        public long dCz;
        public int scene;
    }

    public p() {
        this((byte) 0);
    }

    private p(byte b2) {
        AppMethodBeat.i(121048);
        this.dCt = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(121048);
    }
}
