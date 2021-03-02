package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.Map;

public final class pu extends IEvent {
    public a dVN;

    public static final class a {
        public String dDL;
        public String dVO;
        public String dVP;
        public String dVQ;
        public String dVR;
        public int dVS;
        public int dVT;
        public Map<String, String> dVU;
        public String query;
        public int scene;
        public String sessionId;
    }

    public pu() {
        this((byte) 0);
    }

    private pu(byte b2) {
        AppMethodBeat.i(117614);
        this.dVN = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(117614);
    }
}
