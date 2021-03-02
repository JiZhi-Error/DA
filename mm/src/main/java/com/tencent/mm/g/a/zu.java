package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zu extends IEvent {
    public a efP;

    public static final class a {
        public String appId;
        public String dDL;
        public String dQk;
        public int efQ;
        public String nonceStr;
        public String packageExt;
        public String signType;
        public String timeStamp;
    }

    public zu() {
        this((byte) 0);
    }

    private zu(byte b2) {
        AppMethodBeat.i(91224);
        this.efP = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91224);
    }
}
