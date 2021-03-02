package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mk extends IEvent {
    public a dRK;

    public static final class a {
        public String dRL;
        public String dRM;
        public int dRN;
        public String[] dRO;
        public String dRP;
        public int dRQ;
        public int dRR;
        public String dRS;
        public long endTime;
        public String fileId;
        public int netType;
        public String path;
        public long startTime;
    }

    public mk() {
        this((byte) 0);
    }

    private mk(byte b2) {
        AppMethodBeat.i(126679);
        this.dRK = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(126679);
    }
}
