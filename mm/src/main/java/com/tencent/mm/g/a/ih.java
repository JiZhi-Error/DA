package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.event.IEvent;

public final class ih extends IEvent {
    public a dMT;

    public static final class a {
        public bds dMU;
        public String errMsg;
        public int responseCode;
    }

    public ih() {
        this((byte) 0);
    }

    private ih(byte b2) {
        AppMethodBeat.i(208811);
        this.dMT = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(208811);
    }
}
