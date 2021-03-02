package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.sdk.event.IEvent;

public final class mx extends IEvent {
    public a dSE;

    public static final class a {
        public int action;
        public String appId;
        public String dSF;
        public boolean dSG;
        public boolean dSH = false;
        public f dSy;
        public long duration;
        public int errCode;
        public String errMsg;
        public String state;
    }

    public mx() {
        this((byte) 0);
    }

    private mx(byte b2) {
        AppMethodBeat.i(136976);
        this.dSE = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(136976);
    }
}
