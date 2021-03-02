package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.event.IEvent;

public final class tt extends IEvent {
    public a eaf;

    public static final class a {
        public String appId;
        public String appName;
        public WXMediaMessage dCE;
        public int dMG;
        public String eag;
        public String eah;
        public String eai;
        public String eaj;
        public String eak;
        public String eal;
        public String eam;
        public String ean;
        public String sessionId;
        public String toUser;
    }

    public tt() {
        this((byte) 0);
    }

    private tt(byte b2) {
        AppMethodBeat.i(116047);
        this.eaf = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116047);
    }
}
