package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jc extends IEvent {
    public a dNK;

    public static final class a {
        public String appId;
        public String dFN;
        public int dNL;
        public int opType;
        public String openId;
    }

    public jc() {
        this((byte) 0);
    }

    private jc(byte b2) {
        AppMethodBeat.i(149861);
        this.dNK = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149861);
    }
}
